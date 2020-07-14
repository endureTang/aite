package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserWorkInfo;

public interface NjAppUserWorkMapperExtend {
	public List<NjUserWorkInfo> getRecentWork(String userId);
	
	public NjUserWorkInfo getOrderWorkInfo(String orderId);
	
	public Map<String,Object> getOrderWorkNew(String orderId);
	
	public List<Map> getWorkAttMapByWorkId(@Param("workId") String workId);

	public Map<String, Object> getRecentWorkNew(@Param("userId") String userId);
	
	
}
