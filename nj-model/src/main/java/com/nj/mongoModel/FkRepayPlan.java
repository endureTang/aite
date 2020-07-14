package com.nj.mongoModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lizy
 * @version 2018/4/12.
 */
@ApiModel("还款计划model")
public class FkRepayPlan extends MongoEntity {
    @ApiModelProperty("项目id")
    private String projectId;
    @ApiModelProperty("项目编号")
    private String projectCode;
    @ApiModelProperty("期数")
    private int currentPeriod;
    @ApiModelProperty("计划还款日期")
    private Date repayPlanDate;
    @ApiModelProperty("借款人应还本金")
    private BigDecimal repayPlanCapital;
    @ApiModelProperty("借款人应还利息")
    private BigDecimal repayPlanInterest;
    @ApiModelProperty("应还投资人本金")
    private BigDecimal payInvestCapital;
    @ApiModelProperty("应还投资人利息")
    private BigDecimal payInterestinterest;
    @ApiModelProperty("借款人实还本金")
    private BigDecimal accCapital;
    @ApiModelProperty("借款人实还利息")
    private BigDecimal accInterest;
    @ApiModelProperty("借款人还款日期")
    private Date repayDate;
    @ApiModelProperty("逾期等级")
    private int overdueLevel;
    @ApiModelProperty("还款状态")
    private String status;
    @ApiModelProperty("是否代偿")
    private String isRecovery;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("逾期天数")
    private int overdueDay;
    @ApiModelProperty("应还滞纳金")
    private BigDecimal delayFee;
    @ApiModelProperty("实还滞纳金")
    private BigDecimal delayPay;
    @ApiModelProperty("应还罚息")
    private BigDecimal penaltyFee;
    @ApiModelProperty("实还罚息")
    private BigDecimal penaltyPay;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(int currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Date getRepayPlanDate() {
        return repayPlanDate;
    }

    public void setRepayPlanDate(Date repayPlanDate) {
        this.repayPlanDate = repayPlanDate;
    }

    public BigDecimal getRepayPlanCapital() {
        return repayPlanCapital;
    }

    public void setRepayPlanCapital(BigDecimal repayPlanCapital) {
        this.repayPlanCapital = repayPlanCapital;
    }

    public BigDecimal getRepayPlanInterest() {
        return repayPlanInterest;
    }

    public void setRepayPlanInterest(BigDecimal repayPlanInterest) {
        this.repayPlanInterest = repayPlanInterest;
    }

    public BigDecimal getPayInvestCapital() {
        return payInvestCapital;
    }

    public void setPayInvestCapital(BigDecimal payInvestCapital) {
        this.payInvestCapital = payInvestCapital;
    }

    public BigDecimal getPayInterestinterest() {
        return payInterestinterest;
    }

    public void setPayInterestinterest(BigDecimal payInterestinterest) {
        this.payInterestinterest = payInterestinterest;
    }

    public BigDecimal getAccCapital() {
        return accCapital;
    }

    public void setAccCapital(BigDecimal accCapital) {
        this.accCapital = accCapital;
    }

    public BigDecimal getAccInterest() {
        return accInterest;
    }

    public void setAccInterest(BigDecimal accInterest) {
        this.accInterest = accInterest;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public int getOverdueLevel() {
        return overdueLevel;
    }

    public void setOverdueLevel(int overdueLevel) {
        this.overdueLevel = overdueLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsRecovery() {
        return isRecovery;
    }

    public void setIsRecovery(String isRecovery) {
        this.isRecovery = isRecovery;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(int overdueDay) {
        this.overdueDay = overdueDay;
    }

    public BigDecimal getDelayFee() {
        return delayFee;
    }

    public void setDelayFee(BigDecimal delayFee) {
        this.delayFee = delayFee;
    }

    public BigDecimal getDelayPay() {
        return delayPay;
    }

    public void setDelayPay(BigDecimal delayPay) {
        this.delayPay = delayPay;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public BigDecimal getPenaltyPay() {
        return penaltyPay;
    }

    public void setPenaltyPay(BigDecimal penaltyPay) {
        this.penaltyPay = penaltyPay;
    }
}
