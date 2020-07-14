package com.nj.dao.extend;

import java.util.List;

import com.nj.model.generate.NjOrderFee;

public interface NjOrderFeeMapperExtend {
	
	/**
	 * 批量插入
	 * @param list
	 */
	void insertOrderFee(List<NjOrderFee> list);

	List<NjOrderFee> selectOrderFeeByOrderId(String id);
}