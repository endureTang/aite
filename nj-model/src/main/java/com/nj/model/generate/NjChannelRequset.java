package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjChannelRequset {
    private String id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 第三方订单编号
     */
    @ApiModelProperty(value = "第三方订单编号")
    private String sourceOrderNo;

    /**
     * 第三方业务号
     */
    @ApiModelProperty(value = "第三方业务号")
    private String businessNo;

    /**
     * 业务类型：RepayNotify （还款）
     */
    @ApiModelProperty(value = "业务类型：RepayNotify （还款）")
    private String requestType;

    /**
     * 渠道ID
     */
    @ApiModelProperty(value = "渠道ID")
    private String channelId;

    /**
     * 是否通知，0否1是
     */
    @ApiModelProperty(value = "是否通知，0否1是")
    private Boolean isNotice;

    /**
     * 请求状态  -1 初始状态  0 失败  1 成功。
     */
    @ApiModelProperty(value = "请求状态  -1 初始状态  0 失败  1 成功。")
    private Byte requestStatus;

    /**
     * 失败原因
     */
    @ApiModelProperty(value = "失败原因")
    private String failReasion;

    /**
     * 通知时间
     */
    @ApiModelProperty(value = "通知时间")
    private Date noticeTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 请求信息
     */
    @ApiModelProperty(value = "请求信息")
    private String requestMsg;

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
     * 订单编号
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 第三方订单编号
     * @return source_order_no 第三方订单编号
     */
    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    /**
     * 第三方订单编号
     * @param sourceOrderNo 第三方订单编号
     */
    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    /**
     * 第三方业务号
     * @return business_no 第三方业务号
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * 第三方业务号
     * @param businessNo 第三方业务号
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    /**
     * 业务类型：RepayNotify （还款）
     * @return request_type 业务类型：RepayNotify （还款）
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * 业务类型：RepayNotify （还款）
     * @param requestType 业务类型：RepayNotify （还款）
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * 渠道ID
     * @return channel_id 渠道ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 渠道ID
     * @param channelId 渠道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
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
     * 请求状态  -1 初始状态  0 失败  1 成功。
     * @return request_status 请求状态  -1 初始状态  0 失败  1 成功。
     */
    public Byte getRequestStatus() {
        return requestStatus;
    }

    /**
     * 请求状态  -1 初始状态  0 失败  1 成功。
     * @param requestStatus 请求状态  -1 初始状态  0 失败  1 成功。
     */
    public void setRequestStatus(Byte requestStatus) {
        this.requestStatus = requestStatus;
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
     * 请求信息
     * @return request_msg 请求信息
     */
    public String getRequestMsg() {
        return requestMsg;
    }

    /**
     * 请求信息
     * @param requestMsg 请求信息
     */
    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }
}