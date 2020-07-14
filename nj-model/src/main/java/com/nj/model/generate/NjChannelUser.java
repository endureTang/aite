package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjChannelUser {
    private String id;

    /**
     * 渠道id，对应nj_channel表
     */
    @ApiModelProperty(value = "渠道id，对应nj_channel表")
    private String channelId;

    /**
     * 用户id，对应nj_user_info表
     */
    @ApiModelProperty(value = "用户id，对应nj_user_info表")
    private String userInfoId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

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
     * 渠道id，对应nj_channel表
     * @return channel_id 渠道id，对应nj_channel表
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 渠道id，对应nj_channel表
     * @param channelId 渠道id，对应nj_channel表
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 用户id，对应nj_user_info表
     * @return user_info_id 用户id，对应nj_user_info表
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 用户id，对应nj_user_info表
     * @param userInfoId 用户id，对应nj_user_info表
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}