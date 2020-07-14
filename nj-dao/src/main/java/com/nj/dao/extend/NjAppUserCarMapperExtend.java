package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserCar;

public interface NjAppUserCarMapperExtend {
	
	public List<NjUserCar> getRecentCarByUserId(@Param("userId") String userId);
	
	public Integer getMaxVersion(@Param("userId") String userId);
	
	public List<Map> getRecentCarMapByUserId(@Param("userId") String userId);
	
	public List<Map> getUserCarAttachByCarId(@Param("carId") String carId);
	
	public List<Map> getCarByOrderId(@Param("orderId") String orderId);
	
	public List<Map> getCarByOrderIdThird(@Param("orderId") String orderId);
	
}
