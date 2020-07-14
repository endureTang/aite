package com.nj.dao.extend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjProcessOrderFlows;

public interface NjOrderProcessMapperExtend {
	@SuppressWarnings("rawtypes")
	public List<Map> getOrderProcess();
	public List<Map> getProcessStatus(Map<?, ?> condition);
	public List<Map<String,String>> selectOrderTemplateByStatus(@Param("status")int status);
	/**
	 * 统计用户在贷总金额
	 * @param userId
	 * @param productId
	 * @return
	 */
	public BigDecimal countAmoutnByInLoan(@Param("userId")String userId,@Param("productId")String productId);
	
	/**
	 * 根据订单ID查询订单日志，并对ProcessId进行分组，且查询处每个分组中最新的信息
	 * @param orderNo
	 * @return
	 */
	public List<Map> getOrderUpdateLogAllForProcessId(@Param("orderId") String orderId);
	/**
	 * 如果金额小于100w，则删除多余复审流程:风控经理审核->总监->董事长（61，62，34）
	 * @param processIds
	 */
	public void delectProcessFlows(@Param("processIds") String processIds,@Param("orderId") String orderId);
	/**
	 * 根据订单id，模板id获取流程列表
	 * @param orderId
	 * @param templateId
	 * @return
	 */
	public List<Map<String, Object>> selectOrderProcess(@Param("orderId") String orderId,@Param("templateId") String templateId);
}
