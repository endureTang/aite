package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

public class NjUserHouse {

	private String id;
	private String name;
	private String address;
	private BigDecimal buyPrice;
	private Boolean delFlag;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private String userId;
	private String province;
	private String city;
	private String county;
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
	 * @return  name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return  address 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address  
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return  buy_price 
	 */
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice  
	 */
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
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
	 * @return  create_date 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate  
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return  create_by 
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy  
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return  update_date 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate  
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return  update_by 
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy  
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return  user_id 
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId  
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return  province 
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province  
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return  city 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city  
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return  county 
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county  
	 */
	public void setCounty(String county) {
		this.county = county;
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