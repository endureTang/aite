package com.nj.model.generate;

import com.nj.core.base.entity.NjIdEntity;

import io.swagger.annotations.ApiModelProperty;

public class NjProductCycle extends NjIdEntity {
    private String productId;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String sysId;

    private Integer threType;

    /**
     * 资产等级
     */
    @ApiModelProperty(value = "资产等级")
    private String grade;

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
     * 编号
     * @return sys_id 编号
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * 编号
     * @param sysId 编号
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    /**
     * 
     * @return thre_type 
     */
    public Integer getThreType() {
        return threType;
    }

    /**
     * 
     * @param threType 
     */
    public void setThreType(Integer threType) {
        this.threType = threType;
    }

    /**
     * 资产等级
     * @return grade 资产等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 资产等级
     * @param grade 资产等级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}