package com.nj.mongoModel;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 还款计划主表信息
 * 记录还款计划的总体信息
 */
@ApiModel(description="还款计划主表")
public class RepayPlanMain extends MongoEntity{

	@ApiModelProperty(value = "订单编号")
	private String orderNo;
	
	@ApiModelProperty(value = "企业id")
	private String coporateId;
	
	@ApiModelProperty(value = "贷款期限")
	private Integer loanPeriod;
	
	@ApiModelProperty(value = "贷款金额")
	private BigDecimal loanAmt;
	
	@ApiModelProperty(value = "年利率，如：年利率10%,传0.1")
	private BigDecimal yearRate;
	
	@ApiModelProperty(value = "还款状态")
	private	String repayStatus;
	
	@ApiModelProperty(value = "是否提前结清，1是0否")
	private Integer isEarlySettle;
	
	@ApiModelProperty(value = "结清凭证的attachmentId")
	private String settleCert;
	
	@ApiModelProperty(value = "创建日期")
	private Date createDate;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public BigDecimal getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}
	public BigDecimal getYearRate() {
		return yearRate;
	}
	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}
	public String getRepayStatus() {
		return repayStatus;
	}
	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}
	public Integer getIsEarlySettle() {
		return isEarlySettle;
	}
	public void setIsEarlySettle(Integer isEarlySettle) {
		this.isEarlySettle = isEarlySettle;
	}
	public String getSettleCert() {
		return settleCert;
	}
	public void setSettleCert(String settleCert) {
		this.settleCert = settleCert;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCoporateId() {
		return coporateId;
	}
	public void setCoporateId(String coporateId) {
		this.coporateId = coporateId;
	}
}
