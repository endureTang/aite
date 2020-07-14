package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjProductTemp {
    private String id;

	/**
	 * 产品Id
	 */
	@ApiModelProperty(value = "产品Id")
	private String productId;

	/**
	 * 产品模板id（1：信用类，2：房屋类）
	 */
	@ApiModelProperty(value = "产品模板id（1：信用类，2：房屋类）")
	private Integer templateId;

	/**
	 * 流程模板id
	 */
	@ApiModelProperty(value = "流程模板id")
	private String processTemplateId;

	/**
	 * @return  id 
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id  
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 产品Id
	 * @return  product_id 产品Id
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * 产品Id
	 * @param productId  产品Id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 产品模板id（1：信用类，2：房屋类）
	 * @return  template_id 产品模板id（1：信用类，2：房屋类）
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * 产品模板id（1：信用类，2：房屋类）
	 * @param templateId  产品模板id（1：信用类，2：房屋类）
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * 流程模板id
	 * @return  process_template_id 流程模板id
	 */
	public String getProcessTemplateId() {
		return processTemplateId;
	}

	/**
	 * 流程模板id
	 * @param processTemplateId  流程模板id
	 */
	public void setProcessTemplateId(String processTemplateId) {
		this.processTemplateId = processTemplateId;
	}

	
}