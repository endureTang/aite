package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjOrderChannel {
    private String id;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private String orderId;

    /**
     * 渠道ID，nj_channe的id
     */
    @ApiModelProperty(value = "渠道ID，nj_channe的id")
    private String channelId;

    /**
     * 产品渠道ID。nj_product_channel的id
     */
    @ApiModelProperty(value = "产品渠道ID。nj_product_channel的id")
    private String channelProductId;

    /**
     * 渠道类型（该类型是指渠道在该产品中的类型） 1：进件渠道，2资金渠道 ，3 合作方渠道
     */
    @ApiModelProperty(value = "渠道类型（该类型是指渠道在该产品中的类型） 1：进件渠道，2资金渠道 ，3 合作方渠道")
    private Short channelType;

    /**
     * 期收金类型(1:固定金额,2:比例,3:计算公式) ，如果是按比例则是带%
     */
    @ApiModelProperty(value = "期收金类型(1:固定金额,2:比例,3:计算公式) ，如果是按比例则是带%")
    private Byte bondType;

    /**
     * 期收手续费
     */
    @ApiModelProperty(value = "期收手续费")
    private String bondValue;

    /**
     * 期收手续费值，当期收类型为2时，该值有效，且该值是期收费率算出来的
     */
    @ApiModelProperty(value = "期收手续费值，当期收类型为2时，该值有效，且该值是期收费率算出来的")
    private String bondFee;

    /**
     * 趸收类型(1:固定金额,2:比例,3:计算公式)
     */
    @ApiModelProperty(value = "趸收类型(1:固定金额,2:比例,3:计算公式)")
    private Integer operateFeeType;

    /**
     * 手续费值（月利率，不带百分号）
     */
    @ApiModelProperty(value = "手续费值（月利率，不带百分号）")
    private String operateFee;

    /**
     * 是否期收利率写入合同
     */
    @ApiModelProperty(value = "是否期收利率写入合同")
    private Boolean isRateContract;

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
     * 渠道ID，nj_channe的id
     * @return channel_id 渠道ID，nj_channe的id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 渠道ID，nj_channe的id
     * @param channelId 渠道ID，nj_channe的id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 产品渠道ID。nj_product_channel的id
     * @return channel_product_id 产品渠道ID。nj_product_channel的id
     */
    public String getChannelProductId() {
        return channelProductId;
    }

    /**
     * 产品渠道ID。nj_product_channel的id
     * @param channelProductId 产品渠道ID。nj_product_channel的id
     */
    public void setChannelProductId(String channelProductId) {
        this.channelProductId = channelProductId;
    }

    /**
     * 渠道类型（该类型是指渠道在该产品中的类型） 1：进件渠道，2资金渠道 ，3 合作方渠道
     * @return channel_type 渠道类型（该类型是指渠道在该产品中的类型） 1：进件渠道，2资金渠道 ，3 合作方渠道
     */
    public Short getChannelType() {
        return channelType;
    }

    /**
     * 渠道类型（该类型是指渠道在该产品中的类型） 1：进件渠道，2资金渠道 ，3 合作方渠道
     * @param channelType 渠道类型（该类型是指渠道在该产品中的类型） 1：进件渠道，2资金渠道 ，3 合作方渠道
     */
    public void setChannelType(Short channelType) {
        this.channelType = channelType;
    }

    /**
     * 期收金类型(1:固定金额,2:比例,3:计算公式) ，如果是按比例则是带%
     * @return bond_type 期收金类型(1:固定金额,2:比例,3:计算公式) ，如果是按比例则是带%
     */
    public Byte getBondType() {
        return bondType;
    }

    /**
     * 期收金类型(1:固定金额,2:比例,3:计算公式) ，如果是按比例则是带%
     * @param bondType 期收金类型(1:固定金额,2:比例,3:计算公式) ，如果是按比例则是带%
     */
    public void setBondType(Byte bondType) {
        this.bondType = bondType;
    }

    /**
     * 期收手续费
     * @return bond_value 期收手续费
     */
    public String getBondValue() {
        return bondValue;
    }

    /**
     * 期收手续费
     * @param bondValue 期收手续费
     */
    public void setBondValue(String bondValue) {
        this.bondValue = bondValue;
    }

    /**
     * 期收手续费值，当期收类型为2时，该值有效，且该值是期收费率算出来的
     * @return bond_fee 期收手续费值，当期收类型为2时，该值有效，且该值是期收费率算出来的
     */
    public String getBondFee() {
        return bondFee;
    }

    /**
     * 期收手续费值，当期收类型为2时，该值有效，且该值是期收费率算出来的
     * @param bondFee 期收手续费值，当期收类型为2时，该值有效，且该值是期收费率算出来的
     */
    public void setBondFee(String bondFee) {
        this.bondFee = bondFee;
    }

    /**
     * 趸收类型(1:固定金额,2:比例,3:计算公式)
     * @return operate_fee_type 趸收类型(1:固定金额,2:比例,3:计算公式)
     */
    public Integer getOperateFeeType() {
        return operateFeeType;
    }

    /**
     * 趸收类型(1:固定金额,2:比例,3:计算公式)
     * @param operateFeeType 趸收类型(1:固定金额,2:比例,3:计算公式)
     */
    public void setOperateFeeType(Integer operateFeeType) {
        this.operateFeeType = operateFeeType;
    }

    /**
     * 手续费值（月利率，不带百分号）
     * @return operate_fee 手续费值（月利率，不带百分号）
     */
    public String getOperateFee() {
        return operateFee;
    }

    /**
     * 手续费值（月利率，不带百分号）
     * @param operateFee 手续费值（月利率，不带百分号）
     */
    public void setOperateFee(String operateFee) {
        this.operateFee = operateFee;
    }

    /**
     * 是否期收利率写入合同
     * @return is_rate_contract 是否期收利率写入合同
     */
    public Boolean getIsRateContract() {
        return isRateContract;
    }

    /**
     * 是否期收利率写入合同
     * @param isRateContract 是否期收利率写入合同
     */
    public void setIsRateContract(Boolean isRateContract) {
        this.isRateContract = isRateContract;
    }
}