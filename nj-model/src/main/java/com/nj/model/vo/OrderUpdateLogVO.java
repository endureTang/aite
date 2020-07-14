package com.nj.model.vo;

import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.model.generate.NjOrderUpdateLog;

/**
 * 
 * @Name com.nj.model.vo.OrderUpdateLogVO
 * @Description 订单操作日志试图类
 * 
 * @Author bruce
 * @Version 2018年3月21日 下午2:04:30
 * @Copyright 金鼎财富
 *
 */
public class OrderUpdateLogVO extends NjOrderUpdateLog{
	private String processName;
	private String userName;
	private String updateStatusName;
	
	public String getProcessName() {
		if(this.getProcessId()!=null) {
			EProcessInfo epInfo = EProcessInfo.getEProcessInfo(this.getProcessId());
			processName = epInfo.getName();
		}
		return processName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUpdateStatusName() {
		ELoanOrderStatus eStatus = ELoanOrderStatus.getELoanOrderStatus(this.getUpdateStatus());
		updateStatusName = eStatus.getName();
		return updateStatusName;
	}
	
	
	
}
