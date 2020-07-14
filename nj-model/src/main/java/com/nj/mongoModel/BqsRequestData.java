package com.nj.mongoModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 白骑士请求数据 -该类暂不使用
 * @author MaSong
 * @date 2018-06-08 11:06:11
 */
@ApiModel("白骑士请求数据")
public class BqsRequestData extends MongoEntity {
	
	/**用户ID*/
	@ApiModelProperty("用户ID")
    private String userId;  
    
    /**订单ID*/
	@ApiModelProperty("订单ID")
    private String orderId;      
    
    /**事件类型：详细参考白骑士技术文档5.2*/
	@ApiModelProperty("事件类型：详细参考白骑士技术文档5.2")
    private String eventType; 
    
    /**会话标识*/
	@ApiModelProperty("会话标识")
    private String tokenKey;
    
    /**芝麻信用的OpenId*/
	@ApiModelProperty("芝麻信用openId")
    private String zmOpenId;
    
    /**应用平台类型：h5、web、android、ios*/
	@ApiModelProperty("应用平台类型")
    private String platform;
    
    /**是否需要返回命中规则明细数字*/
	@ApiModelProperty("否需要返回命中规则明细数字")
    private String returnRuleDetail;
    
    /**用户账号*/
	@ApiModelProperty("用户账号")
    private String account;
    
    /**姓名*/
	@ApiModelProperty("姓名")
    private String name;
    
    /**邮箱*/
	@ApiModelProperty("邮箱")
    private String email;
    
    /**手机号码*/
	@ApiModelProperty("手机号码")
    private String mobile;
    
    /**身份证号码*/
	@ApiModelProperty("身份证号码")
    private String certNo;
    
    /**用户住址*/
	@ApiModelProperty("用户住址")
    private String address;
    
    /**用户所在城市*/
	@ApiModelProperty("用户所在城市")
    private String addressCity;
    
    /**用户联系人姓名*/
	@ApiModelProperty("用户联系人姓名")
    private String contactsName;
	
	/**用户联系人手机号*/
	@ApiModelProperty("用户联系人手机号")
	private String contactsMobile;
	
	/**用户第二联系人姓名*/
	@ApiModelProperty("用户第二联系人姓名")
	private String contactsNameSec;
    
	/**用户第二联系人手机号*/
	@ApiModelProperty("用户第二联系人手机号")
	private String contactsMobileSec;
	
	/**用户工作单位名称*/
	@ApiModelProperty("用户工作单位名称")
	private String organization;
	
	/**用户工作单位地址*/
	@ApiModelProperty("用户工作单位地址")
	private String organizationAddress;
	
	/**学历：文盲或半文盲、初中、高中、中专或技校、大专、大学本科、研究生、博士*/
	@ApiModelProperty("学历")
	private String education;

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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getZmOpenId() {
		return zmOpenId;
	}

	public void setZmOpenId(String zmOpenId) {
		this.zmOpenId = zmOpenId;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getReturnRuleDetail() {
		return returnRuleDetail;
	}

	public void setReturnRuleDetail(String returnRuleDetail) {
		this.returnRuleDetail = returnRuleDetail;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsMobile() {
		return contactsMobile;
	}

	public void setContactsMobile(String contactsMobile) {
		this.contactsMobile = contactsMobile;
	}

	public String getContactsNameSec() {
		return contactsNameSec;
	}

	public void setContactsNameSec(String contactsNameSec) {
		this.contactsNameSec = contactsNameSec;
	}

	public String getContactsMobileSec() {
		return contactsMobileSec;
	}

	public void setContactsMobileSec(String contactsMobileSec) {
		this.contactsMobileSec = contactsMobileSec;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
    
}
