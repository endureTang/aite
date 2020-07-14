package com.nj.model.generate;

import java.util.Date;

public class NjAppUserBusicommUpdate {
    private String id;

    /**
     * nj_app_user的id
     */
    private String appUserId;

    /**
     * 老客户经理id
     */
    private String oldBusicommId;

    /**
     * 新客户经理id
     */
    private String newBusicommId;

    /**
     * 记录创建时间
     */
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
     * nj_app_user的id
     * @return app_user_id nj_app_user的id
     */
    public String getAppUserId() {
        return appUserId;
    }

    /**
     * nj_app_user的id
     * @param appUserId nj_app_user的id
     */
    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    /**
     * 老客户经理id
     * @return old_busicomm_id 老客户经理id
     */
    public String getOldBusicommId() {
        return oldBusicommId;
    }

    /**
     * 老客户经理id
     * @param oldBusicommId 老客户经理id
     */
    public void setOldBusicommId(String oldBusicommId) {
        this.oldBusicommId = oldBusicommId;
    }

    /**
     * 新客户经理id
     * @return new_busicomm_id 新客户经理id
     */
    public String getNewBusicommId() {
        return newBusicommId;
    }

    /**
     * 新客户经理id
     * @param newBusicommId 新客户经理id
     */
    public void setNewBusicommId(String newBusicommId) {
        this.newBusicommId = newBusicommId;
    }

    /**
     * 记录创建时间
     * @return create_time 记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 记录创建时间
     * @param createTime 记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}