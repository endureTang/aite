package com.nj.model.generate;

public class NjProcessTemplateFlows {
    /**
     * 
     */
    private Long id;

    /**
     * 模板编号
     */
    private String templateId;

    /**
     * 过程编号
     */
    private Integer processId;

    /**
     * 过程类型(1:手动任务,2:自动任务,3:判断)
     */
    private Short type;

    /**
     * 过程名称
     */
    private String processName;

    /**
     * 执行方法
     */
    private String execFunction;

    /**
     * 前置条件(1:agree:同意,2:reject:驳回,3:refuse:拒绝)
     */
    private Short precondition;

    /**
     * 同意订单状态
     */
    private Integer execAgreeStatus;

    /**
     * 驳回订单状态
     */
    private Integer execRejectStatus;

    /**
     * 执行拒绝订单状态
     */
    private Integer execRefuseStatus;

    /**
     * 顺序
     */
    private Integer execOrders;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 模板编号
     * @return template_id 模板编号
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 模板编号
     * @param templateId 模板编号
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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
     * 过程类型(1:手动任务,2:自动任务,3:判断)
     * @return type 过程类型(1:手动任务,2:自动任务,3:判断)
     */
    public Short getType() {
        return type;
    }

    /**
     * 过程类型(1:手动任务,2:自动任务,3:判断)
     * @param type 过程类型(1:手动任务,2:自动任务,3:判断)
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 过程名称
     * @return process_name 过程名称
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 过程名称
     * @param processName 过程名称
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 执行方法
     * @return exec_function 执行方法
     */
    public String getExecFunction() {
        return execFunction;
    }

    /**
     * 执行方法
     * @param execFunction 执行方法
     */
    public void setExecFunction(String execFunction) {
        this.execFunction = execFunction;
    }

    /**
     * 前置条件(1:agree:同意,2:reject:驳回,3:refuse:拒绝)
     * @return precondition 前置条件(1:agree:同意,2:reject:驳回,3:refuse:拒绝)
     */
    public Short getPrecondition() {
        return precondition;
    }

    /**
     * 前置条件(1:agree:同意,2:reject:驳回,3:refuse:拒绝)
     * @param precondition 前置条件(1:agree:同意,2:reject:驳回,3:refuse:拒绝)
     */
    public void setPrecondition(Short precondition) {
        this.precondition = precondition;
    }

    /**
     * 同意订单状态
     * @return exec_agree_status 同意订单状态
     */
    public Integer getExecAgreeStatus() {
        return execAgreeStatus;
    }

    /**
     * 同意订单状态
     * @param execAgreeStatus 同意订单状态
     */
    public void setExecAgreeStatus(Integer execAgreeStatus) {
        this.execAgreeStatus = execAgreeStatus;
    }

    /**
     * 驳回订单状态
     * @return exec_reject_status 驳回订单状态
     */
    public Integer getExecRejectStatus() {
        return execRejectStatus;
    }

    /**
     * 驳回订单状态
     * @param execRejectStatus 驳回订单状态
     */
    public void setExecRejectStatus(Integer execRejectStatus) {
        this.execRejectStatus = execRejectStatus;
    }

    /**
     * 执行拒绝订单状态
     * @return exec_refuse_status 执行拒绝订单状态
     */
    public Integer getExecRefuseStatus() {
        return execRefuseStatus;
    }

    /**
     * 执行拒绝订单状态
     * @param execRefuseStatus 执行拒绝订单状态
     */
    public void setExecRefuseStatus(Integer execRefuseStatus) {
        this.execRefuseStatus = execRefuseStatus;
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
}