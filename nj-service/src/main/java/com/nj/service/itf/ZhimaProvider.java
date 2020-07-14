package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.antgroup.zmxy.openplatform.api.ZhimaConstants;
import com.antgroup.zmxy.openplatform.api.response.ZhimaAuthEngineSmsauthResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaAuthInfoAuthqueryResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditIvsDetailGetResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditScoreGetResponse;
import com.nj.core.base.common.Constants;
import com.nj.core.base.common.api.RespCode;
import com.nj.core.base.exception.ItfException;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DateTimeHelper;
import com.nj.core.base.util.MD5;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.base.util.zhima.ZhiMaCreditUtil;
import com.nj.dao.NjUserZhimaAuthMapper;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjUserZhimaAuth;
import com.nj.model.generate.UserZhimaIvsLog;
import com.nj.model.generate.UserZhimaIvsScore;
import com.nj.model.generate.ZhimaScoreLog;

@Service("zhimaProvider")
public class ZhimaProvider {
	
	@Resource(name="njZhimaService")
	private NjZhimaService njZhimaService;
	
	@Resource(name="itfAppUserService")
	private AppUserService appUserService;
	
	private static Logger logger = LoggerFactory.getLogger(ZhimaProvider.class);
		
	public NjUserZhimaAuth auth(NjAppUser user ) throws Exception{
		NjUserZhimaAuth auth = njZhimaService.getAuth(user);
		if(auth !=null &&!StringUtils.isEmpty(auth.getToken())){
			return auth;
		}
		String  openId;
		//查询芝麻接口
		if((!StringUtils.isEmpty(user.getTrueName()))&& (!StringUtils.isEmpty(user.getIdentifyId()))
				&& (!StringUtils.isEmpty(user.getMobile()))){
			//获取芝麻授权
			ZhimaAuthEngineSmsauthResponse   scoreResponse=ZhiMaCreditUtil.queryZhimaAuthEngineSmsauth(user.getTrueName(), user.getIdentifyId(), user.getMobile());
			if(scoreResponse ==null || !scoreResponse.isSuccess()){
				throw new ItfException("芝麻授权失败");
			}
			//芝麻授权成功，直接查询芝麻openId
			if(StringUtils.isEmpty(scoreResponse.getOpenId())){//openId为空，查询一次openId
				ZhimaAuthInfoAuthqueryResponse openIdRes =ZhiMaCreditUtil.queryZhimaAuthInfo(user.getTrueName(), user.getIdentifyId());
				if(openIdRes ==null || !openIdRes.isSuccess()){
					throw new ItfException("芝麻授权失败");
				}
				if(!openIdRes.getAuthorized()){
					throw new ItfException("芝麻授权失败");
				}
				openId = openIdRes.getOpenId();			
			}
			else{//openId不为空
				openId = scoreResponse.getOpenId();
			}
			//保存到数据库
			if(!StringUtils.isEmpty(openId)){
				NjUserZhimaAuth cs = new NjUserZhimaAuth();
				cs.setCreateDate(new Date());
				cs.setToken(openId);
				cs.setEndDate(new Date(9999,9,9));
				cs.setUserId(user.getId());
				cs.setDelFlag(false);
				cs =njZhimaService.insertAuth(cs);
				auth =cs;
			}
			return auth;
		}
		else{
			throw new ItfException("用户未绑卡，请先绑卡");
		}
	}
	/**
	 * @param user
	 * @return -1:没有查到他的芝麻分;
	 * 其他：芝麻分
	 * @throws Exception
	 */
	public Double getZhimaScore(NjAppUser user)throws Exception{
		NjUserZhimaAuth auth = njZhimaService.getAuth(user);
		if(auth==null || StringUtils.isEmpty(auth.getToken())){
			logger.error("用户没有授权芝麻信用");
			throw new ItfException(RespCode.ZHIMA_ERROR_NOT_AUTH.getCode(),"zhimaNotAuthenticate");
		}
		if(isValidScore(auth)){
			return  auth.getScore().doubleValue();
		}
		String openId = auth.getToken();
		ZhimaCreditScoreGetResponse  response =ZhiMaCreditUtil.queryZhimaCreditGet(openId, UuidUtil.get32UUID());
		
		//获取芝麻信用分失败时，检查用户是否授权
		if(response ==null){
			logger.error("获取芝麻分失败，queryZhimaAuthInfo返回null");
			throw new ItfException("获取芝麻分失败");
		}
		//保存请求日志
		ZhimaScoreLog scoreLog = new ZhimaScoreLog();
		scoreLog.setBizNo(response.getBizNo());
		scoreLog.setResult(response.getBody());
		scoreLog.setScore(response.getZmScore());
		scoreLog.setCreateDate(new Date());
		scoreLog =njZhimaService.insertScoreLog(scoreLog);
		
		if(!response.isSuccess()){//获取芝麻失败
			if(response.getErrorCode().trim().equals("ZMCREDIT.authentication_fail")
					|| response.getErrorCode().trim().equals("ZMCREDIT.openid_parameter_invalid")){//用户没有授权芝麻
				//删除芝麻授权Id
				njZhimaService.deleteAuth(auth);
				throw new ItfException(RespCode.ZHIMA_ERROR_NOT_AUTH.getCode(),"zhimaNotAuthenticate");
			}
			else{
				throw new ItfException("网络错误，获取芝麻信用失败");
			}
		}
		
		String score = response.getZmScore();
		Double scoreDouble =new Double(0);
		if(StringUtils.isEmpty(score) || score.trim().equals("N/A")){
			scoreDouble =new Double(-1);
		}
		else{
			scoreDouble = Double.parseDouble(score);
		}
		//更新芝麻信用分
		auth.setScore(new BigDecimal(scoreDouble));
		auth.setUpdateDate(new Date());
		auth =njZhimaService.updateAuth(auth);
		return scoreDouble;
	}
	
