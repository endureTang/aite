package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ExportDyOrderData {

	@ExportFormat(name = "客户名称",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String customerName;		
	@ExportFormat(name = "批复金额",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String auditAmount;		
	@ExportFormat(name = "德阳金坤实际放款金额",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String actualAmount;
	@ExportFormat(name = "德阳金坤的贷款余额",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String loanBalace;	
	@ExportFormat(name = "抵押物的位置",align = ExportFormatConstant.Align.LEFT,sort = 5)
	private String dyAdress;
	@ExportFormat(name = "抵押物价值",align = ExportFormatConstant.Align.LEFT,sort = 6)
	private String dyPrice;				
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAuditAmount() {
		return auditAmount;
	}
	public void setAuditAmount(String auditAmount) {
		this.auditAmount = auditAmount;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	public String getLoanBalace() {
		return loanBalace;
	}
	public void setLoanBalace(String loanBalace) {
		this.loanBalace = loanBalace;
	}
	public String getDyAdress() {
		return dyAdress;
	}
	public void setDyAdress(String dyAdress) {
		this.dyAdress = dyAdress;
	}
	public String getDyPrice() {
		return dyPrice;
	}
	public void setDyPrice(String dyPrice) {
		this.dyPrice = dyPrice;
	}
}
