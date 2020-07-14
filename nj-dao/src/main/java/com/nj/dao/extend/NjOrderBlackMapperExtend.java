package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjOrderBlackMapperExtend {
	
	public List<Map> getBlackByOrderId(@Param("orderId")String orderId);
}