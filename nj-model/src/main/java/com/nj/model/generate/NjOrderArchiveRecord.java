package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjOrderArchiveRecord {
    private String id;

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String orderId;

    /**
     * 登记证书
     */
    @ApiModelProperty(value = "登记证书（0：未归档，1：已归档）")
    private Integer certificate;

    /**
     * 车辆保单
     */
    @ApiModelProperty(value = "车辆保单（0：未归档，1：已归档）")
    private Integer carWarranty;

    /**
     * 购车发票
     */
    @ApiModelProperty(value = "购车发票（0：未归档，1：已归档）")
    private Integer carInvoice;

    /**
     * GPS照片
     */
    @ApiModelProperty(value = "GPS照片（0：未归档，1：已归档）")
    private Integer gpsPhoto;

    /**
     * 归档时间
     */
    @ApiModelProperty(value = "归档时间")
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
     * 订单id
     * @return order_id 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 登记证书
     * @return certificate 登记证书
     */
    public Integer getCertificate() {
        return certificate;
    }

    /**
     * 登记证书
     * @param certificate 登记证书
     */
    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    /**
     * 车辆保单
     * @return car_warranty 车辆保单
     */
    public Integer getCarWarranty() {
        return carWarranty;
    }

    /**
     * 车辆保单
     * @param carWarranty 车辆保单
     */
    public void setCarWarranty(Integer carWarranty) {
        this.carWarranty = carWarranty;
    }

    /**
     * 购车发票
     * @return car_invoice 购车发票
     */
    public Integer getCarInvoice() {
        return carInvoice;
    }

    /**
     * 购车发票
     * @param carInvoice 购车发票
     */
    public void setCarInvoice(Integer carInvoice) {
        this.carInvoice = carInvoice;
    }

    /**
     * GPS照片
     * @return gps_photo GPS照片
     */
    public Integer getGpsPhoto() {
        return gpsPhoto;
    }

    /**
     * GPS照片
     * @param gpsPhoto GPS照片
     */
    public void setGpsPhoto(Integer gpsPhoto) {
        this.gpsPhoto = gpsPhoto;
    }

    /**
     * 归档时间
     * @return create_time 归档时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 归档时间
     * @param createTime 归档时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}