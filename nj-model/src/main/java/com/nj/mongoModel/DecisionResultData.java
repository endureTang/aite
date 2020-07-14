package com.nj.mongoModel;

/**
 * @author Lizy
 * @version 2018/5/8.
 */
public class DecisionResultData extends MongoEntity {
    // 订单id
    private String orderId;
    // 结果数据
    private String resultData;
    // 流向决策包
    private String packageNum;
    // 决策结果
    private String decisionResult;
    // 模型分数明细
    private String modelScore;
    // 规则明细
    private String ruleList;
    // 时间
    private String time;
    /**
     * 风险等级
     */
    private String RiskGrade;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public String getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(String packageNum) {
        this.packageNum = packageNum;
    }

    public String getDecisionResult() {
        return decisionResult;
    }

    public void setDecisionResult(String decisionResult) {
        this.decisionResult = decisionResult;
    }

    public String getModelScore() {
        return modelScore;
    }

    public void setModelScore(String modelScore) {
        this.modelScore = modelScore;
    }

    public String getRuleList() {
        return ruleList;
    }

    public void setRuleList(String ruleList) {
        this.ruleList = ruleList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRiskGrade() {
        return RiskGrade;
    }

    public void setRiskGrade(String riskGrade) {
        RiskGrade = riskGrade;
    }
}
