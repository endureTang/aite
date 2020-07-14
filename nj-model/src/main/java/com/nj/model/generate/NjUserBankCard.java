package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserBankCard {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    /**
     * 绑卡关联用户id
     */
    @ApiModelProperty(value = "绑卡关联用户id")
    private String userId;

    /**
     * 银行代码
     */
    @ApiModelProperty(value = "银行代码")
    private String bankCode;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    private String cardNumber;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String trueName;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    /**
     * 银行预留手机号
     */
    @ApiModelProperty(value = "银行预留手机号")
    private String cardMobile;

    /**
     * 状态(0:未绑卡,1:已绑卡)
     */
    @ApiModelProperty(value = "状态(0:未绑卡,1:已绑卡)")
    private Short status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean delFlag;

    /**
     * 绑卡类型：（1：微鼎，2：小贷）
     */
    @ApiModelProperty(value = "绑卡类型：（1：微鼎，2：小贷）")
    private Integer bankType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 编号
     * @return id 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 订单编号
     * @return order_id 订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单编号
     * @param orderId 订单编号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 绑卡关联用户id
     * @return user_id 绑卡关联用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 绑卡关联用户id
     * @param userId 绑卡关联用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 银行代码
     * @return bank_code 银行代码
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 银行代码
     * @param bankCode 银行代码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * 银行卡号
     * @return card_number 银行卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 银行卡号
     * @param cardNumber 银行卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 真实姓名
     * @return true_name 真实姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 真实姓名
     * @param trueName 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 身份证号
     * @return id_number 身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 身份证号
     * @param idNumber 身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 银行预留手机号
     * @return card_mobile 银行预留手机号
     */
    public String getCardMobile() {
        return cardMobile;
    }

    /**
     * 银行预留手机号
     * @param cardMobile 银行预留手机号
     */
    public void setCardMobile(String cardMobile) {
        this.cardMobile = cardMobile;
    }

    /**
     * 状态(0:未绑卡,1:已绑卡)
     * @return status 状态(0:未绑卡,1:已绑卡)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态(0:未绑卡,1:已绑卡)
     * @param status 状态(0:未绑卡,1:已绑卡)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 是否删除
     * @return del_flag 是否删除
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 是否删除
     * @param delFlag 是否删除
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 绑卡类型：（1：微鼎，2：小贷）
     * @return bank_type 绑卡类型：（1：微鼎，2：小贷）
     */
    public Integer getBankType() {
        return bankType;
    }

    /**
     * 绑卡类型：（1：微鼎，2：小贷）
     * @param bankType 绑卡类型：（1：微鼎，2：小贷）
     */
    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}