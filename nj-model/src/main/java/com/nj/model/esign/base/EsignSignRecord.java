package com.nj.model.esign.base;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class EsignSignRecord {
    private String id;

    /**
     * 签署文件属于那个订单
     */
    @ApiModelProperty(value = "签署文件属于那个订单")
    private String orderNo;

    /**
     * 签署人
     */
    @ApiModelProperty(value = "签署人")
    private String accountId;

    /**
     * 被签署文件分类
     */
    @ApiModelProperty(value = "被签署文件分类")
    private String fileCate;

    /**
     * 签署时间
     */
    @ApiModelProperty(value = "签署时间")
    private Date createTime;

    /**
     * e签宝接口返回的用于查询签署详情的id
     */
    @ApiModelProperty(value = "e签宝接口返回的用于查询签署详情的id")
    private String signRecordId;

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
     * 签署文件属于那个订单
     * @return order_no 签署文件属于那个订单
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 签署文件属于那个订单
     * @param orderNo 签署文件属于那个订单
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 签署人
     * @return account_id 签署人
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 签署人
     * @param accountId 签署人
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * 被签署文件分类
     * @return file_cate 被签署文件分类
     */
    public String getFileCate() {
        return fileCate;
    }

    /**
     * 被签署文件分类
     * @param fileCate 被签署文件分类
     */
    public void setFileCate(String fileCate) {
        this.fileCate = fileCate;
    }

    /**
     * 签署时间
     * @return create_time 签署时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 签署时间
     * @param createTime 签署时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * e签宝接口返回的用于查询签署详情的id
     * @return sign_record_id e签宝接口返回的用于查询签署详情的id
     */
    public String getSignRecordId() {
        return signRecordId;
    }

    /**
     * e签宝接口返回的用于查询签署详情的id
     * @param signRecordId e签宝接口返回的用于查询签署详情的id
     */
    public void setSignRecordId(String signRecordId) {
        this.signRecordId = signRecordId;
    }
}