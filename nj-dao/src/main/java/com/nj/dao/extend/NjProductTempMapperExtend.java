package com.nj.dao.extend;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.generate.NjProductTemp;

public interface NjProductTempMapperExtend {
	
	NjProductTemp selectByProductId(@Param("productId") String productId);
	NjProductTemp selectProductTempByOrderId(@Param("orderId") String orderId);
}