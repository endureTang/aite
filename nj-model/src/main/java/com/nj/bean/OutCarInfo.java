package com.nj.bean;

import java.util.Date;
import java.util.List;

public class OutCarInfo {
	private String carNumber;
	private Integer carType;
	private Date buyDate;
	private String buyPrice;
	private String carAge;
	private String remark;
	private List<String> attachment;
	private String xjcd;
	private String shdq;
	private String frontImg;
	private String backImg;
	private String driveLicense;
	private String insuranceNo;
	private String vin;
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public Integer getCarType() {
		return carType;
	}
	public void setCarType(Integer carType) {
		this.carType = carType;
		
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getCarAge() {
		return carAge;
	}
	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<String> getAttachment() {
		return attachment;
	}
	public void setAttachment(List<String> attachment) {
		this.attachment = attachment;
	}
	public String getXjcd() {
		return xjcd;
	}
	public void setXjcd(String xjcd) {
		this.xjcd = xjcd;
	}
	public String getShdq() {
		return shdq;
	}
	public void setShdq(String shdq) {
		this.shdq = shdq;
	}
	public String getFrontImg() {
		return frontImg;
	}
	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}
	public String getBackImg() {
		return backImg;
	}
	public void setBackImg(String backImg) {
		this.backImg = backImg;
	}
	public String getDriveLicense() {
		return driveLicense;
	}
	public void setDriveLicense(String driveLicense) {
		this.driveLicense = driveLicense;
	}
	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	
}
