 package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserPushMessage {
    private String id;

    /**
     * 推送人（企业id）
     */
    @ApiModelProperty(value = "推送人（企业id）")
    private String pushId;

    /**
     * 接收人（用户id）
     */
    @ApiModelProperty(value = "接收人（用户id）")
    private String receiveId;

    /**
     * 推送人名称
     */
    @ApiModelProperty(value = "推送人名称")
    private String pushName;

    /**
     * 接收人名称
     */
    @ApiModelProperty(value = "接收人名称")
    private String receiveName;

    /**
     * 消息标题
     */
    @ApiModelProperty(value = "消息标题")
    private String title;

    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String content;

    /**
     * 推送时间
     */
    @ApiModelProperty(value = "推送时间")
    private Date pushDate;

    /**
     * 接受时间
     */
    @ApiModelProperty(value = "接受时间")
    private Date readDate;

    /**
     * 是否阅读（0：否，1：是）
     */
    @ApiModelProperty(value = "是否阅读（0：否，1：是）")
    private Integer isRead;

    /**
     * 是否删除（0：否，1：是）
     */
    @ApiModelProperty(value = "是否删除（0：否，1：是）")
    private Integer delFlag;

    /**
     * 消息类型（1：贷款通知，2：还款通知，3：债权转让通知）
     */
    @ApiModelProperty(value = "消息类型（1：贷款通知，2：还款通知，3：债权转让通知）")
    private Integer type;

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
     * 推送人（企业id）
     * @return push_id 推送人（企业id）
     */
    public String getPushId() {
        return pushId;
    }

    /**
     * 推送人（企业id）
     * @param pushId 推送人（企业id）
     */
    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    /**
     * 接收人（用户id）
     * @return receive_id 接收人（用户id）
     */
    public String getReceiveId() {
        return receiveId;
    }

    /**
     * 接收人（用户id）
     * @param receiveId 接收人（用户id）
     */
    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * 推送人名称
     * @return push_name 推送人名称
     */
    public String getPushName() {
        return pushName;
    }

    /**
     * 推送人名称
     * @param pushName 推送人名称
     */
    public void setPushName(String pushName) {
        this.pushName = pushName;
    }

    /**
     * 接收人名称
     * @return receive_name 接收人名称
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * 接收人名称
     * @param receiveName 接收人名称
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    /**
     * 消息标题
     * @return title 消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 消息标题
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 消息内容
     * @return content 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 消息内容
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 推送时间
     * @return push_date 推送时间
     */
    public Date getPushDate() {
        return pushDate;
    }

    /**
     * 推送时间
     * @param pushDate 推送时间
     */
    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    /**
     * 接受时间
     * @return read_date 接受时间
     */
    public Date getReadDate() {
        return readDate;
    }

    /**
     * 接受时间
     * @param readDate 接受时间
     */
    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    /**
     * 是否阅读（0：否，1：是）
     * @return is_read 是否阅读（0：否，1：是）
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 是否阅读（0：否，1：是）
     * @param isRead 是否阅读（0：否，1：是）
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 是否删除（0：否，1：是）
     * @return del_flag 是否删除（0：否，1：是）
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 是否删除（0：否，1：是）
     * @param delFlag 是否删除（0：否，1：是）
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 消息类型（1：贷款通知，2：还款通知，3：债权转让通知）
     * @return type 消息类型（1：贷款通知，2：还款通知，3：债权转让通知）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 消息类型（1：贷款通知，2：还款通知，3：债权转让通知）
     * @param type 消息类型（1：贷款通知，2：还款通知，3：债权转让通知）
     */
    public void setType(Integer type) {
        this.type = type;
    }
}