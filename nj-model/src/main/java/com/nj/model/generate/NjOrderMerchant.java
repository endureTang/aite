package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjOrderMerchant {
    private String id;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private String orderId;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号")
    private String merchantNo;

    /**
     * 商户名称
     */
    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    /**
     * 商户所在省
     */
    @ApiModelProperty(value = "商户所在省")
    private String merchantProvince;

    /**
     * 商户所在市
     */
    @ApiModelProperty(value = "商户所在市")
    private String merchantCity;

    /**
     * 商户所在县
     */
    @ApiModelProperty(value = "商户所在县")
    private String merchantCounty;

    /**
     * 商户所在地址
     */
    @ApiModelProperty(value = "商户所在地址")
    private String merchantAddress;

    /**
     * 开始合作时间
     */
    @ApiModelProperty(value = "开始合作时间")
    private Date consociationDate;

    /**
     * 交易流水
     */
    @ApiModelProperty(value = "交易流水")
    private String transactionNo;

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
     * 订单ID
     * @return order_id 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单ID
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 商户编号
     * @return merchant_no 商户编号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号
     * @param merchantNo 商户编号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * 商户名称
     * @return merchant_name 商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称
     * @param merchantName 商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * 商户所在省
     * @return merchant_province 商户所在省
     */
    public String getMerchantProvince() {
        return merchantProvince;
    }

    /**
     * 商户所在省
     * @param merchantProvince 商户所在省
     */
    public void setMerchantProvince(String merchantProvince) {
        this.merchantProvince = merchantProvince;
    }

    /**
     * 商户所在市
     * @return merchant_city 商户所在市
     */
    public String getMerchantCity() {
        return merchantCity;
    }

    /**
     * 商户所在市
     * @param merchantCity 商户所在市
     */
    public void setMerchantCity(String merchantCity) {
        this.merchantCity = merchantCity;
    }

    /**
     * 商户所在县
     * @return merchant_county 商户所在县
     */
    public String getMerchantCounty() {
        return merchantCounty;
    }

    /**
     * 商户所在县
     * @param merchantCounty 商户所在县
     */
    public void setMerchantCounty(String merchantCounty) {
        this.merchantCounty = merchantCounty;
    }

    /**
     * 商户所在地址
     * @return merchant_address 商户所在地址
     */
    public String getMerchantAddress() {
        return merchantAddress;
    }

    /**
     * 商户所在地址
     * @param merchantAddress 商户所在地址
     */
    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    /**
     * 开始合作时间
     * @return consociation_date 开始合作时间
     */
    public Date getConsociationDate() {
        return consociationDate;
    }

    /**
     * 开始合作时间
     * @param consociationDate 开始合作时间
     */
    public void setConsociationDate(Date consociationDate) {
        this.consociationDate = consociationDate;
    }

    /**
     * 交易流水
     * @return transaction_no 交易流水
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * 交易流水
     * @param transactionNo 交易流水
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }
}