/**
 * 
 */
package com.nj.core.base.vo;

import java.io.Serializable;

/**
 * 
 * @Name com.nj.core.base.vo.JsonMessage
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月21日下午2:00:33
 * @Copyright 金鼎财富
 *
 */
public class JsonMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5031067220396761106L;

	private int status = 0;

	private String msg;

	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
