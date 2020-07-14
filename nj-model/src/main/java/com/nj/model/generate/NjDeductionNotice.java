package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjDeductionNotice {
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 第三方订单编号
     */
    @ApiModelProperty(value = "第三方订单编号")
    private String sourceOrderNo;

    private Integer period;

    /**
     * 计划还款日期
     */
    @ApiModelProperty(value = "计划还款日期")
    private Date planRepayDate;

    /**
     * 应还总额
     */
    @ApiModelProperty(value = "应还总额")
    private BigDecimal planRepayTotalAmt;

    private BigDecimal accRepayTotalAmt;

    /**
     * 扣款时间
     */
    @ApiModelProperty(value = "扣款时间")
    private Date deductionDate;

    /**
     * 是否通知，0否1是
     */
    @ApiModelProperty(value = "是否通知，0否1是")
    private Boolean isNotice;

    /**
     * 扣款状态  0 失败  1 成功。
     */
    @ApiModelProperty(value = "扣款状态  0 失败  1 成功。")
    private Byte diductionStatus;

    private String failReasion;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String trueName;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    private String bankNum;

    /**
     * 扣款金额
     */
    @ApiModelProperty(value = "扣款金额")
    private BigDecimal deductionAmt;

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
     * 订单编号
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 第三方订单编号
     * @return source_order_no 第三方订单编号
     */
    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    /**
     * 第三方订单编号
     * @param sourceOrderNo 第三方订单编号
     */
    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    /**
     * 
     * @return period 
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 
     * @param period 
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 计划还款日期
     * @return plan_repay_date 计划还款日期
     */
    public Date getPlanRepayDate() {
        return planRepayDate;
    }

    /**
     * 计划还款日期
     * @param planRepayDate 计划还款日期
     */
    public void setPlanRepayDate(Date planRepayDate) {
        this.planRepayDate = planRepayDate;
    }

    /**
     * 应还总额
     * @return plan_repay_total_amt 应还总额
     */
    public BigDecimal getPlanRepayTotalAmt() {
        return planRepayTotalAmt;
    }

    /**
     * 应还总额
     * @param planRepayTotalAmt 应还总额
     */
    public void setPlanRepayTotalAmt(BigDecimal planRepayTotalAmt) {
        this.planRepayTotalAmt = planRepayTotalAmt;
    }

    /**
     * 
     * @return acc_repay_total_amt 
     */
    public BigDecimal getAccRepayTotalAmt() {
        return accRepayTotalAmt;
    }

    /**
     * 
     * @param accRepayTotalAmt 
     */
    public void setAccRepayTotalAmt(BigDecimal accRepayTotalAmt) {
        this.accRepayTotalAmt = accRepayTotalAmt;
    }

    /**
     * 扣款时间
     * @return deduction_date 扣款时间
     */
    public Date getDeductionDate() {
        return deductionDate;
    }

    /**
     * 扣款时间
     * @param deductionDate 扣款时间
     */
    public void setDeductionDate(Date deductionDate) {
        this.deductionDate = deductionDate;
    }

    /**
     * 是否通知，0否1是
     * @return is_notice 是否通知，0否1是
     */
    public Boolean getIsNotice() {
        return isNotice;
    }

    /**
     * 是否通知，0否1是
     * @param isNotice 是否通知，0否1是
     */
    public void setIsNotice(Boolean isNotice) {
        this.isNotice = isNotice;
    }

    /**
     * 扣款状态  0 失败  1 成功。
     * @return diduction_status 扣款状态  0 失败  1 成功。
     */
    public Byte getDiductionStatus() {
        return diductionStatus;
    }

    /**
     * 扣款状态  0 失败  1 成功。
     * @param diductionStatus 扣款状态  0 失败  1 成功。
     */
    public void setDiductionStatus(Byte diductionStatus) {
        this.diductionStatus = diductionStatus;
    }

    /**
     * 
     * @return fail_reasion 
     */
    public String getFailReasion() {
        return failReasion;
    }

    /**
     * 
     * @param failReasion 
     */
    public void setFailReasion(String failReasion) {
        this.failReasion = failReasion;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 真实姓名
     * @return true_name 真实姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 真实姓名
     * @param trueName 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 银行卡号
     * @return bank_num 银行卡号
     */
    public String getBankNum() {
        return bankNum;
    }

    /**
     * 银行卡号
     * @param bankNum 银行卡号
     */
    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    /**
     * 扣款金额
     * @return deduction_amt 扣款金额
     */
    public BigDecimal getDeductionAmt() {
        return deductionAmt;
    }

    /**
     * 扣款金额
     * @param deductionAmt 扣款金额
     */
    public void setDeductionAmt(BigDecimal deductionAmt) {
        this.deductionAmt = deductionAmt;
    }
}