	/**
	 * 查询用户芝麻反欺诈信息
	 * 
	 * @param orderId：订单id
	 * @param params：cert_no:身份证(必填),name:姓名(必填),mobile:手机号(必填，手机号，最多传入三个，多个手机号之间用|分隔，如15256797367|18669152789)
	 * email:邮箱(选填),bank_card:银行卡(必填),address:地址，ip:手机ip， mac：手机mac, wifimac:手机wifimac， imei:手机imei号，imsi:手机imsi号
	 * @return:map,包含两个参数, ivsScore(Double), ivsDetail(json)
	 */
	public Map<String, Object> getIvsDetail(String orderId, String userId, Map<String, String> params) throws Exception{
		if(StringUtils.isEmpty(orderId)){
			logger.error("订单id不能为空");
			throw new Exception("订单id为空");
		}
		
		String inputMd5 = generateMd5(params);
		if(StringUtils.isEmpty(inputMd5)){
			logger.error("参数不能为空");
			throw new Exception("参数不能为空");
		}
		UserZhimaIvsLog log = new UserZhimaIvsLog();
		Map<String,Object> result = new HashMap<String, Object>();
		//先查数据
		UserZhimaIvsScore ivs = njZhimaService.getIvs(orderId, inputMd5);
		if(isValidIvs(ivs)){
			result.put("ivsScore", ivs.getIvsScore());
			result.put("ivsDetail", ivs.getIvsDetail());
			return result;
		}
		else{
			//重新查询ivs记录
			ZhimaCreditIvsDetailGetResponse  zhimaResp =ZhiMaCreditUtil.queryZhimaCreditIvsDetailGet(params, UuidUtil.get32UUID());
			//解析芝麻返回结果
			log.setBizNo(zhimaResp.getBizNo());
			log.setIvsScore(zhimaResp.getIvsScore()==null ? null: Long.toString(zhimaResp.getIvsScore()));
			log.setResult(zhimaResp.getBody());
			njZhimaService.saveZhimaIvsLog(log);
			if(!zhimaResp.isSuccess()){
				logger.error("调用芝麻反欺诈接口失败，返回错误");
				throw new Exception("芝麻反欺诈返回失败");				
			}
			else{
				UserZhimaIvsScore ivsNew = new UserZhimaIvsScore();
				ivsNew.setIvsDetail(JSONObject.toJSONString(zhimaResp.getIvsDetail()));
				ivsNew.setIvsScore(new Double(zhimaResp.getIvsScore()));
				ivsNew.setOrderId(orderId);
				ivsNew.setUserId(userId);
				njZhimaService.saveZhimaIvs(ivsNew);
				result.put("ivsScore", ivsNew.getIvsScore());
				result.put("ivsDetail", ivsNew.getIvsDetail());
				return result;
			}
		}
	}
	
