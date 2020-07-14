package com.nj.model.generate;

import java.util.Date;

import com.nj.core.base.util.DateUtil;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 导出用
 * 不用原生实体类，是因为以后增删字段时会重新通过数据库自动生成实体类，我们加入的注解需要重新添加
 */
public class NjRepayOfflineLineForExport {

	@ExportFormat(name = "计划还款日期",align = ExportFormatConstant.Align.CENTER,sort = 1)
	private String planRepayDay="";

	@ExportFormat(name = "实际还款日期",align = ExportFormatConstant.Align.CENTER,sort = 2)
	private String actualRepayDay="";
	
	@ExportFormat(name = "还款总额",align = ExportFormatConstant.Align.RIGHT,sort = 3)
	private String totalAmount = "";
	
	@ExportFormat(name = "还款本金",align = ExportFormatConstant.Align.RIGHT,sort = 4)
	private String principal = "";
	
	@ExportFormat(name = "还款利息",align = ExportFormatConstant.Align.RIGHT,sort = 5)
	private String interest = "";
	
	@ExportFormat(name = "还款状态",align = ExportFormatConstant.Align.CENTER,sort = 6)
	private String status = "";

	@ExportFormat(name = "逾期（天）",align = ExportFormatConstant.Align.RIGHT,sort = 7)
	private String overdueDay = "";
	
	public NjRepayOfflineLineForExport(NjRepayOfflineLine obj) {
		// TODO Auto-generated constructor stub
		if(obj.getPlanRepayDay() != null)
		planRepayDay = DateUtil.formatDate(obj.getPlanRepayDay());
		if(obj.getActualRepayDay() != null)
		actualRepayDay = DateUtil.formatDate(obj.getActualRepayDay());

		totalAmount = obj.getTotalAmount().toString();
		principal = obj.getPrincipal().toString();
		interest = obj.getInterest().toString();
		if(obj.getStatus() != null){
			status = obj.getStatus();
			if("10".equals(status)){
				status = "未到期";
			} else if("20".equals(status)){
				status = "到期未还款";
			} else if("90".equals(status)){
				status = "已还款";
			}
		}
		if(obj.getOverdueDay() != null){
			overdueDay = obj.getOverdueDay()+"";
		}
	}

	public String getPlanRepayDay() {
		return planRepayDay;
	}

	public void setPlanRepayDay(String planRepayDay) {
		this.planRepayDay = planRepayDay;
	}

	public String getActualRepayDay() {
		return actualRepayDay;
	}

	public void setActualRepayDay(String actualRepayDay) {
		this.actualRepayDay = actualRepayDay;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOverdueDay() {
		return overdueDay;
	}

	public void setOverdueDay(String overdueDay) {
		this.overdueDay = overdueDay;
	}

}
