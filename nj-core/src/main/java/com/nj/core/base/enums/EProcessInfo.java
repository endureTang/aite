package com.nj.core.base.enums;

/**
 * 
 * @Name com.nj.core.base.enums.EProcessInfo
 * @Description 基本流程枚举
 * 
 * @Author bruce
 * @Version 2018年2月9日 上午9:30:44
 * @Copyright 金鼎财富
 *
 */
public enum EProcessInfo {
	START("启动流程",1,2),
	DECISION_ENGINE("决策引擎",2,3),
	AUTO_SHUNT("自动分单",3,2),
	MANUAL_SHUNT("手动分单",4,1),
	FIRST_CHECK("初审",5,1),
	REVIEW_CHECK("复审",6,1),
	MANAGER_REVIEW_CHECK("经理复审",61,1),
	DIRECTOR_REVIEW_CHECK("总监复审",62,1),
	LAST_CHECK("终审",7,1),
	MODIFY_DATA("修改资料",8,1),
	USER_CONFIRM("用户确认",9,2),
	SEND_MARK("发标",10,1),
	MANUAL_LOAN("放款",11,1),
	
	BUSINESS_SURVEY("业务调查",21,1),
	CONTRACT_Create("合同制作",22,1),
	CONTRACT_CHECK("合同审核",23,1),
	AUTHORIZED_JUDGE("有权责任人判断",24,3),
	
	BEGIN_MAKE_LOANS("开始放款流程",31,1),
	MAKE_LOANS_FIRST_CHECK("放款初审",32,1),
	MAKE_LOANS_SECOND_CHECK("放款专员复审",33,1),
	MAKE_LOANS_THIRD_CHECK("放款经理复审",38,1),
	MAKE_LOANS_FOURTH_CHECK("放款总监复审",34,1),
	MAKE_LOANS_FIFTH_CHECK("放款终审",35,1),
	FINANCE_REVIEW("财务复核",36,1),
	FINANCE_MANAGER_REVIEW("财务经理复核",37,1),
	AUTO_LOAN("自动放款",39,2),
	CREATE_REPAYMENT_PLAN("生成还款计划",41,2),
	END("流程结束",99,1);
	
	protected String name;
    protected int id;
    /**
     * 类型(1:手动流程,2:自动流程,3:判断)
     */
    protected int type;
    /**
     * 对应订单状态
     */
    protected int orderStatus;
    
    EProcessInfo(String name, int id,int type){
        this.name=name;
        this.id=id;
        this.type = type;
    }
    public static EProcessInfo getEProcessInfo(int id) {
    	for(EProcessInfo einfo:EProcessInfo.values()) {
    		if(einfo.getId()==id) {
    			return einfo;
    		}
    	}
    	return null;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
