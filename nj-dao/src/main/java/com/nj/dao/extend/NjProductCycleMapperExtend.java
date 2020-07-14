package com.nj.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.SysDict;

public interface NjProductCycleMapperExtend {
	/**
	 * 根据产品ID删除产品借贷信息
	 * @param productId
	 */
	void deleteByProductId(String productId);

	/**
	 * 根据产品ID获取借贷期数列表
	 * @param id
	 * @return
	 */
	List<SysDict> getByProductId(String productId);

	NjProductCycle getBySysCycleId(@Param("cycleId") String cycleId,@Param("productId") String productId);
}