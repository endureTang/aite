package com.nj.model.mq;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Name com.nj.model.mq.RepayPlanMQ
 * @Description 还款计划MQ实体
 * @Author bruce
 * @Version 2018年4月19日 下午5:20:39
 * @Copyright 金鼎财富
 */
public class RepayPlanMq {
    /**
     * 订单类型(1:微鼎金额订单,2:普惠快捷订单)
     */
    @ApiModelProperty(value = "订单类型(1:微鼎金额订单,2:普惠快捷订单,3小贷)")
    private int type;
    /**
     * 过程编号
     */
    @ApiModelProperty(value = "过程编号")
    private int processId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 状态
     */
    private String status;
    /**
     *
     * 信息
     */
    private String  message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
