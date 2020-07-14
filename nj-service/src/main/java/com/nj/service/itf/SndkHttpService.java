package com.nj.service.itf;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nj.model.generate.NjAppUser;
import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.*;
import com.nj.core.base.util.AESUtil;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.common.Constants;
import com.nj.core.base.util.HttpUtil;
import com.nj.core.base.util.MD5Util;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.SignCommonUtil;
import com.jd.core.constant.CommonVar;
import com.jd.core.util.encrypt.EncrypRSA;

/**
 * 苏宁代扣服务
 * @author Administrator
 *
 */
@Service("sndkHttpService")
public class SndkHttpService {
	private static Logger logger = LoggerFactory.getLogger(SndkHttpService.class);
	
	//tokenName和tokenId都在data里，现在没有token
	public String doHttpPostForSndk(String channelCode, String bankCode,String bankName,String cardType,Map<String, Object> userCarInfo, String srcUri) throws Exception{
		//根据配置类来生成测试环境或正式环境
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("channelCode", channelCode);
		params.put("nonceStr", SignCommonUtil.CreateNoncestr(30));
		params.put("bankCode", bankCode);
		params.put("bankName", bankName);
		params.put("cardType", cardType);
		
		String AESKey = Constants.SNDK.getAESKey();
		String cardInfo = JSONObject.toJSONString(userCarInfo);
		params.put("cardInfo", EncrypRSA.encryptBase64(AESKey,cardInfo));
		params.put("sign", SignCommonUtil.createSign(params));

		String url= Constants.SNDK.createUrl(srcUri);
		logger.warn("request sndk start:"+url+":"+ cardInfo);
		
		String response = HttpUtil.doPost(url, params);
		
		logger.warn("request sndk end:"+url+":"+ response);
		
		return response;
	}
	
	//tokenName和tokenId都在data里，现在没有token
		public String doHttpPostForSndk(Map map) throws Exception{
			
//			SortedMap<String, Object> map = new TreeMap<String, Object>();
//			map.put("bankCode", pd.getString("bankCode"));
//			map.put("bankName", pd.getString("bankName"));
//			map.put("cardType", pd.getString("cardType"));
//
//			String cardHolderName = pd.getString("cardHolderName");
//			String certNo = pd.getString("certNo");
//			String mobileNo = pd.getString("mobileNo");
//			String cardNo = pd.getString("cardNo");
//			String AESKey = Constants.SNDK.getAESKey();
//			String cardInfo = "{'cardHolderName':'"+cardHolderName+"','certNo':'"+certNo+"','mobileNo':'"+mobileNo+"','cardNo':'"+cardNo+"'}";
//			map.put("cardInfo", EncrypRSA.encryptBase64(AESKey,cardInfo));
//
//			String orderAmount = pd.getString("orderAmount");
//			
//			//map.put("bankCode", "nj_server");
//			map.put("channelCode", "nj_server");
//			map.put("nonceStr", SignCommonUtil.CreateNoncestr(30));
//			//map.put("jdSerialNo", "151333339696571b134119fc04043984a42c6b9b134c8");
//			map.put("outOrderNo", DateUtil.getOrderNo());//暂用时间格式
//			map.put("orderTime", DateUtil.getOrderTime());
//			map.put("orderAmount", orderAmount);
//			map.put("merchantNo", "70057572");
//			map.put("merchantAmount", "80000");
//			
//			String sign = SignCommonUtil.createSign("UTF-8", map, com.nj.core.base.common.Constants.SNDK.SIGN_KEY);
//			System.out.println(sign);
//			map.put("sign", sign);
//			
//			System.out.println(map);
			
			
//			map.put("bankCode", "TEST_KJ");
//			map.put("bankName", "TEST_KJ");
//			map.put("cardType", "1");
//			
//			String cardInfo = "{'cardHolderName':'试试','certNo':'510681198606180618','mobileNo':'13666216506','cardNo':'8000000000000000242'}";
//			map.put("cardInfo", EncrypRSA.encryptBase64(CommonVar.JD_PUBLIC_KEY,cardInfo));
//
//			//map.put("bankCode", "nj_server");
//			map.put("channelCode", "nj_server");
//			map.put("nonceStr", SignCommonUtil.CreateNoncestr(30));
//			//map.put("jdSerialNo", "151333339696571b134119fc04043984a42c6b9b134c8");
//			map.put("outOrderNo", "000100001258013928");
//			map.put("orderTime", "20180116141730");
//			map.put("orderAmount", "200000");
//			map.put("merchantNo", "70057572");
//			map.put("merchantAmount", "40000");
//			
//			String sign = SignCommonUtil.createSign("UTF-8", map, com.nj.core.base.common.Constants.SNDK.SIGN_KEY);
//			System.out.println(sign);
//			map.put("sign", sign);
			

			String url= Constants.SNDK.createUrl(Constants.SNDK.SN_NOT_CONTRACT_PAY);
//			logger.warn("request sndk start:"+url+":"+ cardInfo);
			String response = HttpUtil.doPost(url, map);
			logger.warn("request sndk end:"+url+":"+ response);
			return response;
		}
		
		public String doHttpPostForSndkQueryOrder(Map map) throws Exception{
			String url= Constants.SNDK.createUrl(Constants.SNDK.SN_QUERY_ORDER);
			String response = HttpUtil.doPost(url, map);
			logger.warn("request sndk end:"+url+":"+ response);
			return response;
		}
		
	
}
