package com.nj.bean;

import java.util.Date;

public class SmsCodeBean {
	
	private String smsCode;
	private Date expireTime;
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	public SmsCodeBean(String smsCode, Date expireTime){
		this.smsCode =smsCode;
		this.expireTime =expireTime;
	}
	
	public SmsCodeBean(){}
}
