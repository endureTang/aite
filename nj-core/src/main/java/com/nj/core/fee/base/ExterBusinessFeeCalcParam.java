package com.nj.core.fee.base;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 还款计划费用计算算法传入的外部参数，都需继承该抽象类。
 * 所谓外部参数，是指相对贷后模块而言
 * 费用算法需要的外部参数分为两类：（1）系统类一定存在的，如：审批金额、审批期限等 （2）系统内不存在的，需要业务员在放款时输入的
 * 系统内存在的参数又分两部分：一部分为根据还款方式生成本金和利息时需要的，为CreateRepayplanBaseParam
 * 					     一部分在各自算法需要的参数内定义。
 * 该类封装了需要业务员在放款时输入的参数，并提供验证方法。
 * 其中放款时输入参数的验证已实现，各自算法内需要的系统内的参数，在算法的参数内里去实现，这里提供抽象类。
 * 算法里直接使用validate（）即可。
 */
public class ExterBusinessFeeCalcParam {

	protected List<ManualParam> manualParams;	//放款时，业务员手动输入的参数
	
	/**
	 *  验证业务参数是否合法
	 *  @param classPath 使用此验证的算法类的包名+类名
	 */
	public void validate(String classPath) throws Exception{
		
		// 验证业务员手动输入参数
		EBusinessFeeAlgorithm[] als = EBusinessFeeAlgorithm.values();
		for (int i = 0; i < als.length; i++) {
			EBusinessFeeAlgorithm eBusinessFeeAlgorithm = als[i];
			if(eBusinessFeeAlgorithm.getCalcClazz().equals(classPath)){
				validateManualParams(eBusinessFeeAlgorithm);
			}
		}
		
		// 验证系统内存在参数
		validateSysExistParam();
	};
	
	/**
	 * 验证手动输入参数是否完整。 （是否是按BusinessFeeAlgorithmAndManualParamRelation中定义的来传）
	 * @param algorithm 算法枚举
	 */
	@SuppressWarnings("unchecked")
	private void validateManualParams(EBusinessFeeAlgorithm algorithm) throws Exception{
		
		// 手动输入参数转换成map
		Map<String, BigDecimal> manualParamsMap = new HashMap<String, BigDecimal>();
		if(null != manualParams){
			for (ManualParam manualParam : manualParams) {
				manualParamsMap.put(manualParam.getCode(), manualParam.getValue());
			}
		}
		
		// 验证手动输入参数是否完整
		Class<IBusinessFeeCalc> clacClazz = (Class<IBusinessFeeCalc>) Class.forName(algorithm.getCalcClazz());
		List<EBusinessFeeAlgorithmManualParam> list = clacClazz.newInstance().getSupportManualParam();
		if(!CollectionUtils.isEmpty(list)){
			for (EBusinessFeeAlgorithmManualParam eBusinessFeeAlgorithmManualParam : list) {
				if(!manualParamsMap.containsKey(eBusinessFeeAlgorithmManualParam.getCode())){
					throw new Exception("manualParams参数不完整，缺少" + eBusinessFeeAlgorithmManualParam.getCode() + "参数");
				}
			}
		}
	}
	
	/**
	 * 验证系统内存在的参数.由子类重写。若这里用抽象方法，在feign时，无法创建该类对象会报错
	 */
	protected void validateSysExistParam() throws Exception{
		
	};
	

	public List<ManualParam> getManualParams() {
		return manualParams;
	}

	public void setManualParams(List<ManualParam> manualParams) {
		this.manualParams = manualParams;
	}
}
