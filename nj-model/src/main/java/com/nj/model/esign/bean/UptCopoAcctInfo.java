package com.nj.model.esign.bean;

import org.springframework.beans.BeanUtils;

import com.timevale.esign.sdk.tech.bean.UpdateOrganizeBean;
import com.timevale.esign.sdk.tech.bean.UpdatePersonBean;

public class UptCopoAcctInfo {

	private String coporateId;				//企业ID，not null
	private int acctType;					//账户类型：企业账户、法人账户,not null,使用常量EsignCoporateAccountConstant.
	private EUCopoAcctInfo copoAcctInfo;	//账户类型为：企业账户时，该对象not null
	private EUPerAcctInfo perAcctInfo;		//账户类型为：法人账户时，该对象not null
	
	public UpdateOrganizeBean convertCopoBean(){
		UpdateOrganizeBean pb = new UpdateOrganizeBean();
		BeanUtils.copyProperties(this.getCopoAcctInfo(), pb);
		return pb;
	}
	
	public UpdatePersonBean convertPersonBean(){
		UpdatePersonBean pb = new UpdatePersonBean();
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
	public EUCopoAcctInfo getCopoAcctInfo() {
		return copoAcctInfo;
	}
	public void setCopoAcctInfo(EUCopoAcctInfo copoAcctInfo) {
		this.copoAcctInfo = copoAcctInfo;
	}
	public EUPerAcctInfo getPerAcctInfo() {
		return perAcctInfo;
	}
	public void setPerAcctInfo(EUPerAcctInfo perAcctInfo) {
		this.perAcctInfo = perAcctInfo;
	}
}
