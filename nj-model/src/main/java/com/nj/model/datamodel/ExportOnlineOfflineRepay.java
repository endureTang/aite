package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ExportOnlineOfflineRepay {

	@ExportFormat(name = "月份",align = ExportFormatConstant.Align.LEFT,sort = 1)
	private String statisDate;
	@ExportFormat(name = "线上扣款总笔数",align = ExportFormatConstant.Align.LEFT,sort = 2)
	private String onlineRepayTotalNum;
	@ExportFormat(name = "线上扣款总金额",align = ExportFormatConstant.Align.LEFT,sort = 3)
	private String onlineRepayTotalAmt;
	@ExportFormat(name = "线下扣款总笔数",align = ExportFormatConstant.Align.LEFT,sort = 4)
	private String offlineRepayTotalNum;
	@ExportFormat(name = "线下扣款总金额",align = ExportFormatConstant.Align.LEFT,sort = 5)
	private String offlineRepayTotalAmt;
	@ExportFormat(name = "1000元以下线上扣款成功笔数",align = ExportFormatConstant.Align.LEFT,sort = 6)
	private String online0_1000_num;
	@ExportFormat(name = "1000元以下线下调账总笔数",align = ExportFormatConstant.Align.LEFT,sort = 7)
	private String offline0_1000_num;
	@ExportFormat(name = "1000元以下线下调账总金额",align = ExportFormatConstant.Align.LEFT,sort = 8)
	private String offline0_1000_amt;
	@ExportFormat(name = "1000-5000元线上扣款成功总笔数",align = ExportFormatConstant.Align.LEFT,sort = 9)
	private String online1000_5000_num;
	@ExportFormat(name = "1000-5000元线下调账总笔数",align = ExportFormatConstant.Align.LEFT,sort = 10)
	private String offline1000_5000_num;
	@ExportFormat(name = "1000-5000元线下调账总金额",align = ExportFormatConstant.Align.LEFT,sort = 11)
	private String offline1000_5000_amt;
	@ExportFormat(name = "5000-10000元线上扣款成功总笔数",align = ExportFormatConstant.Align.LEFT,sort = 12)
	private String online5000_10000_num;
	@ExportFormat(name = "5000-10000元线下调账总笔数",align = ExportFormatConstant.Align.LEFT,sort = 13)
	private String offline5000_10000_num;
	@ExportFormat(name = "5000-10000元线下调账总金额",align = ExportFormatConstant.Align.LEFT,sort = 14)
	private String offline5000_10000_amt;
	@ExportFormat(name = "10000-50000元线上扣款成功总笔数",align = ExportFormatConstant.Align.LEFT,sort = 15)
	private String online10000_50000_num;
	@ExportFormat(name = "10000-50000元线下调账总笔数",align = ExportFormatConstant.Align.LEFT,sort = 16)
	private String offline10000_50000_num;
	@ExportFormat(name = "10000-50000元线下调账总金额",align = ExportFormatConstant.Align.LEFT,sort = 17)
	private String offline10000_50000_amt;
	@ExportFormat(name = "50000元以上线上扣款成功总笔数",align = ExportFormatConstant.Align.LEFT,sort = 18)
	private String online50000_num;
	@ExportFormat(name = "50000元以上线下调账总笔数",align = ExportFormatConstant.Align.LEFT,sort = 19)
	private String offline50000_num;
	@ExportFormat(name = "50000元以上线下调账总金额",align = ExportFormatConstant.Align.LEFT,sort = 20)
	private String offline50000_amt;
	
	public String getStatisDate() {
		return statisDate;
	}
	public void setStatisDate(String statisDate) {
		this.statisDate = statisDate;
	}
	public String getOnlineRepayTotalNum() {
		return onlineRepayTotalNum;
	}
	public void setOnlineRepayTotalNum(String onlineRepayTotalNum) {
		this.onlineRepayTotalNum = onlineRepayTotalNum;
	}
	public String getOnlineRepayTotalAmt() {
		return onlineRepayTotalAmt;
	}
	public void setOnlineRepayTotalAmt(String onlineRepayTotalAmt) {
		this.onlineRepayTotalAmt = onlineRepayTotalAmt;
	}
	public String getOfflineRepayTotalNum() {
		return offlineRepayTotalNum;
	}
	public void setOfflineRepayTotalNum(String offlineRepayTotalNum) {
		this.offlineRepayTotalNum = offlineRepayTotalNum;
	}
	public String getOfflineRepayTotalAmt() {
		return offlineRepayTotalAmt;
	}
	public void setOfflineRepayTotalAmt(String offlineRepayTotalAmt) {
		this.offlineRepayTotalAmt = offlineRepayTotalAmt;
	}
	public String getOnline0_1000_num() {
		return online0_1000_num;
	}
	public void setOnline0_1000_num(String online0_1000_num) {
		this.online0_1000_num = online0_1000_num;
	}
	public String getOffline0_1000_num() {
		return offline0_1000_num;
	}
	public void setOffline0_1000_num(String offline0_1000_num) {
		this.offline0_1000_num = offline0_1000_num;
	}
	public String getOffline0_1000_amt() {
		return offline0_1000_amt;
	}
	public void setOffline0_1000_amt(String offline0_1000_amt) {
		this.offline0_1000_amt = offline0_1000_amt;
	}
	public String getOnline1000_5000_num() {
		return online1000_5000_num;
	}
	public void setOnline1000_5000_num(String online1000_5000_num) {
		this.online1000_5000_num = online1000_5000_num;
	}
	public String getOffline1000_5000_num() {
		return offline1000_5000_num;
	}
	public void setOffline1000_5000_num(String offline1000_5000_num) {
		this.offline1000_5000_num = offline1000_5000_num;
	}
	public String getOffline1000_5000_amt() {
		return offline1000_5000_amt;
	}
	public void setOffline1000_5000_amt(String offline1000_5000_amt) {
		this.offline1000_5000_amt = offline1000_5000_amt;
	}
	public String getOnline5000_10000_num() {
		return online5000_10000_num;
	}
	public void setOnline5000_10000_num(String online5000_10000_num) {
		this.online5000_10000_num = online5000_10000_num;
	}
	public String getOffline5000_10000_num() {
		return offline5000_10000_num;
	}
	public void setOffline5000_10000_num(String offline5000_10000_num) {
		this.offline5000_10000_num = offline5000_10000_num;
	}
	public String getOffline5000_10000_amt() {
		return offline5000_10000_amt;
	}
	public void setOffline5000_10000_amt(String offline5000_10000_amt) {
		this.offline5000_10000_amt = offline5000_10000_amt;
	}
	public String getOnline10000_50000_num() {
		return online10000_50000_num;
	}
	public void setOnline10000_50000_num(String online10000_50000_num) {
		this.online10000_50000_num = online10000_50000_num;
	}
	public String getOffline10000_50000_num() {
		return offline10000_50000_num;
	}
	public void setOffline10000_50000_num(String offline10000_50000_num) {
		this.offline10000_50000_num = offline10000_50000_num;
	}
	public String getOffline10000_50000_amt() {
		return offline10000_50000_amt;
	}
	public void setOffline10000_50000_amt(String offline10000_50000_amt) {
		this.offline10000_50000_amt = offline10000_50000_amt;
	}
	public String getOnline50000_num() {
		return online50000_num;
	}
	public void setOnline50000_num(String online50000_num) {
		this.online50000_num = online50000_num;
	}
	public String getOffline50000_num() {
		return offline50000_num;
	}
	public void setOffline50000_num(String offline50000_num) {
		this.offline50000_num = offline50000_num;
	}
	public String getOffline50000_amt() {
		return offline50000_amt;
	}
	public void setOffline50000_amt(String offline50000_amt) {
		this.offline50000_amt = offline50000_amt;
	}
}
