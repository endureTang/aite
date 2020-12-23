package com.nj.mongoModel.after;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.nj.mongoModel.MongoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 金融机构回款计划主表信息
 */
@ApiModel(description="回款计划主表")
public class CaptialMoneyBackMainNew extends MongoEntity {

	@ApiModelProperty(value = "订单编号")
	private String orderNo;
	
	@ApiModelProperty(value = "资金渠道id")
	private String coporateId;
	
	@ApiModelProperty(value = "产品id")
	private String productId;
	
	@ApiModelProperty(value = "贷款金额")
	private BigDecimal loanAmt;

	@ApiModelProperty(value = "年利率，如：年利率10%,传0.1")
	private BigDecimal yearRate;

	@ApiModelProperty(value = "贷款期限")
	private Integer loanPeriod;
	
	@ApiModelProperty(value = "还款状态")
	private	String repayStatus;
	
	@ApiModelProperty(value = "是否提前结清，1是0否")
	private Integer isEarlySettle;
	
	@ApiModelProperty(value = "结清凭证的attachmentId")
	private String settleCert;
	
	@ApiModelProperty(value = "提前结清手续费")
	private BigDecimal earlySettleServiceFee;	
	
	@ApiModelProperty(value = "提前结清时间")
	private Date earlySettleDate;
	
	@ApiModelProperty(value = "创建日期")
	private Date createDate;
	
	@ApiModelProperty(value = "数据类型：his 的时候为历史数据")
	private  String  dataFlag;
	
	private List<CaptialMoneyBackNew> listMoneyBackNew;

	public List<CaptialMoneyBackNew> getListMoneyBackNew() {
		return listMoneyBackNew;
	}

	public void setListMoneyBackNew(List<CaptialMoneyBackNew> listMoneyBackNew) {
		this.listMoneyBackNew = listMoneyBackNew;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public Integer getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
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

	public BigDecimal getEarlySettleServiceFee() {
		return earlySettleServiceFee;
	}

	public void setEarlySettleServiceFee(BigDecimal earlySettleServiceFee) {
		this.earlySettleServiceFee = earlySettleServiceFee;
	}
	
	public Date getEarlySettleDate() {
		return earlySettleDate;
	}

	public void setEarlySettleDate(Date earlySettleDate) {
		this.earlySettleDate = earlySettleDate;
	}

	public String getDataFlag() {
		return dataFlag;
	}
	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}
	
}
