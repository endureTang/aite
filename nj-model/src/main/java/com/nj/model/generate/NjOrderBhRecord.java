package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjOrderBhRecord {
    private String id;

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String orderId;

    /**
     * 是否同步：0：未同步，1：已同步
     */
    @ApiModelProperty(value = "是否同步：0：未同步，1：已同步")
    private Integer status;

    /**
     * 上报时间
     */
    @ApiModelProperty(value = "上报时间")
    private Date reportDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

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
     * 订单id
     * @return order_id 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 是否同步：0：未同步，1：已同步
     * @return status 是否同步：0：未同步，1：已同步
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 是否同步：0：未同步，1：已同步
     * @param status 是否同步：0：未同步，1：已同步
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 上报时间
     * @return report_date 上报时间
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 上报时间
     * @param reportDate 上报时间
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
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
}