package com.nj.model.vo;

import java.util.List;

/**
 * 贷后->还款信息页面->还款计划和回款计划
 */
public class PlanVoForRepayInfo {

    private Integer period;                    // 期数
    private String planRepayDate;                // 计划还款日期
    private List<FeeValue> planFeeValueList;    // 应还费用值list
    private String planRepayTotalAmt;            // 应还总额
    private String accRepayDate;                // 实际还款日期
    private List<FeeValue> accFeeValueList;        // 实还费用值list
    private String accRepayTotalAmt;            // 实还总额
    private String repayStatus;                // 还款状态
    private String deductType;                    // 扣款类型中文名称
    private String deductionResult;                // 扣款结果
    private Integer status; //扣款状态


    public class FeeValue {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getPlanRepayDate() {
        return planRepayDate;
    }

    public void setPlanRepayDate(String planRepayDate) {
        this.planRepayDate = planRepayDate;
    }

    public List<FeeValue> getPlanFeeValueList() {
        return planFeeValueList;
    }

    public void setPlanFeeValueList(List<FeeValue> planFeeValueList) {
        this.planFeeValueList = planFeeValueList;
    }

    public String getPlanRepayTotalAmt() {
        return planRepayTotalAmt;
    }

    public void setPlanRepayTotalAmt(String planRepayTotalAmt) {
        this.planRepayTotalAmt = planRepayTotalAmt;
    }

    public String getAccRepayDate() {
        return accRepayDate;
    }

    public void setAccRepayDate(String accRepayDate) {
        this.accRepayDate = accRepayDate;
    }

    public List<FeeValue> getAccFeeValueList() {
        return accFeeValueList;
    }

    public void setAccFeeValueList(List<FeeValue> accFeeValueList) {
        this.accFeeValueList = accFeeValueList;
    }

    public String getAccRepayTotalAmt() {
        return accRepayTotalAmt;
    }

    public void setAccRepayTotalAmt(String accRepayTotalAmt) {
        this.accRepayTotalAmt = accRepayTotalAmt;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }

    public String getDeductionResult() {
        return deductionResult;
    }

    public void setDeductionResult(String deductionResult) {
        this.deductionResult = deductionResult;
    }

}
