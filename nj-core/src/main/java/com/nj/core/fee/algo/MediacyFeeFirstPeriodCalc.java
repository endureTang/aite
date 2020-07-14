package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.algoParam.external.MediacyFeeFirstPeriodCalcExternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.base.ManualParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 算法 {@link EBusinessFeeAlgorithm.MEDIACYFEE_FIRSTPERIOD} 的实现类
 */
public class MediacyFeeFirstPeriodCalc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数对象类型是否传入正确
		MediacyFeeFirstPeriodCalcExternalParam eParam = null;
		try {
			eParam =  (MediacyFeeFirstPeriodCalcExternalParam) externalParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为MediacyFeeFirstPeriodCalcExternalParam类型");
		}
		
		// 2.验证参数是否合法
		eParam.validate(this.getClass().getName());
		insideParam.validate();
		
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
		Integer calcPeriods = insideParam.getAccRepayPeriod();
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		
		for (int i = 1; i <=calcPeriods ; i++) {
			if(1 == i){
				result.put(i, mediacyeeTotalAmount);
			}else{
				result.put(i, BigDecimal.ZERO);
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
