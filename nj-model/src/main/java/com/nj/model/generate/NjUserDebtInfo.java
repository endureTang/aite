package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserDebtInfo {

	private String id;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private String userId;
	private String orgName;
	private BigDecimal loanMoney;
	private String warrantWay;
	private Boolean delFlag;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	private Date beginTime;
	private Date endTime;
	private Integer version;

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
	 * 用户ID
	 * @return  user_id 用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户ID
	 * @param userId  用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return  org_name 
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName  
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return  loan_money 
	 */
	public BigDecimal getLoanMoney() {
		return loanMoney;
	}

	/**
	 * @param loanMoney  
	 */
	public void setLoanMoney(BigDecimal loanMoney) {
		this.loanMoney = loanMoney;
	}

	/**
	 * @return  warrant_way 
	 */
	public String getWarrantWay() {
		return warrantWay;
	}

	/**
	 * @param warrantWay  
	 */
	public void setWarrantWay(String warrantWay) {
		this.warrantWay = warrantWay;
	}

	/**
	 * @return  del_flag 
	 */
	public Boolean getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag  
	 */
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 创建时间
	 * @return  create_time 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * @param createTime  创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return  begin_time 
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime  
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return  end_time 
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime  
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return  version 
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version  
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}