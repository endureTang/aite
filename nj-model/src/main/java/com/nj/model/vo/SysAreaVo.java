package com.nj.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 区域VO，主要用于查询
 * @author MaSong
 * @date 2018-07-24 10:05:35
 */
public class SysAreaVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String id;
	private List<SysAreaVo> cityList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<SysAreaVo> getCityList() {
		return cityList;
	}
	public void setCityList(List<SysAreaVo> cityList) {
		this.cityList = cityList;
	}
	
	
	
}
