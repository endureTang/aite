package com.nj.dao.activiti.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.activiti.base.ProcessCondition;

public interface ProcessConditionMapperExtend {
	
	public List<ProcessCondition> selectByProcess(@Param("productId")String productId);
}