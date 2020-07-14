package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ExportTdUseStaticData {

	@ExportFormat(name = "客户经理",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String accountManager;		
	@ExportFormat(name = "客户名称",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String customer;			
	@ExportFormat(name = "所属企业",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String companyName;			
	@ExportFormat(name = "查询时间",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String queryDateTime;		
	
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getQueryDateTime() {
		return queryDateTime;
	}
	public void setQueryDateTime(String queryDateTime) {
		this.queryDateTime = queryDateTime;
	}
}
