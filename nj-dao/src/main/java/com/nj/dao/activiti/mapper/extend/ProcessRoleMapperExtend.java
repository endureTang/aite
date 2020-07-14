package com.nj.dao.activiti.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.activiti.base.ProcessRole;

public interface ProcessRoleMapperExtend {

	public List<ProcessRole> getRoleByProcessId(@Param("processId")String processId);
}