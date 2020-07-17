package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjStrategy {
    private String id;

    /**
     * 策略名
     */
    @ApiModelProperty(value = "策略名")
    private String name;

    /**
     * 订单来源标识符TM、SS、KR等
     */
    @ApiModelProperty(value = "订单来源标识符TM、SS、KR等")
    private String source;

    /**
     * 原始订单号
     */
    @ApiModelProperty(value = "原始订单号")
    private String sourceNo;

    /**
     * 物流方式
     */
    @ApiModelProperty(value = "物流方式")
    private String transWay;

    /**
     * 物流方式
     */
    @ApiModelProperty(value = "物流单号")
    private String transNo;

    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private String transMoney;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private String amount;

    /**
     * 删除标识 0：未删除 1：已删除
     */
    @ApiModelProperty(value = "删除标识 0：未删除 1：已删除")
    private Short delFlag;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Short sourceNoStus;

    private Short transWayStus;

    private Short transNoStus;

    private Short transMoneyStus;

    private Short amountStus;

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
     * 策略名
     * @return name 策略名
     */
    public String getName() {
        return name;
    }

    /**
     * 策略名
     * @param name 策略名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 订单来源标识符TM、SS、KR等
     * @return source 订单来源标识符TM、SS、KR等
     */
    public String getSource() {
        return source;
    }

    /**
     * 订单来源标识符TM、SS、KR等
     * @param source 订单来源标识符TM、SS、KR等
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 原始订单号
     * @return source_no 原始订单号
     */
    public String getSourceNo() {
        return sourceNo;
    }

    /**
     * 原始订单号
     * @param sourceNo 原始订单号
     */
    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    /**
     * 物流方式
     * @return trans_way 物流方式
     */
    public String getTransWay() {
        return transWay;
    }

    /**
     * 物流方式
     * @param transWay 物流方式
     */
    public void setTransWay(String transWay) {
        this.transWay = transWay;
    }

    /**
     * 物流方式
     * @return trans_no 物流方式
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * 物流方式
     * @param transNo 物流方式
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    /**
     * 运费
     * @return trans_money 运费
     */
    public String getTransMoney() {
        return transMoney;
    }

    /**
     * 运费
     * @param transMoney 运费
     */
    public void setTransMoney(String transMoney) {
        this.transMoney = transMoney;
    }

    /**
     * 数量
     * @return amount 数量
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 数量
     * @param amount 数量
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 删除标识 0：未删除 1：已删除
     * @return del_flag 删除标识 0：未删除 1：已删除
     */
    public Short getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标识 0：未删除 1：已删除
     * @param delFlag 删除标识 0：未删除 1：已删除
     */
    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 是否启用
     * @return source_no_stus 是否启用
     */
    public Short getSourceNoStus() {
        return sourceNoStus;
    }

    /**
     * 是否启用
     * @param sourceNoStus 是否启用
     */
    public void setSourceNoStus(Short sourceNoStus) {
        this.sourceNoStus = sourceNoStus;
    }

    /**
     * 
     * @return trans_way_stus 
     */
    public Short getTransWayStus() {
        return transWayStus;
    }

    /**
     * 
     * @param transWayStus 
     */
    public void setTransWayStus(Short transWayStus) {
        this.transWayStus = transWayStus;
    }

    /**
     * 
     * @return trans_no_stus 
     */
    public Short getTransNoStus() {
        return transNoStus;
    }

    /**
     * 
     * @param transNoStus 
     */
    public void setTransNoStus(Short transNoStus) {
        this.transNoStus = transNoStus;
    }

    /**
     * 
     * @return trans_money_stus 
     */
    public Short getTransMoneyStus() {
        return transMoneyStus;
    }

    /**
     * 
     * @param transMoneyStus 
     */
    public void setTransMoneyStus(Short transMoneyStus) {
        this.transMoneyStus = transMoneyStus;
    }

    /**
     * 
     * @return amount_stus 
     */
    public Short getAmountStus() {
        return amountStus;
    }

    /**
     * 
     * @param amountStus 
     */
    public void setAmountStus(Short amountStus) {
        this.amountStus = amountStus;
    }
}