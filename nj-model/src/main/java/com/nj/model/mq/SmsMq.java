package com.nj.model.mq;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 短信实体
 * @author MaSong
 * @date 2018-07-19 13:24:23
 */
public class SmsMq {
	
	@ApiModelProperty("手机号码，该字段必填")
	private  String mobile;
	
	@ApiModelProperty("短信类型：0 注册 、1修改密码 、2短信登录、3自定义短信、10用户确认码,该字段必填")
	private  String smsType;
	
	@ApiModelProperty("模板ID，该字段为可选，当短信类型为3时，该字段必填")
	private  String templateId;
	
	@ApiModelProperty("验证码，当短信类型为0、1、2、10时，该字段必填")
	private  String code;
	
	@ApiModelProperty("超时时间,该字段主要用于验证码短信提示用户的超时时间,当短信类型为0、1、2、10时，该字段必填")
	private  String limitTime;
	
	@ApiModelProperty("短信信息，当短信类型为3时，该字段必填")
	private  String[] msg;
	
	@ApiModelProperty("短信公司编码，不填则是默认短信渠道,渠道编码查询com.nj.core.base.enums.ESmsConpanyInfo，目前容联云通讯（默认）")
	private  String smsComapanyCode;
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public String[] getMsg() {
		return msg;
	}

	public void setMsg(String[] msg) {
		this.msg = msg;
	}

	public String getSmsComapanyCode() {
		return smsComapanyCode;
	}

	public void setSmsComapanyCode(String smsComapanyCode) {
		this.smsComapanyCode = smsComapanyCode;
	}

	
}
