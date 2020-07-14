package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserInfo {
    private String id;

    private String applyReason;

    private String userName;

    private String email;

    private String userMobile;

    private String password;

    private Integer state;

    private String authToken;

    private Date lastLoginDate;

    private String remarks;

    private Boolean delFlag;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String openUserId;

    private String parentId;

    /**
     * 用户登录token,用于长期登录
     */
    @ApiModelProperty(value = "用户登录token,用于长期登录")
    private String token;

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
     * @return apply_reason 
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * 
     * @param applyReason 
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return user_mobile 
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 
     * @param userMobile 
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return state 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @param state 
     */
    public void setState(Integer state) {
        this.state = state;
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
     * @return remarks 
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 
     * @param remarks 
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
     * 
     * @return open_user_id 
     */
    public String getOpenUserId() {
        return openUserId;
    }

    /**
     * 
     * @param openUserId 
     */
    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }

    /**
     * 
     * @return parent_id 
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId 
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 用户登录token,用于长期登录
     * @return token 用户登录token,用于长期登录
     */
    public String getToken() {
        return token;
    }

    /**
     * 用户登录token,用于长期登录
     * @param token 用户登录token,用于长期登录
     */
    public void setToken(String token) {
        this.token = token;
    }
}