package com.nj.service.itf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("tokenChecker")
public class TokenChecker {
	private static Logger logger = LoggerFactory.getLogger(TokenChecker.class);
	public boolean isLogin(String tokenId, String tokenName){
		if(StringUtils.isEmpty(tokenId)|| StringUtils.isEmpty(tokenName)){
			logger.error("用户没有登录");
			return false;
		}
		return true;
	}
}
