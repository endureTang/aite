package com.nj.model.generate;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class NjProductTransaction {
    private String id;

    /**
     * 产品编号
     */
    @ApiModelProperty(value = "产品编号")
    private String productId;

    /**
     * 还款计划产生方式(0:系统生成,1:渠道方提供,2:用户指定日期)
     */
    @ApiModelProperty(value = "还款计划产生方式(0:系统生成,1:渠道方提供,2:用户指定日期)")
    private Byte repaymentPlanWay;

    /**
     * 还款计划时间偏移(系统生成时有效)
     */
    @ApiModelProperty(value = "还款计划时间偏移(系统生成时有效)")
    private Integer repaymentPlanDayOffset;

    /**
     * 固定投资人利率(年化利率)
     */
    @ApiModelProperty(value = "固定投资人利率(年化利率)")
    private BigDecimal fixedInterestRate;

    /**
     * 借款人利率
     */
    @ApiModelProperty(value = "借款人利率")
    private BigDecimal serviceCharge;

    /**
     * 提款控制(1:控制,0:不控制)
     */
    @ApiModelProperty(value = "提款控制(1:控制,0:不控制)")
    private Boolean drawingControl;

    /**
     * 是否需要用户确认(1:是,0:否)
     */
    @ApiModelProperty(value = "是否需要用户确认(1:是,0:否)")
    private Boolean isOnlineSign;

    /**
     * 是否支持提前还款(1:是,0:否)
     */
    @ApiModelProperty(value = "是否支持提前还款(1:是,0:否)")
    private Boolean isPrepaySup;

    /**
     * 是否支持罚息(1:是,0:否)
     */
    @ApiModelProperty(value = "是否支持罚息(1:是,0:否)")
    private Boolean isPenaltySup;

    /**
     * 合同生成方式(1:系统生成,2:审批上传)
     */
    @ApiModelProperty(value = "合同生成方式(1:系统生成,2:审批上传)")
    private Byte contractGenerationType;

    /**
     * 固定投资人利率
     */
    @ApiModelProperty(value = "固定投资人利率")
    private BigDecimal serviceRateTerm;

    /**
     * 期收服务费
     */
    @ApiModelProperty(value = "期收服务费")
    private BigDecimal termMoney;

    /**
     * 自有资金放款通道（1：系统放款，2：体外放款）
     */
    @ApiModelProperty(value = "自有资金放款通道（1：系统放款，2：体外放款）")
    private Short ownLoanType;

    /**
     * 渠道资金放款通道（1：系统放款，2：体外放款）
     */
    @ApiModelProperty(value = "渠道资金放款通道（1：系统放款，2：体外放款）")
    private Short channelLoanType;

    /**
     * 自有资金回款通道（1：系统回款，2：体外回款）
     */
    @ApiModelProperty(value = "自有资金回款通道（1：系统回款，2：体外回款）")
    private Short ownPaybackType;

    /**
     * 渠道资金回款通道（1：系统回款，2：体外回款）
     */
    @ApiModelProperty(value = "渠道资金回款通道（1：系统回款，2：体外回款）")
    private Short channelPaybackType;

    /**
     * 是否支持产品利率浮动
     */
    @ApiModelProperty(value = "是否支持产品利率浮动")
    private Byte feeFloat;

    /**
     * 是否支持代扣 0 否1是  默认为0
     */
    @ApiModelProperty(value = "是否支持代扣 0 否1是  默认为0")
    private Boolean isDeduct;

    /**
     * 最大进件金额
     */
    @ApiModelProperty(value = "最大进件金额")
    private BigDecimal maxAmount;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 产品编号
     * @return product_id 产品编号
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品编号
     * @param productId 产品编号
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 还款计划产生方式(0:系统生成,1:渠道方提供,2:用户指定日期)
     * @return repayment_plan_way 还款计划产生方式(0:系统生成,1:渠道方提供,2:用户指定日期)
     */
    public Byte getRepaymentPlanWay() {
        return repaymentPlanWay;
    }

    /**
     * 还款计划产生方式(0:系统生成,1:渠道方提供,2:用户指定日期)
     * @param repaymentPlanWay 还款计划产生方式(0:系统生成,1:渠道方提供,2:用户指定日期)
     */
    public void setRepaymentPlanWay(Byte repaymentPlanWay) {
        this.repaymentPlanWay = repaymentPlanWay;
    }

    /**
     * 还款计划时间偏移(系统生成时有效)
     * @return repayment_plan_day_offset 还款计划时间偏移(系统生成时有效)
     */
    public Integer getRepaymentPlanDayOffset() {
        return repaymentPlanDayOffset;
    }

    /**
     * 还款计划时间偏移(系统生成时有效)
     * @param repaymentPlanDayOffset 还款计划时间偏移(系统生成时有效)
     */
    public void setRepaymentPlanDayOffset(Integer repaymentPlanDayOffset) {
        this.repaymentPlanDayOffset = repaymentPlanDayOffset;
    }

    /**
     * 固定投资人利率(年化利率)
     * @return fixed_interest_rate 固定投资人利率(年化利率)
     */
    public BigDecimal getFixedInterestRate() {
        return fixedInterestRate;
    }

    /**
     * 固定投资人利率(年化利率)
     * @param fixedInterestRate 固定投资人利率(年化利率)
     */
    public void setFixedInterestRate(BigDecimal fixedInterestRate) {
        this.fixedInterestRate = fixedInterestRate;
    }

    /**
     * 借款人利率
     * @return service_charge 借款人利率
     */
    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    /**
     * 借款人利率
     * @param serviceCharge 借款人利率
     */
    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    /**
     * 提款控制(1:控制,0:不控制)
     * @return drawing_control 提款控制(1:控制,0:不控制)
     */
    public Boolean getDrawingControl() {
        return drawingControl;
    }

    /**
     * 提款控制(1:控制,0:不控制)
     * @param drawingControl 提款控制(1:控制,0:不控制)
     */
    public void setDrawingControl(Boolean drawingControl) {
        this.drawingControl = drawingControl;
    }

    /**
     * 是否需要用户确认(1:是,0:否)
     * @return is_online_sign 是否需要用户确认(1:是,0:否)
     */
    public Boolean getIsOnlineSign() {
        return isOnlineSign;
    }

    /**
     * 是否需要用户确认(1:是,0:否)
     * @param isOnlineSign 是否需要用户确认(1:是,0:否)
     */
    public void setIsOnlineSign(Boolean isOnlineSign) {
        this.isOnlineSign = isOnlineSign;
    }

    /**
     * 是否支持提前还款(1:是,0:否)
     * @return is_prepay_sup 是否支持提前还款(1:是,0:否)
     */
    public Boolean getIsPrepaySup() {
        return isPrepaySup;
    }

    /**
     * 是否支持提前还款(1:是,0:否)
     * @param isPrepaySup 是否支持提前还款(1:是,0:否)
     */
    public void setIsPrepaySup(Boolean isPrepaySup) {
        this.isPrepaySup = isPrepaySup;
    }

    /**
     * 是否支持罚息(1:是,0:否)
     * @return is_penalty_sup 是否支持罚息(1:是,0:否)
     */
    public Boolean getIsPenaltySup() {
        return isPenaltySup;
    }

    /**
     * 是否支持罚息(1:是,0:否)
     * @param isPenaltySup 是否支持罚息(1:是,0:否)
     */
    public void setIsPenaltySup(Boolean isPenaltySup) {
        this.isPenaltySup = isPenaltySup;
    }

    /**
     * 合同生成方式(1:系统生成,2:审批上传)
     * @return contract_generation_type 合同生成方式(1:系统生成,2:审批上传)
     */
    public Byte getContractGenerationType() {
        return contractGenerationType;
    }

    /**
     * 合同生成方式(1:系统生成,2:审批上传)
     * @param contractGenerationType 合同生成方式(1:系统生成,2:审批上传)
     */
    public void setContractGenerationType(Byte contractGenerationType) {
        this.contractGenerationType = contractGenerationType;
    }

    /**
     * 固定投资人利率
     * @return service_rate_term 固定投资人利率
     */
    public BigDecimal getServiceRateTerm() {
        return serviceRateTerm;
    }

    /**
     * 固定投资人利率
     * @param serviceRateTerm 固定投资人利率
     */
    public void setServiceRateTerm(BigDecimal serviceRateTerm) {
        this.serviceRateTerm = serviceRateTerm;
    }

    /**
     * 期收服务费
     * @return term_money 期收服务费
     */
    public BigDecimal getTermMoney() {
        return termMoney;
    }

    /**
     * 期收服务费
     * @param termMoney 期收服务费
     */
    public void setTermMoney(BigDecimal termMoney) {
        this.termMoney = termMoney;
    }

    /**
     * 自有资金放款通道（1：系统放款，2：体外放款）
     * @return own_loan_type 自有资金放款通道（1：系统放款，2：体外放款）
     */
    public Short getOwnLoanType() {
        return ownLoanType;
    }

    /**
     * 自有资金放款通道（1：系统放款，2：体外放款）
     * @param ownLoanType 自有资金放款通道（1：系统放款，2：体外放款）
     */
    public void setOwnLoanType(Short ownLoanType) {
        this.ownLoanType = ownLoanType;
    }

    /**
     * 渠道资金放款通道（1：系统放款，2：体外放款）
     * @return channel_loan_type 渠道资金放款通道（1：系统放款，2：体外放款）
     */
    public Short getChannelLoanType() {
        return channelLoanType;
    }

    /**
     * 渠道资金放款通道（1：系统放款，2：体外放款）
     * @param channelLoanType 渠道资金放款通道（1：系统放款，2：体外放款）
     */
    public void setChannelLoanType(Short channelLoanType) {
        this.channelLoanType = channelLoanType;
    }

    /**
     * 自有资金回款通道（1：系统回款，2：体外回款）
     * @return own_payback_type 自有资金回款通道（1：系统回款，2：体外回款）
     */
    public Short getOwnPaybackType() {
        return ownPaybackType;
    }

    /**
     * 自有资金回款通道（1：系统回款，2：体外回款）
     * @param ownPaybackType 自有资金回款通道（1：系统回款，2：体外回款）
     */
    public void setOwnPaybackType(Short ownPaybackType) {
        this.ownPaybackType = ownPaybackType;
    }

    /**
     * 渠道资金回款通道（1：系统回款，2：体外回款）
     * @return channel_payback_type 渠道资金回款通道（1：系统回款，2：体外回款）
     */
    public Short getChannelPaybackType() {
        return channelPaybackType;
    }

    /**
     * 渠道资金回款通道（1：系统回款，2：体外回款）
     * @param channelPaybackType 渠道资金回款通道（1：系统回款，2：体外回款）
     */
    public void setChannelPaybackType(Short channelPaybackType) {
        this.channelPaybackType = channelPaybackType;
    }

    /**
     * 是否支持产品利率浮动
     * @return fee_float 是否支持产品利率浮动
     */
    public Byte getFeeFloat() {
        return feeFloat;
    }

    /**
     * 是否支持产品利率浮动
     * @param feeFloat 是否支持产品利率浮动
     */
    public void setFeeFloat(Byte feeFloat) {
        this.feeFloat = feeFloat;
    }

    /**
     * 是否支持代扣 0 否1是  默认为0
     * @return is_deduct 是否支持代扣 0 否1是  默认为0
     */
    public Boolean getIsDeduct() {
        return isDeduct;
    }

    /**
     * 是否支持代扣 0 否1是  默认为0
     * @param isDeduct 是否支持代扣 0 否1是  默认为0
     */
    public void setIsDeduct(Boolean isDeduct) {
        this.isDeduct = isDeduct;
    }

    /**
     * 最大进件金额
     * @return max_amount 最大进件金额
     */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    /**
     * 最大进件金额
     * @param maxAmount 最大进件金额
     */
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }
}