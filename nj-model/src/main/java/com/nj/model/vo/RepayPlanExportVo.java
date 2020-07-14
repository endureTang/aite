package com.nj.model.vo;

import java.math.BigDecimal;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class RepayPlanExportVo {

	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="订单编号",sort=1)
	private String orderNo;					//订单编号
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="还款状态",sort=2)
	private String repayStatus;				//还款状态
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="产品名称",sort=3)
	private String productName;				//产品名称
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="借款人姓名",sort=4)
	private String userName;				//借款人姓名
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="身份证",sort=5)
	private String identifyId;				//身份证
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="借款金额",sort=6)
	private BigDecimal auditAmount;			//即借款金额
	
	@ExportFormat(align=ExportFormatConstant.Align.CENTER,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.INT,name="借款期限",sort=7)
	private Integer auditPeriod;			//借款期限
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="计划还款日期",sort=8)
	private String planRepayDateStr;		//计划还款日期
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="计划还款本金",sort=9)
	private BigDecimal planRepayCapital;	//计划还款本金
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="计划还款利息",sort=10)
	private BigDecimal planRepayInterest;	//计划还款利息
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="应还渠道费",sort=11)
	private BigDecimal planChannelFeeForPeriod;	//应还渠道费
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="应还总额",sort=12)
	private BigDecimal planRepayTotalAmt;	//应还总额
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="实际还款本金",sort=13)
	private BigDecimal accRepayCapital;		//实际还款本金
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="实际还款利息",sort=14)
	private BigDecimal accReapyInterest;	//实际还款利息
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="实还渠道费",sort=15)
	private BigDecimal accChannelFeeForPeriod;	//实还渠道费
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="实还罚息",sort=16)
	private BigDecimal accPayPenalty;	//实还罚息
	
	@ExportFormat(align=ExportFormatConstant.Align.RIGHT,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_2,name="实还总额",sort=17)
	private BigDecimal accRepayTotalAmt;	//实还总额
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="当月实际还款日期",sort=18)
	private String accRepayDateStr;			//实际还款日期
	
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="扣款情况",sort=19)
	private String deductionResult;			//扣款情况

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRepayStatus() {
		return repayStatus;
	}

	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentifyId() {
		return identifyId;
	}

	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}

	public BigDecimal getAuditAmount() {
		return auditAmount;
	}

	public void setAuditAmount(BigDecimal auditAmount) {
		this.auditAmount = auditAmount;
	}

	public Integer getAuditPeriod() {
		return auditPeriod;
	}

	public void setAuditPeriod(Integer auditPeriod) {
		this.auditPeriod = auditPeriod;
	}

	public String getPlanRepayDateStr() {
		return planRepayDateStr;
	}

	public void setPlanRepayDateStr(String planRepayDateStr) {
		this.planRepayDateStr = planRepayDateStr;
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

	public BigDecimal getPlanChannelFeeForPeriod() {
		return planChannelFeeForPeriod;
	}

	public void setPlanChannelFeeForPeriod(BigDecimal planChannelFeeForPeriod) {
		this.planChannelFeeForPeriod = planChannelFeeForPeriod;
	}

	public BigDecimal getPlanRepayTotalAmt() {
		return planRepayTotalAmt;
	}

	public void setPlanRepayTotalAmt(BigDecimal planRepayTotalAmt) {
		this.planRepayTotalAmt = planRepayTotalAmt;
	}

	public BigDecimal getAccRepayCapital() {
		return accRepayCapital;
	}

	public void setAccRepayCapital(BigDecimal accRepayCapital) {
		this.accRepayCapital = accRepayCapital;
	}

	public BigDecimal getAccReapyInterest() {
		return accReapyInterest;
	}

	public void setAccReapyInterest(BigDecimal accReapyInterest) {
		this.accReapyInterest = accReapyInterest;
	}

	public BigDecimal getAccChannelFeeForPeriod() {
		return accChannelFeeForPeriod;
	}

	public void setAccChannelFeeForPeriod(BigDecimal accChannelFeeForPeriod) {
		this.accChannelFeeForPeriod = accChannelFeeForPeriod;
	}

	public BigDecimal getAccPayPenalty() {
		return accPayPenalty;
	}

	public void setAccPayPenalty(BigDecimal accPayPenalty) {
		this.accPayPenalty = accPayPenalty;
	}

	public BigDecimal getAccRepayTotalAmt() {
		return accRepayTotalAmt;
	}

	public void setAccRepayTotalAmt(BigDecimal accRepayTotalAmt) {
		this.accRepayTotalAmt = accRepayTotalAmt;
	}

	public String getAccRepayDateStr() {
		return accRepayDateStr;
	}

	public void setAccRepayDateStr(String accRepayDateStr) {
		this.accRepayDateStr = accRepayDateStr;
	}

	public String getDeductionResult() {
		return deductionResult;
	}

	public void setDeductionResult(String deductionResult) {
		this.deductionResult = deductionResult;
	}



	
}
