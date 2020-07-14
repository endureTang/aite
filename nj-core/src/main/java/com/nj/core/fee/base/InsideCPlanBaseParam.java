package com.nj.core.fee.base;

import com.nj.core.base.util.StringUtils;

/**
 * 贷后模块，生成还款计划和回款计划的基本参数
 */
public class InsideCPlanBaseParam {

	private String repayWay;   					//还款方式。如：10109
	private String beginInterestDate;			//计息开始日。如：2018-01-01
	private String planRepayNum;				//计划还款号数。  即每月几号还款。如：12
	
	private String loanAmount;					//贷款金额。如：2000.00
	private String yearRate;					//贷款年利息。如：年利率10%,传0.1
	private String period;						//贷款期限，单位为月。如：12
	
	private String orderNo; 					//订单编号
	private String productId;					//产品id
	private String productName;					//产品名称
	private String loanUserId;					//贷款人id
	private String coporateId;					//企业id
	private String businessCommissionerId;		//客户经理id
	
	public void validate() throws Exception{
		if(StringUtils.isEmpty(this.repayWay)){
			throw new Exception("repayWay不能为空");
		}
		if(StringUtils.isEmpty(this.beginInterestDate)){
			throw new Exception("beginInterestDate不能为空");
		}
		if(StringUtils.isEmpty(this.planRepayNum)){
			throw new Exception("planRepayNum不能为空");
		}
		if(StringUtils.isEmpty(this.loanAmount)){
			throw new Exception("loanAmount不能为空");
		}
		if(StringUtils.isEmpty(this.yearRate)){
			throw new Exception("yearRate不能为空");
		}
		if(StringUtils.isEmpty(this.period)){
			throw new Exception("period不能为空");
		}
		if(StringUtils.isEmpty(this.orderNo)){
			throw new Exception("orderNo不能为空");
		}
		if(StringUtils.isEmpty(this.productId)){
			throw new Exception("productId不能为空");
		}
		if(StringUtils.isEmpty(this.productName)){
			throw new Exception("productName不能为空");
		}
		if(StringUtils.isEmpty(this.loanUserId)){
			throw new Exception("loanUserId不能为空");
		}
		if(StringUtils.isEmpty(this.coporateId)){
			throw new Exception("coporateId不能为空");
		}
		if(StringUtils.isEmpty(this.businessCommissionerId)){
			throw new Exception("businessCommissionerId不能为空");
		}
	}


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


	public String getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
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
}
