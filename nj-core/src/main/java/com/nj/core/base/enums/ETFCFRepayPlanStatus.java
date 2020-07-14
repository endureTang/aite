package com.nj.core.base.enums;

public enum ETFCFRepayPlanStatus {

	REPAYING(0,"还款中"),REPAYED(1,"已还款"),COMPENSATED(2,"已代偿"),OVERDUE(3,"逾期未还"),YSQHKDSH(-1,"已申请还款待审核");
	
	private Integer value;
	private String name;
	
	private ETFCFRepayPlanStatus(Integer value,String name){
		this.value = value;
		this.name = name;
	}

	public static String getNameByValue(Integer value){
		for (ETFCFRepayPlanStatus status : ETFCFRepayPlanStatus.values()) {
			if(status.value == value.intValue()){
				return status.name;
			} 
		}
		return "";
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
}
