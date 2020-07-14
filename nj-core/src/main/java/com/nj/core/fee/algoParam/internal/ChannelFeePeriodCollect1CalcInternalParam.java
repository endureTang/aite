package com.nj.core.fee.algoParam.internal;

import com.nj.core.base.util.StringUtils;
import com.nj.core.fee.base.InsideBusinessFeeCalcParam;

public class ChannelFeePeriodCollect1CalcInternalParam extends InsideBusinessFeeCalcParam{

	private String repayWay;		//还款方式
	
	@Override
	public void validateInternalOther() throws Exception {
		if(StringUtils.isEmpty(repayWay)){
			throw new Exception("参数repayWay不能为空");
		}
	}
	public String getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}

}
