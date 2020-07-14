package com.nj.model.vo;

import java.math.BigDecimal;

public class OverdueVo {

	private String projectId;			//项目id
	private String projectCode;			//项目编码
	private String projectType;			//项目分类
	private String orderNo;				//订单编号
	private String repayPlanId;			//还款计划id,对应还款计划的某一期
	
	private String planRepayDate;			//计划还款日期
	private String accRepayDate;			//实际还款日期
	private Integer overdueLevel;		//逾期等级
	private String isCompensatory;		//是否代偿
	private Integer overdueDays;		//逾期天数
	private BigDecimal delayFee;		//应还滞纳金
	private BigDecimal delayPay;		//实还滞纳金
	private BigDecimal penaltyFee;		//应还罚息
	private BigDecimal penaltyPay;		//实还罚息
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRepayPlanId() {
		return repayPlanId;
	}
	public void setRepayPlanId(String repayPlanId) {
		this.repayPlanId = repayPlanId;
	}
	public String getPlanRepayDate() {
		return planRepayDate;
	}
	public void setPlanRepayDate(String planRepayDate) {
		this.planRepayDate = planRepayDate;
	}
	public String getAccRepayDate() {
		return accRepayDate;
	}
	public void setAccRepayDate(String accRepayDate) {
		this.accRepayDate = accRepayDate;
	}
	public Integer getOverdueLevel() {
		return overdueLevel;
	}
	public void setOverdueLevel(Integer overdueLevel) {
		this.overdueLevel = overdueLevel;
	}
	public String getIsCompensatory() {
		return isCompensatory;
	}
	public void setIsCompensatory(String isCompensatory) {
		this.isCompensatory = isCompensatory;
	}
	public Integer getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}
	public BigDecimal getDelayFee() {
		return delayFee;
	}
	public void setDelayFee(BigDecimal delayFee) {
		this.delayFee = delayFee;
	}
	public BigDecimal getDelayPay() {
		return delayPay;
	}
	public void setDelayPay(BigDecimal delayPay) {
		this.delayPay = delayPay;
	}
	public BigDecimal getPenaltyFee() {
		return penaltyFee;
	}
	public void setPenaltyFee(BigDecimal penaltyFee) {
		this.penaltyFee = penaltyFee;
	}
	public BigDecimal getPenaltyPay() {
		return penaltyPay;
	}
	public void setPenaltyPay(BigDecimal penaltyPay) {
		this.penaltyPay = penaltyPay;
	}
}
