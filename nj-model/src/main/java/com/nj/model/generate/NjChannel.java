package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjChannel {
    private String id;

    /**
     * 渠道类型 1：进件渠道，2资金渠道
     */
    @ApiModelProperty(value = "渠道类型 1：进件渠道，2资金渠道")
    private Short type;

    private String code;

    private String name;

    /**
     * 还款账户
     */
    @ApiModelProperty(value = "还款账户")
    private String repayAccountId;

    /**
     * 收款账户
     */
    @ApiModelProperty(value = "收款账户")
    private String repeeAccountId;

    private Date createDate;

    private Boolean delFlag;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String mobile;

    /**
     * 公司id
     */
    @ApiModelProperty(value = "公司id")
    private String companyId;

    /**
     * 每日接收资产上限设置（0：不设置）
     */
    @ApiModelProperty(value = "每日接收资产上限设置（0：不设置）")
    private Double fundsLimit;

    private String userInfoId;

    /**
     * 回调地址，该值主要是微鼎金融第三方进件时，订单状态回调，目前是4 和12的状态进行回调
     */
    @ApiModelProperty(value = "回调地址，该值主要是微鼎金融第三方进件时，订单状态回调，目前是4 和12的状态进行回调")
    private String callbackUrl;

    /**
     * 扣款通知URL
     */
    @ApiModelProperty(value = "扣款通知URL")
    private String diductionCallbackUrl;

    /**
     * 澶囨敞
     */
    @ApiModelProperty(value = "澶囨敞")
    private String remark;

    /**
     * 通用回调地址
     */
    @ApiModelProperty(value = "通用回调地址")
    private String commonCallbackUrl;

    private String activateCallbackUrl;

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
     * @return code 
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 还款账户
     * @return repay_account_id 还款账户
     */
    public String getRepayAccountId() {
        return repayAccountId;
    }

    /**
     * 还款账户
     * @param repayAccountId 还款账户
     */
    public void setRepayAccountId(String repayAccountId) {
        this.repayAccountId = repayAccountId;
    }

    /**
     * 收款账户
     * @return repee_account_id 收款账户
     */
    public String getRepeeAccountId() {
        return repeeAccountId;
    }

    /**
     * 收款账户
     * @param repeeAccountId 收款账户
     */
    public void setRepeeAccountId(String repeeAccountId) {
        this.repeeAccountId = repeeAccountId;
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
     * 
     * @return mobile 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     * @param mobile 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 公司id
     * @return company_id 公司id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 公司id
     * @param companyId 公司id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 每日接收资产上限设置（0：不设置）
     * @return funds_limit 每日接收资产上限设置（0：不设置）
     */
    public Double getFundsLimit() {
        return fundsLimit;
    }

    /**
     * 每日接收资产上限设置（0：不设置）
     * @param fundsLimit 每日接收资产上限设置（0：不设置）
     */
    public void setFundsLimit(Double fundsLimit) {
        this.fundsLimit = fundsLimit;
    }

    /**
     * 
     * @return user_info_id 
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 
     * @param userInfoId 
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * 回调地址，该值主要是微鼎金融第三方进件时，订单状态回调，目前是4 和12的状态进行回调
     * @return callback_url 回调地址，该值主要是微鼎金融第三方进件时，订单状态回调，目前是4 和12的状态进行回调
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * 回调地址，该值主要是微鼎金融第三方进件时，订单状态回调，目前是4 和12的状态进行回调
     * @param callbackUrl 回调地址，该值主要是微鼎金融第三方进件时，订单状态回调，目前是4 和12的状态进行回调
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * 扣款通知URL
     * @return diduction_callback_url 扣款通知URL
     */
    public String getDiductionCallbackUrl() {
        return diductionCallbackUrl;
    }

    /**
     * 扣款通知URL
     * @param diductionCallbackUrl 扣款通知URL
     */
    public void setDiductionCallbackUrl(String diductionCallbackUrl) {
        this.diductionCallbackUrl = diductionCallbackUrl;
    }

    /**
     * 澶囨敞
     * @return remark 澶囨敞
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 澶囨敞
     * @param remark 澶囨敞
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 通用回调地址
     * @return common_callback_url 通用回调地址
     */
    public String getCommonCallbackUrl() {
        return commonCallbackUrl;
    }

    /**
     * 通用回调地址
     * @param commonCallbackUrl 通用回调地址
     */
    public void setCommonCallbackUrl(String commonCallbackUrl) {
        this.commonCallbackUrl = commonCallbackUrl;
    }

    /**
     * 
     * @return activate_callback_url 
     */
    public String getActivateCallbackUrl() {
        return activateCallbackUrl;
    }

    /**
     * 
     * @param activateCallbackUrl 
     */
    public void setActivateCallbackUrl(String activateCallbackUrl) {
        this.activateCallbackUrl = activateCallbackUrl;
    }
}