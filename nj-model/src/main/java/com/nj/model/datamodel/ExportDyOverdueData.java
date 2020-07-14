package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ExportDyOverdueData {

	@ExportFormat(name = "客户姓名",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String customerName;
	@ExportFormat(name = "手机号",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String mobile;
	@ExportFormat(name = "身份证号",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String identityNo;
	@ExportFormat(name = "订单编号",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String orderNo;
	@ExportFormat(name = "逾期期数",align = ExportFormatConstant.Align.LEFT,sort = 5)
	private String overduePeriod;
	@ExportFormat(name = "计划还款日期",align = ExportFormatConstant.Align.CENTER,sort = 6)
	private String planRepayDate;
	@ExportFormat(name = "应还总额",align = ExportFormatConstant.Align.RIGHT,sort = 7)
	private String planRepayTotalAmt;
	@ExportFormat(name = "逾期天数",align = ExportFormatConstant.Align.CENTER,sort = 8)
	private String overdueDays;
	@ExportFormat(name = "贷款余额",align = ExportFormatConstant.Align.RIGHT,sort = 9)
	private String loanBalance;
	@ExportFormat(name = "放款金额",align = ExportFormatConstant.Align.RIGHT,sort = 10)
	private String makeLoanAmt;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOverduePeriod() {
		return overduePeriod;
	}
	public void setOverduePeriod(String overduePeriod) {
		this.overduePeriod = overduePeriod;
	}
	public String getPlanRepayDate() {
		return planRepayDate;
	}
	public void setPlanRepayDate(String planRepayDate) {
		this.planRepayDate = planRepayDate;
	}
	public String getPlanRepayTotalAmt() {
		return planRepayTotalAmt;
	}
	public void setPlanRepayTotalAmt(String planRepayTotalAmt) {
		this.planRepayTotalAmt = planRepayTotalAmt;
	}
	public String getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(String overdueDays) {
		this.overdueDays = overdueDays;
	}
	public String getLoanBalance() {
		return loanBalance;
	}
	public void setLoanBalance(String loanBalance) {
		this.loanBalance = loanBalance;
	}
	public String getMakeLoanAmt() {
		return makeLoanAmt;
	}
	public void setMakeLoanAmt(String makeLoanAmt) {
		this.makeLoanAmt = makeLoanAmt;
	}
}
