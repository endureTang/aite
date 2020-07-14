package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.NjProductTransactionOffline;
import com.nj.model.generate.NjProductTransactionOnline;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjProductTransactionOnlineMapperExtend {

	List<NjProductTransactionOnline> selectByOrderNo(PageData pd);
	
	List<Map> selectOffByOrderNo(PageData pd);
	
	List<NjProductTransactionOnline> getOnlineByProductId(PageData pd);
}