package com.nj.bean;

import java.io.Serializable;

/**
 * @author Lizy
 * @version 2019/3/7.
 */
public class ProductPenaltyBean implements Serializable {
    private String productId;
    /**
     * 回款算法
     */
    private String backAlgorithmCode;
    /**
     * 逾期是否自动扣款（0：否，1：是）
     */
    private Short isOverdueAutoDeduct;
    /**
     * 还款算法
     */
    private String planAlgorithmCode;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Short getIsOverdueAutoDeduct() {
        return isOverdueAutoDeduct;
    }

    public void setIsOverdueAutoDeduct(Short isOverdueAutoDeduct) {
        this.isOverdueAutoDeduct = isOverdueAutoDeduct;
    }

    public String getBackAlgorithmCode() {
        return backAlgorithmCode;
    }

    public void setBackAlgorithmCode(String backAlgorithmCode) {
        this.backAlgorithmCode = backAlgorithmCode;
    }

    public String getPlanAlgorithmCode() {
        return planAlgorithmCode;
    }

    public void setPlanAlgorithmCode(String planAlgorithmCode) {
        this.planAlgorithmCode = planAlgorithmCode;
    }

}
