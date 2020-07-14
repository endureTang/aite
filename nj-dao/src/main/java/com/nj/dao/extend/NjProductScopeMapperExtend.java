package com.nj.dao.extend;

import java.util.List;

import com.nj.model.generate.NjProductScope;
import com.nj.model.generate.SysDict;

public interface NjProductScopeMapperExtend {

	/**
	 * 根据产品id删除借贷信息
	 * @param njProductId
	 */
	void deleteByProductId(String njProductId);

	/**
	 * 根据产品ID获取产品用途范围
	 * @param id
	 * @return
	 */
	List<SysDict> getByProductId(String id);
}