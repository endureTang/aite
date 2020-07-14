package com.nj.model.datamodel;

import com.nj.core.base.entity.NjIdEntity;

import io.swagger.annotations.ApiModelProperty;

public class NjAppUserModel extends NjIdEntity {
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String name;
	/**
	 * 身份证
	 */
	@ApiModelProperty(value = "身份证")
	private String idCardNum;
	/**
	 * 户籍
	 */
	@ApiModelProperty(value = "户籍")
	private String householdRegister;
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String tokenName;
	/**
	 * 婚姻状况
	 */
	@ApiModelProperty(value = "婚姻状况")
	private Integer maritalStatus;
	/**
	 * 最高学历
	 */
	@ApiModelProperty(value = "最高学历")
	private Integer highestEducation;
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private Integer houseStatus;
	/**
	 * 详细地址
	 */
	@ApiModelProperty(value = "详细地址")
	private String detailedAddress;
	/**
	 * 区域编号
	 */
	@ApiModelProperty(value = "区域编号")
	private String areaCode;
	
	@ApiModelProperty(value = "性别：0女 1男")
	private String Sex;
	
	@ApiModelProperty(value = "民族")
	private String nation;
	
	@ApiModelProperty(value = "年龄")
	private String age;
	
	@ApiModelProperty(value = "住宅电话")
	private String telephone;
	
	@ApiModelProperty(value = "省")
	private String province;
	
	@ApiModelProperty(value = "市")
	private String city;
	
	@ApiModelProperty(value = "县")
	private String county;
	
	@ApiModelProperty(value = "居住性质：一次性购买、与父母同住、自建、租赁、按揭、其它")
	private String addressNature;
	
	@ApiModelProperty(value = "居住性质金额：当居住性质是租赁或按揭时，该字段填写的是月租金或月还款金额")
	private String addressMoney;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getHouseholdRegister() {
		return householdRegister;
	}
	public void setHouseholdRegister(String householdRegister) {
		this.householdRegister = householdRegister;
	}
	public String getTokenName() {
		return tokenName;
	}
	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}
	public Integer getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Integer getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(Integer highestEducation) {
		this.highestEducation = highestEducation;
	}
	public Integer getHouseStatus() {
		return houseStatus;
	}
	public void setHouseStatus(Integer houseStatus) {
		this.houseStatus = houseStatus;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getAddressNature() {
		return addressNature;
	}
	public void setAddressNature(String addressNature) {
		this.addressNature = addressNature;
	}
	public String getAddressMoney() {
		return addressMoney;
	}
	public void setAddressMoney(String addressMoney) {
		this.addressMoney = addressMoney;
	}
	
}