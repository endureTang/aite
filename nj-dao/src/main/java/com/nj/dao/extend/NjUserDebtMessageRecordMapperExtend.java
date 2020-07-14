package com.nj.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserDebtMessageRecord;

public interface NjUserDebtMessageRecordMapperExtend {
	
	List<NjUserDebtMessageRecord> selectOrderNoList();

	NjUserDebtMessageRecord selectLastMsgByOrderNo(@Param("orderNo") String orderNo);

	void deleteByOrderNo(@Param("orderNo") String orderNo);
}
