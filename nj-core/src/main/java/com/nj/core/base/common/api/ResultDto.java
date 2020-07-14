package com.nj.core.base.common.api;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class ResultDto implements Serializable {
	public static final Integer FAIL = 0;
	public static final Integer SUCCESS = 1;

	private static final long serialVersionUID = -7347771268713299394L;
	/**
	 * 状态 0 ：异常；1：成功
	 */
	private Integer resultStatus = SUCCESS;
	/**
	 * 错误消息
	 */
	@JSONField(name="errorMsg") 
	private String msg = "";
	/**
	 * 错误码
	 */
	private String errorCode;

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
	}

	public void tfcfResp(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "返回代码：" + this.errorCode + ", 消息：" + this.msg;
	}
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
