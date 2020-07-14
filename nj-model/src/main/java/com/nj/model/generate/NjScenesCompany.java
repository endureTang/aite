package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjScenesCompany {
    private String id;

    /**
     * 标的价值
     */
    @ApiModelProperty(value = "标的价值")
    private String bidValue;

    /**
     * 供应链金融付款方
     */
    @ApiModelProperty(value = "供应链金融付款方")
    private String supplyChainFinancialPay;

    private String createDate;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

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
     * 标的价值
     * @return bid_value 标的价值
     */
    public String getBidValue() {
        return bidValue;
    }

    /**
     * 标的价值
     * @param bidValue 标的价值
     */
    public void setBidValue(String bidValue) {
        this.bidValue = bidValue;
    }

    /**
     * 供应链金融付款方
     * @return supply_chain_financial_pay 供应链金融付款方
     */
    public String getSupplyChainFinancialPay() {
        return supplyChainFinancialPay;
    }

    /**
     * 供应链金融付款方
     * @param supplyChainFinancialPay 供应链金融付款方
     */
    public void setSupplyChainFinancialPay(String supplyChainFinancialPay) {
        this.supplyChainFinancialPay = supplyChainFinancialPay;
    }

    /**
     * 
     * @return create_date 
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate 
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}