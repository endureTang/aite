package com.nj.model.generate;

public class NjOrderDebt {
    private String id;

    private String debtId;

    private String orderId;

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
     * @return debt_id 
     */
    public String getDebtId() {
        return debtId;
    }

    /**
     * 
     * @param debtId 
     */
    public void setDebtId(String debtId) {
        this.debtId = debtId;
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
}