package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

public interface NjOrderContractMapperExtend {

	/**
	 * 根据订单编号查询合同模板
	 */
	public List<Map> getContractTemplateByOrderNo(String orderNo);
	
	/**
	 * 根据订单id查询合同模板
	 */
	public List<Map> getContractTemplateByOrderId(String orderId);
	
	/**
	 * 根据订单编号获取合同Map,合同管理获取合同列表用
	 */
	public List<Map> getContractMapByOrderNo(String orderNo) ;
}
