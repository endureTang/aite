package com.nj.core.fee.base;

/**
 * 还款计划费用计算算法传入的内部参数，都需继承该抽象类
 * 即贷后模块需传入的参数
 */
public class InsideBusinessFeeCalcParam {

	private Integer accRepayPeriod;		//还款计划或回款计划的实际总期数
	
	/**
	 * 验证参数
	 */
	public void validate() throws Exception{
		validateAccRepayPeriod();
		validateInternalOther();
	}
	
	/**
	 * 验证
	 */
	public void validateInternalOther() throws Exception{
		
	};
	
	/**
	 * 验证accRepayPeriod参数
	 */
	public void validateAccRepayPeriod() throws Exception {
		if(null == accRepayPeriod){
			throw new Exception("参数accRepayPeriod不能为空");
		}
		if(0 == accRepayPeriod){
			throw new Exception("参数accRepayPeriod非法，不能为0");
		}
	}

	public Integer getAccRepayPeriod() {
		return accRepayPeriod;
	}

	public void setAccRepayPeriod(Integer accRepayPeriod) {
		this.accRepayPeriod = accRepayPeriod;
	}
}
