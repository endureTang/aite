package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjProductContractTemplate {
    private String id;

    private String productId;

    private String type;

    private String typeName;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String templateName;

    /**
     * 核查人编号
     */
    @ApiModelProperty(value = "核查人编号")
    private String url;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

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
     * 
     * @return type 
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return type_name 
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 
     * @param typeName 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 订单编号
     * @return template_name 订单编号
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 订单编号
     * @param templateName 订单编号
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 核查人编号
     * @return url 核查人编号
     */
    public String getUrl() {
        return url;
    }

    /**
     * 核查人编号
     * @param url 核查人编号
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}