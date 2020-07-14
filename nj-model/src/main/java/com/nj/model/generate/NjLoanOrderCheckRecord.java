package com.nj.model.generate;

import java.util.Date;

public class NjLoanOrderCheckRecord {
    /**
     * 
     */
    private String id;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 核查人编号
     */
    private String checkUserId;

    /**
     * 核查时间
     */
    private Date checkDate;

    /**
     * 核查数据类型(1:基础信息,2:信用信息,3:人工核查
            11:申请信息,12:个人信息,13:工作单位,14:车辆信息,
            15:联系人,16:资产佐证,17:其他资料,
            21:修改贷后订单反欺诈状态
            )
     */
    private Byte dataType;

    /**
     * 是否异常(0:正常,1:异常)
     */
    private Boolean abnormal;

    /**
     * 备注
     */
    private String remark;

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
     * 核查人编号
     * @return check_user_id 核查人编号
     */
    public String getCheckUserId() {
        return checkUserId;
    }

    /**
     * 核查人编号
     * @param checkUserId 核查人编号
     */
    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    /**
     * 核查时间
     * @return check_date 核查时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 核查时间
     * @param checkDate 核查时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 核查数据类型(1:基础信息,2:信用信息,3:人工核查
            11:申请信息,12:个人信息,13:工作单位,14:车辆信息,
            15:联系人,16:资产佐证,17:其他资料,
            
            )
     * @return data_type 核查数据类型(1:基础信息,2:信用信息,3:人工核查
            11:申请信息,12:个人信息,13:工作单位,14:车辆信息,
            15:联系人,16:资产佐证,17:其他资料,
            
            )
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     * 核查数据类型(1:基础信息,2:信用信息,3:人工核查
            11:申请信息,12:个人信息,13:工作单位,14:车辆信息,
            15:联系人,16:资产佐证,17:其他资料,
            
            )
     * @param dataType 核查数据类型(1:基础信息,2:信用信息,3:人工核查
            11:申请信息,12:个人信息,13:工作单位,14:车辆信息,
            15:联系人,16:资产佐证,17:其他资料,
            
            )
     */
    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    /**
     * 是否异常(0:正常,1:异常)
     * @return abnormal 是否异常(0:正常,1:异常)
     */
    public Boolean getAbnormal() {
        return abnormal;
    }

    /**
     * 是否异常(0:正常,1:异常)
     * @param abnormal 是否异常(0:正常,1:异常)
     */
    public void setAbnormal(Boolean abnormal) {
        this.abnormal = abnormal;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}