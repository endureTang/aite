package com.nj.core.base.enums;

/**
 * @author Lizy
 * @version 2018/4/25.
 */
public enum DecisionResult {
    //DecisionAsset 决策至资金合作
    ASSET("DecisionAsset"),
    //DecisionPass 决策通过至联合放款
    PASS("DecisionPass"),
    //DecisionCheck 决策至人工审批
    CHECK("DecisionCheck"),
    //DecisionFail 决策拒件
    FAIL("DecisionFail");

    private String result;

    DecisionResult(String result) {
        this.result = result;
    }

    public static DecisionResult getDecision(String result) {
        DecisionResult[] values = DecisionResult.values();
        for (DecisionResult value : values) {
            if (value.getResult().equals(result)) {
                return value;
            }
        }
        return null;
    }

    public String getResult() {
        return result;
    }
}
