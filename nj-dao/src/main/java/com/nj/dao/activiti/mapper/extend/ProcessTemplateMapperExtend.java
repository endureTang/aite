package com.nj.dao.activiti.mapper.extend;

import org.apache.ibatis.annotations.Param;

import com.nj.model.activiti.base.ProcessTemplate;

public interface ProcessTemplateMapperExtend {
	
	public ProcessTemplate getByProcessId(@Param("processId")String processId); 
}