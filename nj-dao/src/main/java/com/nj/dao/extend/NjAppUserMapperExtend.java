package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import com.nj.core.base.util.PageData;
import com.nj.model.vo.CustomerRelationListVo;

public interface NjAppUserMapperExtend {
	
	/**
	 * 贷前反欺诈页面列表数据
	 */
	public List<Map> getLoanBeforeAntiFraidData(PageData param);
	
	/**
	 * 客户-关系管理页面列表数据
	 */
	public List<CustomerRelationListVo> getCustomerRelationListVo(PageData param);
}
