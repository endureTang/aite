package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjProductChannel {
    private String id;

    private String channelOpenId;

    /**
     * 渠道类型 1：进件渠道，2资金渠道
     */
    @ApiModelProperty(value = "渠道类型 1：进件渠道，2资金渠道")
    private Short type;

    private String productId;

    private String channelCode;

    /**
     * 最多可以存放32个汉字
     */
    @ApiModelProperty(value = "最多可以存放32个汉字")
    private String channelName;

    private String channelMobile;

    private String channelAcct;

    private Integer channelType;

    private Double monthlyRate;

    private Integer accountType;

    private Double revenueRate;

    private Integer operateFeeType;

    /**
     * 手续费值（月利率，不带百分号）
     */
    @ApiModelProperty(value = "手续费值（月利率，不带百分号）")
    private Float operateFee;

    private Boolean delFlag;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    /**
     * nj_channel的id
     */
    @ApiModelProperty(value = "nj_channel的id")
    private String channelId;

    private String njChannelId;

    /**
     * 保证金类型(1:固定金额,2:比例,3:计算公式)
     */
    @ApiModelProperty(value = "保证金类型(1:固定金额,2:比例,3:计算公式)")
    private Byte bondType;

    /**
     * 保证金值
     */
    @ApiModelProperty(value = "保证金值")
    private String bondValue;

    /**
     * 是否期收利率写入合同  0 否 1是
     */
    @ApiModelProperty(value = "是否期收利率写入合同  0 否 1是")
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
     * 
     * @return channel_open_id 
     */
    public String getChannelOpenId() {
        return channelOpenId;
    }

    /**
     * 
     * @param channelOpenId 
     */
    public void setChannelOpenId(String channelOpenId) {
        this.channelOpenId = channelOpenId;
    }

    /**
     * 渠道类型 1：进件渠道，2资金渠道
     * @return type 渠道类型 1：进件渠道，2资金渠道
     */
    public Short getType() {
        return type;
    }

    /**
     * 渠道类型 1：进件渠道，2资金渠道
     * @param type 渠道类型 1：进件渠道，2资金渠道
     */
    public void setType(Short type) {
        this.type = type;
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
     * @return channel_code 
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 
     * @param channelCode 
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * 最多可以存放32个汉字
     * @return channel_name 最多可以存放32个汉字
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 最多可以存放32个汉字
     * @param channelName 最多可以存放32个汉字
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 
     * @return channel_mobile 
     */
    public String getChannelMobile() {
        return channelMobile;
    }

    /**
     * 
     * @param channelMobile 
     */
    public void setChannelMobile(String channelMobile) {
        this.channelMobile = channelMobile;
    }

    /**
     * 
     * @return channel_acct 
     */
    public String getChannelAcct() {
        return channelAcct;
    }

    /**
     * 
     * @param channelAcct 
     */
    public void setChannelAcct(String channelAcct) {
        this.channelAcct = channelAcct;
    }

    /**
     * 
     * @return channel_type 
     */
    public Integer getChannelType() {
        return channelType;
    }

    /**
     * 
     * @param channelType 
     */
    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    /**
     * 
     * @return monthly_rate 
     */
    public Double getMonthlyRate() {
        return monthlyRate;
    }

    /**
     * 
     * @param monthlyRate 
     */
    public void setMonthlyRate(Double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    /**
     * 
     * @return account_type 
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 
     * @param accountType 
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 
     * @return revenue_rate 
     */
    public Double getRevenueRate() {
        return revenueRate;
    }

    /**
     * 
     * @param revenueRate 
     */
    public void setRevenueRate(Double revenueRate) {
        this.revenueRate = revenueRate;
    }

    /**
     * 
     * @return operate_fee_type 
     */
    public Integer getOperateFeeType() {
        return operateFeeType;
    }

    /**
     * 
     * @param operateFeeType 
     */
    public void setOperateFeeType(Integer operateFeeType) {
        this.operateFeeType = operateFeeType;
    }

    /**
     * 手续费值（月利率，不带百分号）
     * @return operate_fee 手续费值（月利率，不带百分号）
     */
    public Float getOperateFee() {
        return operateFee;
    }

    /**
     * 手续费值（月利率，不带百分号）
     * @param operateFee 手续费值（月利率，不带百分号）
     */
    public void setOperateFee(Float operateFee) {
        this.operateFee = operateFee;
    }

    /**
     * 
     * @return del_flag 
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 
     * @param delFlag 
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
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

    /**
     * 
     * @return create_by 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 
     * @return update_date 
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 
     * @param updateDate 
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 
     * @return update_by 
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 
     * @param updateBy 
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * nj_channel的id
     * @return channel_id nj_channel的id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * nj_channel的id
     * @param channelId nj_channel的id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 
     * @return nj_channel_id 
     */
    public String getNjChannelId() {
        return njChannelId;
    }

    /**
     * 
     * @param njChannelId 
     */
    public void setNjChannelId(String njChannelId) {
        this.njChannelId = njChannelId;
    }

    /**
     * 保证金类型(1:固定金额,2:比例,3:计算公式)
     * @return bond_type 保证金类型(1:固定金额,2:比例,3:计算公式)
     */
    public Byte getBondType() {
        return bondType;
    }

    /**
     * 保证金类型(1:固定金额,2:比例,3:计算公式)
     * @param bondType 保证金类型(1:固定金额,2:比例,3:计算公式)
     */
    public void setBondType(Byte bondType) {
        this.bondType = bondType;
    }

    /**
     * 保证金值
     * @return bond_value 保证金值
     */
    public String getBondValue() {
        return bondValue;
    }

    /**
     * 保证金值
     * @param bondValue 保证金值
     */
    public void setBondValue(String bondValue) {
        this.bondValue = bondValue;
    }

    /**
     * 是否期收利率写入合同  0 否 1是
     * @return is_rate_contract 是否期收利率写入合同  0 否 1是
     */
    public Boolean getIsRateContract() {
        return isRateContract;
    }

    /**
     * 是否期收利率写入合同  0 否 1是
     * @param isRateContract 是否期收利率写入合同  0 否 1是
     */
    public void setIsRateContract(Boolean isRateContract) {
        this.isRateContract = isRateContract;
    }
}