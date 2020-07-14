package com.nj.model.vo;

import java.lang.reflect.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class WithdrawingPageVo {

	@ApiModelProperty(name="订单号")
	private String orderNo;
	@ApiModelProperty(name="期数")
	private Integer period;
	@ApiModelProperty(name="还款计划的实还编码和值")
	private String rpCodeValue;
	@ApiModelProperty(name="回款计划的实还编码和值")
	private String mbCodeValue;
	@ApiModelProperty(name="回款类型")
	private String payBackType;
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
	public String getPayBackType() {
		return payBackType;
	}
	public void setPayBackType(String payBackType) {
		this.payBackType = payBackType;
	}
	@Override
	public String toString() {
		return "WithdrawingPageVo [orderNo=" + orderNo + ", period=" + period + ", rpCodeValue=" + rpCodeValue
				+ ", mbCodeValue=" + mbCodeValue + ", payBackType=" + payBackType + "]";
	}
	
	
}
