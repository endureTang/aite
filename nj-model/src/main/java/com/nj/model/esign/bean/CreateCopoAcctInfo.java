package com.nj.model.esign.bean;

import org.springframework.beans.BeanUtils;

import com.timevale.esign.sdk.tech.bean.OrganizeBean;
import com.timevale.esign.sdk.tech.bean.PersonBean;

public class CreateCopoAcctInfo {
	
	private String coporateId;				//企业ID，not null
	private int acctType;					//账户类型：企业账户、法人账户,not null,使用常量EsignCoporateAccountConstant.
	private ECCopoAcctInfo copoAcctInfo;	//当账户类型为“企业账户”，该对象不能为空
	private ECPerAcctInfo perAcctInfo;		//当账户类型为“法人账户”，该对象不能为空
	
	public OrganizeBean convertOrganizeBean(){
		OrganizeBean ob = new OrganizeBean();
		BeanUtils.copyProperties(this.getCopoAcctInfo(), ob);
		return ob;
	}
	
	public PersonBean convertPersonBean(){
		PersonBean pb = new PersonBean();
		BeanUtils.copyProperties(this.getPerAcctInfo(), pb);
		return pb;
	}
	
	public String getCoporateId() {
		return coporateId;
	}


	public void setCoporateId(String coporateId) {
		this.coporateId = coporateId;
	}


	public int getAcctType() {
		return acctType;
	}


	public void setAcctType(int acctType) {
		this.acctType = acctType;
	}


	public ECCopoAcctInfo getCopoAcctInfo() {
		return copoAcctInfo;
	}


	public void setCopoAcctInfo(ECCopoAcctInfo copoAcctInfo) {
		this.copoAcctInfo = copoAcctInfo;
	}


	public ECPerAcctInfo getPerAcctInfo() {
		return perAcctInfo;
	}


	public void setPerAcctInfo(ECPerAcctInfo perAcctInfo) {
		this.perAcctInfo = perAcctInfo;
	}
}
