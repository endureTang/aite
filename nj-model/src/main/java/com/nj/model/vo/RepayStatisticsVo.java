package com.nj.model.vo;

import java.math.BigDecimal;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 还款统计
 * @author MaSong
 * @date 2019-08-27
 */
public class RepayStatisticsVo {
	
	// 产品ID
	private String productId;
	
	// 产品名称
	@ExportFormat(name = "产品名称",align = ExportFormatConstant.Align.CENTER,sort = 2)
	private String productName;
	
	// 应还总额
	@ExportFormat(name = "应收总额",align = ExportFormatConstant.Align.CENTER,sort = 8)
	private BigDecimal planAmount;
	
	// 实还总额
	@ExportFormat(name = "实收总额",align = ExportFormatConstant.Align.CENTER,sort = 14)
	private BigDecimal accAmount;

	// 应还本金
	@ExportFormat(name = "应收本金",align = ExportFormatConstant.Align.CENTER,sort = 3)
	private BigDecimal  planCapital;
	
	// 实还本金
	@ExportFormat(name = "实收本金",align = ExportFormatConstant.Align.CENTER,sort = 9)
	private BigDecimal  accCapital;
	
	// 应还利息
	@ExportFormat(name = "应收利息",align = ExportFormatConstant.Align.CENTER,sort = 4)
	private BigDecimal  planInterest;
	
	// 实还利息
	@ExportFormat(name = "实收利息",align = ExportFormatConstant.Align.CENTER,sort = 10)
	private BigDecimal accInterest;
	
	// 应还罚息
	@ExportFormat(name = "应还罚息",align = ExportFormatConstant.Align.CENTER,sort = 5)
	private BigDecimal planPenaltyInterest;
	
	// 实还罚息
	@ExportFormat(name = "实收罚息",align = ExportFormatConstant.Align.CENTER,sort = 11)
	private BigDecimal accPenaltyInterest;
	
	// 应还渠道费
	@ExportFormat(name = "应还渠道费",align = ExportFormatConstant.Align.CENTER,sort = 6)
	private BigDecimal planChannelFee;
	
	// 实还渠道费
	@ExportFormat(name = "实收渠道费",align = ExportFormatConstant.Align.CENTER,sort = 12)
	private BigDecimal accChannelFee;
	
	// 应还居间费
	@ExportFormat(name = "应还居间费",align = ExportFormatConstant.Align.CENTER,sort = 7)
	private BigDecimal planMediacyFee;
	
	// 实还居间费
	@ExportFormat(name = "实收居间费",align = ExportFormatConstant.Align.CENTER,sort = 13)
	private BigDecimal accMediacyFee;
	
	// 统计时间
	@ExportFormat(name = "年月",align = ExportFormatConstant.Align.CENTER,sort = 1)
	private String statisticsDate;
	
	public RepayStatisticsVo(){
		planAmount = new BigDecimal("0");
		accAmount = new BigDecimal("0");
		planCapital = new BigDecimal("0");
		accCapital = new BigDecimal("0");
		planInterest = new BigDecimal("0");
		accInterest = new BigDecimal("0");
		planPenaltyInterest = new BigDecimal("0");
		accPenaltyInterest = new BigDecimal("0");
		planChannelFee = new BigDecimal("0");
		accChannelFee = new BigDecimal("0");
		planMediacyFee = new BigDecimal("0");
		accMediacyFee = new BigDecimal("0");
		
		
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(BigDecimal planAmount) {
		this.planAmount = planAmount;
	}

	public BigDecimal getAccAmount() {
		return accAmount;
	}

	public void setAccAmount(BigDecimal accAmount) {
		this.accAmount = accAmount;
	}

	public BigDecimal getPlanCapital() {
		return planCapital;
	}

	public void setPlanCapital(BigDecimal planCapital) {
		this.planCapital = planCapital;
	}

	public BigDecimal getAccCapital() {
		return accCapital;
	}

	public void setAccCapital(BigDecimal accCapital) {
		this.accCapital = accCapital;
	}

	public BigDecimal getPlanInterest() {
		return planInterest;
	}

	public void setPlanInterest(BigDecimal planInterest) {
		this.planInterest = planInterest;
	}

	public BigDecimal getAccInterest() {
		return accInterest;
	}

	public void setAccInterest(BigDecimal accInterest) {
		this.accInterest = accInterest;
	}

	public BigDecimal getPlanPenaltyInterest() {
		return planPenaltyInterest;
	}

	public void setPlanPenaltyInterest(BigDecimal planPenaltyInterest) {
		this.planPenaltyInterest = planPenaltyInterest;
	}

	public BigDecimal getAccPenaltyInterest() {
		return accPenaltyInterest;
	}

	public void setAccPenaltyInterest(BigDecimal accPenaltyInterest) {
		this.accPenaltyInterest = accPenaltyInterest;
	}

	public BigDecimal getPlanChannelFee() {
		return planChannelFee;
	}

	public void setPlanChannelFee(BigDecimal planChannelFee) {
		this.planChannelFee = planChannelFee;
	}

	public BigDecimal getAccChannelFee() {
		return accChannelFee;
	}

	public void setAccChannelFee(BigDecimal accChannelFee) {
		this.accChannelFee = accChannelFee;
	}

	public BigDecimal getPlanMediacyFee() {
		return planMediacyFee;
	}

	public void setPlanMediacyFee(BigDecimal planMediacyFee) {
		this.planMediacyFee = planMediacyFee;
	}

	public BigDecimal getAccMediacyFee() {
		return accMediacyFee;
	}

	public void setAccMediacyFee(BigDecimal accMediacyFee) {
		this.accMediacyFee = accMediacyFee;
	}

	public String getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(String statisticsDate) {
		this.statisticsDate = statisticsDate;
	}
	
}

