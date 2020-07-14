package com.nj.mongoModel;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.nj.core.base.util.DateUtil;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 标准还款计划
 * @author wangkh
 */
@ApiModel(description="还款计划")
public class RepayPlan extends MongoEntity{

	@ApiModelProperty(value = "产品编码")
	private String productCode;	//产品编码
	
	@ApiModelProperty(value = "产品名称")
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="产品名称",sort=3)
	private String productName;	//产品名称
	
	@ApiModelProperty(value = "订单编号")
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="订单编号",sort=1)
	private String orderNo;					//订单编号
	
	@ApiModelProperty(value = "企业id")
	private String coporateId;				//企业id
	
	@ApiModelProperty(value = "贷款人id")
	private String loanUserId;				//贷款人id
	
	@ApiModelProperty(value = "客户经理id")
	private String businessCommissionerId;	//客户经理id
	
	@ApiModelProperty(value = "贷款年利率")
	private BigDecimal yearRate;			//贷款年利率
	
	@ApiModelProperty(value = "期数")
	private Integer period;					//期数
	
	@ApiModelProperty(value = "计划还款日期")
	private Date planRepayDate;				//计划还款日期
	
	@ApiModelProperty(value = "计划还款本金")
	private BigDecimal planRepayCapital;	//计划还款本金
	
	@ApiModelProperty(value = "计划还款利息")
	private BigDecimal planRepayInterest;	//计划还款利息
	
	@ApiModelProperty(value = "计划每期渠道手续费")
	private BigDecimal planChannelFeeForPeriod;	//计划每期渠道手续费
	
	@ApiModelProperty(value = "应还投资人本金，集成风控应用数据库表中字段")
	private BigDecimal payInvestCapital;	//应还投资人本金，集成风控应用数据库表中字段
	
	@ApiModelProperty(value = "应还投资人利息，集成风控应用数据库表中字段")
	private BigDecimal payInterestInterest;	//应还投资人利息，集成风控应用数据库表中字段
	
	@ApiModelProperty(value = "实际还款日期")
	private Date accRepayDate;				//实际还款日期
	
	@ApiModelProperty(value = "实际还款本金")
	private BigDecimal accRepayCapital;		//实际还款本金
	
	@ApiModelProperty(value = "实际还款利息")
	private BigDecimal accReapyInterest;	//实际还款利息
	
	@ApiModelProperty(value = "实际每期渠道手续费")
	private BigDecimal accChannelFeeForPeriod;	//实际每期渠道手续费
	
	@ApiModelProperty(value = "逾期等级")
	private Integer overdueLevel;			//逾期等级
	
	@ApiModelProperty(value = "逾期天数")
	private Integer overdueDays;			//逾期天数
	
	@ApiModelProperty(value = "应还罚息")
	private BigDecimal payPenalty;			//应还罚息 
	
	@ApiModelProperty(value = "实还罚息")
	private BigDecimal accPayPenalty;		//实还罚息
	
	@ApiModelProperty(value = "还款状态")
	@ExportFormat(align=ExportFormatConstant.Align.LEFT,formatType=ExportFormatConstant.FormatType.STRING,name="还款状态",sort=2)
	private String repayStatus;				//还款状态
	
	@ApiModelProperty(value = "扣款结果")
	private String deductionResult;			//扣款结果
	
	/**
	 * 保存到mongo时对时间格式化，解决时间相差8小时问题
	 */
	public void saveToMongoFormat(){
		this.planRepayDate = DateUtil.getAfterDate(this.getPlanRepayDate(), Calendar.HOUR_OF_DAY, 8);
		this.accRepayDate = DateUtil.getAfterDate(this.getAccRepayDate(), Calendar.HOUR_OF_DAY, 8);
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCoporateId() {
		return coporateId;
	}

	public void setCoporateId(String coporateId) {
		this.coporateId = coporateId;
	}

	public String getLoanUserId() {
		return loanUserId;
	}

	public void setLoanUserId(String loanUserId) {
		this.loanUserId = loanUserId;
	}

	public String getBusinessCommissionerId() {
		return businessCommissionerId;
	}

	public void setBusinessCommissionerId(String businessCommissionerId) {
		this.businessCommissionerId = businessCommissionerId;
	}

	public BigDecimal getYearRate() {
		return yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Date getPlanRepayDate() {
		return planRepayDate;
	}

	public void setPlanRepayDate(Date planRepayDate) {
		this.planRepayDate = planRepayDate;
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

	public BigDecimal getPayInvestCapital() {
		return payInvestCapital;
	}

	public void setPayInvestCapital(BigDecimal payInvestCapital) {
		this.payInvestCapital = payInvestCapital;
	}

	public BigDecimal getPayInterestInterest() {
		return payInterestInterest;
	}

	public void setPayInterestInterest(BigDecimal payInterestInterest) {
		this.payInterestInterest = payInterestInterest;
	}

	public Date getAccRepayDate() {
		return accRepayDate;
	}

	public void setAccRepayDate(Date accRepayDate) {
		this.accRepayDate = accRepayDate;
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

	public Integer getOverdueLevel() {
		return overdueLevel;
	}

	public void setOverdueLevel(Integer overdueLevel) {
		this.overdueLevel = overdueLevel;
	}

	public Integer getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}

	public BigDecimal getPayPenalty() {
		return payPenalty;
	}

	public void setPayPenalty(BigDecimal payPenalty) {
		this.payPenalty = payPenalty;
	}

	public BigDecimal getAccPayPenalty() {
		return accPayPenalty;
	}

	public void setAccPayPenalty(BigDecimal accPayPenalty) {
		this.accPayPenalty = accPayPenalty;
	}

	public String getRepayStatus() {
		return repayStatus;
	}

	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}

	public String getDeductionResult() {
		return deductionResult;
	}

	public void setDeductionResult(String deductionResult) {
		this.deductionResult = deductionResult;
	}

	
}
