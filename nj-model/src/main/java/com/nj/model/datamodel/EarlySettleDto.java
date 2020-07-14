package com.nj.model.datamodel;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 调用贷后提前结清接口传入的DTO
 */
public class EarlySettleDto {
	
	private String orderNo;			//订单编号
	private List<EarlySettleParam> earlySettleParamList;		//提前结清参数
	
	@Override
	public String toString() {
		StringBuilder ojbStr = new StringBuilder();
		Field[] fileds = this.getClass().getDeclaredFields();
		for (int i = 0; i < fileds.length; i++) {
			try {
				ojbStr.append(fileds[i].getName()).append("=").append(fileds[i].get(this)==null?"":fileds[i].get(this).toString()).append(",");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return ojbStr.toString();
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<EarlySettleParam> getEarlySettleParamList() {
		return earlySettleParamList;
	}

	public void setEarlySettleParamList(List<EarlySettleParam> earlySettleParamList) {
		this.earlySettleParamList = earlySettleParamList;
	}
}
