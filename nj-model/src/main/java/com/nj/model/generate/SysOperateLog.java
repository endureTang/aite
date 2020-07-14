package com.nj.model.generate;

import java.util.Date;

public class SysOperateLog {
    /**
     * 编号
     */
    private Long id;

    /**
     * 操作人编号
     */
    private String userId;

    /**
     * 操作人姓名
     */
    private String userName;

    /**
     * 操作功能
     */
    private String operateFunction;

    /**
     * 操作内容
     */
    private String operateContent;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 编号
     * @return id 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 操作人编号
     * @return user_id 操作人编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 操作人编号
     * @param userId 操作人编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 操作人姓名
     * @return user_name 操作人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 操作人姓名
     * @param userName 操作人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 操作功能
     * @return operate_function 操作功能
     */
    public String getOperateFunction() {
        return operateFunction;
    }

    /**
     * 操作功能
     * @param operateFunction 操作功能
     */
    public void setOperateFunction(String operateFunction) {
        this.operateFunction = operateFunction;
    }

    /**
     * 操作内容
     * @return operate_content 操作内容
     */
    public String getOperateContent() {
        return operateContent;
    }

    /**
     * 操作内容
     * @param operateContent 操作内容
     */
    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }

    /**
     * 操作时间
     * @return create_time 操作时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 操作时间
     * @param createTime 操作时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}