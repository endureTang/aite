package com.nj.dao.activiti.mapper.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.activiti.base.ProcessRoleUser;

public interface ProcessRoleUserMapperExtend {

	public List<ProcessRoleUser> getListByTaskKey(@Param("taksKey")String taksKey);
	
	public List<Map<String,String>> getTaskIdList(Map map);
	

	public int insertTaskinsUser(Map map);
}