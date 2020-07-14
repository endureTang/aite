package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjProductArea;
import com.nj.model.generate.SysDict;

public interface NjProductAreaMapperExtend {

	/**
	 * 清空产品发布区域信息
	 * @param njProductId
	 */
	void deleteByProductId(String njProductId);

	/**
	 * 根据产品ID获取产品区域列表
	 * @param productId
	 * @return
	 */
	List<Map<String, Object>> getByProductId(@Param("productId") String productId, @Param("type") String type);

	NjProductArea getTypeByProductId(String productId);
}