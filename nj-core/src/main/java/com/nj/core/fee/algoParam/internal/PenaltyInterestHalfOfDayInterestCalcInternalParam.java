package com.nj.core.fee.algoParam.internal;

import com.nj.core.fee.base.InsideBusinessFeeCalcParam;

public class PenaltyInterestHalfOfDayInterestCalcInternalParam extends InsideBusinessFeeCalcParam{

	private Integer overdueDays;		//逾期天数
	
	@Override
	public void validateInternalOther() throws Exception {
		if(null == this.getOverdueDays()){
			throw new Exception("overdueDays不能为空");
		}
	}

	public Integer getOverdueDays() {
		return overdueDays;
	}

	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}
}
