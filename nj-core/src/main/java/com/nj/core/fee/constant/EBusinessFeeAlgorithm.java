package com.nj.core.fee.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nj.core.fee.algoParam.external.ChannelFeeFirstPeriod1CalcExternalParam;
import com.nj.core.fee.algoParam.external.ChannelFeePeriodCollect1CalcExternalParam;
import com.nj.core.fee.algoParam.external.MediacyFeeAvgToPerioCalcExternalParam;
import com.nj.core.fee.algoParam.external.MediacyFeeFirstPeriodCalcExternalParam;
import com.nj.core.fee.algoParam.external.PenaltyInterestHalfOfDayInterestCalcExternalParam;
import com.nj.core.fee.algoParam.external.PenaltyInterestNotCalcExternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.ManualParam;

/**
 * 业务费用的算法
 * 费用与算法一对多关系。   算法与费用是一对一关系。   （必须按照此规则，一个算法不能对应多个费用,否则报错）
 */
public enum EBusinessFeeAlgorithm {
	
	//罚息  算法
	PENALTYINTEREST_NOTCALC("penaltyInterest_notCalc",				//用于没有应还罚息，有实还罚息的情况
							"不计算罚息",
							"com.nj.core.fee.algo.PenaltyInterestNotCalc",
							"com.nj.core.fee.algoParam.external.PenaltyInterestNotCalcExternalParam",
							"com.nj.core.fee.algoParam.internal.PenaltyInterestNotCalcInternalParam",
							"不计算应还罚息"),				
	PENALTYINTEREST_HALFOFDAYINTEREST("penaltyInterest_halfOfDayInterest",
									  "罚息算法一",
									  "com.nj.core.fee.algo.PenaltyInterestHalfOfDayInterestCalc",
									  "com.nj.core.fee.algoParam.external.PenaltyInterestHalfOfDayInterestCalcExternalParam",
									  "com.nj.core.fee.algoParam.internal.PenaltyInterestHalfOfDayInterestCalcInternalParam",
									  "放款金额  * (贷款日利率  / 2)  * 逾期天数"),
	
	//渠道费  算法
	CHANNELFEE_PERIODCOLLECT_1("channelFee_periodCollect_1",
							   "期收渠道费算法一",
							   "com.nj.core.fee.algo.ChannelFeePeriodCollect1Calc",
							   "com.nj.core.fee.algoParam.external.ChannelFeePeriodCollect1CalcExternalParam",
							   "com.nj.core.fee.algoParam.internal.ChannelFeePeriodCollect1CalcInternalParam",
							   "渠道费按期收取，每期收取金额为：客户批复贷款总金额 * 期收渠道费月利率。先息后本还款时，还本那期不收取渠道费"),
	CHANNELFEE_PERIODCOLLECT_2("channelFee_periodCollect_2",
							   "期收渠道费算法二",
							   "com.nj.core.fee.algo.ChannelFeePeriodCollect2Calc",
							   "com.nj.core.fee.base.ExterBusinessFeeCalcParam",
							   "com.nj.core.fee.algoParam.internal.ChannelFeePeriodCollect2CalcInternalParam",
							   "放款时，输入渠道费总额，平均分摊到每一期。先息后本还款时，还本那期不收取渠道费"),
	CHANNELFEE_FIRSTPERIOD_1("channelFee_firstPeriod_1",
							   "趸收渠道费算法一",
							   "com.nj.core.fee.algo.ChannelFeeFirstPeriod1Calc",
							   "com.nj.core.fee.algoParam.external.ChannelFeeFirstPeriod1CalcExternalParam",
							   "com.nj.core.fee.base.InsideBusinessFeeCalcParam",
							   "渠道费全部归结到第一期。收取金额为：客户批复贷款总金额 * 趸收渠道费率"),
	CHANNELFEE_FIRSTPERIOD_2("channelFee_firstPeriod_2",
							   "趸收渠道费算法二",
							   "com.nj.core.fee.algo.ChannelFeeFirstPeriod2Calc",
							   "com.nj.core.fee.base.ExterBusinessFeeCalcParam",
							   "com.nj.core.fee.base.InsideBusinessFeeCalcParam",
							   "放款时，输入渠道费总额，全部归结到第一期中"),
	
	//居间费  算法
	MEDIACYFEE_AVGTOPERIOD("mediacyFee_avgToPeriod",
						   "居间费算法一",
						   "com.nj.core.fee.algo.MediacyFeeAvgToPerioCalc",
						   "com.nj.core.fee.algoParam.external.MediacyFeeAvgToPerioCalcExternalParam",
						   "com.nj.core.fee.algoParam.internal.MediacyFeeAvgToPerioCalcInternalParam",
						   "放款时，输入居间费总额，平均分摊到每一期。先息后本还款时，还本那期不收取渠道费"),
	MEDIACYFEE_FIRSTPERIOD("mediacyFee_firstPeriod",
						   "居间费算法二",
						   "com.nj.core.fee.algo.MediacyFeeFirstPeriodCalc",
						   "com.nj.core.fee.algoParam.external.MediacyFeeFirstPeriodCalcExternalParam",
						   "com.nj.core.fee.base.InsideBusinessFeeCalcParam",
						   "放款时，输入居间费总额，全部归结到第一期中");
	
