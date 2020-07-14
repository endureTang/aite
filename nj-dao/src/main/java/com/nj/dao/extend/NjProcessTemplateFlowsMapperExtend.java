package com.nj.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjProcessTemplateFlows;

public interface NjProcessTemplateFlowsMapperExtend {

	/**
	 * 根据产品ID获取产品流程列表
	 * @param productId
	 * @return
	 */
	List<NjProcessTemplateFlows> selectByProductId(String productId);

	/**
	 * 根据流程模板ID删除产品流程
	 * @param string
	 */
	void deleteByProductId(String id);

	/**
	 * orderId
	 * @param templateId
	 * @param processId
	 * @param orderId
	 * @return
	 */
	NjProcessTemplateFlows selectCurrentTemplateFlows(@Param ("templateId") String templateId,@Param ("processId") int processId,@Param ("orderId") String orderId,@Param ("status") Integer status);
    
}