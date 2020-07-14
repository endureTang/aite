package com.nj.mongoModel.bh;

import java.util.Date;

import com.nj.mongoModel.MongoEntity;

/**
 * 非循环贷款贷后数据
 * @author MaSong
 * @date 2019-08-07
 */
public class BhUploadD3 extends MongoEntity{
	
	/**请求ID*/
	private String reqId;
	
	/**状态:0失败 1成功*/
	private int status;
	
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
	
	/**请求ID,内部系统*/
	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

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

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
