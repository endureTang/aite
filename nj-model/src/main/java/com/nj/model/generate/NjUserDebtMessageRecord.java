package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserDebtMessageRecord {
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 债权购买人姓名
     */
    @ApiModelProperty(value = "债权购买人姓名")
    private String name;

    /**
     * 状态（0：未同步，1：已同步）
     */
    @ApiModelProperty(value = "状态（0：未同步，1：已同步）")
    private Integer status;

    /**
     * 转让时间
     */
    @ApiModelProperty(value = "转让时间")
    private Date transDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

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
     * 债权购买人姓名
     * @return name 债权购买人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 债权购买人姓名
     * @param name 债权购买人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 状态（0：未同步，1：已同步）
     * @return status 状态（0：未同步，1：已同步）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（0：未同步，1：已同步）
     * @param status 状态（0：未同步，1：已同步）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 转让时间
     * @return trans_date 转让时间
     */
    public Date getTransDate() {
        return transDate;
    }

    /**
     * 转让时间
     * @param transDate 转让时间
     */
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}