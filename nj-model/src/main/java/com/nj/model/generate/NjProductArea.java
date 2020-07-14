package com.nj.model.generate;

import com.nj.core.base.entity.NjIdEntity;

import io.swagger.annotations.ApiModelProperty;

public class NjProductArea extends NjIdEntity {
    private String productId;

    /**
     * 区域类型:0:全国,1:省,2:市,3:县
     */
    @ApiModelProperty(value = "区域类型:0:全国,1:省,2:市,3:县")
    private Byte type;

    /**
     * 区域省编号
     */
    @ApiModelProperty(value = "区域省编号")
    private String provinceId;

    /**
     * 市编码
     */
    @ApiModelProperty(value = "市编码")
    private String cityId;

    /**
     * 县编码
     */
    @ApiModelProperty(value = "县编码")
    private String countyId;

    /**
     * 区域名称
     */
    @ApiModelProperty(value = "区域名称")
    private String areaValue;

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
     * 区域类型:0:全国,1:省,2:市,3:县
     * @return type 区域类型:0:全国,1:省,2:市,3:县
     */
    public Byte getType() {
        return type;
    }

    /**
     * 区域类型:0:全国,1:省,2:市,3:县
     * @param type 区域类型:0:全国,1:省,2:市,3:县
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 区域省编号
     * @return province_id 区域省编号
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * 区域省编号
     * @param provinceId 区域省编号
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 市编码
     * @return city_id 市编码
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 市编码
     * @param cityId 市编码
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * 县编码
     * @return county_id 县编码
     */
    public String getCountyId() {
        return countyId;
    }

    /**
     * 县编码
     * @param countyId 县编码
     */
    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    /**
     * 区域名称
     * @return area_value 区域名称
     */
    public String getAreaValue() {
        return areaValue;
    }

    /**
     * 区域名称
     * @param areaValue 区域名称
     */
    public void setAreaValue(String areaValue) {
        this.areaValue = areaValue;
    }
}