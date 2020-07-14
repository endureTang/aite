package com.nj.core.base.common.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应消息
 * 
 * @author lenovo
 * 
 */
public class ResponseLoanMsg implements Serializable{

	private static final long serialVersionUID = 5677333651679329978L;
	private String id;

	private int resultStatus;
	private String msg;
	
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

	public ResponseLoanMsg setOptional(Map<String, Object> optional) {
		this.optional = optional;
		return this;
	}

	public void optional(String key, Object value) {
		if (this.optional == null) {
			optional = new HashMap<String, Object>(2);
		}
		this.optional.put(key, value);
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

	public ResponseLoanMsg() {
	}

	public int getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
