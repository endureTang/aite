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
public class ResponseSndkMsg implements Serializable{

	private static final long serialVersionUID = 5677333651679329978L;
	private String return_msg;
	private String return_code;
	
	private Map<String, Object> result;

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public boolean isSuccess() {
		if("SUCCESS".equals(return_code)){
			return true;
		}
		return false;
	}
}
