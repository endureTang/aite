package com.nj.core.fee.algoParam.internal;

import com.nj.core.fee.base.InsideBusinessFeeCalcParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;

/**
 * {@link EBusinessFeeAlgorithm.MEDIACYFEE_AVGTOPERIOD} 算法的内部参数
 */
public class MediacyFeeAvgToPerioCalcInternalParam extends InsideBusinessFeeCalcParam{
	
	private String repayWay;		//还款方式

	@Override
	public void validateInternalOther() throws Exception {
		
	}

	public String getRepayWay() {
		return repayWay;
	}

	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}
	
}
