package com.nj.mongoModel.bh;

import java.util.Date;

import com.nj.mongoModel.MongoEntity;

/**
 * 百行征信查询实体
 * @author MaSong
 * @date 2019-08-05
 */
public class BhQuery extends MongoEntity{
	
	/**查询报告ID,该字段是百行征信返回*/
	private String reportId;
	
	/**公司编号*/
	private String companyCode;
	
	/**公司名称*/
	private String companyName;
	
	/**查询人的手机号码*/
	private String mobile;
	
	/**查询人姓名*/
	private String name;
	
	/**查询人身份证*/
	private String idCard;
	
	/**贷款ID*/
	private String loanId;
	
	/**请求信息*/
	private String requsetMsg;
	
	/**返回信息*/
	private String responseMsg;
	
	/**创建时间*/
	private Date  createTime;
	
	private String reqID;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRequsetMsg() {
		return requsetMsg;
	}

	public void setRequsetMsg(String requsetMsg) {
		this.requsetMsg = requsetMsg;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getReqID() {
		return reqID;
	}

	public void setReqID(String reqID) {
		this.reqID = reqID;
	}

	
	
}
