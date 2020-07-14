/**
 * Copyright 2018 bejson.com
 */
package com.nj.mongoModel;

/**
 * Auto-generated: 2018-04-28 9:4:20
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BrIdTwoData extends MongoEntity {

    private String MESSAGE;
    private int costTime;
    private String guid;
    private String RESULT;
    private String userId;
    private String orderId;

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setCostTime(int costTime) {
        this.costTime = costTime;
    }

    public int getCostTime() {
        return costTime;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getRESULT() {
        return RESULT;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}