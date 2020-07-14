package com.nj.model.generate;

public class NjOrderBaseInfoCompany {
    private String id;

    private String orderId;

    private String baseInfoCompanyId;

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
     * @return base_info_company_id 
     */
    public String getBaseInfoCompanyId() {
        return baseInfoCompanyId;
    }

    /**
     * 
     * @param baseInfoCompanyId 
     */
    public void setBaseInfoCompanyId(String baseInfoCompanyId) {
        this.baseInfoCompanyId = baseInfoCompanyId;
    }
}