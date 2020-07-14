package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class SysBusinessDict {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Integer id;

    /**
     * 父级id（顶级为0）
     */
    @ApiModelProperty(value = "父级id（顶级为0）")
    private Integer parentId;

    /**
     * 业务类型（1：信用类，2：房屋类）
     */
    @ApiModelProperty(value = "业务类型（1：信用类，2：房屋类）")
    private Byte businessType;

    /**
     * 字段名称
     */
    @ApiModelProperty(value = "字段名称")
    private String descption;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String keyword;

    /**
     * 对应数据字典值
     */
    @ApiModelProperty(value = "对应数据字典值")
    private String sysDictValue;

    /**
     * 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框,6：数字,7：日期，8：婚姻，9：手机号)
     */
    @ApiModelProperty(value = "数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框,6：数字,7：日期，8：婚姻，9：手机号)")
    private Byte dataType;

    /**
     * 排序顺序
     */
    @ApiModelProperty(value = "排序顺序")
    private Integer orders;

    /**
     * 展示类型（1：基本信息，2：附件资料，3：授权信息,4：身份证相关资料）
     */
    @ApiModelProperty(value = "展示类型（1：基本信息，2：附件资料，3：授权信息,4：身份证相关资料）")
    private Integer showType;

    /**
     * 基本信息保存域名
     */
    @ApiModelProperty(value = "基本信息保存域名")
    private String url;

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
     * 父级id（顶级为0）
     * @return parent_id 父级id（顶级为0）
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级id（顶级为0）
     * @param parentId 父级id（顶级为0）
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 业务类型（1：信用类，2：房屋类）
     * @return business_type 业务类型（1：信用类，2：房屋类）
     */
    public Byte getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型（1：信用类，2：房屋类）
     * @param businessType 业务类型（1：信用类，2：房屋类）
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
     * 对应数据字典值
     * @return sys_dict_value 对应数据字典值
     */
    public String getSysDictValue() {
        return sysDictValue;
    }

    /**
     * 对应数据字典值
     * @param sysDictValue 对应数据字典值
     */
    public void setSysDictValue(String sysDictValue) {
        this.sysDictValue = sysDictValue;
    }

    /**
     * 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框,6：数字,7：日期，8：婚姻，9：手机号)
     * @return data_type 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框,6：数字,7：日期，8：婚姻，9：手机号)
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     * 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框,6：数字,7：日期，8：婚姻，9：手机号)
     * @param dataType 数据类型(1:字符串输入,2:图片,3:ocr读取,4:行政区域,5:下拉框,6：数字,7：日期，8：婚姻，9：手机号)
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

    /**
     * 展示类型（1：基本信息，2：附件资料，3：授权信息,4：身份证相关资料）
     * @return show_type 展示类型（1：基本信息，2：附件资料，3：授权信息,4：身份证相关资料）
     */
    public Integer getShowType() {
        return showType;
    }

    /**
     * 展示类型（1：基本信息，2：附件资料，3：授权信息,4：身份证相关资料）
     * @param showType 展示类型（1：基本信息，2：附件资料，3：授权信息,4：身份证相关资料）
     */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    /**
     * 基本信息保存域名
     * @return url 基本信息保存域名
     */
    public String getUrl() {
        return url;
    }

    /**
     * 基本信息保存域名
     * @param url 基本信息保存域名
     */
    public void setUrl(String url) {
        this.url = url;
    }
}