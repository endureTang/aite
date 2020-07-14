package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjFund;
import com.nj.model.generate.NjFundExample;
import com.nj.model.generate.NjProductTacticsProperty;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjProductTacticsPropertyMapperExtend {

	NjProductTacticsProperty getByProductId(PageData pd);
	
	List<Map> getTacticsByProdId(PageData pd);
	
}