package com.nj.core.base.enums;

/**
 * 
 * @Name com.nj.core.base.enums.ERoleType
 * @Description 角色类型
 * 
 * @Author bruce
 * @Version 2018年6月26日 上午9:37:06
 * @Copyright 金鼎财富
 *
 */
public enum ERoleType {
	CUSTOMERMANAGER("客户经理","businessCommissioner"),
	BUSINESSMANAGER("业务经理","businessManager"),
	RISKCONTROLMANAGER("风控经理","riskManager"),
	RISKCONTROLCOMMISSIONER("风控专员","riskCommissioner"),
	RISKDIRECTOR("风控总监","riskDirector"),
	CHAIRMAN("董事长","chairman"),
	LEGALAFFAIRS("法务","legalAffairs"),
	LENDINGPERSON("放款专员","lendingCommissioner"),
	FINANCEPERSON("财务人员","financeCommissioner"),
	FINANCEMANAGER("财务经理","financeManager"),
	CADMIN("企业管理员","cadmin"),
	AGENT("代理商","agent"),
	NORMAL("普通用户","normal");
	protected String value;
	protected String name;
    
	private ERoleType(String name,String value){
        this.name=name;
        this.value=value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
