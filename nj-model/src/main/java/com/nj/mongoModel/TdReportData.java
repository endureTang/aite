/**
 * Copyright 2018 bejson.com
 */
package com.nj.mongoModel;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auto-generated: 2018-04-28 9:4:20
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel("同盾报告model")
public class TdReportData extends MongoEntity{
	@ApiModelProperty("用户id")
	private String userId;
	@ApiModelProperty("接口调用是否成功")
	private boolean success;
	@ApiModelProperty("错误代码")
	private String reason_code;
	@ApiModelProperty("错误描述")
	private String reason_desc;
	@ApiModelProperty("风险分数")
	private Integer final_score;
	@ApiModelProperty("风险结果")
	private String final_decision;
	@ApiModelProperty("报告编号")
	private String report_id;
	@ApiModelProperty("设备类型")
	private String device_typeo;
	@ApiModelProperty("代理信息")	
	private String proxy_info;
	@ApiModelProperty("扫描时间")	
	private Long apply_time;
	@ApiModelProperty("报告时间")	
	private Long report_time;
	@ApiModelProperty("设备环境信息")	
	private Map<String, Object> device_info;
	@ApiModelProperty("地理位置信息")	
	private Map<String, Object> geo_ip;
	@ApiModelProperty("真实地理位置信息")	
	private Map<String, Object> geo_trueip;
	@ApiModelProperty("扫描出来的风险项")	
	private String risk_items;
	@ApiModelProperty("归属地解析")	
	private Map<String, Object> address_detect;
	@ApiModelProperty("申请编号")	
	private String application_id;
	@ApiModelProperty("信用分")	
	private String credit_score;
	@ApiModelProperty("姓名")
	private String name;
	@ApiModelProperty("身份证")	
	private String id_number;
	@ApiModelProperty("电话")	
	private String mobile;
	@ApiModelProperty("企业id")
	private String companyId;
	@ApiModelProperty("审核结果（中文）")
	private String finalSuggest;

	@ApiModelProperty("订单ID")
	private String OrderId;
	
	public String getFinalSuggest() {
		if(final_decision == null || final_decision.equals("")) {
			finalSuggest = "结果未明";
		}else if(final_decision.equals("Accept")) {
			finalSuggest = "建议通过";
		}else if(final_decision.equals("Review")) {
			finalSuggest = "建议审核";
		}else if(final_decision.equals("Reject")) {
			finalSuggest = "建议拒绝";
		}
		return finalSuggest;
	}
	public void setFinalSuggest(String finalSuggest) {
		this.finalSuggest = finalSuggest;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getReason_code() {
		return reason_code;
	}
	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}
	public String getReason_desc() {
		return reason_desc;
	}
	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}
	public Integer getFinal_score() {
		return final_score;
	}
	public void setFinal_score(Integer final_score) {
		this.final_score = final_score;
	}
	public String getFinal_decision() {
		return final_decision;
	}
	public void setFinal_decision(String final_decision) {
		this.final_decision = final_decision;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getDevice_typeo() {
		return device_typeo;
	}
	public void setDevice_typeo(String device_typeo) {
		this.device_typeo = device_typeo;
	}
	public String getProxy_info() {
		return proxy_info;
	}
	public void setProxy_info(String proxy_info) {
		this.proxy_info = proxy_info;
	}
	public Long getApply_time() {
		return apply_time;
	}
	public void setApply_time(Long apply_time) {
		this.apply_time = apply_time;
	}
	public Long getReport_time() {
		return report_time;
	}
	public void setReport_time(Long report_time) {
		this.report_time = report_time;
	}
	public Map<String, Object> getDevice_info() {
		return device_info;
	}
	public void setDevice_info(Map<String, Object> device_info) {
		this.device_info = device_info;
	}
	public Map<String, Object> getGeo_ip() {
		return geo_ip;
	}
	public void setGeo_ip(Map<String, Object> geo_ip) {
		this.geo_ip = geo_ip;
	}
	public Map<String, Object> getGeo_trueip() {
		return geo_trueip;
	}
	public void setGeo_trueip(Map<String, Object> geo_trueip) {
		this.geo_trueip = geo_trueip;
	}
	public String getRisk_items() {
		return risk_items;
	}
	public void setRisk_items(String risk_items) {
		this.risk_items = risk_items;
	}
	public Map<String, Object> getAddress_detect() {
		return address_detect;
	}
	public void setAddress_detect(Map<String, Object> address_detect) {
		this.address_detect = address_detect;
	}
	public String getApplication_id() {
		return application_id;
	}
	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}
	public String getCredit_score() {
		return credit_score;
	}
	public void setCredit_score(String credit_score) {
		this.credit_score = credit_score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
}