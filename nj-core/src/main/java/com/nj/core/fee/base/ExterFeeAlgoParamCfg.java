package com.nj.core.fee.base;

/**
 * 订单的费用、算法、外部参数类的关联关系
 * 用于调用贷后接口时，传入的参数类
 */
public class ExterFeeAlgoParamCfg {

	public static final Integer REPAY_PLAN = 1;			//还款计划
	public static final Integer MONEY_BACK_PLAN = 2;		//回款计划
	
	// 配置对象，即使还款计划的配置还是回款计划的配置。  使用该类的敞亮
	private Integer cfgObj;
	
	// 业务费用编码
	private String businessFeeCode;
	
	// 算法编码
	private String algorithmCode;
	
	// 费用算法的外部参数。   设置该值时，一定要根据算法枚举EBusinessFeeAlgorithm中配置的外部参数类型来生成对象，再转换成json。
	// 如：计算渠道费时，枚举为EBusinessFeeAlgorithm.CHANNELFEE_PERIODCOLLECT_1，eParam传值的类型为com.nj.core.fee.algoParam.external.ChannelFeePeriodCollect1CalcExternalParam
	// 创建ChannelFeePeriodCollect1CalcExternalParam对象，设置值，转换成json,赋值给该字段
	private String eParamJson;

	public Integer getCfgObj() {
		return cfgObj;
	}

	public void setCfgObj(Integer cfgObj) {
		this.cfgObj = cfgObj;
	}

	public String getBusinessFeeCode() {
		return businessFeeCode;
	}

	public void setBusinessFeeCode(String businessFeeCode) {
		this.businessFeeCode = businessFeeCode;
	}

	public String getAlgorithmCode() {
		return algorithmCode;
	}

	public void setAlgorithmCode(String algorithmCode) {
		this.algorithmCode = algorithmCode;
	}

	public String geteParamJson() {
		return eParamJson;
	}

	public void seteParamJson(String eParamJson) {
		this.eParamJson = eParamJson;
	}

}
