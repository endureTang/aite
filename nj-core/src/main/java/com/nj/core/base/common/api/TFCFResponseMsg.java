package com.nj.core.base.common.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

public class TFCFResponseMsg implements Serializable{
	
	
	private static final long serialVersionUID = -6701884922876734919L;

	public static final Integer FAIL = 0;
	
	public static final Integer SUCCESS = 1;
	
	private Integer resultStatus = SUCCESS;
	/**
	 * 错误消息
	 */
	private String msg = "";
	/**
	 * 错误码
	 */
	private String errorCode;
	
	private String id;
	
	
	private Map<String, Object> optional;
	/**
	 *总条数
	 */
	private Long total;
	/**
	 *数据列
	 */
	private List<?> rows = new ArrayList<Object>();
	/**
	 * 合计项
	 */
	private List<?> footer;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getOptional() {
		return optional;
	}

	public void setOptional(Map<String, Object> optional) {
		this.optional = optional;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public List<?> getFooter() {
		return footer;
	}

	public void setFooter(List<?> footer) {
		this.footer = footer;
	}

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
