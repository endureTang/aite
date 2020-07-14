package com.nj.mongoModel;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 普惠还款计划
 *
 * @author Lizy
 * @version 2018/4/18.
 */
public class PhRepayPlan extends MongoEntity {
    @ApiModelProperty("订单id")
    private String orderId;
    @ApiModelProperty("业务日期")
    private String busiDt;
    @ApiModelProperty("贷款申请编号")
    private String loanNo;
    @ApiModelProperty("分期期数")
    private int installNum;
    @ApiModelProperty("当前期数")
    private int currInstallNum;
    @ApiModelProperty("应收日期")
    private String repayDt;
    @ApiModelProperty("应还总额")
    private double receAmt;
    @ApiModelProperty("应收本金")
    private double recePrinAmt;
    @ApiModelProperty("应收利息")
    private double receInterAmt;
    @ApiModelProperty("应收服务费")
    private double receServiceAmt;
    @ApiModelProperty("应收滞纳金")
    private double receOverdueAmt;
    @ApiModelProperty("应收账户管理费")
    private double receAccountMrgAmt;
    @ApiModelProperty("应收保险费")
    private double receInsuranceAmt;
    @ApiModelProperty("应收手续费")
    private double receProcAmt;
    @ApiModelProperty("应收提前还款违约金")
    private double recePenaltyAmt;
    @ApiModelProperty("应收还款随心包")
    private double receAttachAmt;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBusiDt() {
        return busiDt;
    }

    public void setBusiDt(String busiDt) {
        this.busiDt = busiDt;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public int getInstallNum() {
        return installNum;
    }

    public void setInstallNum(int installNum) {
        this.installNum = installNum;
    }

    public int getCurrInstallNum() {
        return currInstallNum;
    }

    public void setCurrInstallNum(int currInstallNum) {
        this.currInstallNum = currInstallNum;
    }

    public String getRepayDt() {
        return repayDt;
    }

    public void setRepayDt(String repayDt) {
        this.repayDt = repayDt;
    }

    public double getReceAmt() {
        return receAmt;
    }

    public void setReceAmt(double receAmt) {
        this.receAmt = receAmt;
    }

    public double getRecePrinAmt() {
        return recePrinAmt;
    }

    public void setRecePrinAmt(double recePrinAmt) {
        this.recePrinAmt = recePrinAmt;
    }

    public double getReceInterAmt() {
        return receInterAmt;
    }

    public void setReceInterAmt(double receInterAmt) {
        this.receInterAmt = receInterAmt;
    }

    public double getReceServiceAmt() {
        return receServiceAmt;
    }

    public void setReceServiceAmt(double receServiceAmt) {
        this.receServiceAmt = receServiceAmt;
    }

    public double getReceOverdueAmt() {
        return receOverdueAmt;
    }

    public void setReceOverdueAmt(double receOverdueAmt) {
        this.receOverdueAmt = receOverdueAmt;
    }

    public double getReceAccountMrgAmt() {
        return receAccountMrgAmt;
    }

    public void setReceAccountMrgAmt(double receAccountMrgAmt) {
        this.receAccountMrgAmt = receAccountMrgAmt;
    }

    public double getReceInsuranceAmt() {
        return receInsuranceAmt;
    }

    public void setReceInsuranceAmt(double receInsuranceAmt) {
        this.receInsuranceAmt = receInsuranceAmt;
    }

    public double getReceProcAmt() {
        return receProcAmt;
    }

    public void setReceProcAmt(double receProcAmt) {
        this.receProcAmt = receProcAmt;
    }

    public double getRecePenaltyAmt() {
        return recePenaltyAmt;
    }

    public void setRecePenaltyAmt(double recePenaltyAmt) {
        this.recePenaltyAmt = recePenaltyAmt;
    }

    public double getReceAttachAmt() {
        return receAttachAmt;
    }

    public void setReceAttachAmt(double receAttachAmt) {
        this.receAttachAmt = receAttachAmt;
    }
}
