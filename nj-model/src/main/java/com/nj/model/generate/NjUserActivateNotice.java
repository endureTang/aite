package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserActivateNotice {
    private String id;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String trueName;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "银行卡号")
    private String bankCard;

    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    /**
     * 绑定手机号码
     */
    @ApiModelProperty(value = "绑定手机号码")
    private String bindMobile;

    /**
     * 是否通知，0否1是
     */
    @ApiModelProperty(value = "是否通知，0否1是")
    private Boolean isNotice;

    /**
     * 激活状态 0 失败  1成功
     */
    @ApiModelProperty(value = "激活状态 0 失败  1成功")
    private Byte activateStatus;

    /**
     * 失败原因
     */
    @ApiModelProperty(value = "失败原因")
    private String failReasion;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 通知时间
     */
    @ApiModelProperty(value = "通知时间")
    private Date noticeTime;

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
     * 手机号码
     * @return mobile 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * 银行卡号
     * @return bank_card 银行卡号
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 银行卡号
     * @param bankCard 银行卡号
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    /**
     * 身份证号码
     * @return id_card 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号码
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 绑定手机号码
     * @return bind_mobile 绑定手机号码
     */
    public String getBindMobile() {
        return bindMobile;
    }

    /**
     * 绑定手机号码
     * @param bindMobile 绑定手机号码
     */
    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    /**
     * 是否通知，0否1是
     * @return is_notice 是否通知，0否1是
     */
    public Boolean getIsNotice() {
        return isNotice;
    }

    /**
     * 是否通知，0否1是
     * @param isNotice 是否通知，0否1是
     */
    public void setIsNotice(Boolean isNotice) {
        this.isNotice = isNotice;
    }

    /**
     * 激活状态 0 失败  1成功
     * @return activate_status 激活状态 0 失败  1成功
     */
    public Byte getActivateStatus() {
        return activateStatus;
    }

    /**
     * 激活状态 0 失败  1成功
     * @param activateStatus 激活状态 0 失败  1成功
     */
    public void setActivateStatus(Byte activateStatus) {
        this.activateStatus = activateStatus;
    }

    /**
     * 失败原因
     * @return fail_reasion 失败原因
     */
    public String getFailReasion() {
        return failReasion;
    }

    /**
     * 失败原因
     * @param failReasion 失败原因
     */
    public void setFailReasion(String failReasion) {
        this.failReasion = failReasion;
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

    /**
     * 通知时间
     * @return notice_time 通知时间
     */
    public Date getNoticeTime() {
        return noticeTime;
    }

    /**
     * 通知时间
     * @param noticeTime 通知时间
     */
    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }
}