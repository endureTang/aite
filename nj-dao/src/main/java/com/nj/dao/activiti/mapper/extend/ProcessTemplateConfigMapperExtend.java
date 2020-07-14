package com.nj.dao.activiti.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.activiti.base.ProcessTemplateConfig;

public interface ProcessTemplateConfigMapperExtend {

	public List<ProcessTemplateConfig> getListByTaskinsid(@Param("taskinsid")String taskinsid);
}
