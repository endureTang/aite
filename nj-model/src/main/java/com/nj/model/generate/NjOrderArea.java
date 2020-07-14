package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjOrderArea {
    private String id;

    /**
     * 地名
     */
    @ApiModelProperty(value = "地名")
    private String name;

    /**
     * 地区code
     */
    @ApiModelProperty(value = "地区code")
    private String code;

    /**
     * 父级Code,当为省时，该字段为0
     */
    @ApiModelProperty(value = "父级Code,当为省时，该字段为0")
    private String parentCode;

    /**
     * 区域类型 1 省  2 市  3县区
     */
    @ApiModelProperty(value = "区域类型 1 省  2 市  3县区")
    private String type;

    /**
     * 总计
     */
    @ApiModelProperty(value = "总计")
    private Integer amount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 总批复金额
     */
    @ApiModelProperty(value = "总批复金额")
    private BigDecimal auditamt;

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
     * 地名
     * @return name 地名
     */
    public String getName() {
        return name;
    }

    /**
     * 地名
     * @param name 地名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 地区code
     * @return code 地区code
     */
    public String getCode() {
        return code;
    }

    /**
     * 地区code
     * @param code 地区code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 父级Code,当为省时，该字段为0
     * @return parent_code 父级Code,当为省时，该字段为0
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 父级Code,当为省时，该字段为0
     * @param parentCode 父级Code,当为省时，该字段为0
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 区域类型 1 省  2 市  3县区
     * @return type 区域类型 1 省  2 市  3县区
     */
    public String getType() {
        return type;
    }

    /**
     * 区域类型 1 省  2 市  3县区
     * @param type 区域类型 1 省  2 市  3县区
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 总计
     * @return amount 总计
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 总计
     * @param amount 总计
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
     * 
     * @return auditAmt 
     */
    public BigDecimal getAuditamt() {
        return auditamt;
    }

    /**
     * 
     * @param auditamt 
     */
    public void setAuditamt(BigDecimal auditamt) {
        this.auditamt = auditamt;
    }
}