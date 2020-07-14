package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ExportLedgerData {

	@ExportFormat(name = "机构",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String coporateName;
	@ExportFormat(name = "数据日期",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String incomeOrderTime;
	@ExportFormat(name = "客户名称",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String customerName;
	@ExportFormat(name = "业务类型",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String businessType;
	@ExportFormat(name = "实际控制人",align = ExportFormatConstant.Align.LEFT,sort = 5)
	private String actualControlPerson;
	@ExportFormat(name = "是否集团客户",align = ExportFormatConstant.Align.LEFT,sort = 6)
	private String isGroupCustomer;
	@ExportFormat(name = "客户类型",align = ExportFormatConstant.Align.LEFT,sort = 7)
	private String customerType;
	@ExportFormat(name = "发放日期",align = ExportFormatConstant.Align.LEFT,sort = 8)
	private String makeLoanDate;
	@ExportFormat(name = "到期日期",align = ExportFormatConstant.Align.LEFT,sort = 9)
	private String expireDate;
	@ExportFormat(name = "发放金额（万元）",align = ExportFormatConstant.Align.LEFT,sort = 10)
	private String makeLoanAmt;
	@ExportFormat(name = "上季度分表风险分类结果",align = ExportFormatConstant.Align.LEFT,sort = 11)
	private String sjdfbfxfljg;
	@ExportFormat(name = "实际风险分类",align = ExportFormatConstant.Align.LEFT,sort = 12)
	private String sjfxfl;
	@ExportFormat(name = "本周余额（万元）",align = ExportFormatConstant.Align.LEFT,sort = 13)
	private String loanBalance;
	@ExportFormat(name = "逾期情况",align = ExportFormatConstant.Align.LEFT,sort = 14)
	private String isOverdue;
	@ExportFormat(name = "本金",align = ExportFormatConstant.Align.LEFT,sort = 15)
	private String overdueCaptial;
	@ExportFormat(name = "本金逾期天数",align = ExportFormatConstant.Align.LEFT,sort = 16)
	private String overdueCaptialDays;
	@ExportFormat(name = "利息",align = ExportFormatConstant.Align.LEFT,sort = 17)
	private String overdueInterest;
	@ExportFormat(name = "利息逾期天数",align = ExportFormatConstant.Align.LEFT,sort = 18)
	private String overdueInterestDays;
	@ExportFormat(name = "金额合计",align = ExportFormatConstant.Align.LEFT,sort = 19)
	private String overdueTotalAmt;
	@ExportFormat(name = "行业",align = ExportFormatConstant.Align.LEFT,sort = 20)
	private String industry;
	@ExportFormat(name = "地区（市）",align = ExportFormatConstant.Align.LEFT,sort = 21)
	private String address;
	@ExportFormat(name = "担保方式",align = ExportFormatConstant.Align.LEFT,sort = 22)
	private String guaranteeType;
	@ExportFormat(name = "抵押人及抵押物信息",align = ExportFormatConstant.Align.LEFT,sort = 23)
	private String collateralInfo;
	@ExportFormat(name = "出质人及质押物信息",align = ExportFormatConstant.Align.LEFT,sort = 24)
	private String pledgeInfo;
	@ExportFormat(name = "保证担保人",align = ExportFormatConstant.Align.LEFT,sort = 25)
	private String guarantee;
	@ExportFormat(name = "管控要求",align = ExportFormatConstant.Align.LEFT,sort = 26)
	private String gkyq;
	@ExportFormat(name = "执行年利率（%）",align = ExportFormatConstant.Align.LEFT,sort = 27)
	private String yearRate;
	@ExportFormat(name = "咨询费",align = ExportFormatConstant.Align.LEFT,sort = 28)
	private String consultationFee;
	@ExportFormat(name = "备注",align = ExportFormatConstant.Align.LEFT,sort = 29)
	private String remark;
	@ExportFormat(name = "最后一步审批人",align = ExportFormatConstant.Align.LEFT,sort = 30)
	private String lastAuditPerson;
	@ExportFormat(name = "审批时间",align = ExportFormatConstant.Align.LEFT,sort = 31)
	private String lastAuditTime;
	@ExportFormat(name = "最后一次还款时间",align = ExportFormatConstant.Align.LEFT,sort = 32)
	private String lastRepayedTime;
	
	
	public String getCoporateName() {
		return coporateName;
	}
	public void setCoporateName(String coporateName) {
		this.coporateName = coporateName;
	}
	public String getIncomeOrderTime() {
		return incomeOrderTime;
	}
	public void setIncomeOrderTime(String incomeOrderTime) {
		this.incomeOrderTime = incomeOrderTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getActualControlPerson() {
		return actualControlPerson;
	}
	public void setActualControlPerson(String actualControlPerson) {
		this.actualControlPerson = actualControlPerson;
	}
	public String getIsGroupCustomer() {
		return isGroupCustomer;
	}
	public void setIsGroupCustomer(String isGroupCustomer) {
		this.isGroupCustomer = isGroupCustomer;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getMakeLoanDate() {
		return makeLoanDate;
	}
	public void setMakeLoanDate(String makeLoanDate) {
		this.makeLoanDate = makeLoanDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getMakeLoanAmt() {
		return makeLoanAmt;
	}
	public void setMakeLoanAmt(String makeLoanAmt) {
		this.makeLoanAmt = makeLoanAmt;
	}
	public String getSjdfbfxfljg() {
		return sjdfbfxfljg;
	}
	public void setSjdfbfxfljg(String sjdfbfxfljg) {
		this.sjdfbfxfljg = sjdfbfxfljg;
	}
	public String getSjfxfl() {
		return sjfxfl;
	}
	public void setSjfxfl(String sjfxfl) {
		this.sjfxfl = sjfxfl;
	}
	public String getLoanBalance() {
		return loanBalance;
	}
	public void setLoanBalance(String loanBalance) {
		this.loanBalance = loanBalance;
	}
	public String getIsOverdue() {
		return isOverdue;
	}
	public void setIsOverdue(String isOverdue) {
		this.isOverdue = isOverdue;
	}
	public String getOverdueCaptial() {
		return overdueCaptial;
	}
	public void setOverdueCaptial(String overdueCaptial) {
		this.overdueCaptial = overdueCaptial;
	}
	public String getOverdueCaptialDays() {
		return overdueCaptialDays;
	}
	public void setOverdueCaptialDays(String overdueCaptialDays) {
		this.overdueCaptialDays = overdueCaptialDays;
	}
	public String getOverdueInterest() {
		return overdueInterest;
	}
	public void setOverdueInterest(String overdueInterest) {
		this.overdueInterest = overdueInterest;
	}
	public String getOverdueInterestDays() {
		return overdueInterestDays;
	}
	public void setOverdueInterestDays(String overdueInterestDays) {
		this.overdueInterestDays = overdueInterestDays;
	}
	public String getOverdueTotalAmt() {
		return overdueTotalAmt;
	}
	public void setOverdueTotalAmt(String overdueTotalAmt) {
		this.overdueTotalAmt = overdueTotalAmt;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGuaranteeType() {
		return guaranteeType;
	}
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}
	public String getCollateralInfo() {
		return collateralInfo;
	}
	public void setCollateralInfo(String collateralInfo) {
		this.collateralInfo = collateralInfo;
	}
	public String getPledgeInfo() {
		return pledgeInfo;
	}
	public void setPledgeInfo(String pledgeInfo) {
		this.pledgeInfo = pledgeInfo;
	}
	public String getGuarantee() {
		return guarantee;
	}
	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}
	public String getGkyq() {
		return gkyq;
	}
	public void setGkyq(String gkyq) {
		this.gkyq = gkyq;
	}
	public String getYearRate() {
		return yearRate;
	}
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
	}
	public String getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(String consultationFee) {
		this.consultationFee = consultationFee;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLastAuditPerson() {
		return lastAuditPerson;
	}
	public void setLastAuditPerson(String lastAuditPerson) {
		this.lastAuditPerson = lastAuditPerson;
	}
	public String getLastAuditTime() {
		return lastAuditTime;
	}
	public void setLastAuditTime(String lastAuditTime) {
		this.lastAuditTime = lastAuditTime;
	}
	public String getLastRepayedTime() {
		return lastRepayedTime;
	}
	public void setLastRepayedTime(String lastRepayedTime) {
		this.lastRepayedTime = lastRepayedTime;
	}
	
	
}
