package com.nj.mongoModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志记录model
 *
 * @author Lizy
 * @version 2018/5/3.
 */
public class LoggerModel extends MongoEntity {
    //调用的第三方
    private String thirdPart;
    // 调用名称
    private String name;
    // 描述
    private String description;
    // 调用结果
    private String status;
    // 调用时间
    private Date requestTime;
    // 调用时长
    private long requestDuration;
    // 订单id
    private String orderId;
    // 企业id
    private String companyId;

    public String getThirdPart() {
        return thirdPart;
    }

    public void setThirdPart(String thirdPart) {
        this.thirdPart = thirdPart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public long getRequestDuration() {
        return requestDuration;
    }

    public void setRequestDuration(long requestDuration) {
        this.requestDuration = requestDuration;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
