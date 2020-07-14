package com.nj.model.mq;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @Name com.jdcf.asset.mq.OrderMq
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年2月5日 下午4:16:25
 * @Copyright 金鼎财富
 *
 */
public class OrderMq {
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 过程编号
	 */
	@ApiModelProperty(value="过程编号")
	private int processId;
	/**
	 * 执行结果
	 */
	@ApiModelProperty(value="执行结果 1：通过,2:驳回,3:拒绝,4:暂停")
	private Short execResult;
	/**
	 * 模板编号
	 */
	@ApiModelProperty(value="流程模板编号")
	private String templateId;
	
	public OrderMq() {
		
	}
	public OrderMq(String orderId,int processId,String templateId) {
		this.orderId=orderId;
		this.processId = processId;
		this.templateId = templateId;
		this.execResult = 1;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public Short getExecResult() {
		return execResult;
	}

	public void setExecResult(Short execResult) {
		this.execResult = execResult;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	
}
