package com.nj.model.datamodel;

import java.util.List;

import com.nj.core.base.entity.NjIdEntity;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.SysDict;

import io.swagger.annotations.ApiModelProperty;

public class NjProductModel extends NjIdEntity {
	
	/**
	 * 是否渠道进件
	 */
	@ApiModelProperty(value = "进件支持：0：自主进件，1：渠道进件，2：自主/渠道进件")
	private Integer isChannelInput;
	/**
	 * 产品费率
	 */
	@ApiModelProperty(value = "产品费率")
	private Double monthlyRate;
	/**
	 * 产品对象
	 */
	@ApiModelProperty(value = "产品信息")
	private NjProduct njproduct;
   
    /**
     * 所需材料
     */
    @ApiModelProperty(value = "所需材料")
    private String material;
    
    /**
     * 所需材料
     */
    @ApiModelProperty(value = "还款方式")
    private List<SysDict> repayWay;
    
    /**
     * 可待期数列表
     */
    @ApiModelProperty(value = "可待期数列表")
    private List<SysDict> termInfoList;
    
    /**
     * 借款用途列表
     */
    @ApiModelProperty(value = "借款用途列表")
    private List<SysDict> productScopeList;
    /**
     * 模板id
     */
    @ApiModelProperty(value = "模板id：1：信用类，2：房屋类")
    private Integer templateId;

	public NjProduct getNjproduct() {
		return njproduct;
	}

	public void setNjproduct(NjProduct njproduct) {
		this.njproduct = njproduct;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public List<SysDict> getTermInfoList() {
		return termInfoList;
	}

	public void setTermInfoList(List<SysDict> termInfoList) {
		this.termInfoList = termInfoList;
	}

	public List<SysDict> getProductScopeList() {
		return productScopeList;
	}

	public void setProductScopeList(List<SysDict> productScopeList) {
		this.productScopeList = productScopeList;
	}

	public Integer getIsChannelInput() {
		return isChannelInput;
	}

	public void setIsChannelInput(Integer isChannelInput) {
		this.isChannelInput = isChannelInput;
	}

	public Double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(Double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public List<SysDict> getRepayWay() {
		return repayWay;
	}

	public void setRepayWay(List<SysDict> repayWay) {
		this.repayWay = repayWay;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
}