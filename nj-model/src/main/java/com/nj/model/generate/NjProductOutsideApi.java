package com.nj.model.generate;

import com.nj.core.base.entity.NjIdEntity;

import io.swagger.annotations.ApiModelProperty;

public class NjProductOutsideApi extends NjIdEntity {
    /**
     * 产品编号
     */
    @ApiModelProperty(value = "产品编号")
    private String productId;

    /**
     * 外部接口编号
     */
    @ApiModelProperty(value = "外部接口编号")
    private Long outsideApiId;

    /**
     * 产品编号
     * @return product_id 产品编号
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品编号
     * @param productId 产品编号
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 外部接口编号
     * @return outside_api_id 外部接口编号
     */
    public Long getOutsideApiId() {
        return outsideApiId;
    }

    /**
     * 外部接口编号
     * @param outsideApiId 外部接口编号
     */
    public void setOutsideApiId(Long outsideApiId) {
        this.outsideApiId = outsideApiId;
    }
}