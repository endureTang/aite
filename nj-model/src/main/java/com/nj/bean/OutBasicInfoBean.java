package com.nj.bean;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.nj.core.base.validator.NotBlank;

public class OutBasicInfoBean {
	@NotNull(message="申请人婚姻信息不能为空")
	private Integer marriage;
	private Integer house;
	private Short bindBankCark;
	private String bankAccount;
	private Integer education;
	@NotBlank(message="申请人地址不能为空")
	private String address;
	private String phone;
	 private String ownIndustry;
	private List<String> attachments;
		
	/**微信号*/
	private String weixinNo;
	
	/**户籍*/ 
	private String householdRegister;
	
	/**省*/
	private String province;
	
	/**市*/
	private String city;
	
	/**县*/
	private String county;
	
	public Integer getMarriage() {
		return marriage;
	}
	public String getOwnIndustry() {
		return ownIndustry;
	}
	public void setOwnIndustry(String ownIndustry) {
		this.ownIndustry = ownIndustry;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public Integer getHouse() {
		return house;
	}
	public void setHouse(Integer house) {
		this.house = house;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<String> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Short getBindBankCark() {
		return bindBankCark;
	}
	public void setBindBankCark(Short bindBankCark) {
		this.bindBankCark = bindBankCark;
	}
	public String getWeixinNo() {
		return weixinNo;
	}
	public void setWeixinNo(String weixinNo) {
		this.weixinNo = weixinNo;
	}
	public String getHouseholdRegister() {
		return householdRegister;
	}
	public void setHouseholdRegister(String householdRegister) {
		this.householdRegister = householdRegister;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
}
