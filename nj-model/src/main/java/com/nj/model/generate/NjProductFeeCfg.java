package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjProductFeeCfg {
    private String id;

    private String productId;

    /**
     * 配置对象。1：客户还款计划2：小贷公司回款计划
     */
    @ApiModelProperty(value = "配置对象。1：客户还款计划2：小贷公司回款计划")
    private Short cfgObj;

    /**
     * 费用code。对应枚举类EBusinessFee的code
     */
    @ApiModelProperty(value = "费用code。对应枚举类EBusinessFee的code")
    private String businessFeeCode;

    /**
     * 采用算法。对应枚举类EBusinessFeeAlgorithm的code，费用中，本金和利息没有算法，其他费用有算法
     */
    @ApiModelProperty(value = "采用算法。对应枚举类EBusinessFeeAlgorithm的code，费用中，本金和利息没有算法，其他费用有算法")
    private String algorithmCode;

    /**
     * 分摊顺序。部分还款时，还款金额按照分摊顺序进行分摊。目前没有部分还款，此字段为预留字段
     */
    @ApiModelProperty(value = "分摊顺序。部分还款时，还款金额按照分摊顺序进行分摊。目前没有部分还款，此字段为预留字段")
    private Short shareIndex;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

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
     * 配置对象。1：客户还款计划2：小贷公司回款计划
     * @return cfg_obj 配置对象。1：客户还款计划2：小贷公司回款计划
     */
    public Short getCfgObj() {
        return cfgObj;
    }

    /**
     * 配置对象。1：客户还款计划2：小贷公司回款计划
     * @param cfgObj 配置对象。1：客户还款计划2：小贷公司回款计划
     */
    public void setCfgObj(Short cfgObj) {
        this.cfgObj = cfgObj;
    }

    /**
     * 费用code。对应枚举类EBusinessFee的code
     * @return business_fee_code 费用code。对应枚举类EBusinessFee的code
     */
    public String getBusinessFeeCode() {
        return businessFeeCode;
    }

    /**
     * 费用code。对应枚举类EBusinessFee的code
     * @param businessFeeCode 费用code。对应枚举类EBusinessFee的code
     */
    public void setBusinessFeeCode(String businessFeeCode) {
        this.businessFeeCode = businessFeeCode;
    }

    /**
     * 采用算法。对应枚举类EBusinessFeeAlgorithm的code，费用中，本金和利息没有算法，其他费用有算法
     * @return algorithm_code 采用算法。对应枚举类EBusinessFeeAlgorithm的code，费用中，本金和利息没有算法，其他费用有算法
     */
    public String getAlgorithmCode() {
        return algorithmCode;
    }

    /**
     * 采用算法。对应枚举类EBusinessFeeAlgorithm的code，费用中，本金和利息没有算法，其他费用有算法
     * @param algorithmCode 采用算法。对应枚举类EBusinessFeeAlgorithm的code，费用中，本金和利息没有算法，其他费用有算法
     */
    public void setAlgorithmCode(String algorithmCode) {
        this.algorithmCode = algorithmCode;
    }

    /**
     * 分摊顺序。部分还款时，还款金额按照分摊顺序进行分摊。目前没有部分还款，此字段为预留字段
     * @return share_index 分摊顺序。部分还款时，还款金额按照分摊顺序进行分摊。目前没有部分还款，此字段为预留字段
     */
    public Short getShareIndex() {
        return shareIndex;
    }

    /**
     * 分摊顺序。部分还款时，还款金额按照分摊顺序进行分摊。目前没有部分还款，此字段为预留字段
     * @param shareIndex 分摊顺序。部分还款时，还款金额按照分摊顺序进行分摊。目前没有部分还款，此字段为预留字段
     */
    public void setShareIndex(Short shareIndex) {
        this.shareIndex = shareIndex;
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
}