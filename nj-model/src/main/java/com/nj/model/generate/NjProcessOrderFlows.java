package com.nj.model.generate;

import java.util.Date;

import com.nj.core.base.enums.EProcessInfo;

public class NjProcessOrderFlows {
    /**
     * 
     */
    private String id;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 过程编号
     */
    private Integer processId;
    
    private String processName;

    /**
     * 审批用户编号
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 开始执行时间
     */
    private Date beginTime;

    /**
     * 完成执行时间
     */
    private Date finishTime;

    /**
     * 执行时间(以秒为单位)
     */
    private Long execTime;

    /**
     * 顺序
     */
    private Integer execOrders;

    /**
     * 状态(0:等待执行,1:正在执行,2:执行完成)
     */
    private Short status;

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
     * 过程编号
     * @return process_id 过程编号
     */
    public Integer getProcessId() {
        return processId;
    }

    /**
     * 过程编号
     * @param processId 过程编号
     */
    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    /**
     * 审批用户编号
     * @return user_id 审批用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 审批用户编号
     * @param userId 审批用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * 开始执行时间
     * @return begin_time 开始执行时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 开始执行时间
     * @param beginTime 开始执行时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 完成执行时间
     * @return finish_time 完成执行时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 完成执行时间
     * @param finishTime 完成执行时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 执行时间(以秒为单位)
     * @return exec_time 执行时间(以秒为单位)
     */
    public Long getExecTime() {
        return execTime;
    }

    /**
     * 执行时间(以秒为单位)
     * @param execTime 执行时间(以秒为单位)
     */
    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    /**
     * 顺序
     * @return exec_orders 顺序
     */
    public Integer getExecOrders() {
        return execOrders;
    }

    /**
     * 顺序
     * @param execOrders 顺序
     */
    public void setExecOrders(Integer execOrders) {
        this.execOrders = execOrders;
    }

    /**
     * 状态(0:等待执行,1:正在执行,2:执行完成)
     * @return status 状态(0:等待执行,1:正在执行,2:执行完成)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 状态(0:等待执行,1:正在执行,2:执行完成)
     * @param status 状态(0:等待执行,1:正在执行,2:执行完成)
     */
    public void setStatus(Short status) {
        this.status = status;
    }

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
}