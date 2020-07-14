package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 
 * @author Administrator
 */
public class ExportSysLedgerData2 {
	
	@ExportFormat(name = "公司",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String coporateName;
	@ExportFormat(name = "姓名",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String customerName;
	@ExportFormat(name = "年龄",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String age;
	@ExportFormat(name = "性别",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String sex;
	@ExportFormat(name = "进件金额",align = ExportFormatConstant.Align.LEFT,sort = 5)
	private String loanAmt;
	@ExportFormat(name = "业务审批通过金额",align = ExportFormatConstant.Align.LEFT,sort = 6)
	private String crossAmt;
	@ExportFormat(name = "抵押物城市",align = ExportFormatConstant.Align.LEFT,sort = 7)
	private String dyCity;
	@ExportFormat(name = "抵押物的位置",align = ExportFormatConstant.Align.LEFT,sort = 8)
	private String dyAdress;
	@ExportFormat(name = "常住地址",align = ExportFormatConstant.Align.LEFT,sort = 9)
	private String ermanentAdress;
	@ExportFormat(name = "职业",align = ExportFormatConstant.Align.LEFT,sort = 10)
	private String occupation;
	@ExportFormat(name = "贷款用途",align = ExportFormatConstant.Align.LEFT,sort = 11)
	private String loanPurpose;
	@ExportFormat(name = "是否放款",align = ExportFormatConstant.Align.LEFT,sort = 12)
	private String isMakeLoan;
	@ExportFormat(name = "放款金额 ",align = ExportFormatConstant.Align.LEFT,sort = 13)
	private String makeLoanAmt;
	@ExportFormat(name = "当前是否逾期 ",align = ExportFormatConstant.Align.LEFT,sort = 14)
	private String isOverdue;
	@ExportFormat(name = "逾期时间 ",align = ExportFormatConstant.Align.LEFT,sort = 15)
	private String overdueTime;
	@ExportFormat(name = "逾期本金 ",align = ExportFormatConstant.Align.LEFT,sort = 16)
	private String overdueCapital;
	@ExportFormat(name = "逾期利息",align = ExportFormatConstant.Align.LEFT,sort = 17)
	private String overdueInterise;
	@ExportFormat(name = "当前时点贷款余额",align = ExportFormatConstant.Align.LEFT,sort = 18)
	private String loanBalanceCur;
	@ExportFormat(name = "执行年利率",align = ExportFormatConstant.Align.LEFT,sort = 19)
	private String yearRate;
	
	public String getCoporateName() {
		return coporateName;
	}
	public void setCoporateName(String coporateName) {
		this.coporateName = coporateName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(String loanAmt) {
		this.loanAmt = loanAmt;
	}
	public String getCrossAmt() {
		return crossAmt;
	}
	public void setCrossAmt(String crossAmt) {
		this.crossAmt = crossAmt;
	}
	public String getDyCity() {
		return dyCity;
	}
	public void setDyCity(String dyCity) {
		this.dyCity = dyCity;
	}
	public String getDyAdress() {
		return dyAdress;
	}
	public void setDyAdress(String dyAdress) {
		this.dyAdress = dyAdress;
	}
	public String getErmanentAdress() {
		return ermanentAdress;
	}
	public void setErmanentAdress(String ermanentAdress) {
		this.ermanentAdress = ermanentAdress;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getIsMakeLoan() {
		return isMakeLoan;
	}
	public void setIsMakeLoan(String isMakeLoan) {
		this.isMakeLoan = isMakeLoan;
	}
	public String getMakeLoanAmt() {
		return makeLoanAmt;
	}
	public void setMakeLoanAmt(String makeLoanAmt) {
		this.makeLoanAmt = makeLoanAmt;
	}
	public String getIsOverdue() {
		return isOverdue;
	}
	public void setIsOverdue(String isOverdue) {
		this.isOverdue = isOverdue;
	}
	public String getOverdueTime() {
		return overdueTime;
	}
	public void setOverdueTime(String overdueTime) {
		this.overdueTime = overdueTime;
	}
	public String getOverdueCapital() {
		return overdueCapital;
	}
	public void setOverdueCapital(String overdueCapital) {
		this.overdueCapital = overdueCapital;
	}
	public String getOverdueInterise() {
		return overdueInterise;
	}
	public void setOverdueInterise(String overdueInterise) {
		this.overdueInterise = overdueInterise;
	}
	public String getLoanBalanceCur() {
		return loanBalanceCur;
	}
	public void setLoanBalanceCur(String loanBalanceCur) {
		this.loanBalanceCur = loanBalanceCur;
	}
	public String getYearRate() {
		return yearRate;
	}
	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
	}
	
}
