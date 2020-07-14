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
public enum ESysDictType {

	// 数据字典中 type字段标识 产品类型
	PRODUCT("CPFBSXFL", "产品类型"),
	// 数据字典中 type字段标识 亲戚朋友关系
	RELATIVE("QPGXLX", " 亲戚朋友关系"),
	// 数据字典中type字段标识 婚姻状态
	MARRIAGE("HYZT", " 婚姻状态"),

	WORK("GZZT", "工作相关"),

	MAX_EDU("ZGXL", "学历"),

	PERIOD("CPDKKXQX", "还款期数"),

	REPAY("REPAYTYPE", ""),

	RECU_TYPE("RECUTYPE", ""),

	/** 产品创建-交易配置：平台手续费 */
	CPPTSXF("CPPTSXF", "平台手续费"),
	/** 产品创建-交易配置：还款方设置 */
	CPJYHKJS("CPJYHKJS", "还款方设置"),
	/** 产品创建-交易配置：收款方设置 */
	CPJYSKJS("CPJYSKJS", "收款方设置"),
	/** 产品创建-交易配置：还款方式 ,能贷 */
	CPHKFS("CPHKFS", "还款方式 "),
	/** 产品创建-交易配置：还款方式 ,微鼎金融 */
	WDCPHKFS("WDCPHKFS", "还款方式 "),

	/** 产品创建-业务受理配置：资料设置 */
	CPZLSZ("CPZLSZ", "资料设置"),
	/** 产品创建-业务受理配置：征信设置 */
	CPZXSZ("CPZXSZ", "征信设置"),
	/** 产品创建-业务受理配置：递增增幅 */
	CPDKDZZF("CPDKDZZF", "递增增幅"),
	/** 产品创建-业务受理配置：可选期限 */
	CPDKKXQX("CPDKKXQX", "可选期限"),
	/** 产品创建-业务受理配置：实名认证 */
	CPSMRZ("CPSMRZ", "实名认证"),

	/** 产品创建-申请渠道配置：用途配置 */
	CPYTPZ("CPYTPZ", "用途配置"),

	/** 产品创建-交易配置：交易模式 */
	CPJYMS("CPJYMS", "交易模式"),

	/** 产品创建-交易配置：交易流程配置条件 */
	CPLCTJ("CPLCTJ", "交易流程配置条件"),

	/** 产品创建-发布设置：申请适用区域 */
	SYSCITY("SYSCITY", "申请适用区域"),
	/** 产品创建-发布设置：申请用户范围设置 */
	CPFBSQFW("CPFBSQFW", "申请用户范围设置"),
	/** 产品创建-发布设置：上线分类设置 */
	CPFBSXFL("CPFBSXFL", "上线分类设置"),

	/** 贷后管理-列表管理：还款状态 */
	DHHKZT("DHHKZT", "还款状态"),
	/** 贷后管理-列表管理：是否逾期 */
	DHYQZT("DHYQZT", "是否逾期"),
	/** 贷后管理-列表管理：还款期限 */
	DHHKQX("DHHKQX", "还款期限"),
	/** 车辆型号 **/
	CLLX("CLLX", "车辆型号"),
	/** 车辆价格区间类型 */
	CLJG("CLJG", "车辆价格区间类型"),
	/** 车辆年龄区间 */
	CLNL("CLNL", "车辆年龄区间"),
	/** 产品标签 */
	CPBQ("CPBQ", "产品标签"),
	/** 数据加密密码 */
	JMKEY("JMKEY", "数据加密密码"),

	/**
	 * 发标量配置
	 * 
	 * @see ELoanOrderStatus.BUILD_CORPORE
	 */
	BUILD_CORPORE_LIMIT("BUILD_CORPORE_LIMIT", "发标量配置");

	private String value;

	private String desc;

	private ESysDictType(String value, String desc) {
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
