package com.nj.model.datamodel;

import io.swagger.annotations.ApiModelProperty;

public class SysBusinessDictModel {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "还款账户")
    private Byte businessType;

    /**
     * 字段名称
     */
    private String descption;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框)
     */
    @ApiModelProperty(value = "数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框)")
    private Byte dataType;

    /**
     * 排序顺序
     */
    private Integer orders;
    
    /**
     * 填报类型(1:必填,2:选填,3:不填)
     */
    @ApiModelProperty(value = "填报类型(1:必填,2:选填,3:不填)")
    private Integer inputType;
    /**
     * 配置项值
     */
    private Object value;
    /**
     * 其他
     */
    private Object remark;

    /**
     * 编号
     * @return id 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 业务类型
     * @return business_type 业务类型
     */
    public Byte getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型
     * @param businessType 业务类型
     */
    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    /**
     * 字段名称
     * @return descption 字段名称
     */
    public String getDescption() {
        return descption;
    }

    /**
     * 字段名称
     * @param descption 字段名称
     */
    public void setDescption(String descption) {
        this.descption = descption;
    }

    /**
     * 关键字
     * @return keyword 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 关键字
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框)
     * @return data_type 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框)
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     * 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框)
     * @param dataType 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框)
     */
    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    /**
     * 排序顺序
     * @return orders 排序顺序
     */
    public Integer getOrders() {
        return orders;
    }
    
    /**
     * 排序顺序
     * @param orders 排序顺序
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

	public Integer getInputType() {
		return inputType;
	}

	public void setInputType(Integer inputType) {
		this.inputType = inputType;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getRemark() {
		return remark;
	}

	public void setRemark(Object remark) {
		this.remark = remark;
	}
}