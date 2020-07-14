package com.nj.enterprise.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nj.core.ehcache.EhCacheUtil;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
/** 
 * 验证器，增加了登录次数校验功能 
 * @author trj
 */
@Component
public class RetryLimitCredentialsMatcher extends SimpleCredentialsMatcher {
	
    private static final Logger log = LoggerFactory.getLogger(RetryLimitCredentialsMatcher.class);

    private int maxRetryNum = 5;

    public void setMaxRetryNum(int maxRetryNum) {
        this.maxRetryNum = maxRetryNum;
    }
	
  
    @Override  
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {  
    	
        String username = (String) token.getPrincipal();  
        Cache cache = EhCacheUtil.getInstance().get("passwordRetryCache");
        Element element = cache.get(username);
        Integer retryCount;
        if(element == null) {
        	retryCount = 1;
        }else {
        	retryCount = (Integer) element.getObjectValue();
        }
        if (retryCount > maxRetryNum) {
        	log.error("用户[{}]进行登录验证..失败验证超过{}次", username, maxRetryNum);
            throw new ExcessiveAttemptsException("用户: " + username + " 尝试次数超过【"+maxRetryNum+"】次数限制");  
        }else {
        	EhCacheUtil.getInstance().put("passwordRetryCache", username, retryCount+1);
        }
        //严重用户是否登录成功
        boolean matches = super.doCredentialsMatch(token, info);  
        if (matches) {  
            //登录成功，清除限制缓存
        	EhCacheUtil.getInstance().remove("passwordRetryCache", username); 
        }  
        return matches;  
    }  
} 

