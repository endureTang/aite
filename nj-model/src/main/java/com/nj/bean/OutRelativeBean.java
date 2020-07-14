package com.nj.bean;

import javax.validation.constraints.NotNull;

import com.nj.core.base.validator.NotBlank;

public class OutRelativeBean {
	
	@NotBlank(message="联系人姓名不能为空")
	private String name;
	@NotBlank(message="联系人手机不能为空")
	private String phone;
	//@NotNull(message="联系人关系类型不能为空")
	private Integer relative;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRelative() {
		return relative;
	}
	public void setRelative(Integer relative) {
		this.relative = relative;
	}
	
}
