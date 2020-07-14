package com.nj.model.mq;

/**
 * 
 * @Name com.nj.model.mq.OutsideApiMq
 * @Description 外部数据接口调用消息队列
 * 
 * @Author bruce
 * @Version 2018年5月25日 下午2:22:42
 * @Copyright 金鼎财富
 *
 */
public class OutsideApiMq {
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 外部接口关键字
	 */
	private String apiKeyword;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getApiKeyword() {
		return apiKeyword;
	}
	public void setApiKeyword(String apiKeyword) {
		this.apiKeyword = apiKeyword;
	}
	
}
