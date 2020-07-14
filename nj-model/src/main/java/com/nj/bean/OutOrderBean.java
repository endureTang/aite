package com.nj.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 第三方进件实体类
 * @author MaSong
 */
public class OutOrderBean {
	
	/**产品编号*/
	@NotBlank(message="产品编号不能为空")
	private String productCode;
	
	/***商品订单编号不能为空*/
	@NotBlank(message="商品订单编号不能为空")
	private String orderCode; 
	
	/***订单创建时间*/
	private Date createDate;
	
	/**用户ID*/
	@NotBlank(message="用户id不能为空")
	private String userId;
	
	/**申请金额*/
	@NotNull(message="申请金额不能为空")
	private BigDecimal applySum;
	
	/**申请期限*/
	@NotNull(message="申请期限不能为空")
	private Integer applyPeriod;
	
	/**申请用途*/
	@NotNull(message="申请用途不能为空")
	private String purpose;
	
	/**工作信息*/
	private List<OutWorkInfoBean> workInfo;
	
	/**基本信息*/
	@NotNull(message="申请人基本信息不能为空")
	@Valid
	private OutBasicInfoBean basicInfo;
	
	/**证件信息*/
	private OutCertInfo certInfo;
	
	/**房屋信息*/
	private List<OutHouseInfo> houseInfo;
	
	/**车辆信息*/
	private List<OutCarInfo> carInfo;
	
	/**芝麻分和活体识别图，该字段暂时未使用*/
	private OutUntiFraudInfo untiFraudInfo;
	
	/**实际借款人ID*/
	private String realBorrowId;
	
	/**实际还款人ID*/
	private String realPayIdl;
	
	/**订单回调接口*/
	@NotBlank(message="订单回调接口不能为空")
	private String callbackUrl;
	
	/**扣款回调接口*/
	private String diductionCallbackUrl;
	
	/**联系人*/
	//@NotNull(message="申请人联系人信息不能为空")
	//@Valid
	private List<OutRelativeBean> relativeInfo;
	
	/**放款方式 0 线下、 1线上*/
	private Integer lendType=1;
	
	/**还款来源*/
	private String repaySource;
	
	/**项目详情*/
	private String projectDetail;
	/**
	 * 放款时间，该时间没有任何意义，主要用于注册期望放款时间
	 */
	private String makeLoansDate;
	/**
	 * 合同地址
	 */
	private String contractUrl;
	
	/**项目总金额,例如手机总价格,如果没有分期,该字段跟借款金额一致*/
	private BigDecimal projectAmount;
	
	/**首付款*/
	private BigDecimal firstAmount;
	
	/**项目名称，例如购买的是什么牌子型号的手机*/
	private String projectName;
	
	/**综合费率*/
	private String totalRating;
	
	/**期收服务费类型：1:固定金额,2:比例,*/
	private Integer bondType;
	
	/**期收服务费率，当类型为2时，该值为年化的带%*/
	private String bondValue;
	
	/**商户信息*/
	private OutMerchantInfo merchantInfo;
	
	public OutMerchantInfo getMerchantInfo() {
		return merchantInfo;
	}
	public void setMerchantInfo(OutMerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}
	public String getTotalRating() {
		return totalRating;
	}
	public Integer getBondType() {
		return bondType;
	}
	public void setBondType(Integer bondType) {
		this.bondType = bondType;
	}
	public String getBondValue() {
		return bondValue;
	}
	public void setBondValue(String bondValue) {
		this.bondValue = bondValue;
	}
	public void setTotalRating(String totalRating) {
		this.totalRating = totalRating;
	}
	public String getRepaySource() {
		return repaySource;
	}
	public void setRepaySource(String repaySource) {
		this.repaySource = repaySource;
	}
	public String getProjectDetail() {
		return projectDetail;
	}
	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}
	public List<OutRelativeBean> getRelativeInfo() {
		return relativeInfo;
	}
	public void setRelativeInfo(List<OutRelativeBean> relativeInfo) {
		this.relativeInfo = relativeInfo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BigDecimal getApplySum() {
		return applySum;
	}
	public void setApplySum(BigDecimal applySum) {
		this.applySum = applySum;
	}
	public Integer getApplyPeriod() {
		return applyPeriod;
	}
	public void setApplyPeriod(Integer applyPeriod) {
		this.applyPeriod = applyPeriod;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public List<OutWorkInfoBean> getWorkInfo() {
		return workInfo;
	}
	public void setWorkInfo(List<OutWorkInfoBean> workInfo) {
		this.workInfo = workInfo;
	}
	public OutBasicInfoBean getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(OutBasicInfoBean basicInfo) {
		this.basicInfo = basicInfo;
	}
	public OutCertInfo getCertInfo() {
		return certInfo;
	}
	public void setCertInfo(OutCertInfo certInfo) {
		this.certInfo = certInfo;
	}
	public List<OutHouseInfo> getHouseInfo() {
		return houseInfo;
	}
	public void setHouseInfo(List<OutHouseInfo> houseInfo) {
		this.houseInfo = houseInfo;
	}
	public List<OutCarInfo> getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(List<OutCarInfo> carInfo) {
		this.carInfo = carInfo;
	}
	public OutUntiFraudInfo getUntiFraudInfo() {
		return untiFraudInfo;
	}
	public void setUntiFraudInfo(OutUntiFraudInfo untiFraudInfo) {
		this.untiFraudInfo = untiFraudInfo;
	}
	public String getRealBorrowId() {
		return realBorrowId;
	}
	public void setRealBorrowId(String realBorrowId) {
		this.realBorrowId = realBorrowId;
	}
	public String getRealPayIdl() {
		return realPayIdl;
	}
	public void setRealPayIdl(String realPayIdl) {
		this.realPayIdl = realPayIdl;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public Integer getLendType() {
		return lendType;
	}
	public void setLendType(Integer lendType) {
		this.lendType = lendType;
	}
	public String getMakeLoansDate() {
		return makeLoansDate;
	}
	public void setMakeLoansDate(String makeLoansDate) {
		this.makeLoansDate = makeLoansDate;
	}

	public String getContractUrl() {
		return contractUrl;
	}

	public void setContractUrl(String contractUrl) {
		this.contractUrl = contractUrl;
	}
	public BigDecimal getProjectAmount() {
		return projectAmount;
	}
	public void setProjectAmount(BigDecimal projectAmount) {
		this.projectAmount = projectAmount;
	}
	public BigDecimal getFirstAmount() {
		return firstAmount;
	}
	public void setFirstAmount(BigDecimal firstAmount) {
		this.firstAmount = firstAmount;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDiductionCallbackUrl() {
		return diductionCallbackUrl;
	}
	public void setDiductionCallbackUrl(String diductionCallbackUrl) {
		this.diductionCallbackUrl = diductionCallbackUrl;
	}
	
}
