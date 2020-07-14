package com.nj.core.base.enums;

/**
 * 还款计划、回款计划中的扣款类型枚举
 */
public enum EDeductType {

	ONLINE_ZHONGJIN(0,"线上中金扣款"),OFFLINE(9,"线下还款");
	
	private Integer value;
	private String name;
	
	private EDeductType(Integer value,String name){
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getNameByValue(Integer value){
		for (EDeductType dt : EDeductType.values()) {
			if(dt.getValue() == value){
				return dt.getName();
			}
		}
		return "";
	}
	
	public static Integer getValueByName(String name){
		for (EDeductType dt : EDeductType.values()) {
			if(dt.getName().equals(name)){
				return dt.getValue();
			}
		}
		return null;
	}
}
