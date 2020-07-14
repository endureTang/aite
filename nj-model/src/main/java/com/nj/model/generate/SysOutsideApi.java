package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class SysOutsideApi{
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;

    /**
     * 三方接口提供公司名称
     */
    @ApiModelProperty(value = "三方接口提供公司名称")
    private String supplierName;

    /**
     * 接口中文名称
     */
    @ApiModelProperty(value = "接口中文名称")
    private String apiName;

    /**
     * 接口关键字
     */
    @ApiModelProperty(value = "接口关键字")
    private String apiKeyword;

    /**
     * 编号
     * @return id 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 三方接口提供公司名称
     * @return supplier_name 三方接口提供公司名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 三方接口提供公司名称
     * @param supplierName 三方接口提供公司名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * 接口中文名称
     * @return api_name 接口中文名称
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * 接口中文名称
     * @param apiName 接口中文名称
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    /**
     * 接口关键字
     * @return api_keyword 接口关键字
     */
    public String getApiKeyword() {
        return apiKeyword;
    }

    /**
     * 接口关键字
     * @param apiKeyword 接口关键字
     */
    public void setApiKeyword(String apiKeyword) {
        this.apiKeyword = apiKeyword;
    }
}