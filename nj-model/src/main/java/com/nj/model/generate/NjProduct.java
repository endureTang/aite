package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjProduct {
    private String id;

    private String productName;

    private String productCode;

    /**
     * 资金产品编码
     */
    @ApiModelProperty(value = "资金产品编码")
    private String productCodeZj;

    private String productDescription;

    /**
     * 产品标签(多个标签逗号分隔)
     */
    @ApiModelProperty(value = "产品标签(多个标签逗号分隔)")
    private String productTags;

    /**
     * 是否支持自主进件(1:支持,0:不支持)
     */
    @ApiModelProperty(value = "是否支持自主进件(1:支持,0:不支持)")
    private Boolean isOwnInput;

    private String logoUrl;

    /**
     * 借款主体(1:个人,2:机构)
     */
    @ApiModelProperty(value = "借款主体(1:个人,2:机构)")
    private Byte loanSubject;

    /**
     * 担保方式(1:渠道担保,2:第三方担保,0:无)
     */
    @ApiModelProperty(value = "担保方式(1:渠道担保,2:第三方担保,0:无)")
    private Byte guaranteeType;

    /**
     * 担保公司
     */
    @ApiModelProperty(value = "担保公司")
    private String guaranteeValue;

    private Boolean isMortgage;

    private String payDeadLine;

    private Integer nonRecuFeeType;

    private BigDecimal nonRecuFee;

    private Integer feeType;

    private BigDecimal defaultFee;

    private BigDecimal minFee;

    private BigDecimal maxFee;

    private String repayWay;

    private Integer reckonModel;

    private Boolean isPrepaySup;

    private Integer prepayFeeType;

    private BigDecimal prepayRawFee;

    private Boolean isPenaltySup;

    private BigDecimal penaltyRawFee;

    private Integer penaltyType;

    private Boolean isUserCustomized;

    private Integer visiableScope;

    private Integer accountType;

    private Integer recmmandOrder;

    private Boolean isRecommand;

    private Integer state;

    private Integer displayOrder;

    private Boolean delFlag;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String openProductId;

    private String feeInfo;

    private String amountInfo;

    private String termInfo;

    private Integer productType;

    private String productThreechannelId;

    /**
     * 1：用户输入金额，2：系统指定金额，3：风险定价金额
     */
    @ApiModelProperty(value = "1：用户输入金额，2：系统指定金额，3：风险定价金额")
    private Short priceStrategy;

    /**
     * 逾期是否自动扣款（0：否，1：是）
     */
    @ApiModelProperty(value = "逾期是否自动扣款（0：否，1：是）")
    private Short isOverdueAutoDeduct;

    /**
     * 同盾风险报告有效期，单位天，默认30
     */
    @ApiModelProperty(value = "同盾风险报告有效期，单位天，默认30")
    private Integer tdReportValidDate;

    /**
     * 上报借款用途 ,该值存的是编号。
     */
    @ApiModelProperty(value = "上报借款用途 ,该值存的是编号。")
    private String wdUsageNo;

    /**
     * 上报借款类型，该值传输编号
     */
    @ApiModelProperty(value = "上报借款类型，该值传输编号")
    private String wdBorrowType;

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
     * @return product_name 
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 
     * @param productName 
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 
     * @return product_code 
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 
     * @param productCode 
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 资金产品编码
     * @return product_code_zj 资金产品编码
     */
    public String getProductCodeZj() {
        return productCodeZj;
    }

    /**
     * 资金产品编码
     * @param productCodeZj 资金产品编码
     */
    public void setProductCodeZj(String productCodeZj) {
        this.productCodeZj = productCodeZj;
    }

    /**
     * 
     * @return product_description 
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * 
     * @param productDescription 
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * 产品标签(多个标签逗号分隔)
     * @return product_tags 产品标签(多个标签逗号分隔)
     */
    public String getProductTags() {
        return productTags;
    }

    /**
     * 产品标签(多个标签逗号分隔)
     * @param productTags 产品标签(多个标签逗号分隔)
     */
    public void setProductTags(String productTags) {
        this.productTags = productTags;
    }

    /**
     * 是否支持自主进件(1:支持,0:不支持)
     * @return is_own_input 是否支持自主进件(1:支持,0:不支持)
     */
    public Boolean getIsOwnInput() {
        return isOwnInput;
    }

    /**
     * 是否支持自主进件(1:支持,0:不支持)
     * @param isOwnInput 是否支持自主进件(1:支持,0:不支持)
     */
    public void setIsOwnInput(Boolean isOwnInput) {
        this.isOwnInput = isOwnInput;
    }

    /**
     * 
     * @return logo_url 
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 
     * @param logoUrl 
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * 借款主体(1:个人,2:机构)
     * @return loan_subject 借款主体(1:个人,2:机构)
     */
    public Byte getLoanSubject() {
        return loanSubject;
    }

    /**
     * 借款主体(1:个人,2:机构)
     * @param loanSubject 借款主体(1:个人,2:机构)
     */
    public void setLoanSubject(Byte loanSubject) {
        this.loanSubject = loanSubject;
    }

    /**
     * 担保方式(1:渠道担保,2:第三方担保,0:无)
     * @return guarantee_type 担保方式(1:渠道担保,2:第三方担保,0:无)
     */
    public Byte getGuaranteeType() {
        return guaranteeType;
    }

    /**
     * 担保方式(1:渠道担保,2:第三方担保,0:无)
     * @param guaranteeType 担保方式(1:渠道担保,2:第三方担保,0:无)
     */
    public void setGuaranteeType(Byte guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    /**
     * 担保公司
     * @return guarantee_value 担保公司
     */
    public String getGuaranteeValue() {
        return guaranteeValue;
    }

    /**
     * 担保公司
     * @param guaranteeValue 担保公司
     */
    public void setGuaranteeValue(String guaranteeValue) {
        this.guaranteeValue = guaranteeValue;
    }

    /**
     * 
     * @return is_mortgage 
     */
    public Boolean getIsMortgage() {
        return isMortgage;
    }

    /**
     * 
     * @param isMortgage 
     */
    public void setIsMortgage(Boolean isMortgage) {
        this.isMortgage = isMortgage;
    }

    /**
     * 
     * @return pay_dead_line 
     */
    public String getPayDeadLine() {
        return payDeadLine;
    }

    /**
     * 
     * @param payDeadLine 
     */
    public void setPayDeadLine(String payDeadLine) {
        this.payDeadLine = payDeadLine;
    }

    /**
     * 
     * @return non_recu_fee_type 
     */
    public Integer getNonRecuFeeType() {
        return nonRecuFeeType;
    }

    /**
     * 
     * @param nonRecuFeeType 
     */
    public void setNonRecuFeeType(Integer nonRecuFeeType) {
        this.nonRecuFeeType = nonRecuFeeType;
    }

    /**
     * 
     * @return non_recu_fee 
     */
    public BigDecimal getNonRecuFee() {
        return nonRecuFee;
    }

    /**
     * 
     * @param nonRecuFee 
     */
    public void setNonRecuFee(BigDecimal nonRecuFee) {
        this.nonRecuFee = nonRecuFee;
    }

    /**
     * 
     * @return fee_type 
     */
    public Integer getFeeType() {
        return feeType;
    }

    /**
     * 
     * @param feeType 
     */
    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    /**
     * 
     * @return default_fee 
     */
    public BigDecimal getDefaultFee() {
        return defaultFee;
    }

    /**
     * 
     * @param defaultFee 
     */
    public void setDefaultFee(BigDecimal defaultFee) {
        this.defaultFee = defaultFee;
    }

    /**
     * 
     * @return min_fee 
     */
    public BigDecimal getMinFee() {
        return minFee;
    }

    /**
     * 
     * @param minFee 
     */
    public void setMinFee(BigDecimal minFee) {
        this.minFee = minFee;
    }

    /**
     * 
     * @return max_fee 
     */
    public BigDecimal getMaxFee() {
        return maxFee;
    }

    /**
     * 
     * @param maxFee 
     */
    public void setMaxFee(BigDecimal maxFee) {
        this.maxFee = maxFee;
    }

    /**
     * 
     * @return repay_way 
     */
    public String getRepayWay() {
        return repayWay;
    }

    /**
     * 
     * @param repayWay 
     */
    public void setRepayWay(String repayWay) {
        this.repayWay = repayWay;
    }

    /**
     * 
     * @return reckon_model 
     */
    public Integer getReckonModel() {
        return reckonModel;
    }

    /**
     * 
     * @param reckonModel 
     */
    public void setReckonModel(Integer reckonModel) {
        this.reckonModel = reckonModel;
    }

    /**
     * 
     * @return is_prepay_sup 
     */
    public Boolean getIsPrepaySup() {
        return isPrepaySup;
    }

    /**
     * 
     * @param isPrepaySup 
     */
    public void setIsPrepaySup(Boolean isPrepaySup) {
        this.isPrepaySup = isPrepaySup;
    }

    /**
     * 
     * @return prepay_fee_type 
     */
    public Integer getPrepayFeeType() {
        return prepayFeeType;
    }

    /**
     * 
     * @param prepayFeeType 
     */
    public void setPrepayFeeType(Integer prepayFeeType) {
        this.prepayFeeType = prepayFeeType;
    }

    /**
     * 
     * @return prepay_raw_fee 
     */
    public BigDecimal getPrepayRawFee() {
        return prepayRawFee;
    }

    /**
     * 
     * @param prepayRawFee 
     */
    public void setPrepayRawFee(BigDecimal prepayRawFee) {
        this.prepayRawFee = prepayRawFee;
    }

    /**
     * 
     * @return is_penalty_sup 
     */
    public Boolean getIsPenaltySup() {
        return isPenaltySup;
    }

    /**
     * 
     * @param isPenaltySup 
     */
    public void setIsPenaltySup(Boolean isPenaltySup) {
        this.isPenaltySup = isPenaltySup;
    }

    /**
     * 
     * @return penalty_raw_fee 
     */
    public BigDecimal getPenaltyRawFee() {
        return penaltyRawFee;
    }

    /**
     * 
     * @param penaltyRawFee 
     */
    public void setPenaltyRawFee(BigDecimal penaltyRawFee) {
        this.penaltyRawFee = penaltyRawFee;
    }

    /**
     * 
     * @return penalty_type 
     */
    public Integer getPenaltyType() {
        return penaltyType;
    }

    /**
     * 
     * @param penaltyType 
     */
    public void setPenaltyType(Integer penaltyType) {
        this.penaltyType = penaltyType;
    }

    /**
     * 
     * @return is_user_customized 
     */
    public Boolean getIsUserCustomized() {
        return isUserCustomized;
    }

    /**
     * 
     * @param isUserCustomized 
     */
    public void setIsUserCustomized(Boolean isUserCustomized) {
        this.isUserCustomized = isUserCustomized;
    }

    /**
     * 
     * @return visiable_scope 
     */
    public Integer getVisiableScope() {
        return visiableScope;
    }

    /**
     * 
     * @param visiableScope 
     */
    public void setVisiableScope(Integer visiableScope) {
        this.visiableScope = visiableScope;
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
     * @return recmmand_order 
     */
    public Integer getRecmmandOrder() {
        return recmmandOrder;
    }

    /**
     * 
     * @param recmmandOrder 
     */
    public void setRecmmandOrder(Integer recmmandOrder) {
        this.recmmandOrder = recmmandOrder;
    }

    /**
     * 
     * @return is_recommand 
     */
    public Boolean getIsRecommand() {
        return isRecommand;
    }

    /**
     * 
     * @param isRecommand 
     */
    public void setIsRecommand(Boolean isRecommand) {
        this.isRecommand = isRecommand;
    }

    /**
     * 
     * @return state 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @param state 
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 
     * @return display_order 
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * 
     * @param displayOrder 
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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

    /**
     * 
     * @return open_product_id 
     */
    public String getOpenProductId() {
        return openProductId;
    }

    /**
     * 
     * @param openProductId 
     */
    public void setOpenProductId(String openProductId) {
        this.openProductId = openProductId;
    }

    /**
     * 
     * @return fee_info 
     */
    public String getFeeInfo() {
        return feeInfo;
    }

    /**
     * 
     * @param feeInfo 
     */
    public void setFeeInfo(String feeInfo) {
        this.feeInfo = feeInfo;
    }

    /**
     * 
     * @return amount_info 
     */
    public String getAmountInfo() {
        return amountInfo;
    }

    /**
     * 
     * @param amountInfo 
     */
    public void setAmountInfo(String amountInfo) {
        this.amountInfo = amountInfo;
    }

    /**
     * 
     * @return term_info 
     */
    public String getTermInfo() {
        return termInfo;
    }

    /**
     * 
     * @param termInfo 
     */
    public void setTermInfo(String termInfo) {
        this.termInfo = termInfo;
    }

    /**
     * 
     * @return product_type 
     */
    public Integer getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType 
     */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return product_threechannel_id 
     */
    public String getProductThreechannelId() {
        return productThreechannelId;
    }

    /**
     * 
     * @param productThreechannelId 
     */
    public void setProductThreechannelId(String productThreechannelId) {
        this.productThreechannelId = productThreechannelId;
    }

    /**
     * 1：用户输入金额，2：系统指定金额，3：风险定价金额
     * @return price_strategy 1：用户输入金额，2：系统指定金额，3：风险定价金额
     */
    public Short getPriceStrategy() {
        return priceStrategy;
    }

    /**
     * 1：用户输入金额，2：系统指定金额，3：风险定价金额
     * @param priceStrategy 1：用户输入金额，2：系统指定金额，3：风险定价金额
     */
    public void setPriceStrategy(Short priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    /**
     * 逾期是否自动扣款（0：否，1：是）
     * @return is_overdue_auto_deduct 逾期是否自动扣款（0：否，1：是）
     */
    public Short getIsOverdueAutoDeduct() {
        return isOverdueAutoDeduct;
    }

    /**
     * 逾期是否自动扣款（0：否，1：是）
     * @param isOverdueAutoDeduct 逾期是否自动扣款（0：否，1：是）
     */
    public void setIsOverdueAutoDeduct(Short isOverdueAutoDeduct) {
        this.isOverdueAutoDeduct = isOverdueAutoDeduct;
    }

    /**
     * 同盾风险报告有效期，单位天，默认30
     * @return td_report_valid_date 同盾风险报告有效期，单位天，默认30
     */
    public Integer getTdReportValidDate() {
        return tdReportValidDate;
    }

    /**
     * 同盾风险报告有效期，单位天，默认30
     * @param tdReportValidDate 同盾风险报告有效期，单位天，默认30
     */
    public void setTdReportValidDate(Integer tdReportValidDate) {
        this.tdReportValidDate = tdReportValidDate;
    }

    /**
     * 上报借款用途 ,该值存的是编号。
     * @return wd_usage_no 上报借款用途 ,该值存的是编号。
     */
    public String getWdUsageNo() {
        return wdUsageNo;
    }

    /**
     * 上报借款用途 ,该值存的是编号。
     * @param wdUsageNo 上报借款用途 ,该值存的是编号。
     */
    public void setWdUsageNo(String wdUsageNo) {
        this.wdUsageNo = wdUsageNo;
    }

    /**
     * 上报借款类型，该值传输编号
     * @return wd_borrow_type 上报借款类型，该值传输编号
     */
    public String getWdBorrowType() {
        return wdBorrowType;
    }

    /**
     * 上报借款类型，该值传输编号
     * @param wdBorrowType 上报借款类型，该值传输编号
     */
    public void setWdBorrowType(String wdBorrowType) {
        this.wdBorrowType = wdBorrowType;
    }
}