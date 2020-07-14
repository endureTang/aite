package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjDeductionRequest {
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 第三方订单编号
     */
    @ApiModelProperty(value = "第三方订单编号")
    private String sourceOrderNo;

    /**
     * 扣款期数
     */
    @ApiModelProperty(value = "扣款期数")
    private Integer period;

    private String productId;

    private String channelId;

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
     * 第三方订单编号
     * @return source_order_no 第三方订单编号
     */
    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    /**
     * 第三方订单编号
     * @param sourceOrderNo 第三方订单编号
     */
    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    /**
     * 扣款期数
     * @return period 扣款期数
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 扣款期数
     * @param period 扣款期数
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 
     * @return product_id 
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId 
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return channel_id 
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 
     * @param channelId 
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 
     * @return create_date 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}