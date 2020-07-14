package com.nj.bean;

import java.util.List;

public class OutHouseInfo {
	private String name;
	private String address;
	private String price;
	private List<String> image;
	private String frontImg;
	private String backImg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<String> getImage() {
		return image;
	}
	public void setImage(List<String> image) {
		this.image = image;
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
	
	
}	
