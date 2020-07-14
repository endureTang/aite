package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjStatisticsReturnMoney {
    private String id;

    private String companyId;

    private String productId;

    private Date date;

    /**
     * 回款金额，单位元
     */
    @ApiModelProperty(value = "回款金额，单位元")
    private BigDecimal returnAmt;

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
     * @return company_id 
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 
     * @param companyId 
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
     * 
     * @return date_ 
     */
    public Date getDate() {
        return date;
    }

    /**
     * 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 回款金额，单位元
     * @return return_amt 回款金额，单位元
     */
    public BigDecimal getReturnAmt() {
        return returnAmt;
    }

    /**
     * 回款金额，单位元
     * @param returnAmt 回款金额，单位元
     */
    public void setReturnAmt(BigDecimal returnAmt) {
        this.returnAmt = returnAmt;
    }
}