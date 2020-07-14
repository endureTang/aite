package com.nj.core.base.enums;

/**
 * 
 * @Name com.nj.core.base.enums.ELoanOrderStatus
 * @Description 贷款订单状态枚举
 * 
 * @Author bruce
 * @Version 2018年2月9日 上午9:29:39
 * @Copyright 金鼎财富
 *
 */
public enum ELoanOrderStatus {
	WAIT("待开启审批流程",0),
	  START("启动审批流程",1),
	  DECISION_ENGINE("决策引擎通过",2),//等待分单
	  BUSINESS_SHUNT("订单初始化",20),
	  BUSINESS_SURVEY_SUCCESS("预审通过",21),
	  SHUNT("分单成功",3),//分单成功,等待审核
	  PLATFORM_REFUSE("平台拒绝",4),
	  FIRST_CHECK_SUCCESS("初审通过",5),
	  REVIEW_CHECK_SUCCESS("复审(一)通过",51),
	  MANAGER_REVIEW_CHECK_SUCCESS("复审(二)通过",53),
	  DIRECTOR_REVIEW_CHECK_SUCCESS("复审(三)通过",54),
	  LAST_CHECK_SUCCESS("终审通过",7),
	  CREATE_CONTRACT("合同制作成功",8),
	  CONTRACT_CHECK_SUCCESS("合同审核通过",81),
	  USER_CONFIRM("用户确认",9),//资产进入库存,等待发标
	  USER_REFUSE("用户拒绝",41),
	  BUILD_CORPORE("生成标的物",10),//按规则生成标的物
	  FUNDRAISING_SUCCESS("发标成功",11),//等待放款
	  FUNDRAISING_FAIL("发标失败",15),//发标审核未通过
	  START_LENDING("发起放款",31),
	  FIRST_CHECK_LENDING("放款初审通过",32),
	  SECOND_CHECK_LENDING("放款复审(一)通过",33),
	  THIRD_CHECK_LENDING("放款复审(二)通过",34),
	  FOURTH_CHECK_LENDING("放款复审(三)通过",35),
	  FIFTH_CHECK_LENDING("放款终审通过",36),
	  SIXTH_CHECK_LENDING("财务放款审查通过",37),
	  SEVENTH_CHECK_LENDING("财务放款复核通过",38),
	  REPAYMENT_PLAN_FINISH("还款计划创建成功",61),
	  MAKE_LOANS("放款成功",12),
	  FIRST_REJECT("驳回",52),
	  OVERDUE("逾期",70),
	  REPAYMENT("还款完成",99),
	  PUHUICANCEL("普惠撤销临时状态",-1);
	
	protected String name;
    protected int value;
    
	private ELoanOrderStatus(String name, int value){
        this.name=name;
        this.value=value;
    }
	
	public static ELoanOrderStatus getELoanOrderStatus(int value) {
		for(ELoanOrderStatus estatus:ELoanOrderStatus.values()) {
			if(estatus.getValue()==value) {
				return estatus;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

