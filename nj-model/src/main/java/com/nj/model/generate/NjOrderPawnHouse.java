package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjOrderPawnHouse {
    private String id;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private String orderId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 小区名称
     */
    @ApiModelProperty(value = "小区名称")
    private String houseName;

    /**
     * 省：该字段存储的是省的编码
     */
    @ApiModelProperty(value = "省：该字段存储的是省的编码")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 县/区
     */
    @ApiModelProperty(value = "县/区")
    private String county;

    private String address;

    /**
     * 所有权人
     */
    @ApiModelProperty(value = "所有权人")
    private String owner;

    /**
     * 权证号
     */
    @ApiModelProperty(value = "权证号")
    private String warrantNo;

    /**
     * 建筑面积
     */
    @ApiModelProperty(value = "建筑面积")
    private BigDecimal coveredArea;

    /**
     * 登记日期
     */
    @ApiModelProperty(value = "登记日期")
    private Date recordDate;

    /**
     * 房龄
     */
    @ApiModelProperty(value = "房龄")
    private Integer houseAge;

    /**
     * 装修情况： 0精装 1简装 2清水 3其它
     */
    @ApiModelProperty(value = "装修情况： 0精装 1简装 2清水 3其它")
    private String fitmentStatus;

    /**
     * 是否唯一住房  0 否1是
     */
    @ApiModelProperty(value = "是否唯一住房  0 否1是")
    private Boolean isOnly;

    /**
     * 网站一名称
     */
    @ApiModelProperty(value = "网站一名称")
    private String webOneName;

    /**
     * 网站一价格，单位万
     */
    @ApiModelProperty(value = "网站一价格，单位万")
    private BigDecimal webOnePrice;

    /**
     * 网站二名称
     */
    @ApiModelProperty(value = "网站二名称")
    private String webTwoName;

    /**
     * 网站二价格，单位万
     */
    @ApiModelProperty(value = "网站二价格，单位万")
    private BigDecimal webTwoPrice;

    /**
     * 网站三名称
     */
    @ApiModelProperty(value = "网站三名称")
    private String webThreeName;

    /**
     * 网站三价格，单位万
     */
    @ApiModelProperty(value = "网站三价格，单位万")
    private BigDecimal webThreePrice;

    /**
     * 评估公司
     */
    @ApiModelProperty(value = "评估公司")
    private String companyName;

    /**
     * 评估价格
     */
    @ApiModelProperty(value = "评估价格")
    private BigDecimal companyPrice;

    /**
     * 认定价格
     */
    @ApiModelProperty(value = "认定价格")
    private BigDecimal cognizancePrice;

    /**
     * 抵押层数
     */
    @ApiModelProperty(value = "抵押层数")
    private Byte mortgageNo;

    /**
     * 房贷余额
     */
    @ApiModelProperty(value = "房贷余额")
    private BigDecimal loanBalance;

    /**
     * 可贷额度
     */
    @ApiModelProperty(value = "可贷额度")
    private BigDecimal loanQuta;

    /**
     * 市场价格，该值是用户输入
     */
    @ApiModelProperty(value = "市场价格，该值是用户输入")
    private BigDecimal marketMoney;

    /**
     * 贷款金额
     */
    @ApiModelProperty(value = "贷款金额")
    private BigDecimal loanMoney;

    /**
     * 贷款期限
     */
    @ApiModelProperty(value = "贷款期限")
    private Byte loanTerm;

    /**
     * 是否删除 0 否1 是
     */
    @ApiModelProperty(value = "是否删除 0 否1 是")
    private Boolean isDel;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;

    private Integer version;

    private String pawnStatus;

    private String pawnBank;

    /**
     * 网站一图片
     */
    @ApiModelProperty(value = "网站一图片")
    private String picFileOne;

    /**
     * 网站二图片
     */
    @ApiModelProperty(value = "网站二图片")
    private String picFileTwo;

    /**
     * 网站三图片
     */
    @ApiModelProperty(value = "网站三图片")
    private String picFileThree;

    /**
     * 评估公司图片
     */
    @ApiModelProperty(value = "评估公司图片")
    private String picFileFour;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

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
     * 订单ID
     * @return order_id 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单ID
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 小区名称
     * @return house_name 小区名称
     */
    public String getHouseName() {
        return houseName;
    }

    /**
     * 小区名称
     * @param houseName 小区名称
     */
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    /**
     * 省：该字段存储的是省的编码
     * @return province 省：该字段存储的是省的编码
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省：该字段存储的是省的编码
     * @param province 省：该字段存储的是省的编码
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 县/区
     * @return county 县/区
     */
    public String getCounty() {
        return county;
    }

    /**
     * 县/区
     * @param county 县/区
     */
    public void setCounty(String county) {
        this.county = county;
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
     * 所有权人
     * @return owner 所有权人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 所有权人
     * @param owner 所有权人
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 权证号
     * @return warrant_no 权证号
     */
    public String getWarrantNo() {
        return warrantNo;
    }

    /**
     * 权证号
     * @param warrantNo 权证号
     */
    public void setWarrantNo(String warrantNo) {
        this.warrantNo = warrantNo;
    }

    /**
     * 建筑面积
     * @return covered_area 建筑面积
     */
    public BigDecimal getCoveredArea() {
        return coveredArea;
    }

    /**
     * 建筑面积
     * @param coveredArea 建筑面积
     */
    public void setCoveredArea(BigDecimal coveredArea) {
        this.coveredArea = coveredArea;
    }

    /**
     * 登记日期
     * @return record_date 登记日期
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * 登记日期
     * @param recordDate 登记日期
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * 房龄
     * @return house_age 房龄
     */
    public Integer getHouseAge() {
        return houseAge;
    }

    /**
     * 房龄
     * @param houseAge 房龄
     */
    public void setHouseAge(Integer houseAge) {
        this.houseAge = houseAge;
    }

    /**
     * 装修情况： 0精装 1简装 2清水 3其它
     * @return fitment_status 装修情况： 0精装 1简装 2清水 3其它
     */
    public String getFitmentStatus() {
        return fitmentStatus;
    }

    /**
     * 装修情况： 0精装 1简装 2清水 3其它
     * @param fitmentStatus 装修情况： 0精装 1简装 2清水 3其它
     */
    public void setFitmentStatus(String fitmentStatus) {
        this.fitmentStatus = fitmentStatus;
    }

    /**
     * 是否唯一住房  0 否1是
     * @return is_only 是否唯一住房  0 否1是
     */
    public Boolean getIsOnly() {
        return isOnly;
    }

    /**
     * 是否唯一住房  0 否1是
     * @param isOnly 是否唯一住房  0 否1是
     */
    public void setIsOnly(Boolean isOnly) {
        this.isOnly = isOnly;
    }

    /**
     * 网站一名称
     * @return web_one_name 网站一名称
     */
    public String getWebOneName() {
        return webOneName;
    }

    /**
     * 网站一名称
     * @param webOneName 网站一名称
     */
    public void setWebOneName(String webOneName) {
        this.webOneName = webOneName;
    }

    /**
     * 网站一价格，单位万
     * @return web_one_price 网站一价格，单位万
     */
    public BigDecimal getWebOnePrice() {
        return webOnePrice;
    }

    /**
     * 网站一价格，单位万
     * @param webOnePrice 网站一价格，单位万
     */
    public void setWebOnePrice(BigDecimal webOnePrice) {
        this.webOnePrice = webOnePrice;
    }

    /**
     * 网站二名称
     * @return web_two_name 网站二名称
     */
    public String getWebTwoName() {
        return webTwoName;
    }

    /**
     * 网站二名称
     * @param webTwoName 网站二名称
     */
    public void setWebTwoName(String webTwoName) {
        this.webTwoName = webTwoName;
    }

    /**
     * 网站二价格，单位万
     * @return web_two_price 网站二价格，单位万
     */
    public BigDecimal getWebTwoPrice() {
        return webTwoPrice;
    }

    /**
     * 网站二价格，单位万
     * @param webTwoPrice 网站二价格，单位万
     */
    public void setWebTwoPrice(BigDecimal webTwoPrice) {
        this.webTwoPrice = webTwoPrice;
    }

    /**
     * 网站三名称
     * @return web_three_name 网站三名称
     */
    public String getWebThreeName() {
        return webThreeName;
    }

    /**
     * 网站三名称
     * @param webThreeName 网站三名称
     */
    public void setWebThreeName(String webThreeName) {
        this.webThreeName = webThreeName;
    }

    /**
     * 网站三价格，单位万
     * @return web_three_price 网站三价格，单位万
     */
    public BigDecimal getWebThreePrice() {
        return webThreePrice;
    }

    /**
     * 网站三价格，单位万
     * @param webThreePrice 网站三价格，单位万
     */
    public void setWebThreePrice(BigDecimal webThreePrice) {
        this.webThreePrice = webThreePrice;
    }

    /**
     * 评估公司
     * @return company_name 评估公司
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 评估公司
     * @param companyName 评估公司
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 评估价格
     * @return company_price 评估价格
     */
    public BigDecimal getCompanyPrice() {
        return companyPrice;
    }

    /**
     * 评估价格
     * @param companyPrice 评估价格
     */
    public void setCompanyPrice(BigDecimal companyPrice) {
        this.companyPrice = companyPrice;
    }

    /**
     * 认定价格
     * @return cognizance_price 认定价格
     */
    public BigDecimal getCognizancePrice() {
        return cognizancePrice;
    }

    /**
     * 认定价格
     * @param cognizancePrice 认定价格
     */
    public void setCognizancePrice(BigDecimal cognizancePrice) {
        this.cognizancePrice = cognizancePrice;
    }

    /**
     * 抵押层数
     * @return mortgage_no 抵押层数
     */
    public Byte getMortgageNo() {
        return mortgageNo;
    }

    /**
     * 抵押层数
     * @param mortgageNo 抵押层数
     */
    public void setMortgageNo(Byte mortgageNo) {
        this.mortgageNo = mortgageNo;
    }

    /**
     * 房贷余额
     * @return loan_balance 房贷余额
     */
    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    /**
     * 房贷余额
     * @param loanBalance 房贷余额
     */
    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    /**
     * 可贷额度
     * @return loan_quta 可贷额度
     */
    public BigDecimal getLoanQuta() {
        return loanQuta;
    }

    /**
     * 可贷额度
     * @param loanQuta 可贷额度
     */
    public void setLoanQuta(BigDecimal loanQuta) {
        this.loanQuta = loanQuta;
    }

    /**
     * 市场价格，该值是用户输入
     * @return market_money 市场价格，该值是用户输入
     */
    public BigDecimal getMarketMoney() {
        return marketMoney;
    }

    /**
     * 市场价格，该值是用户输入
     * @param marketMoney 市场价格，该值是用户输入
     */
    public void setMarketMoney(BigDecimal marketMoney) {
        this.marketMoney = marketMoney;
    }

    /**
     * 贷款金额
     * @return loan_money 贷款金额
     */
    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    /**
     * 贷款金额
     * @param loanMoney 贷款金额
     */
    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    /**
     * 贷款期限
     * @return loan_term 贷款期限
     */
    public Byte getLoanTerm() {
        return loanTerm;
    }

    /**
     * 贷款期限
     * @param loanTerm 贷款期限
     */
    public void setLoanTerm(Byte loanTerm) {
        this.loanTerm = loanTerm;
    }

    /**
     * 是否删除 0 否1 是
     * @return is_del 是否删除 0 否1 是
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 是否删除 0 否1 是
     * @param isDel 是否删除 0 否1 是
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     * @return create_by 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 更新人
     * @return update_by 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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
     * @return pawn_status 
     */
    public String getPawnStatus() {
        return pawnStatus;
    }

    /**
     * 
     * @param pawnStatus 
     */
    public void setPawnStatus(String pawnStatus) {
        this.pawnStatus = pawnStatus;
    }

    /**
     * 
     * @return pawn_bank 
     */
    public String getPawnBank() {
        return pawnBank;
    }

    /**
     * 
     * @param pawnBank 
     */
    public void setPawnBank(String pawnBank) {
        this.pawnBank = pawnBank;
    }

    /**
     * 网站一图片
     * @return pic_file_one 网站一图片
     */
    public String getPicFileOne() {
        return picFileOne;
    }

    /**
     * 网站一图片
     * @param picFileOne 网站一图片
     */
    public void setPicFileOne(String picFileOne) {
        this.picFileOne = picFileOne;
    }

    /**
     * 网站二图片
     * @return pic_file_two 网站二图片
     */
    public String getPicFileTwo() {
        return picFileTwo;
    }

    /**
     * 网站二图片
     * @param picFileTwo 网站二图片
     */
    public void setPicFileTwo(String picFileTwo) {
        this.picFileTwo = picFileTwo;
    }

    /**
     * 网站三图片
     * @return pic_file_three 网站三图片
     */
    public String getPicFileThree() {
        return picFileThree;
    }

    /**
     * 网站三图片
     * @param picFileThree 网站三图片
     */
    public void setPicFileThree(String picFileThree) {
        this.picFileThree = picFileThree;
    }

    /**
     * 评估公司图片
     * @return pic_file_four 评估公司图片
     */
    public String getPicFileFour() {
        return picFileFour;
    }

    /**
     * 评估公司图片
     * @param picFileFour 评估公司图片
     */
    public void setPicFileFour(String picFileFour) {
        this.picFileFour = picFileFour;
    }

    /**
     * 备注
     * @return remarks 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}