package com.nj.mongoModel;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nj.core.base.util.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 逾期信息
 */
@ApiModel("逾期信息")
public class Overdue extends MongoEntity{

	@ApiModelProperty("业务日期")
	private Date businessDate;			//业务日期,表示该条逾期数据是哪一天的。 格式：yyyy-MM-dd
	
	@ApiModelProperty("订单编号")
	private String orderNo;				//订单编号
	
	@ApiModelProperty("企业id")
	private String companyId;	
	
	@ApiModelProperty("产品id")
	private String productId;	
	
	@ApiModelProperty("产品名称")
	private String productName;			//产品名称
	
	@ApiModelProperty("当前期数")
	private Integer curPeriod;			//当前期数
	
	@ApiModelProperty("当前逾期开始日期")
	private Date overdueBegin;			//当前逾期开始日期
	
	@ApiModelProperty("当前逾期天数")
	private Integer overdueDays;		//当前逾期天数
	
	@ApiModelProperty("当前逾期等级")
	private Integer overdueLevel;		//当前逾期等级
	
	@ApiModelProperty("当前逾期开始期数")
	private Integer overdueBeginPeriod;	//当前逾期开始期数
	
	@ApiModelProperty("当前未还本金累计")
	private BigDecimal unpayCapital;	//当前未还本金累计
	
	@ApiModelProperty("当前未还利息累计")
	private BigDecimal unpayInterest;	//当前未还利息累计
	
	@ApiModelProperty("当前未还本息累计")
	private BigDecimal unpayTotal;		//当前未还本息累计
	
	@ApiModelProperty("剩余应收总和")
	private BigDecimal remainTotal;		//剩余应收总和	
	
	@ApiModelProperty("剩余应收本金")
	private BigDecimal remainCapital;	//剩余应收本金
	
	@ApiModelProperty("剩余应收利息")
	private BigDecimal remainInterest;	//剩余应收利息
	
	@ApiModelProperty("剩余应收罚息")
	private BigDecimal remainPenalty;	//剩余应收罚息
	
	/**
	 * 保存到mongo时对时间格式化，解决时间相差8小时问题
	 */
	public void saveToMongoFormat(){
		this.businessDate = DateUtil.getAfterDate(this.getBusinessDate(), Calendar.HOUR_OF_DAY, 8);
		this.overdueBegin = DateUtil.getAfterDate(this.getOverdueBegin(), Calendar.HOUR_OF_DAY, 8);
	}

	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCurPeriod() {
		return curPeriod;
	}

	public void setCurPeriod(Integer curPeriod) {
		this.curPeriod = curPeriod;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getOverdueBegin() {
		return overdueBegin;
	}

	public void setOverdueBegin(Date overdueBegin) {
		this.overdueBegin = overdueBegin;
	}

	public Integer getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}

	public Integer getOverdueLevel() {
		return overdueLevel;
	}

	public void setOverdueLevel(Integer overdueLevel) {
		this.overdueLevel = overdueLevel;
	}

	public Integer getOverdueBeginPeriod() {
		return overdueBeginPeriod;
	}

	public void setOverdueBeginPeriod(Integer overdueBeginPeriod) {
		this.overdueBeginPeriod = overdueBeginPeriod;
	}

	public BigDecimal getUnpayCapital() {
		return unpayCapital;
	}

	public void setUnpayCapital(BigDecimal unpayCapital) {
		this.unpayCapital = unpayCapital;
	}

	public BigDecimal getUnpayInterest() {
		return unpayInterest;
	}

	public void setUnpayInterest(BigDecimal unpayInterest) {
		this.unpayInterest = unpayInterest;
	}

	public BigDecimal getUnpayTotal() {
		return unpayTotal;
	}

	public void setUnpayTotal(BigDecimal unpayTotal) {
		this.unpayTotal = unpayTotal;
	}

	public BigDecimal getRemainTotal() {
		return remainTotal;
	}

	public void setRemainTotal(BigDecimal remainTotal) {
		this.remainTotal = remainTotal;
	}

	public BigDecimal getRemainCapital() {
		return remainCapital;
	}

	public void setRemainCapital(BigDecimal remainCapital) {
		this.remainCapital = remainCapital;
	}

	public BigDecimal getRemainInterest() {
		return remainInterest;
	}

	public void setRemainInterest(BigDecimal remainInterest) {
		this.remainInterest = remainInterest;
	}

	public BigDecimal getRemainPenalty() {
		return remainPenalty;
	}

	public void setRemainPenalty(BigDecimal remainPenalty) {
		this.remainPenalty = remainPenalty;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
}
