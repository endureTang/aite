package com.nj.dao.extend;

import java.util.List;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysDict;

public interface NjProductTypeMapperExtend {

	/**
	 * 批量插入产品类型
	 * @param pd
	 */
	void insertBath(PageData pd);
	/**
	 * 清空产品类型中间表
	 * @param njProductId
	 */
	void deleteByProductId(String njProductId);
	
	/**
	 * 根据产品ID获取产品类型列表
	 * @param productId
	 * @return
	 */
	List<SysDict> getByProductId(String productId);
}