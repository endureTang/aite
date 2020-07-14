package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.algoParam.external.ChannelFeePeriodCollect1CalcExternalParam;
import com.nj.core.fee.algoParam.internal.ChannelFeePeriodCollect1CalcInternalParam;
import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 算法 {@link EBusinessFeeAlgorithm.CHANNELFEE_PERIODCOLLECT_1} 的实现类
 */
public class ChannelFeePeriodCollect1Calc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数对象类型是否传入正确
		ChannelFeePeriodCollect1CalcExternalParam eParam = null;
		try {
			eParam =  (ChannelFeePeriodCollect1CalcExternalParam) externalParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为ChannelFeePeriodCollect1CalcExternalParam类型");
		}
		
		ChannelFeePeriodCollect1CalcInternalParam iParam = null;
		try {
			iParam = (ChannelFeePeriodCollect1CalcInternalParam) insideParam;
		} catch (Exception e) {
			throw new Exception("传入的参数对象类型不对，应为ChannelFeePeriodCollect1CalcInternalParam类型");
		}
		
		// 2.验证参数是否合法
		eParam.validate(this.getClass().getName());
		iParam.validate();
		
		// 3.计算每期渠道费
		BigDecimal loanAmount = eParam.getLoanAmount();
		BigDecimal channelFeeRateForMonth = eParam.getChannelFeeRateForMonth();
		
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		int calcPeriods = iParam.getAccRepayPeriod();				//待计算期数
		if(iParam.getRepayWay().contains("10101")){					//若是先息后本，则最后一期不算渠道费
			calcPeriods = calcPeriods -1;
		}
		for (int i = 1; i <= calcPeriods; i++) {
			result.put(i, loanAmount.multiply(channelFeeRateForMonth).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		
		return result;
	}

	@Override
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam() {
		
		return null;
	}

}
