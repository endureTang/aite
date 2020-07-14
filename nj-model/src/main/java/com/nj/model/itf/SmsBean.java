package com.nj.model.itf;

import java.io.Serializable;
import java.util.Date;

public class SmsBean implements Serializable{
	private String smsCode;
	private String tradeSerial;
	private Date time;
	
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getTradeSerial() {
		return tradeSerial;
	}
	public void setTradeSerial(String tradeSerial) {
		this.tradeSerial = tradeSerial;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
