package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjContactCompany {
    private String id;

    /**
     * 实际控制人姓名
     */
    @ApiModelProperty(value = "实际控制人姓名")
    private String trueControlName;

    /**
     * 实际控制人身份证号码
     */
    @ApiModelProperty(value = "实际控制人身份证号码")
    private String trueControlIdcard;

    /**
     * 实际控制人电话号码
     */
    @ApiModelProperty(value = "实际控制人电话号码")
    private String trueControlMobile;

    /**
     * 法定代表人姓名
     */
    @ApiModelProperty(value = "法定代表人姓名")
    private String legalManName;

    /**
     * 法人身份证
     */
    @ApiModelProperty(value = "法人身份证")
    private String legalManIdcard;

    /**
     * 法人电话号码
     */
    @ApiModelProperty(value = "法人电话号码")
    private String legalManMobile;

    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    /**
     * 联系人电话号码
     */
    @ApiModelProperty(value = "联系人电话号码")
    private String contactMobile;

    /**
     * 最大自然人股东姓名
     */
    @ApiModelProperty(value = "最大自然人股东姓名")
    private String maxShareholderName;

    /**
     * 最大自然人股东身份证
     */
    @ApiModelProperty(value = "最大自然人股东身份证")
    private String maxShareholderIdcard;

    /**
     * 最大自然人股东电话
     */
    @ApiModelProperty(value = "最大自然人股东电话")
    private String maxShareholderMobile;

    /**
     * 最大法人股东姓名
     */
    @ApiModelProperty(value = "最大法人股东姓名")
    private String maxLegalManName;

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
     * 实际控制人姓名
     * @return true_control_name 实际控制人姓名
     */
    public String getTrueControlName() {
        return trueControlName;
    }

    /**
     * 实际控制人姓名
     * @param trueControlName 实际控制人姓名
     */
    public void setTrueControlName(String trueControlName) {
        this.trueControlName = trueControlName;
    }

    /**
     * 实际控制人身份证号码
     * @return true_control_idcard 实际控制人身份证号码
     */
    public String getTrueControlIdcard() {
        return trueControlIdcard;
    }

    /**
     * 实际控制人身份证号码
     * @param trueControlIdcard 实际控制人身份证号码
     */
    public void setTrueControlIdcard(String trueControlIdcard) {
        this.trueControlIdcard = trueControlIdcard;
    }

    /**
     * 实际控制人电话号码
     * @return true_control_mobile 实际控制人电话号码
     */
    public String getTrueControlMobile() {
        return trueControlMobile;
    }

    /**
     * 实际控制人电话号码
     * @param trueControlMobile 实际控制人电话号码
     */
    public void setTrueControlMobile(String trueControlMobile) {
        this.trueControlMobile = trueControlMobile;
    }

    /**
     * 法定代表人姓名
     * @return legal_man_name 法定代表人姓名
     */
    public String getLegalManName() {
        return legalManName;
    }

    /**
     * 法定代表人姓名
     * @param legalManName 法定代表人姓名
     */
    public void setLegalManName(String legalManName) {
        this.legalManName = legalManName;
    }

    /**
     * 法人身份证
     * @return legal_man_idcard 法人身份证
     */
    public String getLegalManIdcard() {
        return legalManIdcard;
    }

    /**
     * 法人身份证
     * @param legalManIdcard 法人身份证
     */
    public void setLegalManIdcard(String legalManIdcard) {
        this.legalManIdcard = legalManIdcard;
    }

    /**
     * 法人电话号码
     * @return legal_man_mobile 法人电话号码
     */
    public String getLegalManMobile() {
        return legalManMobile;
    }

    /**
     * 法人电话号码
     * @param legalManMobile 法人电话号码
     */
    public void setLegalManMobile(String legalManMobile) {
        this.legalManMobile = legalManMobile;
    }

    /**
     * 联系人姓名
     * @return contact_name 联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 联系人姓名
     * @param contactName 联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 联系人电话号码
     * @return contact_mobile 联系人电话号码
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * 联系人电话号码
     * @param contactMobile 联系人电话号码
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    /**
     * 最大自然人股东姓名
     * @return max_shareholder_name 最大自然人股东姓名
     */
    public String getMaxShareholderName() {
        return maxShareholderName;
    }

    /**
     * 最大自然人股东姓名
     * @param maxShareholderName 最大自然人股东姓名
     */
    public void setMaxShareholderName(String maxShareholderName) {
        this.maxShareholderName = maxShareholderName;
    }

    /**
     * 最大自然人股东身份证
     * @return max_shareholder_idcard 最大自然人股东身份证
     */
    public String getMaxShareholderIdcard() {
        return maxShareholderIdcard;
    }

    /**
     * 最大自然人股东身份证
     * @param maxShareholderIdcard 最大自然人股东身份证
     */
    public void setMaxShareholderIdcard(String maxShareholderIdcard) {
        this.maxShareholderIdcard = maxShareholderIdcard;
    }

    /**
     * 最大自然人股东电话
     * @return max_shareholder_mobile 最大自然人股东电话
     */
    public String getMaxShareholderMobile() {
        return maxShareholderMobile;
    }

    /**
     * 最大自然人股东电话
     * @param maxShareholderMobile 最大自然人股东电话
     */
    public void setMaxShareholderMobile(String maxShareholderMobile) {
        this.maxShareholderMobile = maxShareholderMobile;
    }

    /**
     * 最大法人股东姓名
     * @return max_legal_man_name 最大法人股东姓名
     */
    public String getMaxLegalManName() {
        return maxLegalManName;
    }

    /**
     * 最大法人股东姓名
     * @param maxLegalManName 最大法人股东姓名
     */
    public void setMaxLegalManName(String maxLegalManName) {
        this.maxLegalManName = maxLegalManName;
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