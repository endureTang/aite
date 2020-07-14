package com.nj.model.generate;

public class NjLoanOrderPhoneCheck {
    /**
     * 
     */
    private String id;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 与贷款人关系
     */
    private String relation;

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
     * 联系人
     * @return contact_name 联系人
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 联系人
     * @param contactName 联系人
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 联系电话
     * @return contact_phone 联系电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 联系电话
     * @param contactPhone 联系电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 与贷款人关系
     * @return relation 与贷款人关系
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 与贷款人关系
     * @param relation 与贷款人关系
     */
    public void setRelation(String relation) {
        this.relation = relation;
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