	/**
	 * 查询用户芝麻反欺诈信息
	 * 
	 * @param orderId：订单id
	 * @return:map,包含两个参数, ivsScore(Double), ivsDetail(json)
	 */
	public Map<String, Object> getIvsDetail(String orderId, String userId) throws Exception{
		if(StringUtils.isEmpty(orderId)){
			logger.error("订单id不能为空");
			throw new Exception("订单id为空");
		}
		Map<String, String> params = new HashMap<String, String>();
		NjAppUser user = appUserService.getAppUser(userId);
		params.put("cert_no", user.getIdentifyId());
		params.put("name", user.getTrueName());
		params.put("mobile", user.getMobile());
		params.put("bank_card", appUserService.getBankCard(user));
		params.put("ip", appUserService.getIp(user));
		params.put("mac", appUserService.getMac(user));
		params.put("wifimac", appUserService.getWifiMac(user));
		logger.debug("get zhimaIvsDetail params="+params.toString());
		String inputMd5 = generateMd5(params);
		if(StringUtils.isEmpty(inputMd5)){
			logger.error("参数不能为空");
			throw new Exception("参数不能为空");
		}
		UserZhimaIvsLog log = new UserZhimaIvsLog();
		Map<String,Object> result = new HashMap<String, Object>();
		//先查数据
		UserZhimaIvsScore ivs = njZhimaService.getIvs(orderId, inputMd5);
		if(isValidIvs(ivs)){
			result.put("ivsScore", ivs.getIvsScore());
			result.put("ivsDetail", ivs.getIvsDetail());
			return result;
		}
		else{
			//重新查询ivs记录
			ZhimaCreditIvsDetailGetResponse  zhimaResp =ZhiMaCreditUtil.queryZhimaCreditIvsDetailGet(params, UuidUtil.get32UUID());
			//解析芝麻返回结果
			log.setBizNo(zhimaResp.getBizNo());
			log.setIvsScore(zhimaResp.getIvsScore()==null ? null: Long.toString(zhimaResp.getIvsScore()));
			log.setResult(zhimaResp.getBody());
			njZhimaService.saveZhimaIvsLog(log);
			if(!zhimaResp.isSuccess()){
				logger.error("调用芝麻反欺诈接口失败，返回错误");
				throw new Exception("芝麻反欺诈返回失败");				
			}
			else{
				UserZhimaIvsScore ivsNew = new UserZhimaIvsScore();
				ivsNew.setIvsDetail(JSONObject.toJSONString(zhimaResp.getIvsDetail()));
				ivsNew.setIvsScore(new Double(zhimaResp.getIvsScore()));
				ivsNew.setOrderId(orderId);
				ivsNew.setUserId(userId);
				njZhimaService.saveZhimaIvs(ivsNew);
				result.put("ivsScore", ivsNew.getIvsScore());
				result.put("ivsDetail", ivsNew.getIvsDetail());
				return result;
			}
		}
	}
	
	private boolean isValidIvs(UserZhimaIvsScore ivs){
		if(ivs ==null){
			return false;
		}
		if(StringUtils.isEmpty(ivs.getIvsDetail())){
			return false;
		}
		/*if(DateTimeHelper.getDaysOfTwoDate(new Date(), ivs.getCreateDate())> Constants.ITF.ZHIMA_IVS_EXPIRE){
			return false;
		}*/
		return true;
	}
	
	private String generateMd5(Map<String, String> param){
		if(param==null || param.isEmpty()){
			return "";
		}
		StringBuffer sb= new StringBuffer();
		
		SortedMap<String , String> data = new TreeMap<String, String>();
		for(Map.Entry<String, String> m: param.entrySet()){
			if(m.getValue()!=null 
					&& !StringUtils.isEmpty(m.getValue().toString())){
				data.put(m.getKey(),m.getValue());
			}
		}
		
		for(Map.Entry<String, String> m: data.entrySet()){
			sb.append(m.getKey()).append("=").append(m.getValue());
		}
		
		return MD5.md5(sb.toString());
	}
	
	private boolean isValidScore(NjUserZhimaAuth auth){
		if(auth.getScore()==null)
			return false;
		if(DateTimeHelper.getDaysOfTwoDate(new Date(), auth.getUpdateDate())<Constants.ITF.ZHIMA_SCORE_EXPIRE)
			return true;
		return false;
	}
}
