package com.nj.model.esign.bean;

import com.timevale.esign.sdk.tech.bean.UpdateOrganizeBean;

/**
 * e签宝更新企业账户时传入参数的封装对象
 * @author wkh
 *
 */
public class EUCopoAcctInfo {

	private String name;		//机构名称
	private String email;		//邮箱地址
	private String mobile;		//手机号码
	private String address;		//公司地址
	private String scope;		//经营范围
	private int organType;		//单位类型，使用枚举OrgType
	
	private int userType;		//注册类型，1-代理人注册，2-法人注册，默认1
	
	private String agentName;	//代理人姓名，当userType值为1时必填
	private String agentIdNo;	//代理人身份证号，当userType值为1时必填
	
	private String legalName;	//法定代表姓名，当userType为2时必填
	private String legalIdNo;	//法定代表身份证号/护照号，当userType为2时必填
	
	private int legalArea;		//法定代表人归属地,0-大陆，1-香港，2-澳门，3-台湾，4-外籍，默认0,使用枚举LegalArea
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int getOrganType() {
		return organType;
	}

	public void setOrganType(int organType) {
		this.organType = organType;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentIdNo() {
		return agentIdNo;
	}

	public void setAgentIdNo(String agentIdNo) {
		this.agentIdNo = agentIdNo;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalIdNo() {
		return legalIdNo;
	}

	public void setLegalIdNo(String legalIdNo) {
		this.legalIdNo = legalIdNo;
	}

	public int getLegalArea() {
		return legalArea;
	}

	public void setLegalArea(int legalArea) {
		this.legalArea = legalArea;
	}
}
