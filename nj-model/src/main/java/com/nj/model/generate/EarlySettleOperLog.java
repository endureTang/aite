package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class EarlySettleOperLog {
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 操作人id
     */
    @ApiModelProperty(value = "操作人id")
    private String userId;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private Date createTime;

    /**
     * 操作参数
     */
    @ApiModelProperty(value = "操作参数")
    private String params;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 订单编号
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 操作人id
     * @return user_id 操作人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 操作人id
     * @param userId 操作人id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 操作时间
     * @return create_time 操作时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 操作时间
     * @param createTime 操作时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 操作参数
     * @return params 操作参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 操作参数
     * @param params 操作参数
     */
    public void setParams(String params) {
        this.params = params;
    }
}