package com.nj.model.esign.bean;

/**
 * e签宝中更新个人账户时传入参数的封装对象
 * @author wkh
 *
 */
public class EUPerAcctInfo {

	private String email;			//邮箱地址
	private String mobile;			//手机号码
	private String name;			//姓名
	private String organ;			//所属公司
	private String title;			//职业
	private String address;			//常用地址
	
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
}
