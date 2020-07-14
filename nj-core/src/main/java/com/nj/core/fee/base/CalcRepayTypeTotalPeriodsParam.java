package com.nj.core.fee.base;
/**
 * 调用还款方式的方法（计算生成还款计划或回款计划的最终期数）时传入的参数
 */
public class CalcRepayTypeTotalPeriodsParam {

	private String repayWay;   					//还款方式。如：10109
	private String beginInterestDate;			//计息开始日。如：2018-01-01
	private String planRepayNum;				//计划还款号数。  即每月几号还款。如：12
	private String period;						//贷款期限，单位为月。如：12
	
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
}
