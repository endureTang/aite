package com.nj.enterprise.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
 * @Name com.nj.enterprise.shiro.CaptchaUsernamePasswordToken
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月6日 上午11:11:03
 * @Copyright 金鼎财富
 *
 */
@SuppressWarnings("serial")
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken{
	//验证码字符串  
    private String captcha;
    
    public CaptchaUsernamePasswordToken(String username, String password,String captcha) {  
        super(username, password);  
        this.captcha = captcha;  
    }  
  
    public String getCaptcha() {  
        return captcha;  
    }  
  
    public void setCaptcha(String captcha) {  
        this.captcha = captcha;  
    }  
}
