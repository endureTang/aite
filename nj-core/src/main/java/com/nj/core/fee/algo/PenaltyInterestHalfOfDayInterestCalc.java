package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.algoParam.external.PenaltyInterestHalfOfDayInterestCalcExternalParam;
import com.nj.core.fee.algoParam.internal.PenaltyInterestHalfOfDayInterestCalcInternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 *  算法 {@link EBusinessFeeAlgorithm.PENALTYINTEREST_HALFOFDAYINTEREST} 的实现类
 */
public class PenaltyInterestHalfOfDayInterestCalc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数对象类型是否传入正确
		PenaltyInterestHalfOfDayInterestCalcExternalParam eParam = null;
		try {
			eParam =  (PenaltyInterestHalfOfDayInterestCalcExternalParam) externalParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为"+PenaltyInterestHalfOfDayInterestCalcExternalParam.class.getName()+"类型");
		}
		
		PenaltyInterestHalfOfDayInterestCalcInternalParam iParam = null;
		try {
			iParam = (PenaltyInterestHalfOfDayInterestCalcInternalParam) insideParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为PenaltyInterestNotCalcInternalParam类型");
		}
		
		// 2.验证参数是否合法
		eParam.validate(this.getClass().getName());
		iParam.validate();
		
		// 3.获取该算法必要参数，进行计算
		BigDecimal loanAmount = eParam.getLoanAmount();
		BigDecimal yearRate = eParam.getYearRate();
		Integer overdueDays = iParam.getOverdueDays();
		if(null == overdueDays){
			overdueDays = 0;
		}
		// 计算日逾期罚息利率
		BigDecimal dayOverdueRate = yearRate.divide(new BigDecimal(12), 6, BigDecimal.ROUND_HALF_UP)	
							        		.divide(new BigDecimal(30), 6, BigDecimal.ROUND_HALF_UP)
							        		.multiply(new BigDecimal(0.5));
		
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		for (int i = 1; i <= iParam.getAccRepayPeriod(); i++) {
			BigDecimal planPenInter = loanAmount.multiply(dayOverdueRate).multiply(new BigDecimal(overdueDays)).setScale(2, BigDecimal.ROUND_HALF_UP);
			result.put(i, planPenInter);
		}
		
		return result;
	}

	@Override
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam() {
		return null;
	}
}
