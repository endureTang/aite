/**
 * 
 */
package com.nj.core.base.entity;

import java.io.Serializable;

/**
 * 
 * @Name com.nj.core.base.entity.NjIdEntity
 * @Description
 * 
 * @Author Frank
 * @Version 2018年3月21日下午5:43:25
 * @Copyright 金鼎财富
 *
 */
public abstract class NjIdEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 635787912844666069L;
	/**
	 * 编号
	 */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
