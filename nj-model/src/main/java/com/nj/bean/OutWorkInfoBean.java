package com.nj.bean;

import java.math.BigDecimal;
import java.util.List;

public class OutWorkInfoBean {
	private String companyName;
	private String companyTel;
	private String companyAddr;
	private String job;
	private BigDecimal annualIncome;
	private String monthIncome;
	private List<String> attachments;
	private String recentWorkYears;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getMonthIncome() {
		return monthIncome;
	}
	public void setMonthIncome(String monthIncome) {
		this.monthIncome = monthIncome;
	}
	public List<String> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	public String getRecentWorkYears() {
		return recentWorkYears;
	}
	public void setRecentWorkYears(String recentWorkYears) {
		this.recentWorkYears = recentWorkYears;
	}
	
	
}
