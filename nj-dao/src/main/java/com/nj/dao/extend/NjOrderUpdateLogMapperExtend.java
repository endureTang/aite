package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.vo.OrderUpdateLogVO;

public interface NjOrderUpdateLogMapperExtend {

    
    /*
     * 获取日志列表
     */
    List<OrderUpdateLogVO> selectLogByOrderNo(@Param("orderNo")String orderNo);
    /**
     * 根据订单状体查询日志列表
     * @param orderNo
     * @param auditeStatusList
     * @return
     */
    List<OrderUpdateLogVO> selectOrderLogByStatus(@Param("orderNo")String orderNo,@Param("list")List<Integer> auditeStatusList);
    
	/**
	 * 批量插入日志
	 * 
	 * @param size
	 * @param grade
	 */
	void batchInsertByOrderInfo(@Param("size") long size, @Param("grade") String grade,
			@Param("newStatus") int newStatus, @Param("oldStatus") int oldStatus);
	
	void updateLogStatus(@Param("orderId") String orderId,@Param("execOrders") long execOrders);
	List<Map<String,Object>> getProcessListByOrderId(Map<String, Object> map);
	List<Map<String, Object>> getProductPeriods(Map<String, Object> queryMap);
	List<Map<String, Object>> getCapticalChannelListByOrderId(Map<String, Object> map);
	List<Map<String, Object>> getOrderFeeListByOrderId(Map<String, Object> map);
	List<Map<String, Object>> getCapticalChannelId(Map<String, Object> map);
}