package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjFund;
import com.nj.model.generate.NjFundExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjFundMapperExtend {


	List<NjFund> getList();

	List<NjFund> getListByName(PageData pd);
	
	List<Map> getListByProductId(PageData pd);
	
}