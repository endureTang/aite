package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.datamodel.ExamineUserDO;
import com.nj.model.datamodel.PrcessOrderDO;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessTemplateFlows;


/**
 * 
 * @Name com.nj.dao.extend.NjProcessMapperExtend
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年2月9日 上午9:22:41
 * @Copyright 金鼎财富
 *
 */
public interface NjProcessMapperExtend {
	/**
     * 统计当天审批人员派单情况
     * @param beginTime
     * @return
     */
    List<ExamineUserDO> statShunt(@Param("beginTime")String beginTime,@Param("productId")String productId);
    /**
     * 查询订单对应的原始工作流程
     * @param orderId
     * @return
     */
    List<NjProcessTemplateFlows> selectProcessFlowsByOrderId(String orderId);
    /**
     * 查询订单对应的工作流进度
     * @param orderId
     * @return
     */
    //List<PrcessOrderDO> selectProcessOrderByOrderId(String orderId);
    /**
     * 查询当前的过程信息
     * @param orderId
     * @param processId
     * @return
     */
    NjProcessTemplateFlows selectProcessTemplateByOrderProcess(@Param("orderId")String orderId,@Param("processId")int processId);
    /**
     * 查询正在执行的过程
     * @param orderId
     * @return
     */
    NjProcessTemplateFlows selectCurrentProcess(@Param("orderId")String orderId,@Param("templateId")String templateId);
    
    /**
     * 查询正在执行的过程
     * @param orderId
     * @return
     */
    NjProcessOrderFlows selectCurrentProcessByOrderId(@Param("orderId")String orderId);
    /**
     * 查询核查记录信息
     * @param orderId
     * @param dateType
     * @return
     */
    Map<String,String> selectCheckRecord(@Param("orderId")String orderId,@Param("dateType")int dateType);
    /**
     * 查询产品手动审核流程
     * @param param
     * @return
     */
    List<NjProcessTemplateFlows> selectCheckProcessByProductId(Map<String, Object> param);
    /**
     * 查询订单流程
     * @param orderId
     * @return
     */
    Integer selectOrderProcessByOrderId(@Param("orderId")String orderId);
}

