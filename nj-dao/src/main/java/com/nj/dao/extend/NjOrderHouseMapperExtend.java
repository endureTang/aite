package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjOrderHouseMapperExtend {
	
	public List<Map> getOrderHousesByOrderId(@Param("orderId")String orderId);
	

}