package com.nj.model.datamodel;

import java.util.Date;

import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 
 * @Name com.nj.model.datamodel.ExportOrderModel
 * @Description 导出订单model
 * 
 * @Author bruce
 * @Version 2018年2月8日 下午4:38:26
 * @Copyright 金鼎财富
 *
 */
public class ExportOrderModel {
	private String orderId;
	@ExportFormat(name = "订单编号",align = ExportFormatConstant.Align.CENTER,sort = 2)
	private String orderNo;
	@ExportFormat(name = "放款金额",align = ExportFormatConstant.Align.CENTER,sort = 7)
	private String auditAmount;
	@ExportFormat(name = "金坤实际放款金额",align = ExportFormatConstant.Align.CENTER,sort = 8)
	private String actualAmount;
	@ExportFormat(name = "申请期限",align = ExportFormatConstant.Align.CENTER,sort = 9)
	private String period;
	@ExportFormat(name = "申请时间",align = ExportFormatConstant.Align.CENTER,sort = 10)
	private String createDate;
	@ExportFormat(name = "放款时间",align = ExportFormatConstant.Align.CENTER,sort = 11)
	private String makeLoansDate;
	@ExportFormat(name = "订单状态",align = ExportFormatConstant.Align.CENTER,sort = 3)
	private String orderStatus;
	@ExportFormat(name = "贷后核查",align = ExportFormatConstant.Align.CENTER,sort = 1)
	private String after_status;
	private String productId;
	@ExportFormat(name = "产品名",align = ExportFormatConstant.Align.CENTER,sort = 4)
	private String productName;
	private String mobile;
	@ExportFormat(name = "贷款申请人",align = ExportFormatConstant.Align.CENTER,sort = 5)
	private String trueName;
	@ExportFormat(name = "身份证",align = ExportFormatConstant.Align.CENTER,sort = 6)
	private String identifyId;
	@ExportFormat(name = "渠道商",align = ExportFormatConstant.Align.CENTER,sort = 12)
	private String channelName;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAuditAmount() {
		return auditAmount;
	}
	public void setAuditAmount(String auditAmount) {
		this.auditAmount = auditAmount;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCreateDate() {
		if(!StringUtils.isEmpty(createDate)) {
			Date date2 = new Date();
			date2.setTime(Long.parseLong(createDate));
			return DateUtil.formatDate(date2, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getMakeLoansDate() {
		if(!StringUtils.isEmpty(makeLoansDate)) {
			Date date2 = new Date();
			date2.setTime(Long.parseLong(makeLoansDate));
			return DateUtil.formatDate(date2, "yyyy-MM-dd HH:mm:ss");
		}
		return "";
	}
	public void setMakeLoansDate(String makeLoansDate) {
		this.makeLoansDate = makeLoansDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getAfter_status() {
		if(after_status == null || after_status.equals(0)) {
			return "正常";
		}else {
			return "异常";
		}
	}
	public void setAfter_status(String after_status) {
		this.after_status = after_status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getIdentifyId() {
		return identifyId;
	}
	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
}
