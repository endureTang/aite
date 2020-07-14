package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjStatisticsManagerReturn {
    private String id;

    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID")
    private String coporateId;

    /**
     * 企业员工
     */
    @ApiModelProperty(value = "企业员工")
    private String userId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String coporateName;

    /**
     * 员工名称
     */
    @ApiModelProperty(value = "员工名称")
    private String userName;

    /**
     * 回款金额
     */
    @ApiModelProperty(value = "回款金额")
    private BigDecimal returnAmount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 回款时间
     */
    @ApiModelProperty(value = "回款时间")
    private Date returnTime;

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
     * 企业ID
     * @return coporate_id 企业ID
     */
    public String getCoporateId() {
        return coporateId;
    }

    /**
     * 企业ID
     * @param coporateId 企业ID
     */
    public void setCoporateId(String coporateId) {
        this.coporateId = coporateId;
    }

    /**
     * 企业员工
     * @return user_id 企业员工
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 企业员工
     * @param userId 企业员工
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 企业名称
     * @return coporate_name 企业名称
     */
    public String getCoporateName() {
        return coporateName;
    }

    /**
     * 企业名称
     * @param coporateName 企业名称
     */
    public void setCoporateName(String coporateName) {
        this.coporateName = coporateName;
    }

    /**
     * 员工名称
     * @return user_name 员工名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 员工名称
     * @param userName 员工名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 回款金额
     * @return return_amount 回款金额
     */
    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * 回款金额
     * @param returnAmount 回款金额
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
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

    /**
     * 回款时间
     * @return return_time 回款时间
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 回款时间
     * @param returnTime 回款时间
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
}