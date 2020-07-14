package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjBankInfo {
    private Integer id;

    /**
     * 渠道类型
     */
    @ApiModelProperty(value = "渠道类型")
    private String channelType;

    /**
     * 银行编码
     */
    @ApiModelProperty(value = "银行编码")
    private String bankCode;

    /**
     * 银行名称
     */
    @ApiModelProperty(value = "银行名称")
    private String bankName;

    /**
     * 银行简写
     */
    @ApiModelProperty(value = "银行简写")
    private String bankAbbreviation;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 渠道类型
     * @return channel_type 渠道类型
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * 渠道类型
     * @param channelType 渠道类型
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    /**
     * 银行编码
     * @return bank_code 银行编码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 银行编码
     * @param bankCode 银行编码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * 银行名称
     * @return bank_name 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 银行名称
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 银行简写
     * @return bank_abbreviation 银行简写
     */
    public String getBankAbbreviation() {
        return bankAbbreviation;
    }

    /**
     * 银行简写
     * @param bankAbbreviation 银行简写
     */
    public void setBankAbbreviation(String bankAbbreviation) {
        this.bankAbbreviation = bankAbbreviation;
    }
}