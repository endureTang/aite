package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 成都金坤线下房抵贷数据汇总表导出实体类
 */
public class ExportCdHouseData {

	@ExportFormat(name = "数据统计时间",align = ExportFormatConstant.Align.CENTER,sort = 1)
	private String statisDate;
	@ExportFormat(name = "进件数量",align = ExportFormatConstant.Align.CENTER,sort = 2)
	private Long incomeNum;
	@ExportFormat(name = "审批数量",align = ExportFormatConstant.Align.CENTER,sort = 3)
	private Long auditNum;
	@ExportFormat(name = "通过数量",align = ExportFormatConstant.Align.CENTER,sort = 4)
	private Long auditCrossOrderNum;
	@ExportFormat(name = "进件金额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 5)
	private String incomeTotalAmt;
	@ExportFormat(name = "通过金额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 6)
	private String auditCrossTotalAmt;
	@ExportFormat(name = "新增放款（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 7)
	private String newAddMakeLoanAmt;
	@ExportFormat(name = "回收贷款本金（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 8)
	private String acceptedCapitalSum;
	@ExportFormat(name = "回收贷款利息（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 9)
	private String acceptedInterestSum;
	@ExportFormat(name = "应收本金总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 10)
	private String planCapitalSum;
	@ExportFormat(name = "应收利息总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 11)
	private String planInterestSum;
	@ExportFormat(name = "应收未收本金总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 12)
	private String planNotCapitalSum;
	@ExportFormat(name = "应收未收利息总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 13)
	private String planNotInterestSum;
	@ExportFormat(name = "应收未收本息总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 14)
	private String planNotCapitalInterestSum;
	@ExportFormat(name = "逾期超过90天的本金总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 15)
	private String overdue90CapitalSum;
	@ExportFormat(name = "逾期超过90天的利息总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 16)
	private String overdue90InterestSum;
	@ExportFormat(name = "逾期超过90天的本息总额（万元）",align = ExportFormatConstant.Align.RIGHT,sort = 17)
	private String overdue90CapitalInterestSum;
	@ExportFormat(name = "逾期率",align = ExportFormatConstant.Align.CENTER,sort = 18)
	private String overdueRate;
	@ExportFormat(name = "不良率",align = ExportFormatConstant.Align.CENTER,sort = 19)
	private String poorRate;
	
	public String getStatisDate() {
		return statisDate;
	}
	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}
	public Long getIncomeNum() {
		return incomeNum;
	}
	public void setIncomeNum(Long incomeNum) {
		this.incomeNum = incomeNum;
	}
	public Long getAuditNum() {
		return auditNum;
	}
	public void setAuditNum(Long auditNum) {
		this.auditNum = auditNum;
	}
	public Long getAuditCrossOrderNum() {
		return auditCrossOrderNum;
	}
	public void setAuditCrossOrderNum(Long auditCrossOrderNum) {
		this.auditCrossOrderNum = auditCrossOrderNum;
	}
	public String getIncomeTotalAmt() {
		return incomeTotalAmt;
	}
	public void setIncomeTotalAmt(String incomeTotalAmt) {
		this.incomeTotalAmt = incomeTotalAmt;
	}
	public String getAuditCrossTotalAmt() {
		return auditCrossTotalAmt;
	}
	public void setAuditCrossTotalAmt(String auditCrossTotalAmt) {
		this.auditCrossTotalAmt = auditCrossTotalAmt;
	}
	public String getNewAddMakeLoanAmt() {
		return newAddMakeLoanAmt;
	}
	public void setNewAddMakeLoanAmt(String newAddMakeLoanAmt) {
		this.newAddMakeLoanAmt = newAddMakeLoanAmt;
	}
	public String getAcceptedCapitalSum() {
		return acceptedCapitalSum;
	}
	public void setAcceptedCapitalSum(String acceptedCapitalSum) {
		this.acceptedCapitalSum = acceptedCapitalSum;
	}
	public String getAcceptedInterestSum() {
		return acceptedInterestSum;
	}
	public void setAcceptedInterestSum(String acceptedInterestSum) {
		this.acceptedInterestSum = acceptedInterestSum;
	}
	public String getPlanCapitalSum() {
		return planCapitalSum;
	}
	public void setPlanCapitalSum(String planCapitalSum) {
		this.planCapitalSum = planCapitalSum;
	}
	public String getPlanInterestSum() {
		return planInterestSum;
	}
	public void setPlanInterestSum(String planInterestSum) {
		this.planInterestSum = planInterestSum;
	}
	public String getPlanNotCapitalSum() {
		return planNotCapitalSum;
	}
	public void setPlanNotCapitalSum(String planNotCapitalSum) {
		this.planNotCapitalSum = planNotCapitalSum;
	}
	public String getPlanNotInterestSum() {
		return planNotInterestSum;
	}
	public void setPlanNotInterestSum(String planNotInterestSum) {
		this.planNotInterestSum = planNotInterestSum;
	}
	public String getPlanNotCapitalInterestSum() {
		return planNotCapitalInterestSum;
	}
	public void setPlanNotCapitalInterestSum(String planNotCapitalInterestSum) {
		this.planNotCapitalInterestSum = planNotCapitalInterestSum;
	}
	public String getOverdue90CapitalSum() {
		return overdue90CapitalSum;
	}
	public void setOverdue90CapitalSum(String overdue90CapitalSum) {
		this.overdue90CapitalSum = overdue90CapitalSum;
	}
	public String getOverdue90InterestSum() {
		return overdue90InterestSum;
	}
	public void setOverdue90InterestSum(String overdue90InterestSum) {
		this.overdue90InterestSum = overdue90InterestSum;
	}
	public String getOverdue90CapitalInterestSum() {
		return overdue90CapitalInterestSum;
	}
	public void setOverdue90CapitalInterestSum(String overdue90CapitalInterestSum) {
		this.overdue90CapitalInterestSum = overdue90CapitalInterestSum;
	}
	public String getOverdueRate() {
		return overdueRate;
	}
	public void setOverdueRate(String overdueRate) {
		this.overdueRate = overdueRate;
	}
	public String getPoorRate() {
		return poorRate;
	}
	public void setPoorRate(String poorRate) {
		this.poorRate = poorRate;
	}
}
