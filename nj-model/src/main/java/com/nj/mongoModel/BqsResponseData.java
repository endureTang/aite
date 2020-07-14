package com.nj.mongoModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 白骑士响应数据
 * @author MaSong
 * @date 2018-06-08 11:06:28
 */
@ApiModel(description="白骑士响应数据")
public class BqsResponseData extends MongoEntity {
	
	/**用户ID*/
	@ApiModelProperty("用户ID")
    private String userId;  
    
    /**订单ID*/
	@ApiModelProperty("订单ID")
    private String orderId;  
	
    /**订单ID*/
	@ApiModelProperty("公司ID")
	private String companyId;
	
	/**姓名*/
	@ApiModelProperty("姓名")
	private String name;
	
	/**身份证信息*/
	@ApiModelProperty("身份证信息")
	private String certNo;
	
	/**手机号码*/
	@ApiModelProperty("手机号码")
	private String mobile;
	
	/**事件类型*/
	@ApiModelProperty("事件类型")
	private String eventType;
	
	/**结果码,成功:BQS000,失败：BQS101*/
	@ApiModelProperty("结果码,成功:BQS000,失败：BQS101")
	private String resultCode;
	
    /**结果描述，该字段可空*/
	@ApiModelProperty("结果描述，该字段可空")
	private String resultDesc;
	
	/**流水号*/
	@ApiModelProperty("流水号")
	private String flowNo;
	
	/**决策结果码*/
	@ApiModelProperty("决策结果码")
	private String finalDecision;
	
	/**最终风险系数，只有权重策略模式下有效,该字段可空*/
	@ApiModelProperty("最终风险系数")
	private String finalScore;
	
	/**策略集内容明细*/
	@ApiModelProperty("策略集内容明细")
	private String strategySet;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getFlowNo() {
		return flowNo;
	}

	public void setFlowNo(String flowNo) {
		this.flowNo = flowNo;
	}

	public String getFinalDecision() {
		return finalDecision;
	}

	public void setFinalDecision(String finalDecision) {
		this.finalDecision = finalDecision;
	}

	public String getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}

	public String getStrategySet() {
		return strategySet;
	}

	public void setStrategySet(String strategySet) {
		this.strategySet = strategySet;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	
}
