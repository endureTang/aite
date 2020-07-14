package com.nj.service.itf;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.Constants;
import com.nj.core.base.common.api.ResponseMsg;
import com.nj.core.base.common.api.TFCFResponseMsg;
import com.nj.model.generate.NjAppUser;

@Service("itfUserService")
public class ItfUserService {
	
	@Autowired
	private AppUserService appUserservice;
	
	@Resource(name="tfcfHttpService")
	private TfcfHttpService tfcfHttpService;
	
	@Resource(name="itfChannelService")
	private ItfChannelService itfChannelService;
	
	@Resource(name="userCenterService")
	private UserCenterService userCenterService;
	
	private Logger logger = LoggerFactory.getLogger(ItfUserService.class);
	
	/**
	 * 获取用户绑卡信息
	 * 
	 * @param user
	 * @return bank:银行名，certNo:身份证号，name:姓名，cardNo:银行卡号,isBindCard:是否绑卡,userBalance:可用余额
	 * @throws Exception
	 */
	public Map<String, Object> getBankCard(NjAppUser user) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> tfcfParams = new HashMap<String, Object>();
		tfcfParams.put("userId", appUserservice.getTfcfUserId(user, user.getMobile(), ""));

		// 调用tfcf接口查个人信息
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf(user.getMobile(), "", tfcfParams,
				Constants.TFCF.GET_USER_INFO);
		if (StringUtils.isEmpty(tfcfResp)) {
			logger.error("user:" + user.getMobile() + ":获取银行卡信息失败");
			throw new Exception("在财富端获取绑卡信息失败");
		}

		ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
		Map<String, Object> option = tfcfResp1.getOptional();
		Integer bankCardStatus = (Integer) option.get("bankCardStatus");

		if (tfcfResp1.getResultStatus() != 0)// 返回失败
		{
			logger.warn("user:" + user.getMobile() + ":天府财富绑定银行卡确认失败");
			throw new Exception("在财富端获取绑卡信息失败");
		}
		if (bankCardStatus != 1) {// 返回bankcardStatus不等于1，表示用户未绑卡
			ret.put("isBindCard", 0);
			logger.debug("user:" + user.getMobile() + ":用户未绑卡");
			return ret;
		} else {
			ret.put("isBindCard", 1);
			ret.put("cardNo", option.get("bankCardName"));
			ret.put("bank", option.get("bankName"));
			ret.put("name", user.getDefiTrueName());
			ret.put("certNo", user.getDefiIdentifyId());
			ret.put("userBalance", option.get("userBalance"));
			return ret;
		}
	}

	/**
	 * @param user
	 * @param tokenName
	 * @param tokenId
	 * @throws Exception
	 */
	public void updateUserCert(NjAppUser user, String tokenName, String tokenId) throws Exception {
		String tfcfUserId = appUserservice.getTfcfUserId(user, tokenName, tokenId);

		Map<String, Object> tfcfParams = new HashMap<String, Object>();
		tfcfParams.put("userId", tfcfUserId);
		logger.debug("getBankCard/:tfcfUserId" + tfcfUserId);
		// 查询个人真实姓名或身份证是否为空，如果为空，去天府财富查询。个人真实姓名和身份证信息来自于绑卡或天府财富
		if (StringUtils.isEmpty(user.getIdentifyId()) || StringUtils.isEmpty(user.getTrueName())) {
			String tfcfAccount = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, tfcfParams,
					Constants.TFCF.GET_USER_ACCOUNT_INFO);
			if (StringUtils.isEmpty(tfcfAccount)) {
				logger.warn("/userCtr/getBankCard:" + tokenName + ":天府财富获取用户账户信息失败");
				return;
			}
			logger.debug("/getBankCard:GET_USER_ACCOUNT_INFO:" + tfcfAccount);
			ResponseMsg tfcfAccount1 = JSONObject.parseObject(tfcfAccount, ResponseMsg.class);
			// 获取用户账户信息成功，更新用户真实姓名和真实身份证
			if (tfcfAccount1.getResultStatus() == 0) {
				String certNo = tfcfAccount1.getOptional() != null ? (String) tfcfAccount1.getOptional().get("idcard")
						: null;
				String trueName = tfcfAccount1.getOptional() != null
						? (String) tfcfAccount1.getOptional().get("truename") : null;
				String cardNo = tfcfAccount1.getOptional() != null ? (String) tfcfAccount1.getOptional().get("cardno")
						: null;
				// 获取天府财富的数据，更新用户信息
				if ((!StringUtils.isEmpty(certNo)) || (!StringUtils.isEmpty(trueName))) {
					logger.info("/userCtr/getBankCard:" + tokenName + ":更新个人的身份证和姓名");
					user.setTrueName(appUserservice.encryptString(user, trueName));
					user.setIdentifyId(appUserservice.encryptString(user, certNo));
					user.setDefiIdentifyId(appUserservice.createDefiIdentifyId(certNo));
					user.setDefiTrueName(appUserservice.createDefiTrueName(trueName));
					appUserservice.updateUser(user);
				}
				if (StringUtils.isEmpty(cardNo)) {
					Map<String, Object> z = new HashMap<String, Object>();
					return;
				}
			}
		}
	}
}
