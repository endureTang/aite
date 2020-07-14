package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjWithdrawingRecord {
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 期数
     */
    @ApiModelProperty(value = "期数")
    private Integer currentPeriod;

    /**
     * 应扣日期
     */
    @ApiModelProperty(value = "应扣日期")
    private Date createDate;

    /**
     * 扣款本金
     */
    @ApiModelProperty(value = "扣款本金")
    private BigDecimal withdrawingCapital;

    /**
     * 扣款利息
     */
    @ApiModelProperty(value = "扣款利息")
    private BigDecimal withdrawingInterest;

    /**
     * 罚息
     */
    @ApiModelProperty(value = "罚息")
    private BigDecimal defaultInterest;

    /**
     * 是否逾期
     */
    @ApiModelProperty(value = "是否逾期")
    private Boolean isOverdue;

    /**
     * 逾期天数
     */
    @ApiModelProperty(value = "逾期天数")
    private Integer overdueDay;

    /**
     * 实际扣款日期
     */
    @ApiModelProperty(value = "实际扣款日期")
    private Date withdrawingDate;

    /**
     * 状态(0:等待扣款,
     * 1:开始扣款
     * 2:扣款中
     * 3:余额不足,失败,
     * 4:系统原因,失败
     * 5:扣款成功
     * )
     */
    @ApiModelProperty(value = "状态(0:等待扣款,1:开始扣款2:扣款中3:余额不足,失败,4:系统原因,失败 5:扣款成功)")
    private Byte status;

    /**
     * 利率
     */
    @ApiModelProperty(value = "利率")
    private BigDecimal rate;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;
    /**
     * 渠道费
     */
    @ApiModelProperty(value = "渠道费")
    private BigDecimal channelFee;
    /**
     * 类型，0：小贷，1：渠道
     */
    private int type;
    private String coporateId;

    public String getCoporateId() {
        return coporateId;
    }

    public void setCoporateId(String coporateId) {
        this.coporateId = coporateId;
    }

    public BigDecimal getChannelFee() {
        return channelFee;
    }

    public void setChannelFee(BigDecimal channelFee) {
        this.channelFee = channelFee;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 订单编号
     *
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     *
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 期数
     *
     * @return current_period 期数
     */
    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    /**
     * 期数
     *
     * @param currentPeriod 期数
     */
    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    /**
     * 应扣日期
     *
     * @return create_date 应扣日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 应扣日期
     *
     * @param createDate 应扣日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 扣款本金
     *
     * @return withdrawing_capital 扣款本金
     */
    public BigDecimal getWithdrawingCapital() {
        return withdrawingCapital;
    }

    /**
     * 扣款本金
     *
     * @param withdrawingCapital 扣款本金
     */
    public void setWithdrawingCapital(BigDecimal withdrawingCapital) {
        this.withdrawingCapital = withdrawingCapital;
    }

    /**
     * 扣款利息
     *
     * @return withdrawing_interest 扣款利息
     */
    public BigDecimal getWithdrawingInterest() {
        return withdrawingInterest;
    }

    /**
     * 扣款利息
     *
     * @param withdrawingInterest 扣款利息
     */
    public void setWithdrawingInterest(BigDecimal withdrawingInterest) {
        this.withdrawingInterest = withdrawingInterest;
    }

    /**
     * 罚息
     *
     * @return default_interest 罚息
     */
    public BigDecimal getDefaultInterest() {
        return defaultInterest;
    }

    /**
     * 罚息
     *
     * @param defaultInterest 罚息
     */
    public void setDefaultInterest(BigDecimal defaultInterest) {
        this.defaultInterest = defaultInterest;
    }

    /**
     * 是否逾期
     *
     * @return is_overdue 是否逾期
     */
    public Boolean getIsOverdue() {
        return isOverdue;
    }

    /**
     * 是否逾期
     *
     * @param isOverdue 是否逾期
     */
    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    /**
     * 逾期天数
     *
     * @return overdue_day 逾期天数
     */
    public Integer getOverdueDay() {
        return overdueDay;
    }

    /**
     * 逾期天数
     *
     * @param overdueDay 逾期天数
     */
    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    /**
     * 实际扣款日期
     *
     * @return withdrawing_date 实际扣款日期
     */
    public Date getWithdrawingDate() {
        return withdrawingDate;
    }

    /**
     * 实际扣款日期
     *
     * @param withdrawingDate 实际扣款日期
     */
    public void setWithdrawingDate(Date withdrawingDate) {
        this.withdrawingDate = withdrawingDate;
    }

    /**
     * 状态(0:等待扣款,
     * 1:开始扣款
     * 2:扣款中
     * 3:余额不足,失败,
     * 4:系统原因,失败
     * 5:扣款成功
     * )
     *
     * @return status 状态(0:等待扣款,
     * 1:开始扣款
     * 2:扣款中
     * 3:余额不足,失败,
     * 4:系统原因,失败
     * 5:扣款成功
     * )
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态(0:等待扣款,
     * 1:开始扣款
     * 2:扣款中
     * 3:余额不足,失败,
     * 4:系统原因,失败
     * 5:扣款成功
     * )
     *
     * @param status 状态(0:等待扣款,
     *               1:开始扣款
     *               2:扣款中
     *               3:余额不足,失败,
     *               4:系统原因,失败
     *               5:扣款成功
     *               )
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 利率
     *
     * @return rate 利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 利率
     *
     * @param rate 利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 产品名称
     *
     * @return product_name 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
}