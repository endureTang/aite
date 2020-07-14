package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ExportLedgerData3 {

	@ExportFormat(name = "机构",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String coporateName;
	@ExportFormat(name = "合同编号（订单编号）",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String orderNo;
	@ExportFormat(name = "客户名称",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String customerName;
	@ExportFormat(name = "证件类型",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String certType;
	@ExportFormat(name = "证件号码",align = ExportFormatConstant.Align.LEFT,sort = 5)
	private String certNo;
	@ExportFormat(name = "发放日期",align = ExportFormatConstant.Align.LEFT,sort = 6)
	private String makeLoanDate;
	@ExportFormat(name = "首次扣款日期",align = ExportFormatConstant.Align.LEFT,sort = 7)
	private String firstDeductDate;
	@ExportFormat(name = "到期日期",align = ExportFormatConstant.Align.LEFT,sort = 8)
	private String expireDate;
	@ExportFormat(name = "还款方式",align = ExportFormatConstant.Align.LEFT,sort = 9)
	private String repayWay;
	@ExportFormat(name = "贷款期限（月）",align = ExportFormatConstant.Align.LEFT,sort = 10)
	private String loanPeriod;
	@ExportFormat(name = "发放金额（万元）",align = ExportFormatConstant.Align.LEFT,sort = 11)
	private String makeLoanAmt;
	@ExportFormat(name = "当前余额（万元）",align = ExportFormatConstant.Align.LEFT,sort = 12)
	private String loanBalance;
	@ExportFormat(name = "本金或利息是否逾期",align = ExportFormatConstant.Align.LEFT,sort = 13)
	private String isOverdue;
	@ExportFormat(name = "逾期开始日期",align = ExportFormatConstant.Align.LEFT,sort = 14)
	private String overdueBeginDate;
	@ExportFormat(name = "本金逾期金额",align = ExportFormatConstant.Align.LEFT,sort = 15)
	private String capitalOverdueAmt;
	@ExportFormat(name = "本金逾期天数",align = ExportFormatConstant.Align.LEFT,sort = 16)
	private String capitalOverdueDays;
	@ExportFormat(name = "利息逾期金额",align = ExportFormatConstant.Align.LEFT,sort = 17)
	private String interestOverdueAmt;
	@ExportFormat(name = "利息逾期天数",align = ExportFormatConstant.Align.LEFT,sort = 18)
	private String interestOverdueDays;
	@ExportFormat(name = "逾期金额合计",align = ExportFormatConstant.Align.LEFT,sort = 19)
	private String overdueTotalAmt;
	@ExportFormat(name = "执行年利率（%）",align = ExportFormatConstant.Align.LEFT,sort = 20)
	private String yearRate;
	
	// 抵押物信息
	@ExportFormat(name = "所有权人",align = ExportFormatConstant.Align.LEFT,sort = 21)
	private String owner;
	@ExportFormat(name = "评估价值（元）",align = ExportFormatConstant.Align.LEFT,sort = 22)
	private String companyPrice;
	@ExportFormat(name = "房屋所有权证号",align = ExportFormatConstant.Align.LEFT,sort = 23)
	private String warrantNo;	
	@ExportFormat(name = "省",align = ExportFormatConstant.Align.LEFT,sort = 24)
	private String province;
	@ExportFormat(name = "市",align = ExportFormatConstant.Align.LEFT,sort = 25)
	private String city;
	@ExportFormat(name = "区",align = ExportFormatConstant.Align.LEFT,sort = 26)
	private String county;
	@ExportFormat(name = "详细地址",align = ExportFormatConstant.Align.LEFT,sort = 27)
	private String address;
	@ExportFormat(name = "建筑面积",align = ExportFormatConstant.Align.LEFT,sort = 28)
	private String coveredArea;
	
	
	public String getCoporateName() {
		return coporateName;
	}
	public void setCoporateName(String coporateName) {
		this.coporateName = coporateName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getMakeLoanDate() {
		return makeLoanDate;
	}
	public void setMakeLoanDate(String makeLoanDate) {
		this.makeLoanDate = makeLoanDate;
	}
	public String getFirstDeductDate() {
		return firstDeductDate;
	}
	public void setFirstDeductDate(String firstDeductDate) {
		this.firstDeductDate = firstDeductDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}
	public String getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(String loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public String getMakeLoanAmt() {
		return makeLoanAmt;
	}
	public void setMakeLoanAmt(String makeLoanAmt) {
		this.makeLoanAmt = makeLoanAmt;
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
	public String getOverdueBeginDate() {
		return overdueBeginDate;
	}
	public void setOverdueBeginDate(String overdueBeginDate) {
		this.overdueBeginDate = overdueBeginDate;
	}
	public String getCapitalOverdueAmt() {
		return capitalOverdueAmt;
	}
	public void setCapitalOverdueAmt(String capitalOverdueAmt) {
		this.capitalOverdueAmt = capitalOverdueAmt;
	}
	public String getCapitalOverdueDays() {
		return capitalOverdueDays;
	}
	public void setCapitalOverdueDays(String capitalOverdueDays) {
		this.capitalOverdueDays = capitalOverdueDays;
	}
	public String getInterestOverdueAmt() {
		return interestOverdueAmt;
	}
	public void setInterestOverdueAmt(String interestOverdueAmt) {
		this.interestOverdueAmt = interestOverdueAmt;
	}
	public String getInterestOverdueDays() {
		return interestOverdueDays;
	}
	public void setInterestOverdueDays(String interestOverdueDays) {
		this.interestOverdueDays = interestOverdueDays;
	}
	public String getOverdueTotalAmt() {
		return overdueTotalAmt;
	}
	public void setOverdueTotalAmt(String overdueTotalAmt) {
		this.overdueTotalAmt = overdueTotalAmt;
	}
	public String getYearRate() {
		return yearRate;
	}
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCompanyPrice() {
		return companyPrice;
	}
	public void setCompanyPrice(String companyPrice) {
		this.companyPrice = companyPrice;
	}
	public String getWarrantNo() {
		return warrantNo;
	}
	public void setWarrantNo(String warrantNo) {
		this.warrantNo = warrantNo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCoveredArea() {
		return coveredArea;
	}
	public void setCoveredArea(String coveredArea) {
		this.coveredArea = coveredArea;
	}
	
}
