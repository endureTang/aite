package com.nj.model.itf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FaceidHeadBean implements Serializable {
	private String name; 
	private String certNo;
	private String birthday;
	private String address;
	private String gender;
	/**
	 * 如果用户调用时设置可选参数legality为“1”，则返回身份证照片的合法性检查结果，否则不返回该字段。
	 * 结果为五种分类的概率值（取［0，1］区间实数，取3位有效数字，总和等于1.0），返回结果样例见2.1.4。五种分类为：
	 * 1.ID Photo （正式身份证照片）
     * 2.Temporary ID Photo  （临时身份证照片）
     * 3.Photocopy （正式身份证的复印件）
     * 4.Screen （手机或电脑屏幕翻拍的照片）
     * 5.Edited （用工具合成或者编辑过的身份证图片）
	 * */
	private Map<String, Object> legality = new HashMap<String, Object>(0);
	private String race;//民族
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Map<String, Object> getLegality() {
		return legality;
	}
	public void setLegality(Map<String, Object> legality) {
		this.legality = legality;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	
}
