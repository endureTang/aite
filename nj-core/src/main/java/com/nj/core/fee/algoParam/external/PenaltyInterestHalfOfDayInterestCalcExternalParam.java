package com.nj.core.fee.algoParam.external;

import java.math.BigDecimal;

import com.nj.core.fee.base.ExterBusinessFeeCalcParam;

/**
 * EBusinessFeeAlgorithm.PENALTYINTEREST_HALFOFDAYINTEREST 算法的参数
 */
public class PenaltyInterestHalfOfDayInterestCalcExternalParam extends ExterBusinessFeeCalcParam{

	private BigDecimal loanAmount;		//客户批复贷款金额。如：2000.00
	private BigDecimal yearRate;		//贷款年利息。如：年利率10%,传0.1
	
	/**
	 * 验证 参数
	 */
	@Override
	public void validateSysExistParam() throws Exception {
		if(null == this.getLoanAmount()){
			throw new Exception("loanAmount不能为空");
		}
		if(null == this.getYearRate()){
			throw new Exception("yearRate不能为空");
		}
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getYearRate() {
		return yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}
}
