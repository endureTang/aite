package com.nj.core.base.common.api;

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
public class ResponseMsg extends ResultDto {

	private static final long serialVersionUID = 5677333651679329978L;
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

	public ResponseMsg setOptional(Map<String, Object> optional) {
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

	public ResponseMsg() {
	}

	public ResponseMsg(Integer status, String msg) {
		this.setResultStatus(status);
		this.setMsg(msg);
	}
	
	public ResponseMsg(Integer status, String code, String msg){
		this.setResultStatus(status);
		this.setErrorCode(code);
		this.setMsg(msg);
	}
	
	public ResponseMsg(Integer status, RespCode resp){
		this.setResultStatus(status);
		this.setErrorCode(resp.getCode());
		this.setMsg(resp.getMsg());
	}
	
	public ResponseMsg( TFCFResponseMsg tfcfMsg){
		this.setErrorCode(tfcfMsg.getErrorCode());
		this.setFooter(tfcfMsg.getFooter());
		this.setMsg(tfcfMsg.getMsg());
		this.setOptional(tfcfMsg.getOptional());
		this.setResultStatus(tfcfMsg.getResultStatus());
		this.setRows(tfcfMsg.getRows());
		this.setTotal(tfcfMsg.getTotal());
	}
}
