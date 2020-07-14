package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserCar {
    private String id;

    private Integer version;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carNumber;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 型号
     */
    @ApiModelProperty(value = "型号")
    private String model;

    /**
     * 首付金额
     */
    @ApiModelProperty(value = "首付金额")
    private BigDecimal firstPayment;

    /**
     * 实际购车价，单位万
     */
    @ApiModelProperty(value = "实际购车价，单位万")
    private String buyPrice;

    /**
     * 车龄
     */
    @ApiModelProperty(value = "车龄")
    private String carAge;

    private String remark;

    private Date createDate;

    private Boolean delFlag;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 车辆新旧程度
     */
    @ApiModelProperty(value = "车辆新旧程度")
    private String xjcd;

    /**
     * 车辆上户地区
     */
    @ApiModelProperty(value = "车辆上户地区")
    private String shdq;

    /**
     * 购置日期
     */
    @ApiModelProperty(value = "购置日期")
    private Date buyDate;

    /**
     * 保险单号
     */
    @ApiModelProperty(value = "保险单号")
    private String insuranceNo;

    /**
     * 车架号
     */
    @ApiModelProperty(value = "车架号")
    private String vin;

    /**
     * 上一承租人项目编号
     */
    @ApiModelProperty(value = "上一承租人项目编号")
    private String lastProjectNo;

    /**
     * 第一个承租人项目编号
     */
    @ApiModelProperty(value = "第一个承租人项目编号")
    private String firstProjectNo;

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
     * @return version 
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 车牌号
     * @return car_number 车牌号
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * 车牌号
     * @param carNumber 车牌号
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * 车型
     * @return car_type 车型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 车型
     * @param carType 车型
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 品牌
     * @return brand 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 品牌
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 型号
     * @return model 型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 型号
     * @param model 型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 首付金额
     * @return first_payment 首付金额
     */
    public BigDecimal getFirstPayment() {
        return firstPayment;
    }

    /**
     * 首付金额
     * @param firstPayment 首付金额
     */
    public void setFirstPayment(BigDecimal firstPayment) {
        this.firstPayment = firstPayment;
    }

    /**
     * 实际购车价，单位万
     * @return buy_price 实际购车价，单位万
     */
    public String getBuyPrice() {
        return buyPrice;
    }

    /**
     * 实际购车价，单位万
     * @param buyPrice 实际购车价，单位万
     */
    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * 车龄
     * @return car_age 车龄
     */
    public String getCarAge() {
        return carAge;
    }

    /**
     * 车龄
     * @param carAge 车龄
     */
    public void setCarAge(String carAge) {
        this.carAge = carAge;
    }

    /**
     * 
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * @return del_flag 
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 
     * @param delFlag 
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 车辆新旧程度
     * @return xjcd 车辆新旧程度
     */
    public String getXjcd() {
        return xjcd;
    }

    /**
     * 车辆新旧程度
     * @param xjcd 车辆新旧程度
     */
    public void setXjcd(String xjcd) {
        this.xjcd = xjcd;
    }

    /**
     * 车辆上户地区
     * @return shdq 车辆上户地区
     */
    public String getShdq() {
        return shdq;
    }

    /**
     * 车辆上户地区
     * @param shdq 车辆上户地区
     */
    public void setShdq(String shdq) {
        this.shdq = shdq;
    }

    /**
     * 购置日期
     * @return buy_date 购置日期
     */
    public Date getBuyDate() {
        return buyDate;
    }

    /**
     * 购置日期
     * @param buyDate 购置日期
     */
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * 保险单号
     * @return insurance_no 保险单号
     */
    public String getInsuranceNo() {
        return insuranceNo;
    }

    /**
     * 保险单号
     * @param insuranceNo 保险单号
     */
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    /**
     * 车架号
     * @return vin 车架号
     */
    public String getVin() {
        return vin;
    }

    /**
     * 车架号
     * @param vin 车架号
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * 上一承租人项目编号
     * @return last_project_no 上一承租人项目编号
     */
    public String getLastProjectNo() {
        return lastProjectNo;
    }

    /**
     * 上一承租人项目编号
     * @param lastProjectNo 上一承租人项目编号
     */
    public void setLastProjectNo(String lastProjectNo) {
        this.lastProjectNo = lastProjectNo;
    }

    /**
     * 第一个承租人项目编号
     * @return first_project_no 第一个承租人项目编号
     */
    public String getFirstProjectNo() {
        return firstProjectNo;
    }

    /**
     * 第一个承租人项目编号
     * @param firstProjectNo 第一个承租人项目编号
     */
    public void setFirstProjectNo(String firstProjectNo) {
        this.firstProjectNo = firstProjectNo;
    }
}