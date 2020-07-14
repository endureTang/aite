package com.nj.model.vo;

/**
 * 客户->关系管理,列表页面的VO
 */
public class CustomerRelationListVo {

	private String id;
	private String customerName;		//客户名称
	private String mobile;				//客户手机号
	private String identityNo;			//身份证号
	private String bankCardNo;			//银行卡号
	private String accountManagerName;	//客户经理姓名
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getAccountManagerName() {
		return accountManagerName;
	}
	public void setAccountManagerName(String accountManagerName) {
		this.accountManagerName = accountManagerName;
	}
}
