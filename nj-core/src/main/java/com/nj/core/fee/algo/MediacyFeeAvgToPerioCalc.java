package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.algoParam.external.MediacyFeeAvgToPerioCalcExternalParam;
import com.nj.core.fee.algoParam.internal.MediacyFeeAvgToPerioCalcInternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.base.ManualParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 算法 {@link EBusinessFeeAlgorithm.MEDIACYFEE_AVGTOPERIOD} 的实现类
 */
public class MediacyFeeAvgToPerioCalc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数对象类型是否传入正确
		MediacyFeeAvgToPerioCalcExternalParam eParam = null;
		try {
			eParam =  (MediacyFeeAvgToPerioCalcExternalParam) externalParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为MediacyFeeAvgToPerioCalcExternalParam类型");
		}
		
		MediacyFeeAvgToPerioCalcInternalParam iParam = null;
		try {
			iParam = (MediacyFeeAvgToPerioCalcInternalParam) insideParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为MediacyFeeAvgToPerioCalcInternalParam类型");
		}
		
		// 2.验证参数是否合法
		eParam.validate(this.getClass().getName());
		iParam.validate();
		
		// 3.计算
		// 3.1得到居间费总额
		BigDecimal mediacyeeTotalAmount = BigDecimal.ZERO;		//居间费总额
		List<ManualParam> manualParamList = eParam.getManualParams();
		for (ManualParam manualParam : manualParamList) {
			if(manualParam.getCode().equals(EBusinessFeeAlgorithmManualParam.MEDIACYFEE_TOTALAMOUNT.getCode())){
				mediacyeeTotalAmount = manualParam.getValue();
			}
		}
		
		// 3.2得到每期的居间费
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		
		int calcPeriods = iParam.getAccRepayPeriod();				//待计算期数
		if(iParam.getRepayWay().contains("10101")){					//若是先息后本，则最后一期不算渠道费
			calcPeriods = calcPeriods -1;
		}
		BigDecimal avgMediacyee = mediacyeeTotalAmount.divide(new BigDecimal(calcPeriods),2,BigDecimal.ROUND_HALF_UP);		//每期平均居间费
		for (int i = 1; i <= calcPeriods; i++) {
			if(i == calcPeriods){		//最后一期单独处理，防止除不尽的情况
				result.put(i, mediacyeeTotalAmount.subtract(avgMediacyee.multiply(new BigDecimal(calcPeriods - 1))));
			}else{
				result.put(i, avgMediacyee);
			}
		}
		return result;
	}

	@Override
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam() {
		List<EBusinessFeeAlgorithmManualParam> mediacyfeeData = new ArrayList<EBusinessFeeAlgorithmManualParam>();
		mediacyfeeData.add(EBusinessFeeAlgorithmManualParam.MEDIACYFEE_TOTALAMOUNT);
		return mediacyfeeData;
	}
}
