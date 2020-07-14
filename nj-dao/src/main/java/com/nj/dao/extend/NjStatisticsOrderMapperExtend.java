package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjStatisticsOrder;

/**
 * @author Lizy
 * @version 2018/6/28.
 */
public interface NjStatisticsOrderMapperExtend {
    /**
     * 获取订单统计数据
     */
    List<Map> getOrder(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据公司获取数据
     */
    List<Map> getOrderByCompany(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("companyId") String companyId);
    
    List<NjStatisticsOrder> countOrderStastis(@Param("coporateId")String coporateId,@Param("beginDate")String beginDate,@Param("endDate")String endDate);
}
