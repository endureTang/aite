package com.nj.model.esign.bean;

/**
 * e签宝中创建个人账户时的传入参数的封装对象
 * @author wkh
 *
 */
public class ECPerAcctInfo {
	
	private String email;			//邮箱地址
	private String mobile;			//手机号码
	private String name;			//姓名,create:not null
	private String idNo;			//身份证号/护照号,create:not null
	private String organ;			//所属公司
	private String title;			//职业
	private String address;			//常用地址
	private int personArea;			//个人归属地：0-大陆，1-香港，2-澳门，3-台湾，4-外籍，默认0.使用枚举LegalArea
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getOrgan() {
		return organ;
	}
	public void setOrgan(String organ) {
		this.organ = organ;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPersonArea() {
		return personArea;
	}
	public void setPersonArea(int personArea) {
		this.personArea = personArea;
	}
}
