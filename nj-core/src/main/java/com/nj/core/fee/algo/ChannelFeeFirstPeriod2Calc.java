package com.nj.core.fee.algo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.base.IBusinessFeeCalc;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.base.ManualParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;
import com.nj.core.fee.constant.EBusinessFeeAlgorithmManualParam;

/**
 * 算法 {@link EBusinessFeeAlgorithm.CHANNELFEE_FIRSTPERIOD_2} 的实现类
 */
public class ChannelFeeFirstPeriod2Calc implements IBusinessFeeCalc{

	@Override
	public Map<Integer,BigDecimal> calc(ExterBusinessFeeCalcParam externalParam,
										InsideBusinessFeeCalcParam insideParam) throws Exception {
		
		// 1.验证参数是否合法
		externalParam.validate(this.getClass().getName());
		insideParam.validate();
		
		// 2.计算每期渠道费
		// 2.1 获取放款时手动输入的渠道费总额
		BigDecimal channelFeeTotalAmount = BigDecimal.ZERO;		//渠道费总额
		List<ManualParam> manualParamList = externalParam.getManualParams();
		for (ManualParam manualParam : manualParamList) {
			if(manualParam.getCode().equals(EBusinessFeeAlgorithmManualParam.CHANNELFEE_TOTALAMOUNT.getCode())){
				channelFeeTotalAmount = manualParam.getValue();
			}
		}
		
		// 2.2得到每期的渠道费
		Map<Integer,BigDecimal> result = new HashMap<Integer, BigDecimal>();
		int calcPeriods = insideParam.getAccRepayPeriod();				//待计算期数
		
		for (int i = 1; i <= calcPeriods; i++) {
			if(i == 1){		//最后一期单独处理，防止除不尽的情况
				result.put(i, channelFeeTotalAmount);
			}else{
				result.put(i, BigDecimal.ZERO);
			}
		}
		
		return result;
	}

	@Override
	public List<EBusinessFeeAlgorithmManualParam> getSupportManualParam() {
		List<EBusinessFeeAlgorithmManualParam> channelFeeData = new ArrayList<EBusinessFeeAlgorithmManualParam>();
		channelFeeData.add(EBusinessFeeAlgorithmManualParam.CHANNELFEE_TOTALAMOUNT);
		return channelFeeData;
	}

}
