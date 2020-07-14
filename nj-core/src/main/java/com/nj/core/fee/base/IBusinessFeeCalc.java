package com.nj.core.fee.base;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 还款计划费用计算接口
 * 所有费用计算的方法都需实现该接口
 */
public interface IBusinessFeeCalc {

	/**
	 * 计算某项费用的值
	 * @param externalParam	外部调用贷后时，传入的外部参数
	 * @param insideParam 贷后内部传入的参数
	 * 计算费用时，传入的参数来源有几个地方：
	 * 		1.贷后内部的参数，如：实际生成的还款计划期数。成都金坤申请12期，生成还款计划有13期。对应insideParam
	 * 		2.贷后外部的参数，分为两部分：
	 * 			（1）发起放款时，系统内就已经存在的参数。对应baseParam和externalParam
	 * 			（2）发起放款时，系统内不存在的参数，需要业务员手动输入。对应externalParam的父类
	 * @return Map<Integer,BigDecimal>  <第几期，费用值>。  必须拉通计算所有期的费用项，因为
	 */
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
						   				InsideBusinessFeeCalcParam insideParam) throws Exception;
	
	/**
	 * 得到该算法支持的手动输入的参数
	 */
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam();
}
