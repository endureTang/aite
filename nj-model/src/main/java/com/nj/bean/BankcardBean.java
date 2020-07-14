package com.nj.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BankcardBean {
		
	@Size(min=1,message="{validate.bindcard.cardNo.null}")
	private String cardNo;
	@Size(min=1,message="{validate.bindcard.name.null}")
	private String name;
	@Size(min=1,message="{validate.bindcard.mobile.null}")
	private String mobile;
	@Size(min=1,message="{validate.bindcard.certNo.null}")
	private String certNo;
	private String userId;
	@Size(min=1,message="{validate.bindcard.bank.null}")
	private String bankNo;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
		
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public BankcardBean(){}
	
	public BankcardBean(String userId, String certNo,String name, String cardNo, String mobile , String bankNo){
		this.userId=userId;
		this.cardNo= cardNo;
		this.name=name;
		this.mobile=mobile;
		this.certNo= certNo;
		this.bankNo=bankNo;
	}
}
