package com.nj.bean;

public class OutCertInfo {
	// 身份证正面
	private String certFrontImg;
	// 身份证背面
	private String certBackImg;
	// 手持身份证
	private String verifyImg;
	// 活体认证照片
	private String livingImg;
	public String getCertFrontImg() {
		return certFrontImg;
	}
	public void setCertFrontImg(String certFrontImg) {
		this.certFrontImg = certFrontImg;
	}
	public String getCertBackImg() {
		return certBackImg;
	}
	public void setCertBackImg(String certBackImg) {
		this.certBackImg = certBackImg;
	}
	public String getVerifyImg() {
		return verifyImg;
	}
	public void setVerifyImg(String verifyImg) {
		this.verifyImg = verifyImg;
	}
	public String getLivingImg() {
		return livingImg;
	}
	public void setLivingImg(String livingImg) {
		this.livingImg = livingImg;
	}
	
}
