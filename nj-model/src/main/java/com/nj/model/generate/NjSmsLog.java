package com.nj.model.generate;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjSmsLog {
    private String id;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    /**
     * 短信公司编号
     */
    @ApiModelProperty(value = "短信公司编号")
    private String companyCode;

    /**
     * 短信类型
     */
    @ApiModelProperty(value = "短信类型")
    private String smsType;

    /**
     * 模板ID
     */
    @ApiModelProperty(value = "模板ID")
    private String templateId;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    private String code;

    /**
     * 信息
     */
    @ApiModelProperty(value = "信息")
    private String msg;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

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
     * 手机号码
     * @return mobile 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 短信公司编号
     * @return company_code 短信公司编号
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 短信公司编号
     * @param companyCode 短信公司编号
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 短信类型
     * @return sms_type 短信类型
     */
    public String getSmsType() {
        return smsType;
    }

    /**
     * 短信类型
     * @param smsType 短信类型
     */
    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    /**
     * 模板ID
     * @return template_Id 模板ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 模板ID
     * @param templateId 模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 验证码
     * @return code 验证码
     */
    public String getCode() {
        return code;
    }

    /**
     * 验证码
     * @param code 验证码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 信息
     * @return msg 信息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 信息
     * @param msg 信息
     */
    public void setMsg(String msg) {
        this.msg = msg;
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
}