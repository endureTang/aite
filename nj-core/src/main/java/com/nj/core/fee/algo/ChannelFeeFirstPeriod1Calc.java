package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.algoParam.external.ChannelFeeFirstPeriod1CalcExternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 算法 {@link EBusinessFeeAlgorithm.CHANNELFEE_FIRSTPERIOD_1} 的实现类
 */
public class ChannelFeeFirstPeriod1Calc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数对象类型是否传入正确
		ChannelFeeFirstPeriod1CalcExternalParam eParam = null;
		try {
			eParam =  (ChannelFeeFirstPeriod1CalcExternalParam) externalParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为ChannelFeeFirstPeriod1CalcExternalParam类型");
		}
		
		// 2.验证参数是否合法
		eParam.validate(this.getClass().getName());
		insideParam.validate();
		
		// 3.计算每期渠道费
		BigDecimal loanAmount = eParam.getLoanAmount();
		BigDecimal channelFeeRate = eParam.getChannelFeeRate();
		
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		int calcPeriods = insideParam.getAccRepayPeriod();				//待计算期数
		for (int i = 1; i <= calcPeriods; i++) {
			if(i == 1){
				result.put(i, loanAmount.multiply(channelFeeRate).setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				result.put(i, BigDecimal.ZERO);
			}
		}
		
		return result;
	}

	@Override
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam() {
		
		return null;
	}

}
