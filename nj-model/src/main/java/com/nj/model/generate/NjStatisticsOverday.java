package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjStatisticsOverday {
    private String id;

    /**
     * 企业id
     */
    @ApiModelProperty(value = "企业id")
    private String companyId;

    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private String productId;

    /**
     * 统计日期
     */
    @ApiModelProperty(value = "统计日期")
    private Date date;

    /**
     * 累计逾期金额
     */
    @ApiModelProperty(value = "累计逾期金额")
    private BigDecimal totalAmount;

    /**
     * M1的人数
     */
    @ApiModelProperty(value = "M1的人数")
    private Integer m1PersonNum;

    /**
     * M1的逾期总金额
     */
    @ApiModelProperty(value = "M1的逾期总金额")
    private BigDecimal m1TotalAmount;

    /**
     * M2的人数
     */
    @ApiModelProperty(value = "M2的人数")
    private Integer m2PersonNum;

    /**
     * M2的逾期总金额
     */
    @ApiModelProperty(value = "M2的逾期总金额")
    private BigDecimal m2TotalAmount;

    /**
     * M2+的人数
     */
    @ApiModelProperty(value = "M2+的人数")
    private Integer m2MorePersonNum;

    /**
     * M2+的逾期总金额
     */
    @ApiModelProperty(value = "M2+的逾期总金额")
    private BigDecimal m2MoreTotalAmount;

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
     * 统计日期
     * @return date_ 统计日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 统计日期
     * @param date 统计日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 累计逾期金额
     * @return total_amount 累计逾期金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 累计逾期金额
     * @param totalAmount 累计逾期金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * M1的人数
     * @return m1_person_num M1的人数
     */
    public Integer getM1PersonNum() {
        return m1PersonNum;
    }

    /**
     * M1的人数
     * @param m1PersonNum M1的人数
     */
    public void setM1PersonNum(Integer m1PersonNum) {
        this.m1PersonNum = m1PersonNum;
    }

    /**
     * M1的逾期总金额
     * @return m1_total_amount M1的逾期总金额
     */
    public BigDecimal getM1TotalAmount() {
        return m1TotalAmount;
    }

    /**
     * M1的逾期总金额
     * @param m1TotalAmount M1的逾期总金额
     */
    public void setM1TotalAmount(BigDecimal m1TotalAmount) {
        this.m1TotalAmount = m1TotalAmount;
    }

    /**
     * M2的人数
     * @return m2_person_num M2的人数
     */
    public Integer getM2PersonNum() {
        return m2PersonNum;
    }

    /**
     * M2的人数
     * @param m2PersonNum M2的人数
     */
    public void setM2PersonNum(Integer m2PersonNum) {
        this.m2PersonNum = m2PersonNum;
    }

    /**
     * M2的逾期总金额
     * @return m2_total_amount M2的逾期总金额
     */
    public BigDecimal getM2TotalAmount() {
        return m2TotalAmount;
    }

    /**
     * M2的逾期总金额
     * @param m2TotalAmount M2的逾期总金额
     */
    public void setM2TotalAmount(BigDecimal m2TotalAmount) {
        this.m2TotalAmount = m2TotalAmount;
    }

    /**
     * M2+的人数
     * @return m2_more_person_num M2+的人数
     */
    public Integer getM2MorePersonNum() {
        return m2MorePersonNum;
    }

    /**
     * M2+的人数
     * @param m2MorePersonNum M2+的人数
     */
    public void setM2MorePersonNum(Integer m2MorePersonNum) {
        this.m2MorePersonNum = m2MorePersonNum;
    }

    /**
     * M2+的逾期总金额
     * @return m2_more_total_amount M2+的逾期总金额
     */
    public BigDecimal getM2MoreTotalAmount() {
        return m2MoreTotalAmount;
    }

    /**
     * M2+的逾期总金额
     * @param m2MoreTotalAmount M2+的逾期总金额
     */
    public void setM2MoreTotalAmount(BigDecimal m2MoreTotalAmount) {
        this.m2MoreTotalAmount = m2MoreTotalAmount;
    }
}