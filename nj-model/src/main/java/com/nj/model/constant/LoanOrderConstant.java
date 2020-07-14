package com.nj.model.constant;

public class LoanOrderConstant {
	
	// 订单状态  status
	public static final Integer STATUS_0 = 0; 		//暂存->待开启审批流程
	public static final Integer STATUS_1 = 1; 		//待系统反欺诈识别
	public static final Integer STATUS_2 = 2; 		//系统反欺诈拒绝/人工反欺诈识别标记欺诈
	public static final Integer STATUS_3 = 3; 		//系统反欺诈同意/人工反欺诈识别标记正常->待批复
	public static final Integer STATUS_4 = 4; 		//批复拒绝
	public static final Integer STATUS_5 = 5; 		//批复同意/二次复核退回->待复核
	public static final Integer STATUS_6 = 6; 		//复核同意->待业务核实
	public static final Integer STATUS_7 = 7; 		//复核同意，流程审批完成->待生成合同
	public static final Integer STATUS_8 = 8; 		//合同生成成功-待用户确认
	public static final Integer STATUS_9 = 9; 		//无需用户确认/用户确认->待自动发标 
	public static final Integer STATUS_10 = 10; 	//用户确认拒绝->中止合同
	public static final Integer STATUS_11 = 11; 	//待自动发标->线上募资->待放款
	public static final Integer STATUS_12 = 12; 	//放款成功
	public static final Integer STATUS_13 = 13; 
	public static final Integer STATUS_14 = 14; 	//系统反欺诈->待人工反欺诈识别
	public static final Integer STATUS_15 = 15;		//发标受阻->中止合同
	public static final Integer STATUS_16 = 16;		//线上募资放款->放款失败->待人工发标
	public static final Integer STATUS_51 = 51; 	//复核同意->待二次复核
	public static final Integer STATUS_99 = 99; 	//用户还款完成
	
	// 订单批复贷款方式 relend_method
	public static final String RELEND_METHOD_OFF = "0";				//线下放款
	public static final String RELEND_METHOD_ONL_PUBLIC = "1";		//线上放款-公众放款
	public static final String RELEND_METHOD_ONL_SELF = "2";		//线上放款-自放款
}
