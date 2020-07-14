package com.nj.model.generate;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class NjStatisticsOrder {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private String companyId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String companyName;

    /**
     * 进件数量
     */
    @ApiModelProperty(value = "进件数量")
    private String orderNum;

    /**
     * 进件金额
     */
    @ApiModelProperty(value = "进件金额")
    private BigDecimal orderAmount;

    /**
     * 通过审批数量
     */
    @ApiModelProperty(value = "通过审批数量")
    private String passNum;

    /**
     * 通过审批金额
     */
    @ApiModelProperty(value = "通过审批金额")
    private BigDecimal passAmount;

    /**
     * 放款数量
     */
    @ApiModelProperty(value = "放款数量")
    private String loanNum;

    /**
     * 放款金额
     */
    @ApiModelProperty(value = "放款金额")
    private BigDecimal loanAmount;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private String productId;

    /**
     * 拒件数
     */
    @ApiModelProperty(value = "拒件数")
    private String refuseNum;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private String time;

    /**
     * 平均撮合时效
     */
    @ApiModelProperty(value = "平均撮合时效")
    private Double avgMatchHourse;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
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
     * 企业名称
     * @return company_name 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 企业名称
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 进件数量
     * @return order_num 进件数量
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 进件数量
     * @param orderNum 进件数量
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 进件金额
     * @return order_amount 进件金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 进件金额
     * @param orderAmount 进件金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 通过审批数量
     * @return pass_num 通过审批数量
     */
    public String getPassNum() {
        return passNum;
    }

    /**
     * 通过审批数量
     * @param passNum 通过审批数量
     */
    public void setPassNum(String passNum) {
        this.passNum = passNum;
    }

    /**
     * 通过审批金额
     * @return pass_amount 通过审批金额
     */
    public BigDecimal getPassAmount() {
        return passAmount;
    }

    /**
     * 通过审批金额
     * @param passAmount 通过审批金额
     */
    public void setPassAmount(BigDecimal passAmount) {
        this.passAmount = passAmount;
    }

    /**
     * 放款数量
     * @return loan_num 放款数量
     */
    public String getLoanNum() {
        return loanNum;
    }

    /**
     * 放款数量
     * @param loanNum 放款数量
     */
    public void setLoanNum(String loanNum) {
        this.loanNum = loanNum;
    }

    /**
     * 放款金额
     * @return loan_amount 放款金额
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * 放款金额
     * @param loanAmount 放款金额
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
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
     * 产品id
     * @return product_id 产品id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品id
     * @param productId 产品id
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 拒件数
     * @return refuse_num 拒件数
     */
    public String getRefuseNum() {
        return refuseNum;
    }

    /**
     * 拒件数
     * @param refuseNum 拒件数
     */
    public void setRefuseNum(String refuseNum) {
        this.refuseNum = refuseNum;
    }

    /**
     * 时间
     * @return time 时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 时间
     * @param time 时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 平均撮合时效
     * @return avg_match_hourse 平均撮合时效
     */
    public Double getAvgMatchHourse() {
        return avgMatchHourse;
    }

    /**
     * 平均撮合时效
     * @param avgMatchHourse 平均撮合时效
     */
    public void setAvgMatchHourse(Double avgMatchHourse) {
        this.avgMatchHourse = avgMatchHourse;
    }
}