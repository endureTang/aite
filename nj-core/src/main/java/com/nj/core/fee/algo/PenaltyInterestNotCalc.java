package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.algoParam.external.PenaltyInterestNotCalcExternalParam;
import com.nj.core.fee.algoParam.internal.PenaltyInterestNotCalcInternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 算法 {@link EBusinessFeeAlgorithm.PENALTYINTEREST_NOTCALC} 的实现类
 */
public class PenaltyInterestNotCalc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数对象类型是否传入正确
		PenaltyInterestNotCalcExternalParam eParam = null;
		try {
			eParam =  (PenaltyInterestNotCalcExternalParam) externalParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为PenaltyInterestNotCalcParam类型");
		}
		
		PenaltyInterestNotCalcInternalParam iParam = null;
		try {
			iParam = (PenaltyInterestNotCalcInternalParam) insideParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为PenaltyInterestNotCalcInternalParam类型");
		}
		
		// 2.验证参数是否合法
		eParam.validate(this.getClass().getName());
		iParam.validate();
		
		// 3.该算法不计算罚息，因此返回null
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		for (int i = 1; i <= iParam.getAccRepayPeriod(); i++) {
			result.put(i, null);
		}
		return result;
	}

	@Override
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam() {
		
		return null;
	}

}
