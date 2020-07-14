package com.nj.model.esign.bean;

import org.springframework.beans.BeanUtils;

import com.timevale.esign.sdk.tech.bean.UpdatePersonBean;

public class UptPerAcctInfo{
	
	private String userId;			//用户ID,not null
	private EUPerAcctInfo perAcctInfo;	//可以更新的用户信息，not null
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public EUPerAcctInfo getPerAcctInfo() {
		return perAcctInfo;
	}
	public void setPerAcctInfo(EUPerAcctInfo perAcctInfo) {
		this.perAcctInfo = perAcctInfo;
	}
	public UpdatePersonBean convertPersonBean(){
		UpdatePersonBean pb = new UpdatePersonBean();
		BeanUtils.copyProperties(this.getPerAcctInfo(), pb);
		return pb;
	}
}
