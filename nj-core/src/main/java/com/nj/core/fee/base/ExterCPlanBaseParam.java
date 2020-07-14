package com.nj.core.fee.base;

import java.lang.reflect.Field;

/**
 * 外部调用贷后时，传入的创建还款计划和回款计划的基本参数
 */
public class ExterCPlanBaseParam {

	private String repayWay;   					//还款方式。如：10109
	private String beginInterestDate;			//计息开始日。如：2018-01-01
	private String planRepayNum;				//计划还款号数。  即每月几号还款。如：12
	
	private String customerLoanAmount;			//客户批复贷款金额。如：2000.00
	private String selfCompanyMaekLoanAmount;	//本公司放款金额。如：2000.00
	private String yearRate;					//贷款年利息。如：年利率10%,传0.1
	private String period;						//贷款期限，单位为月。如：12
	
	private String orderNo; 					//订单编号
	private String productId;					//产品id
	private String productName;					//产品名称
	private String loanUserId;					//贷款人id
	private String coporateId;					//企业id
	private String businessCommissionerId;		//客户经理id
	
	public String getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}
	public String getBeginInterestDate() {
		return beginInterestDate;
	}
	public void setBeginInterestDate(String beginInterestDate) {
		this.beginInterestDate = beginInterestDate;
	}
	public String getPlanRepayNum() {
		return planRepayNum;
	}
	public void setPlanRepayNum(String planRepayNum) {
		this.planRepayNum = planRepayNum;
	}
	public String getCustomerLoanAmount() {
		return customerLoanAmount;
	}
	public void setCustomerLoanAmount(String customerLoanAmount) {
		this.customerLoanAmount = customerLoanAmount;
	}
	public String getSelfCompanyMaekLoanAmount() {
		return selfCompanyMaekLoanAmount;
	}
	public void setSelfCompanyMaekLoanAmount(String selfCompanyMaekLoanAmount) {
		this.selfCompanyMaekLoanAmount = selfCompanyMaekLoanAmount;
	}
	public String getYearRate() {
		return yearRate;
	}
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLoanUserId() {
		return loanUserId;
	}
	public void setLoanUserId(String loanUserId) {
		this.loanUserId = loanUserId;
	}
	public String getCoporateId() {
		return coporateId;
	}
	public void setCoporateId(String coporateId) {
		this.coporateId = coporateId;
	}
	public String getBusinessCommissionerId() {
		return businessCommissionerId;
	}
	public void setBusinessCommissionerId(String businessCommissionerId) {
		this.businessCommissionerId = businessCommissionerId;
	}
	@Override
	public String toString() {
		StringBuilder ojbStr = new StringBuilder();
		Field[] fileds = this.getClass().getDeclaredFields();
		for (int i = 0; i < fileds.length; i++) {
			try {
				ojbStr.append(fileds[i].getName()).append("=").append(fileds[i].get(this)==null?"":fileds[i].get(this).toString()).append(",");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return ojbStr.toString();
	}
}
