package com.nj.core.fee.base;

import java.math.BigDecimal;

/**
 * 放款时，业务员手动输入的参数
 */
public class ManualParam {

	private String code;			//手动输入参数的code，对应EBusinessFeeAlgorithmManualParam的code
	private BigDecimal value;		//参数的值
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
