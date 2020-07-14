package com.nj.dao.activiti.mapper.extend;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProcessQueryMapperExtend {
	
	public Map<String,Object> getTaskInsById(@Param("taskinsid")String taskinsid);
	

	public String getProcessMaxVersion(@Param("productId")String productId);
}
