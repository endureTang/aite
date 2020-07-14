package com.nj.mongoModel;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 普惠还款详情
 *
 * @author Lizy
 * @version 2018/4/18.
 */
public class PhRepayDetail extends MongoEntity {
    @ApiModelProperty("订单id")
    private String orderId;
    @ApiModelProperty("业务日期")
    private String busiDt;
    @ApiModelProperty("贷款申请编号")
    private String loanNo;
    @ApiModelProperty("客户编号")
    private String custNo;
    @ApiModelProperty("客户号")
    private String ecifCustNo;
    @ApiModelProperty("分期期数")
    private int installNum;
    @ApiModelProperty("当前期数")
    private int currInstallNum;
    @ApiModelProperty("当期是否结清")
    private String isCloseCurrNum;
    @ApiModelProperty("应收日期")
    private String repayDt;
    @ApiModelProperty("应还总额")
    private double receAmt;
    @ApiModelProperty("减免总额")
    private double reduAmt;
    @ApiModelProperty("实还总额")
    private double actuAmt;
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
    @ApiModelProperty("减免本金")
    private double reduPrinAmt;
    @ApiModelProperty("减免利息")
    private double reduInterAmt;
    @ApiModelProperty("减免服务费")
    private double reduServiceAmt;
    @ApiModelProperty("减免滞纳金")
    private double reduOverdueAmt;
    @ApiModelProperty("减免账户管理费")
    private double reduAccountMrgAmt;
    @ApiModelProperty("减免保险费")
    private double reduInsuranceAmt;
    @ApiModelProperty("减免手续费")
    private double reduProcAmt;
    @ApiModelProperty("减免提前还款违约金")
    private double reduPenaltyAmt;
    @ApiModelProperty("减免还款随心包")
    private double reduAttachAmt;
    @ApiModelProperty("实收日期")
    private String transDt;
    @ApiModelProperty("实收本金")
    private double actuPrinAmt;
    @ApiModelProperty("实收利息")
    private double actuInterAmt;
    @ApiModelProperty("实收服务费")
    private double actuServiceAmt;
    @ApiModelProperty("实收滞纳金")
    private double actuOverdueAmt;
    @ApiModelProperty("实收账户管理费")
    private double actuAccountMrgAmt;
    @ApiModelProperty("实收保险费")
    private double actuInsuranceAmt;
    @ApiModelProperty("实收手续费")
    private double actuProcAmt;
    @ApiModelProperty("实收违约金")
    private double actuPenaltyAmt;
    @ApiModelProperty("实收还款随心包")
    private double actuAttachAmt;
    @ApiModelProperty("超额还款")
    private double overAmt;
    @ApiModelProperty("对公还款金额")
    private double dgTransBal;
    @ApiModelProperty("代扣还款金额")
    private double dkTransBal;
    @ApiModelProperty("剩余本金")
    private double remainPrin;
    @ApiModelProperty("逾期等级")
    private int overLvl;
    @ApiModelProperty("晚还款天数")
    private int overDays;
    @ApiModelProperty("结清当前期数")
    private int closeInstNum;
    @ApiModelProperty("结清方式")
    private String planRepayType;
    @ApiModelProperty("结清日期")
    private String closeDt;
    @ApiModelProperty("未还本金")
    private double repayPrinAmt;
    @ApiModelProperty("未还利息")
    private double repayInterAmt;
    @ApiModelProperty("未还服务费")
    private double repayServiceAmt;
    @ApiModelProperty("未还滞纳金")
    private double repayOverdueAmt;
    @ApiModelProperty("未还账户管理费")
    private double repayAccountMrgAmt;
    @ApiModelProperty("未还保险费")
    private double repayInsuranceAmt;
    @ApiModelProperty("未还手续费")
    private double repayProcAmt;
    @ApiModelProperty("未还违约金")
    private double repayPenaltyAmt;
    @ApiModelProperty("未还随心包")
    private double repayAttachAmt;
    @ApiModelProperty("未还总额")
    private double repayAmt;
    @ApiModelProperty("结算时间")
    private Date settleTime;

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

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getEcifCustNo() {
        return ecifCustNo;
    }

