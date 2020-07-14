package com.nj.model.datamodel;

/**
 * 
 * @Name com.nj.model.datamodel.ExamineUserDO
 * @Description 审批用户工作情况
 * 
 * @Author bruce
 * @Version 2018年2月8日 下午4:38:26
 * @Copyright 金鼎财富
 *
 */
public class ExamineUserDO {
	private String id;
	private String userName;
	/**
	 * 派单总件数
	 */
	private int totalNumber=0;
	/**
	 * 剩余数量
	 */
	private int overplusNumber=0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getOverplusNumber() {
		return overplusNumber;
	}
	public void setOverplusNumber(int overplusNumber) {
		this.overplusNumber = overplusNumber;
	}
	
}
