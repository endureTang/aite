package com.nj.model.generate;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjAppUser implements Serializable {
    private String id;

    private Integer version;

    private String address;

    private String mial;

    private String mobile;

    private String nickName;

    private String userId;

    private String userAvatar;

    private Integer userType;

    private String trueName;

    private String identifyId;

    private String defiTrueName;

    private String defiIdentifyId;

    private String authToken;

    private String lastLoginDeviceOs;

    private String lastLoginDeviceId;

    private String lastLoginDeviceType;

    private Date lastLoginDate;

    private Boolean isContactSync;

    private Date lastContactSyncDate;

    private String openId;

    /**
     * 账号来源渠道
     */
    @ApiModelProperty(value = "账号来源渠道")
    private String channel;

    private String channelUserId;

    /**
     * 0 未审核 1已通过 2不通过
     */
    @ApiModelProperty(value = "0 未审核 1已通过 2不通过")
    private Integer fraudType;

    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private String companyId;

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
     * @return version 
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 
     * @return address 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return mial 
     */
    public String getMial() {
        return mial;
    }

    /**
     * 
     * @param mial 
     */
    public void setMial(String mial) {
        this.mial = mial;
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
     * 
     * @return nick_name 
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 
     * @param nickName 
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 
     * @return user_id 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return user_avatar 
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 
     * @param userAvatar 
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * 
     * @return user_type 
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType 
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 
     * @return true_name 
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 
     * @param trueName 
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 
     * @return identify_id 
     */
    public String getIdentifyId() {
        return identifyId;
    }

    /**
     * 
     * @param identifyId 
     */
    public void setIdentifyId(String identifyId) {
        this.identifyId = identifyId;
    }

    /**
     * 
     * @return defi_true_name 
     */
    public String getDefiTrueName() {
        return defiTrueName;
    }

    /**
     * 
     * @param defiTrueName 
     */
    public void setDefiTrueName(String defiTrueName) {
        this.defiTrueName = defiTrueName;
    }

    /**
     * 
     * @return defi_identify_id 
     */
    public String getDefiIdentifyId() {
        return defiIdentifyId;
    }

    /**
     * 
     * @param defiIdentifyId 
     */
    public void setDefiIdentifyId(String defiIdentifyId) {
        this.defiIdentifyId = defiIdentifyId;
    }

    /**
     * 
     * @return auth_token 
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * 
     * @param authToken 
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * 
     * @return last_login_device_os 
     */
    public String getLastLoginDeviceOs() {
        return lastLoginDeviceOs;
    }

    /**
     * 
     * @param lastLoginDeviceOs 
     */
    public void setLastLoginDeviceOs(String lastLoginDeviceOs) {
        this.lastLoginDeviceOs = lastLoginDeviceOs;
    }

    /**
     * 
     * @return last_login_device_id 
     */
    public String getLastLoginDeviceId() {
        return lastLoginDeviceId;
    }

    /**
     * 
     * @param lastLoginDeviceId 
     */
    public void setLastLoginDeviceId(String lastLoginDeviceId) {
        this.lastLoginDeviceId = lastLoginDeviceId;
    }

    /**
     * 
     * @return last_login_device_type 
     */
    public String getLastLoginDeviceType() {
        return lastLoginDeviceType;
    }

    /**
     * 
     * @param lastLoginDeviceType 
     */
    public void setLastLoginDeviceType(String lastLoginDeviceType) {
        this.lastLoginDeviceType = lastLoginDeviceType;
    }

    /**
     * 
     * @return last_login_date 
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 
     * @param lastLoginDate 
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 
     * @return is_contact_sync 
     */
    public Boolean getIsContactSync() {
        return isContactSync;
    }

    /**
     * 
     * @param isContactSync 
     */
    public void setIsContactSync(Boolean isContactSync) {
        this.isContactSync = isContactSync;
    }

    /**
     * 
     * @return last_contact_sync_date 
     */
    public Date getLastContactSyncDate() {
        return lastContactSyncDate;
    }

    /**
     * 
     * @param lastContactSyncDate 
     */
    public void setLastContactSyncDate(Date lastContactSyncDate) {
        this.lastContactSyncDate = lastContactSyncDate;
    }

    /**
     * 
     * @return open_id 
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 
     * @param openId 
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 账号来源渠道
     * @return channel 账号来源渠道
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 账号来源渠道
     * @param channel 账号来源渠道
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 
     * @return channel_user_id 
     */
    public String getChannelUserId() {
        return channelUserId;
    }

    /**
     * 
     * @param channelUserId 
     */
    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    /**
     * 0 未审核 1已通过 2不通过
     * @return fraud_type 0 未审核 1已通过 2不通过
     */
    public Integer getFraudType() {
        return fraudType;
    }

    /**
     * 0 未审核 1已通过 2不通过
     * @param fraudType 0 未审核 1已通过 2不通过
     */
    public void setFraudType(Integer fraudType) {
        this.fraudType = fraudType;
    }

    /**
     * 企业id
     * @return company_id 企业id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 企业id
     * @param companyId 企业id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}