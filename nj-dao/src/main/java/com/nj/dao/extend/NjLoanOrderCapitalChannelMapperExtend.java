package com.nj.dao.extend;

import com.nj.model.generate.NjLoanOrderCapitalChannel;
import com.nj.model.generate.NjStatisticsSummary;
import com.nj.model.generate.NjStatisticsSummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NjLoanOrderCapitalChannelMapperExtend {
	
	/**
	 * 批量插入
	 * @param list
	 */
	void insertBathCapitalChannel(List<NjLoanOrderCapitalChannel> list);
    
}