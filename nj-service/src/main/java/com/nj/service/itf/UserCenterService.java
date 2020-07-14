package com.nj.service.itf;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.Constants;
import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.util.HttpUtil;
import com.nj.core.base.util.SignCommonUtil;
import com.nj.core.base.util.UuidUtil;


@Service("userCenterService")
public class UserCenterService {
	
/*	@Value("{userCenterServer.baseUrl}")
	private String registBaseUrl;*/
	
	Logger logger = LoggerFactory.getLogger(UserCenterService.class);

	public String register(String mobile, String password, String appId, String appKey){
		SortedMap<String, Object> packageParams = new TreeMap<String, Object>();
		packageParams.put("channelCode", appId);
		//Base64.byteArrayToAltBase64(password.getBytes());
		packageParams.put("mobile",mobile);
		packageParams.put("password",Base64.getEncoder().encodeToString(password.getBytes()));
		String nonceStr =
				new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+UuidUtil.get32UUID().substring(0,8);
		packageParams.put("nonceStr", nonceStr);
		packageParams.put("sign", SignCommonUtil.createSign("utf-8", packageParams, appKey));
		logger.debug("register 参数："+packageParams.toString());
		String retStr =HttpUtil.doPost(AddressConstants.getRegisterUri(), packageParams);	
		logger.info("usercenter regist url="+AddressConstants.getRegisterUri()+" result:"+retStr);
		if(StringUtils.isEmpty(retStr)){
			return null;
		}
		try{
			JSONObject ret = JSONObject.parseObject(retStr);
			if("SUCCESS".equals(ret.getString("return_code"))
					&& "SUCCESS".equals(ret.getJSONObject("result").getString("result_code"))){
				return ret.getJSONObject("result").getString("open_id");
			}//用户已经注册
			else if("10002".equals(ret.getJSONObject("result").getString("error_code"))){
				return ret.getJSONObject("result").getString("open_id");
			}
			else{
				logger.info("注册失败："+ret.getJSONObject("result").getString("error_msg"));
				return null;
			}
			
		}catch(Exception e){
			logger.error("register error,return string="+retStr,e);
			return null;
		}
	}
}
