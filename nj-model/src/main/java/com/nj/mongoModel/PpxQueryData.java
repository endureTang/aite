package com.nj.mongoModel;

import java.util.List;

/**
 * 拍拍信数据model
 *
 * @author Lizy
 * @version 2018/4/17.
 */
public class PpxQueryData extends MongoEntity {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 是否关注用户，1是；2否
     */
    private String isAlert;
    /**
     * 风险记录概要
     */
    private List<String> blackSummary;
    /**
     * 是否为不良用户，1是；2否
     */
    private String isBlack;
    /**
     * 是否关联人不良
     */
    private String isBadRelated;

    public void setIsAlert(String isAlert) {
        this.isAlert = isAlert;
    }

    public String getIsAlert() {
        return this.isAlert;
    }

    public void setBlackSummary(List<String> blackSummary) {
        this.blackSummary = blackSummary;
    }

    public List<String> getBlackSummary() {
        return this.blackSummary;
    }

    public void setIsBlack(String isBlack) {
        this.isBlack = isBlack;
    }

    public String getIsBlack() {
        return this.isBlack;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsBadRelated() {
        return isBadRelated;
    }

    public void setIsBadRelated(String isBadRelated) {
        this.isBadRelated = isBadRelated;
    }

    @Override
    public String toString() {
        return "PpxQueryData{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", isAlert='" + isAlert + '\'' +
                ", blackSummary=" + blackSummary +
                ", isBlack='" + isBlack + '\'' +
                '}';
    }
}
