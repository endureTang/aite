package com.nj.bean;

import java.math.BigDecimal;
import java.util.List;

public class OutUntiFraudInfo {
	private Integer blackHit;
	private BigDecimal zmfqzScore;
	private BigDecimal zmScore;
	private String zmfqzDetail;
	private BigDecimal houtiScore;
	private String huotiDetail;
	private List<String> huotiImg;
	private String huotiFrom;
	private String blackHitDetail;
	public Integer getBlackHit() {
		return blackHit;
	}
	public void setBlackHit(Integer blackHit) {
		this.blackHit = blackHit;
	}
	public BigDecimal getZmfqzScore() {
		return zmfqzScore;
	}
	public void setZmfqzScore(BigDecimal zmfqzScore) {
		this.zmfqzScore = zmfqzScore;
	}
	public BigDecimal getZmScore() {
		return zmScore;
	}
	public void setZmScore(BigDecimal zmScore) {
		this.zmScore = zmScore;
	}
	public String getZmfqzDetail() {
		return zmfqzDetail;
	}
	public void setZmfqzDetail(String zmfqzDetail) {
		this.zmfqzDetail = zmfqzDetail;
	}
	public BigDecimal getHoutiScore() {
		return houtiScore;
	}
	public void setHoutiScore(BigDecimal houtiScore) {
		this.houtiScore = houtiScore;
	}
	public String getHuotiDetail() {
		return huotiDetail;
	}
	public void setHuotiDetail(String huotiDetail) {
		this.huotiDetail = huotiDetail;
	}
	public List<String> getHuotiImg() {
		return huotiImg;
	}
	public void setHuotiImg(List<String> huotiImg) {
		this.huotiImg = huotiImg;
	}
	public String getHuotiFrom() {
		return huotiFrom;
	}
	public void setHuotiFrom(String huotiFrom) {
		this.huotiFrom = huotiFrom;
	}
	public String getBlackHitDetail() {
		return blackHitDetail;
	}
	public void setBlackHitDetail(String blackHitDetail) {
		this.blackHitDetail = blackHitDetail;
	}
	
}
