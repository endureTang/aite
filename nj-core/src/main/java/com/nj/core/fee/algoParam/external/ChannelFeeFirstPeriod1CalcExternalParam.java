package com.nj.core.fee.algoParam.external;

import java.math.BigDecimal;

import com.nj.core.fee.base.ExterBusinessFeeCalcParam;
import com.nj.core.fee.constant.EBusinessFeeAlgorithm;

/**
 *  {@link EBusinessFeeAlgorithm.CHANNELFEE_FIRSTPERIOD_1}算法的参数
 */
public class ChannelFeeFirstPeriod1CalcExternalParam extends ExterBusinessFeeCalcParam{

	private BigDecimal loanAmount;					//客户批复的贷款金额。如：2000.00
	private BigDecimal channelFeeRate;				//趸收渠道费率。如：2%，传0.02
	
	protected void validateSysExistParam() throws Exception {
		if(null == this.getLoanAmount()){
			throw new Exception("参数loanAmount不能为空");
		}
		if(null == this.getChannelFeeRate()){
			throw new Exception("参数channelFeeRate不能为空");
		}
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getChannelFeeRate() {
		return channelFeeRate;
	}

	public void setChannelFeeRate(BigDecimal channelFeeRate) {
		this.channelFeeRate = channelFeeRate;
	}
	
}
