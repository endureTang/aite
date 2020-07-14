package com.nj.model.generate;

public class NjOrderPawnHouseLink {
    private String id;

    private String orderId;

    private String pawnId;

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
     * @return pawn_id 
     */
    public String getPawnId() {
        return pawnId;
    }

    /**
     * 
     * @param pawnId 
     */
    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }
}