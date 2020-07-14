/**
 * 
 */
package com.nj.core.base.enums;

/**
 * 
 * @Name com.nj.core.base.enums.ESysDictType
 * @Description 数据字典类型
 * 
 * @Author Frank
 * @Version 2018年3月22日下午1:30:57
 * @Copyright 金鼎财富
 *
 */
public enum EPaybackType {

	// 数据字典中 type字段标识 产品类型
	OWNPAYBACK("ownPayBack", "自有资金回款"),
	// 数据字典中 type字段标识 亲戚朋友关系
	CHANNELPAYBACK("channelPayBack", "资金渠道回款");
	
	private String value;

	private String desc;

	private EPaybackType(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