    public void setEcifCustNo(String ecifCustNo) {
        this.ecifCustNo = ecifCustNo;
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

    public String getIsCloseCurrNum() {
        return isCloseCurrNum;
    }

    public void setIsCloseCurrNum(String isCloseCurrNum) {
        this.isCloseCurrNum = isCloseCurrNum;
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

    public double getReduAmt() {
        return reduAmt;
    }

    public void setReduAmt(double reduAmt) {
        this.reduAmt = reduAmt;
    }

    public double getActuAmt() {
        return actuAmt;
    }

    public void setActuAmt(double actuAmt) {
        this.actuAmt = actuAmt;
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

    public double getReduPrinAmt() {
        return reduPrinAmt;
    }

    public void setReduPrinAmt(double reduPrinAmt) {
        this.reduPrinAmt = reduPrinAmt;
    }

    public double getReduInterAmt() {
        return reduInterAmt;
    }

    public void setReduInterAmt(double reduInterAmt) {
        this.reduInterAmt = reduInterAmt;
    }

    public double getReduServiceAmt() {
        return reduServiceAmt;
    }

    public void setReduServiceAmt(double reduServiceAmt) {
        this.reduServiceAmt = reduServiceAmt;
    }

    public double getReduOverdueAmt() {
        return reduOverdueAmt;
    }

    public void setReduOverdueAmt(double reduOverdueAmt) {
        this.reduOverdueAmt = reduOverdueAmt;
    }

    public double getReduAccountMrgAmt() {
        return reduAccountMrgAmt;
    }

    public void setReduAccountMrgAmt(double reduAccountMrgAmt) {
        this.reduAccountMrgAmt = reduAccountMrgAmt;
    }

    public double getReduInsuranceAmt() {
        return reduInsuranceAmt;
    }

    public void setReduInsuranceAmt(double reduInsuranceAmt) {
        this.reduInsuranceAmt = reduInsuranceAmt;
    }

    public double getReduProcAmt() {
        return reduProcAmt;
    }

    public void setReduProcAmt(double reduProcAmt) {
        this.reduProcAmt = reduProcAmt;
    }

    public double getReduPenaltyAmt() {
        return reduPenaltyAmt;
    }

    public void setReduPenaltyAmt(double reduPenaltyAmt) {
        this.reduPenaltyAmt = reduPenaltyAmt;
    }

    public double getReduAttachAmt() {
        return reduAttachAmt;
    }

    public void setReduAttachAmt(double reduAttachAmt) {
        this.reduAttachAmt = reduAttachAmt;
    }

    public String getTransDt() {
        return transDt;
    }

    public void setTransDt(String transDt) {
        this.transDt = transDt;
    }

    public double getActuPrinAmt() {
        return actuPrinAmt;
    }

    public void setActuPrinAmt(double actuPrinAmt) {
        this.actuPrinAmt = actuPrinAmt;
    }

    public double getActuInterAmt() {
        return actuInterAmt;
    }

    public void setActuInterAmt(double actuInterAmt) {
        this.actuInterAmt = actuInterAmt;
    }

    public double getActuServiceAmt() {
        return actuServiceAmt;
    }

    public void setActuServiceAmt(double actuServiceAmt) {
        this.actuServiceAmt = actuServiceAmt;
    }

    public double getActuOverdueAmt() {
        return actuOverdueAmt;
    }

    public void setActuOverdueAmt(double actuOverdueAmt) {
        this.actuOverdueAmt = actuOverdueAmt;
    }

    public double getActuAccountMrgAmt() {
        return actuAccountMrgAmt;
    }

    public void setActuAccountMrgAmt(double actuAccountMrgAmt) {
        this.actuAccountMrgAmt = actuAccountMrgAmt;
    }

    public double getActuInsuranceAmt() {
        return actuInsuranceAmt;
    }

    public void setActuInsuranceAmt(double actuInsuranceAmt) {
        this.actuInsuranceAmt = actuInsuranceAmt;
    }

    public double getActuProcAmt() {
        return actuProcAmt;
    }

    public void setActuProcAmt(double actuProcAmt) {
        this.actuProcAmt = actuProcAmt;
    }

    public double getActuPenaltyAmt() {
        return actuPenaltyAmt;
    }

    public void setActuPenaltyAmt(double actuPenaltyAmt) {
        this.actuPenaltyAmt = actuPenaltyAmt;
    }

    public double getActuAttachAmt() {
        return actuAttachAmt;
    }

    public void setActuAttachAmt(double actuAttachAmt) {
        this.actuAttachAmt = actuAttachAmt;
    }

    public double getOverAmt() {
        return overAmt;
    }

    public void setOverAmt(double overAmt) {
        this.overAmt = overAmt;
    }

    public double getDgTransBal() {
        return dgTransBal;
    }

    public void setDgTransBal(double dgTransBal) {
        this.dgTransBal = dgTransBal;
    }

    public double getDkTransBal() {
        return dkTransBal;
    }

    public void setDkTransBal(double dkTransBal) {
        this.dkTransBal = dkTransBal;
    }

    public double getRemainPrin() {
        return remainPrin;
    }

    public void setRemainPrin(double remainPrin) {
        this.remainPrin = remainPrin;
    }

    public int getOverLvl() {
        return overLvl;
    }

    public void setOverLvl(int overLvl) {
        this.overLvl = overLvl;
    }

    public int getOverDays() {
        return overDays;
    }

    public void setOverDays(int overDays) {
        this.overDays = overDays;
    }

    public int getCloseInstNum() {
        return closeInstNum;
    }

    public void setCloseInstNum(int closeInstNum) {
        this.closeInstNum = closeInstNum;
    }

    public String getPlanRepayType() {
        return planRepayType;
    }

    public void setPlanRepayType(String planRepayType) {
        this.planRepayType = planRepayType;
    }

    public String getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(String closeDt) {
        this.closeDt = closeDt;
    }

    public double getRepayPrinAmt() {
        return repayPrinAmt;
    }

    public void setRepayPrinAmt(double repayPrinAmt) {
        this.repayPrinAmt = repayPrinAmt;
    }

    public double getRepayInterAmt() {
        return repayInterAmt;
    }

    public void setRepayInterAmt(double repayInterAmt) {
        this.repayInterAmt = repayInterAmt;
    }

    public double getRepayServiceAmt() {
        return repayServiceAmt;
    }

    public void setRepayServiceAmt(double repayServiceAmt) {
        this.repayServiceAmt = repayServiceAmt;
    }

    public double getRepayOverdueAmt() {
        return repayOverdueAmt;
    }

    public void setRepayOverdueAmt(double repayOverdueAmt) {
        this.repayOverdueAmt = repayOverdueAmt;
    }

    public double getRepayAccountMrgAmt() {
        return repayAccountMrgAmt;
    }

    public void setRepayAccountMrgAmt(double repayAccountMrgAmt) {
        this.repayAccountMrgAmt = repayAccountMrgAmt;
    }

    public double getRepayInsuranceAmt() {
        return repayInsuranceAmt;
    }

    public void setRepayInsuranceAmt(double repayInsuranceAmt) {
        this.repayInsuranceAmt = repayInsuranceAmt;
    }

    public double getRepayProcAmt() {
        return repayProcAmt;
    }

    public void setRepayProcAmt(double repayProcAmt) {
        this.repayProcAmt = repayProcAmt;
    }

    public double getRepayPenaltyAmt() {
        return repayPenaltyAmt;
    }

    public void setRepayPenaltyAmt(double repayPenaltyAmt) {
        this.repayPenaltyAmt = repayPenaltyAmt;
    }

    public double getRepayAttachAmt() {
        return repayAttachAmt;
    }

    public void setRepayAttachAmt(double repayAttachAmt) {
        this.repayAttachAmt = repayAttachAmt;
    }

    public double getRepayAmt() {
        return repayAmt;
    }

    public void setRepayAmt(double repayAmt) {
        this.repayAmt = repayAmt;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

}
