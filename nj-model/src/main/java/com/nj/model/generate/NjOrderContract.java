package com.nj.model.generate;

import java.util.Date;

public class NjOrderContract {
    private String id;

    private String orderNo;

    private String contractTemplateId;

    private String contractName;

    private String url;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

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
     * 
     * @return order_no 
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 
     * @param orderNo 
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 
     * @return contract_template_id 
     */
    public String getContractTemplateId() {
        return contractTemplateId;
    }

    /**
     * 
     * @param contractTemplateId 
     */
    public void setContractTemplateId(String contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    /**
     * 
     * @return contract_name 
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * 
     * @param contractName 
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * 
     * @return url 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return create_date 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return create_by 
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 
     * @param createBy 
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 
     * @return update_date 
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 
     * @param updateDate 
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 
     * @return update_by 
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 
     * @param updateBy 
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}