	private String code;				//算法编码
	private String name;				//算法名称
	private String calcClazz;			//算法类的全路径：包名+类名
	private String externalParamClazz;	//算法类中计算方法的外部参数类的全路径：包名+类名。外部参数指：从贷后模块外传给贷后的参数
	private String insideParamClazz;	//算法类中计算方法的内部参数类的全路径：包名+类名。内部参数指：贷后模块从自己模块内获取的参数
	private String explain;				//算法的说明文字
	
	private EBusinessFeeAlgorithm(String code,String name,String calcClazz,String externalParamClazz,String insideParamClazz,String explain){
		this.code = code;
		this.name = name;
		this.calcClazz = calcClazz;
		this.externalParamClazz = externalParamClazz;
		this.insideParamClazz = insideParamClazz;
		this.explain = explain;
	}
	
	/**
	 * 通过算法code获取算法枚举
	 */
	public static EBusinessFeeAlgorithm getAlgoByCode(String code){
		EBusinessFeeAlgorithm [] arr = EBusinessFeeAlgorithm.values();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].getCode().equals(code)){
				return arr[i];
			}
		}
		return null;
	}
	
	/**
	 * 创建还款计划时，通过算法的编码和传入的外部费用计算参数的json,获取外部参数类
	 */
	public static ExterBusinessFeeCalcParam getExterCalcParam(String algoCode,String json){
		
		JSONObject jsonObject = JSONObject.parseObject(json);
		
		if(algoCode.equals(PENALTYINTEREST_NOTCALC.getCode())){
			PenaltyInterestNotCalcExternalParam param = new PenaltyInterestNotCalcExternalParam();
			param.setManualParams(getMPList(jsonObject));
			return param;
		}else if(algoCode.equals(PENALTYINTEREST_HALFOFDAYINTEREST.getCode())){
			PenaltyInterestHalfOfDayInterestCalcExternalParam param = new PenaltyInterestHalfOfDayInterestCalcExternalParam();
			param.setManualParams(getMPList(jsonObject));
			param.setYearRate(new BigDecimal(jsonObject.getString("yearRate")));
			param.setLoanAmount(new BigDecimal(jsonObject.getString("loanAmount")));
			return param;
		}else if(algoCode.equals(CHANNELFEE_PERIODCOLLECT_1.getCode())){
			ChannelFeePeriodCollect1CalcExternalParam param = new ChannelFeePeriodCollect1CalcExternalParam();
			param.setManualParams(getMPList(jsonObject));
			param.setLoanAmount(new BigDecimal(jsonObject.getString("loanAmount")));
			param.setChannelFeeRateForMonth(new BigDecimal(jsonObject.getString("channelFeeRateForMonth")));
			return param;
		}else if(algoCode.equals(CHANNELFEE_PERIODCOLLECT_2.getCode())){
			ExterBusinessFeeCalcParam param = new ExterBusinessFeeCalcParam();
			param.setManualParams(getMPList(jsonObject));
			return param;
		}else if(algoCode.equals(CHANNELFEE_FIRSTPERIOD_1.getCode())){
			ChannelFeeFirstPeriod1CalcExternalParam param = new ChannelFeeFirstPeriod1CalcExternalParam();
			param.setManualParams(getMPList(jsonObject));
			param.setLoanAmount(new BigDecimal(jsonObject.getString("loanAmount")));
			param.setChannelFeeRate(new BigDecimal(jsonObject.getString("channelFeeRate")));
			return param;
		}else if(algoCode.equals(CHANNELFEE_FIRSTPERIOD_2.getCode())){
			ExterBusinessFeeCalcParam param = new ExterBusinessFeeCalcParam();
			param.setManualParams(getMPList(jsonObject));
			return param;
		}else if(algoCode.equals(MEDIACYFEE_AVGTOPERIOD.getCode())){
			MediacyFeeAvgToPerioCalcExternalParam param = new MediacyFeeAvgToPerioCalcExternalParam();
			param.setManualParams(getMPList(jsonObject));
			return param;
		}else if(algoCode.equals(MEDIACYFEE_FIRSTPERIOD.getCode())){
			MediacyFeeFirstPeriodCalcExternalParam param = new MediacyFeeFirstPeriodCalcExternalParam();
			param.setManualParams(getMPList(jsonObject));
			return param;
		}
		return null;
	}
	
	/**
	 * 创建还款计划时，通过传入的外部费用计算参数的json转换成的JSONObject,获取List<ManualParam>
	 */
	private static List<ManualParam> getMPList(JSONObject jsonObject){
		List<ManualParam> mpList = new ArrayList<ManualParam>();
		if(null != jsonObject){
			JSONArray jsonArr = jsonObject.getJSONArray("manualParams");
			if(null != jsonArr){
				for (Object object : jsonArr) {
					JSONObject manualParamJO = JSONObject.parseObject(object.toString());
					ManualParam manualParam = new ManualParam();
					manualParam.setCode(manualParamJO.getString("code"));
					manualParam.setValue(new BigDecimal(manualParamJO.getString("value")));
					mpList.add(manualParam);
				}
			}
		}
		return mpList;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCalcClazz() {
		return calcClazz;
	}

	public void setCalcClazz(String calcClazz) {
		this.calcClazz = calcClazz;
	}

	public String getExternalParamClazz() {
		return externalParamClazz;
	}

	public void setExternalParamClazz(String externalParamClazz) {
		this.externalParamClazz = externalParamClazz;
	}

	public String getInsideParamClazz() {
		return insideParamClazz;
	}

	public void setInsideParamClazz(String insideParamClazz) {
		this.insideParamClazz = insideParamClazz;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
	
}
