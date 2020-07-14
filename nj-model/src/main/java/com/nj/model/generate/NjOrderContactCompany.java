package com.nj.model.generate;

public class NjOrderContactCompany {
    private String id;

    private String orderId;

    private String njContactCompanyId;

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
     * @return order_id 
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId 
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 
     * @return nj_contact_company_id 
     */
    public String getNjContactCompanyId() {
        return njContactCompanyId;
    }

    /**
     * 
     * @param njContactCompanyId 
     */
    public void setNjContactCompanyId(String njContactCompanyId) {
        this.njContactCompanyId = njContactCompanyId;
    }
}