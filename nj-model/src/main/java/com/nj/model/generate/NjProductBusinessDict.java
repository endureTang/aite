package com.nj.model.generate;

import com.nj.core.base.entity.NjIdEntity;

public class NjProductBusinessDict extends NjIdEntity {
    /**
     * 产品编号
     */
    private String productId;

    /**
     * 业务字段编号
     */
    private Integer busiDictId;

    /**
     * 填报类型(1:必填,2:选填,3:不填)
     */
    private Byte inputType;

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
     * 业务字段编号
     * @return busi_dict_id 业务字段编号
     */
    public Integer getBusiDictId() {
        return busiDictId;
    }

    /**
     * 业务字段编号
     * @param busiDictId 业务字段编号
     */
    public void setBusiDictId(Integer busiDictId) {
        this.busiDictId = busiDictId;
    }

    /**
     * 填报类型(1:必填,2:选填,3:不填)
     * @return input_type 填报类型(1:必填,2:选填,3:不填)
     */
    public Byte getInputType() {
        return inputType;
    }

    /**
     * 填报类型(1:必填,2:选填,3:不填)
     * @param inputType 填报类型(1:必填,2:选填,3:不填)
     */
    public void setInputType(Byte inputType) {
        this.inputType = inputType;
    }
}