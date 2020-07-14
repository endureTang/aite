package com.nj.bean;

import java.util.List;

import com.nj.model.datamodel.FeeCodeValue;

/**
 * 线下还款时，接受参数用的bean
 */
public class OfflineRepayBean {

	private String orderNo;					//订单编号
	private Integer period;					//期数
	private String accRepayDate;			//实际还款时间。非必填
	private String repayStatus;				//还款状态。非必填：扣款成功要填，失败不填
	private String deductionResult;			//扣款情况。
	private String rpCodeValue;				//还款计划的实还编码和值
	private String mbCodeValue;				//回款计划的的实还编码和值
	
	private List<FeeCodeValue> rpFeeInfoList;	//还款计划费用信息列表
	private List<FeeCodeValue> mbFeeInfoList;	//回款计划费用信息列表
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getAccRepayDate() {
		return accRepayDate;
	}
	public void setAccRepayDate(String accRepayDate) {
		this.accRepayDate = accRepayDate;
	}
	public String getRepayStatus() {
		return repayStatus;
	}
	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}
	public String getDeductionResult() {
		return deductionResult;
	}
	public void setDeductionResult(String deductionResult) {
		this.deductionResult = deductionResult;
	}
	public String getRpCodeValue() {
		return rpCodeValue;
	}
	public void setRpCodeValue(String rpCodeValue) {
		this.rpCodeValue = rpCodeValue;
	}
	public String getMbCodeValue() {
		return mbCodeValue;
	}
	public void setMbCodeValue(String mbCodeValue) {
		this.mbCodeValue = mbCodeValue;
	}
	public List<FeeCodeValue> getRpFeeInfoList() {
		return rpFeeInfoList;
	}
	public void setRpFeeInfoList(List<FeeCodeValue> rpFeeInfoList) {
		this.rpFeeInfoList = rpFeeInfoList;
	}
	public List<FeeCodeValue> getMbFeeInfoList() {
		return mbFeeInfoList;
	}
	public void setMbFeeInfoList(List<FeeCodeValue> mbFeeInfoList) {
		this.mbFeeInfoList = mbFeeInfoList;
	}
	
}
