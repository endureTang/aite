package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserBasicInfo;

public interface NjAppUserBasicInfoMapperExtend {
	public List<NjUserBasicInfo> getRecentBasicInfo(@Param("userId") String userId);
	
	public NjUserBasicInfo getUserBasicInfoByOrderId(@Param("orderId") String orderId);
	
	public NjUserBasicInfo getUserBasicInfoByUserId(@Param("orderId") String orderId);
	
	public List<Map> getBasicAttMapByWorkId(@Param("basicInfoId") String basicInfoId);
	
}
