package com.nj.dao.activiti.mapper.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.activiti.base.ProcessFlows;

public interface ProcessFlowsMapperExtend {
	
	public List<Map<String,String>> getLinkByProcessId(@Param("processId")String processId);
	
	public List<String> getRoleByProcessId(@Param("processId")String processId);
	
	public List<String> getProductProcessSysVar(@Param("processId")String processId);
	
	/**
	 * 通过任务实例id得到该任务实例下一步的所有路线 
	 */
	public List<Map<String,String>> getListByTaskinsidOut(@Param("taskinsid")String taskinsid);
	
	public List<ProcessFlows> getListById(@Param("idList")List<String> idList);
}