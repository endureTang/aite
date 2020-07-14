package com.nj.model.vo;

import java.math.BigDecimal;

/**
 * 摊余成本收入计算VO
 */
public class AmortizedCostVo {

	private Integer totalPeriod;					//总期数
	private Integer period;							//期数
	private BigDecimal periodBeginCapital;			//期初本金
	private String monthRate;						//月利率
	private BigDecimal planRepayCapital;			//每月本金
	private BigDecimal planRepayInterest;			//每月利息
	private BigDecimal planRepayCapInter;			//每月回收本息
	private BigDecimal periodBeginAmortizationCost;	//期初摊余成本
	private String accRate;							//实际利率
	private BigDecimal accInterest;					//实际利息
	private BigDecimal periodEndAmortizationCost;	//期末摊余成本
	private BigDecimal curInterestAdjust;			//当期利息调整
	private BigDecimal interestAdjustNum;			//利息调整累计
	
	public Integer getTotalPeriod() {
		return totalPeriod;
	}
	public void setTotalPeriod(Integer totalPeriod) {
		this.totalPeriod = totalPeriod;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public BigDecimal getPeriodBeginCapital() {
		return periodBeginCapital;
	}
	public void setPeriodBeginCapital(BigDecimal periodBeginCapital) {
		this.periodBeginCapital = periodBeginCapital;
	}
	public String getMonthRate() {
		return monthRate;
	}
	public void setMonthRate(String monthRate) {
		this.monthRate = monthRate;
	}
	public BigDecimal getPlanRepayCapital() {
		return planRepayCapital;
	}
	public void setPlanRepayCapital(BigDecimal planRepayCapital) {
		this.planRepayCapital = planRepayCapital;
	}
	public BigDecimal getPlanRepayInterest() {
		return planRepayInterest;
	}
	public void setPlanRepayInterest(BigDecimal planRepayInterest) {
		this.planRepayInterest = planRepayInterest;
	}
	public BigDecimal getPlanRepayCapInter() {
		return planRepayCapInter;
	}
	public void setPlanRepayCapInter(BigDecimal planRepayCapInter) {
		this.planRepayCapInter = planRepayCapInter;
	}
	public BigDecimal getPeriodBeginAmortizationCost() {
		return periodBeginAmortizationCost;
	}
	public void setPeriodBeginAmortizationCost(BigDecimal periodBeginAmortizationCost) {
		this.periodBeginAmortizationCost = periodBeginAmortizationCost;
	}
	public String getAccRate() {
		return accRate;
	}
	public void setAccRate(String accRate) {
		this.accRate = accRate;
	}
	public BigDecimal getAccInterest() {
		return accInterest;
	}
	public void setAccInterest(BigDecimal accInterest) {
		this.accInterest = accInterest;
	}
	public BigDecimal getPeriodEndAmortizationCost() {
		return periodEndAmortizationCost;
	}
	public void setPeriodEndAmortizationCost(BigDecimal periodEndAmortizationCost) {
		this.periodEndAmortizationCost = periodEndAmortizationCost;
	}
	public BigDecimal getCurInterestAdjust() {
		return curInterestAdjust;
	}
	public void setCurInterestAdjust(BigDecimal curInterestAdjust) {
		this.curInterestAdjust = curInterestAdjust;
	}
	public BigDecimal getInterestAdjustNum() {
		return interestAdjustNum;
	}
	public void setInterestAdjustNum(BigDecimal interestAdjustNum) {
		this.interestAdjustNum = interestAdjustNum;
	}
	
	
}
