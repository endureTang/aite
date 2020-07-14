package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjCoporate {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    private String companCode;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String companName;

    /**
     * 归属区域
     */
    @ApiModelProperty(value = "归属区域")
    private String areaId;

    /**
     * 区域编码
     */
    @ApiModelProperty(value = "区域编码")
    private String code;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private String busiLicenseNo;

    /**
     * 机构类型
     */
    @ApiModelProperty(value = "机构类型")
    private String taxNo;

    /**
     * 联系地址
     */
    @ApiModelProperty(value = "联系地址")
    private String address;

    private String bankNo;

    private Integer accountType;

    private String smsCode;

    /**
     * 邮政编码
     */
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;

    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String master;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 传真
     */
    @ApiModelProperty(value = "传真")
    private String fax;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private String status;

    /**
     * 主负责人
     */
    @ApiModelProperty(value = "主负责人")
    private String primaryPerson;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private Boolean delFlag;

    private String orgCode;

    /**
     * 最大授信额度
     */
    @ApiModelProperty(value = "最大授信额度")
    private Double maxCreditLimit;

    /**
     * 支付渠道(1:金鼎支付; 2:兴业存管)
     */
    @ApiModelProperty(value = "支付渠道(1:金鼎支付; 2:兴业存管)")
    private Integer payChannel;

    /**
     * 资产推送渠道(1:小贷资金;2:p2p募集资金)
     */
    @ApiModelProperty(value = "资产推送渠道(1:小贷资金;2:p2p募集资金)")
    private Integer capitalEndChannel;

    /**
     * 编号
     * @return id 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return compan_code 
     */
    public String getCompanCode() {
        return companCode;
    }

    /**
     * 
     * @param companCode 
     */
    public void setCompanCode(String companCode) {
        this.companCode = companCode;
    }

    /**
     * 名称
     * @return compan_name 名称
     */
    public String getCompanName() {
        return companName;
    }

    /**
     * 名称
     * @param companName 名称
     */
    public void setCompanName(String companName) {
        this.companName = companName;
    }

    /**
     * 归属区域
     * @return area_id 归属区域
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 归属区域
     * @param areaId 归属区域
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 区域编码
     * @return code 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 区域编码
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 排序
     * @return busi_license_no 排序
     */
    public String getBusiLicenseNo() {
        return busiLicenseNo;
    }

    /**
     * 排序
     * @param busiLicenseNo 排序
     */
    public void setBusiLicenseNo(String busiLicenseNo) {
        this.busiLicenseNo = busiLicenseNo;
    }

    /**
     * 机构类型
     * @return tax_no 机构类型
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * 机构类型
     * @param taxNo 机构类型
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    /**
     * 联系地址
     * @return address 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return bank_no 
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 
     * @param bankNo 
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    /**
     * 
     * @return account_type 
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 
     * @param accountType 
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 
     * @return sms_code 
     */
    public String getSmsCode() {
        return smsCode;
    }

    /**
     * 
     * @param smsCode 
     */
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    /**
     * 邮政编码
     * @return zip_code 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 邮政编码
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 负责人
     * @return master 负责人
     */
    public String getMaster() {
        return master;
    }

    /**
     * 负责人
     * @param master 负责人
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 电话
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 传真
     * @return fax 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 传真
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 是否启用
     * @return status 是否启用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 是否启用
     * @param status 是否启用
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 主负责人
     * @return primary_person 主负责人
     */
    public String getPrimaryPerson() {
        return primaryPerson;
    }

    /**
     * 主负责人
     * @param primaryPerson 主负责人
     */
    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    /**
     * 创建者
     * @return create_by 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 更新者
     * @return update_by 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     * @return update_date 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 备注信息
     * @return remarks 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 删除标记
     * @return del_flag 删除标记
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记
     * @param delFlag 删除标记
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 
     * @return org_code 
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 
     * @param orgCode 
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * 最大授信额度
     * @return max_credit_limit 最大授信额度
     */
    public Double getMaxCreditLimit() {
        return maxCreditLimit;
    }

    /**
     * 最大授信额度
     * @param maxCreditLimit 最大授信额度
     */
    public void setMaxCreditLimit(Double maxCreditLimit) {
        this.maxCreditLimit = maxCreditLimit;
    }

    /**
     * 支付渠道(1:金鼎支付; 2:兴业存管)
     * @return pay_channel 支付渠道(1:金鼎支付; 2:兴业存管)
     */
    public Integer getPayChannel() {
        return payChannel;
    }

    /**
     * 支付渠道(1:金鼎支付; 2:兴业存管)
     * @param payChannel 支付渠道(1:金鼎支付; 2:兴业存管)
     */
    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    /**
     * 资产推送渠道(1:小贷资金;2:p2p募集资金)
     * @return capital_end_channel 资产推送渠道(1:小贷资金;2:p2p募集资金)
     */
    public Integer getCapitalEndChannel() {
        return capitalEndChannel;
    }

    /**
     * 资产推送渠道(1:小贷资金;2:p2p募集资金)
     * @param capitalEndChannel 资产推送渠道(1:小贷资金;2:p2p募集资金)
     */
    public void setCapitalEndChannel(Integer capitalEndChannel) {
        this.capitalEndChannel = capitalEndChannel;
    }
}