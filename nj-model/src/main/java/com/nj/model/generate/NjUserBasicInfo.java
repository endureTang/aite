package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserBasicInfo {
    private String id;

    private Integer version;

    private String areaCode;

    private String address;

    private Integer marrStatus;

    private String userId;

    private String orderId;

    private Integer maxEducation;

    private Integer estateType;

    private Boolean bindBankCark;

    private String bankAccount;

    /**
     * 户籍
     */
    @ApiModelProperty(value = "户籍")
    private String householdRegister;

    private String remarks;

    private Date createDate;

    private Boolean delFlag;

    private String name;

    private String idCardNum;

    private Integer sex;

    private Integer age;

    private String mobile;

    private String addressNature;

    private BigDecimal addressMoney;

    private String nation;

    private String province;

    private String city;

    private String county;

    private String telephone;

    /**
     * 所属行业
     */
    @ApiModelProperty(value = "所属行业")
    private String ownIndustry;

    /**
     * 微信号
     */
    @ApiModelProperty(value = "微信号")
    private String weixinNo;

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
     * 
     * @return area_code 
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 
     * @param areaCode 
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 
     * @return address 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return marr_status 
     */
    public Integer getMarrStatus() {
        return marrStatus;
    }

    /**
     * 
     * @param marrStatus 
     */
    public void setMarrStatus(Integer marrStatus) {
        this.marrStatus = marrStatus;
    }

    /**
     * 
     * @return user_id 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return max_education 
     */
    public Integer getMaxEducation() {
        return maxEducation;
    }

    /**
     * 
     * @param maxEducation 
     */
    public void setMaxEducation(Integer maxEducation) {
        this.maxEducation = maxEducation;
    }

    /**
     * 
     * @return estate_type 
     */
    public Integer getEstateType() {
        return estateType;
    }

    /**
     * 
     * @param estateType 
     */
    public void setEstateType(Integer estateType) {
        this.estateType = estateType;
    }

    /**
     * 
     * @return bind_bank_cark 
     */
    public Boolean getBindBankCark() {
        return bindBankCark;
    }

    /**
     * 
     * @param bindBankCark 
     */
    public void setBindBankCark(Boolean bindBankCark) {
        this.bindBankCark = bindBankCark;
    }

    /**
     * 
     * @return bank_account 
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 
     * @param bankAccount 
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 户籍
     * @return household_register 户籍
     */
    public String getHouseholdRegister() {
        return householdRegister;
    }

    /**
     * 户籍
     * @param householdRegister 户籍
     */
    public void setHouseholdRegister(String householdRegister) {
        this.householdRegister = householdRegister;
    }

    /**
     * 
     * @return remarks 
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 
     * @param remarks 
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return id_card_num 
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    /**
     * 
     * @param idCardNum 
     */
    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    /**
     * 
     * @return sex 
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 
     * @param sex 
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 
     * @return age 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     * @return mobile 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     * @param mobile 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 
     * @return address_nature 
     */
    public String getAddressNature() {
        return addressNature;
    }

    /**
     * 
     * @param addressNature 
     */
    public void setAddressNature(String addressNature) {
        this.addressNature = addressNature;
    }

    /**
     * 
     * @return address_money 
     */
    public BigDecimal getAddressMoney() {
        return addressMoney;
    }

    /**
     * 
     * @param addressMoney 
     */
    public void setAddressMoney(BigDecimal addressMoney) {
        this.addressMoney = addressMoney;
    }

    /**
     * 
     * @return nation 
     */
    public String getNation() {
        return nation;
    }

    /**
     * 
     * @param nation 
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 
     * @return province 
     */
    public String getProvince() {
        return province;
    }

    /**
     * 
     * @param province 
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 
     * @return city 
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return county 
     */
    public String getCounty() {
        return county;
    }

    /**
     * 
     * @param county 
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 
     * @return telephone 
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     * @param telephone 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 所属行业
     * @return own_industry 所属行业
     */
    public String getOwnIndustry() {
        return ownIndustry;
    }

    /**
     * 所属行业
     * @param ownIndustry 所属行业
     */
    public void setOwnIndustry(String ownIndustry) {
        this.ownIndustry = ownIndustry;
    }

    /**
     * 微信号
     * @return weixin_no 微信号
     */
    public String getWeixinNo() {
        return weixinNo;
    }

    /**
     * 微信号
     * @param weixinNo 微信号
     */
    public void setWeixinNo(String weixinNo) {
        this.weixinNo = weixinNo;
    }
}