package com.nj.dao.extend;

import com.nj.model.generate.NjWithdrawingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Lizy
 * @version 2018/7/13.
 */
public interface NjWithdrawingRecordMapperExtend {
    /**
     * 修改逾期状态
     */
    void updateOverdueRecord(@Param("time") String time);

    /**
     * 获取逾期记录
     */
    List<NjWithdrawingRecord> getOverdueRecord();

    /**
     * 获取需要扣款的记录
     */
    List<NjWithdrawingRecord> getWithdrawingRecord();

    /**
     * 获取需要删除的记录
     */
    List<NjWithdrawingRecord> getDeleteRecord();

    /**
     * 根据订单号和期数查询记录
     */
    NjWithdrawingRecord getRecordByOrderNoAndPeriod(@Param("orderNo") String orderNo, @Param("period") Integer period);
}
