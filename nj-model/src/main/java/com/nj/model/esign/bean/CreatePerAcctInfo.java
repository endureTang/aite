package com.nj.model.esign.bean;

import org.springframework.beans.BeanUtils;

import com.timevale.esign.sdk.tech.bean.PersonBean;

public class CreatePerAcctInfo{
	
	private String userId;			//用户id,not null
	private ECPerAcctInfo personAcctInfo;		//个人账户信息,not null
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public ECPerAcctInfo getPersonAcctInfo() {
		return personAcctInfo;
	}
	public void setPersonAcctInfo(ECPerAcctInfo personAcctInfo) {
		this.personAcctInfo = personAcctInfo;
	}
	
	public PersonBean convertPersonBean(){
		PersonBean pb = new PersonBean();
		BeanUtils.copyProperties(this.getPersonAcctInfo(), pb);
		return pb;
	}
}
