package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjLoanOrder {
    private String id;

    private String orderNo;

    private String userId;

    private BigDecimal amount;

    private Integer period;

    private BigDecimal auditAmount;

    private Integer auditPeriod;

    private String remarks;

    private String usageId;

    private String usageDesc;

    private Integer status;

    /**
     * nj_product_channel的id
     */
    @ApiModelProperty(value = "nj_product_channel的id")
    private String channelId;

    private String relativeChanId;

    private String agentId;

    private String productId;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    private Boolean delFlag;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String auditRating;

    private String auditServiceRating;

    /**
     * 首次服务费率（年华）
     */
    @ApiModelProperty(value = "首次服务费率（年华）")
    private String chargeFeeRate;

    /**
     * 每期服务费
     */
    @ApiModelProperty(value = "每期服务费")
    private String feeValue;

    /**
     * 每期服务费率
     */
    @ApiModelProperty(value = "每期服务费率")
    private String feeRate;

    private String lendMethod;

    private String geAgcyAdvice;

    private String fundsUse;

    private String enterpriseCase;

    private String projectContent;

    private String repayWay;

    private Integer cfstatus;

    /**
     * 回调地址
     */
    @ApiModelProperty(value = "回调地址")
    private String callbackUrl;

    /**
     * 第三方订单编号
     */
    @ApiModelProperty(value = "第三方订单编号")
    private String sourceOrderNo;

    private String relendMethod;

    private String auditSxf;

    private Integer auditSxfType;

    private String auditBond;

    private Integer auditBondType;

    private String auditRemarks;

    private String blockedFunds;

    private String contractAttrId;

    /**
     * 天府财富项目编号
     */
    @ApiModelProperty(value = "天府财富项目编号")
    private String tfcfProjectNo;

    /**
     * 放款时间
     */
    @ApiModelProperty(value = "放款时间")
    private Date makeLoansDate;

    /**
     * 风险等级
     */
    @ApiModelProperty(value = "风险等级")
    private String riskGrade;

    /**
     * 贷后核查状态(0:正常，1:异常)
     */
    @ApiModelProperty(value = "贷后核查状态(0:正常，1:异常)")
    private Byte afterStatus;

    /**
     * 资产等级
     */
    @ApiModelProperty(value = "资产等级")
    private String assetGrade;

    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private String companyId;

    /**
     * 是否归档（0：未归档，1：已归档）
     */
    @ApiModelProperty(value = "是否归档（0：未归档，1：已归档）")
    private Integer isArchive;

    private String togetherLoanUserid;

    private String transactionNo;

    /**
     * 固定投资人利率
     */
    @ApiModelProperty(value = "固定投资人利率")
    private String fixRate;

    /**
     * 资产编号（自动生成，资产推送到资金端，用于资金端展示）
     */
    @ApiModelProperty(value = "资产编号（自动生成，资产推送到资金端，用于资金端展示）")
    private String assetsCode;

    /**
     * 扣款回调URL
     */
    @ApiModelProperty(value = "扣款回调URL")
    private String diductionCallbackUrl;

    /**
     * 项目总金额，该值主要是指消费金融场景，产品的总价值，例如医美分期，整形的总费用。
     */
    @ApiModelProperty(value = "项目总金额，该值主要是指消费金融场景，产品的总价值，例如医美分期，整形的总费用。")
    private BigDecimal projectAmount;

    /**
     * 首付款
     */
    @ApiModelProperty(value = "首付款")
    private BigDecimal firstAmount;

    /**
     * 居间费
     */
    @ApiModelProperty(value = "居间费")
    private BigDecimal middleAmount;

    /**
     * 小贷公司实际放款金额
     */
    @ApiModelProperty(value = "小贷公司实际放款金额")
    private BigDecimal actualAmount;

    /**
     * 小贷公司放款是否完成
     */
    @ApiModelProperty(value = "小贷公司放款是否完成")
    private Boolean isCompanyPayed;

    /**
     * 资金渠道放款是否已完成
     */
    @ApiModelProperty(value = "资金渠道放款是否已完成")
    private Boolean isCapitalChannelPayed;

    /**
     * 综合利率
     */
    @ApiModelProperty(value = "综合利率")
    private String totalRating;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 合同利率
     */
    @ApiModelProperty(value = "合同利率")
    private String contractRate;

    /**
     * 同盾报告id
     */
    @ApiModelProperty(value = "同盾报告id")
    private String tdReportId;

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
     * @return order_no 
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 
     * @param orderNo 
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * @return amount 
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount 
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return period 
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 
     * @param period 
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 
     * @return audit_amount 
     */
    public BigDecimal getAuditAmount() {
        return auditAmount;
    }

    /**
     * 
     * @param auditAmount 
     */
    public void setAuditAmount(BigDecimal auditAmount) {
        this.auditAmount = auditAmount;
    }

    /**
     * 
     * @return audit_period 
     */
    public Integer getAuditPeriod() {
        return auditPeriod;
    }

    /**
     * 
     * @param auditPeriod 
     */
    public void setAuditPeriod(Integer auditPeriod) {
        this.auditPeriod = auditPeriod;
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
     * @return usage_id 
     */
    public String getUsageId() {
        return usageId;
    }

    /**
     * 
     * @param usageId 
     */
    public void setUsageId(String usageId) {
        this.usageId = usageId;
    }

    /**
     * 
     * @return usage_desc 
     */
    public String getUsageDesc() {
        return usageDesc;
    }

    /**
     * 
     * @param usageDesc 
     */
    public void setUsageDesc(String usageDesc) {
        this.usageDesc = usageDesc;
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * nj_product_channel的id
     * @return channel_id nj_product_channel的id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * nj_product_channel的id
     * @param channelId nj_product_channel的id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 
     * @return relative_chan_id 
     */
    public String getRelativeChanId() {
        return relativeChanId;
    }

    /**
     * 
     * @param relativeChanId 
     */
    public void setRelativeChanId(String relativeChanId) {
        this.relativeChanId = relativeChanId;
    }

    /**
     * 
     * @return agent_id 
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * 
     * @param agentId 
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * 
     * @return product_id 
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId 
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 产品名称
     * @return product_name 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
     * @return audit_rating 
     */
    public String getAuditRating() {
        return auditRating;
    }

    /**
     * 
     * @param auditRating 
     */
    public void setAuditRating(String auditRating) {
        this.auditRating = auditRating;
    }

    /**
     * 
     * @return audit_service_rating 
     */
    public String getAuditServiceRating() {
        return auditServiceRating;
    }

    /**
     * 
     * @param auditServiceRating 
     */
    public void setAuditServiceRating(String auditServiceRating) {
        this.auditServiceRating = auditServiceRating;
    }

    /**
     * 首次服务费率（年华）
     * @return charge_fee_rate 首次服务费率（年华）
     */
    public String getChargeFeeRate() {
        return chargeFeeRate;
    }

    /**
     * 首次服务费率（年华）
     * @param chargeFeeRate 首次服务费率（年华）
     */
    public void setChargeFeeRate(String chargeFeeRate) {
        this.chargeFeeRate = chargeFeeRate;
    }

    /**
     * 每期服务费
     * @return fee_value 每期服务费
     */
    public String getFeeValue() {
        return feeValue;
    }

    /**
     * 每期服务费
     * @param feeValue 每期服务费
     */
    public void setFeeValue(String feeValue) {
        this.feeValue = feeValue;
    }

    /**
     * 每期服务费率
     * @return fee_rate 每期服务费率
     */
    public String getFeeRate() {
        return feeRate;
    }

    /**
     * 每期服务费率
     * @param feeRate 每期服务费率
     */
    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }

    /**
     * 
     * @return lend_method 
     */
    public String getLendMethod() {
        return lendMethod;
    }

    /**
     * 
     * @param lendMethod 
     */
    public void setLendMethod(String lendMethod) {
        this.lendMethod = lendMethod;
    }

    /**
     * 
     * @return ge_agcy_advice 
     */
    public String getGeAgcyAdvice() {
        return geAgcyAdvice;
    }

    /**
     * 
     * @param geAgcyAdvice 
     */
    public void setGeAgcyAdvice(String geAgcyAdvice) {
        this.geAgcyAdvice = geAgcyAdvice;
    }

    /**
     * 
     * @return funds_use 
     */
    public String getFundsUse() {
        return fundsUse;
    }

    /**
     * 
     * @param fundsUse 
     */
    public void setFundsUse(String fundsUse) {
        this.fundsUse = fundsUse;
    }

    /**
     * 
     * @return enterprise_case 
     */
    public String getEnterpriseCase() {
        return enterpriseCase;
    }

    /**
     * 
     * @param enterpriseCase 
     */
    public void setEnterpriseCase(String enterpriseCase) {
        this.enterpriseCase = enterpriseCase;
    }

    /**
     * 
     * @return project_content 
     */
    public String getProjectContent() {
        return projectContent;
    }

    /**
     * 
     * @param projectContent 
     */
    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
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
     * @return cfstatus 
     */
    public Integer getCfstatus() {
        return cfstatus;
    }

    /**
     * 
     * @param cfstatus 
     */
    public void setCfstatus(Integer cfstatus) {
        this.cfstatus = cfstatus;
    }

    /**
     * 回调地址
     * @return callback_url 回调地址
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * 回调地址
     * @param callbackUrl 回调地址
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * 第三方订单编号
     * @return source_order_no 第三方订单编号
     */
    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    /**
     * 第三方订单编号
     * @param sourceOrderNo 第三方订单编号
     */
    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    /**
     * 
     * @return relend_method 
     */
    public String getRelendMethod() {
        return relendMethod;
    }

    /**
     * 
     * @param relendMethod 
     */
    public void setRelendMethod(String relendMethod) {
        this.relendMethod = relendMethod;
    }

    /**
     * 
     * @return audit_sxf 
     */
    public String getAuditSxf() {
        return auditSxf;
    }

    /**
     * 
     * @param auditSxf 
     */
    public void setAuditSxf(String auditSxf) {
        this.auditSxf = auditSxf;
    }

    /**
     * 
     * @return audit_sxf_type 
     */
    public Integer getAuditSxfType() {
        return auditSxfType;
    }

    /**
     * 
     * @param auditSxfType 
     */
    public void setAuditSxfType(Integer auditSxfType) {
        this.auditSxfType = auditSxfType;
    }

    /**
     * 
     * @return audit_bond 
     */
    public String getAuditBond() {
        return auditBond;
    }

    /**
     * 
     * @param auditBond 
     */
    public void setAuditBond(String auditBond) {
        this.auditBond = auditBond;
    }

    /**
     * 
     * @return audit_bond_type 
     */
    public Integer getAuditBondType() {
        return auditBondType;
    }

    /**
     * 
     * @param auditBondType 
     */
    public void setAuditBondType(Integer auditBondType) {
        this.auditBondType = auditBondType;
    }

    /**
     * 
     * @return audit_remarks 
     */
    public String getAuditRemarks() {
        return auditRemarks;
    }

    /**
     * 
     * @param auditRemarks 
     */
    public void setAuditRemarks(String auditRemarks) {
        this.auditRemarks = auditRemarks;
    }

    /**
     * 
     * @return blocked_funds 
     */
    public String getBlockedFunds() {
        return blockedFunds;
    }

    /**
     * 
     * @param blockedFunds 
     */
    public void setBlockedFunds(String blockedFunds) {
        this.blockedFunds = blockedFunds;
    }

    /**
     * 
     * @return contract_attr_id 
     */
    public String getContractAttrId() {
        return contractAttrId;
    }

    /**
     * 
     * @param contractAttrId 
     */
    public void setContractAttrId(String contractAttrId) {
        this.contractAttrId = contractAttrId;
    }

    /**
     * 天府财富项目编号
     * @return tfcf_project_no 天府财富项目编号
     */
    public String getTfcfProjectNo() {
        return tfcfProjectNo;
    }

    /**
     * 天府财富项目编号
     * @param tfcfProjectNo 天府财富项目编号
     */
    public void setTfcfProjectNo(String tfcfProjectNo) {
        this.tfcfProjectNo = tfcfProjectNo;
    }

    /**
     * 放款时间
     * @return make_loans_date 放款时间
     */
    public Date getMakeLoansDate() {
        return makeLoansDate;
    }

    /**
     * 放款时间
     * @param makeLoansDate 放款时间
     */
    public void setMakeLoansDate(Date makeLoansDate) {
        this.makeLoansDate = makeLoansDate;
    }

    /**
     * 风险等级
     * @return risk_grade 风险等级
     */
    public String getRiskGrade() {
        return riskGrade;
    }

    /**
     * 风险等级
     * @param riskGrade 风险等级
     */
    public void setRiskGrade(String riskGrade) {
        this.riskGrade = riskGrade;
    }

    /**
     * 贷后核查状态(0:正常，1:异常)
     * @return after_status 贷后核查状态(0:正常，1:异常)
     */
    public Byte getAfterStatus() {
        return afterStatus;
    }

    /**
     * 贷后核查状态(0:正常，1:异常)
     * @param afterStatus 贷后核查状态(0:正常，1:异常)
     */
    public void setAfterStatus(Byte afterStatus) {
        this.afterStatus = afterStatus;
    }

    /**
     * 资产等级
     * @return asset_grade 资产等级
     */
    public String getAssetGrade() {
        return assetGrade;
    }

    /**
     * 资产等级
     * @param assetGrade 资产等级
     */
    public void setAssetGrade(String assetGrade) {
        this.assetGrade = assetGrade;
    }

    /**
     * 企业id
     * @return company_id 企业id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 企业id
     * @param companyId 企业id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 是否归档（0：未归档，1：已归档）
     * @return is_archive 是否归档（0：未归档，1：已归档）
     */
    public Integer getIsArchive() {
        return isArchive;
    }

    /**
     * 是否归档（0：未归档，1：已归档）
     * @param isArchive 是否归档（0：未归档，1：已归档）
     */
    public void setIsArchive(Integer isArchive) {
        this.isArchive = isArchive;
    }

    /**
     * 
     * @return together_loan_userid 
     */
    public String getTogetherLoanUserid() {
        return togetherLoanUserid;
    }

    /**
     * 
     * @param togetherLoanUserid 
     */
    public void setTogetherLoanUserid(String togetherLoanUserid) {
        this.togetherLoanUserid = togetherLoanUserid;
    }

    /**
     * 
     * @return transaction_no 
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * 
     * @param transactionNo 
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    /**
     * 固定投资人利率
     * @return fix_rate 固定投资人利率
     */
    public String getFixRate() {
        return fixRate;
    }

    /**
     * 固定投资人利率
     * @param fixRate 固定投资人利率
     */
    public void setFixRate(String fixRate) {
        this.fixRate = fixRate;
    }

    /**
     * 资产编号（自动生成，资产推送到资金端，用于资金端展示）
     * @return assets_code 资产编号（自动生成，资产推送到资金端，用于资金端展示）
     */
    public String getAssetsCode() {
        return assetsCode;
    }

    /**
     * 资产编号（自动生成，资产推送到资金端，用于资金端展示）
     * @param assetsCode 资产编号（自动生成，资产推送到资金端，用于资金端展示）
     */
    public void setAssetsCode(String assetsCode) {
        this.assetsCode = assetsCode;
    }

    /**
     * 扣款回调URL
     * @return diduction_callback_url 扣款回调URL
     */
    public String getDiductionCallbackUrl() {
        return diductionCallbackUrl;
    }

    /**
     * 扣款回调URL
     * @param diductionCallbackUrl 扣款回调URL
     */
    public void setDiductionCallbackUrl(String diductionCallbackUrl) {
        this.diductionCallbackUrl = diductionCallbackUrl;
    }

    /**
     * 项目总金额，该值主要是指消费金融场景，产品的总价值，例如医美分期，整形的总费用。
     * @return project_amount 项目总金额，该值主要是指消费金融场景，产品的总价值，例如医美分期，整形的总费用。
     */
    public BigDecimal getProjectAmount() {
        return projectAmount;
    }

    /**
     * 项目总金额，该值主要是指消费金融场景，产品的总价值，例如医美分期，整形的总费用。
     * @param projectAmount 项目总金额，该值主要是指消费金融场景，产品的总价值，例如医美分期，整形的总费用。
     */
    public void setProjectAmount(BigDecimal projectAmount) {
        this.projectAmount = projectAmount;
    }

    /**
     * 首付款
     * @return first_amount 首付款
     */
    public BigDecimal getFirstAmount() {
        return firstAmount;
    }

    /**
     * 首付款
     * @param firstAmount 首付款
     */
    public void setFirstAmount(BigDecimal firstAmount) {
        this.firstAmount = firstAmount;
    }

    /**
     * 居间费
     * @return middle_amount 居间费
     */
    public BigDecimal getMiddleAmount() {
        return middleAmount;
    }

    /**
     * 居间费
     * @param middleAmount 居间费
     */
    public void setMiddleAmount(BigDecimal middleAmount) {
        this.middleAmount = middleAmount;
    }

    /**
     * 小贷公司实际放款金额
     * @return actual_amount 小贷公司实际放款金额
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * 小贷公司实际放款金额
     * @param actualAmount 小贷公司实际放款金额
     */
    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 小贷公司放款是否完成
     * @return is_company_payed 小贷公司放款是否完成
     */
    public Boolean getIsCompanyPayed() {
        return isCompanyPayed;
    }

    /**
     * 小贷公司放款是否完成
     * @param isCompanyPayed 小贷公司放款是否完成
     */
    public void setIsCompanyPayed(Boolean isCompanyPayed) {
        this.isCompanyPayed = isCompanyPayed;
    }

    /**
     * 资金渠道放款是否已完成
     * @return is_capital_channel_payed 资金渠道放款是否已完成
     */
    public Boolean getIsCapitalChannelPayed() {
        return isCapitalChannelPayed;
    }

    /**
     * 资金渠道放款是否已完成
     * @param isCapitalChannelPayed 资金渠道放款是否已完成
     */
    public void setIsCapitalChannelPayed(Boolean isCapitalChannelPayed) {
        this.isCapitalChannelPayed = isCapitalChannelPayed;
    }

    /**
     * 综合利率
     * @return total_rating 综合利率
     */
    public String getTotalRating() {
        return totalRating;
    }

    /**
     * 综合利率
     * @param totalRating 综合利率
     */
    public void setTotalRating(String totalRating) {
        this.totalRating = totalRating;
    }

    /**
     * 项目名称
     * @return project_name 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 合同利率
     * @return contract_rate 合同利率
     */
    public String getContractRate() {
        return contractRate;
    }

    /**
     * 合同利率
     * @param contractRate 合同利率
     */
    public void setContractRate(String contractRate) {
        this.contractRate = contractRate;
    }

    /**
     * 同盾报告id
     * @return td_report_id 同盾报告id
     */
    public String getTdReportId() {
        return tdReportId;
    }

    /**
     * 同盾报告id
     * @param tdReportId 同盾报告id
     */
    public void setTdReportId(String tdReportId) {
        this.tdReportId = tdReportId;
    }
}