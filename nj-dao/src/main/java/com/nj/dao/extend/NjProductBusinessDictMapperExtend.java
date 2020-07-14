package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import com.nj.core.base.mapper.BaseMapper;
import com.nj.model.datamodel.SysBusinessDictModel;
import com.nj.model.generate.NjProductBusinessDict;

public interface NjProductBusinessDictMapperExtend extends BaseMapper {

	/**
	 * 根据产品ID获取产品业务交易配置列表
	 * @param productId
	 * @return
	 */
	List<Map<String, Object>> selectByProduct(String productId);

	/**
	 * 批量插入产品业务配置
	 * @param insertBathList
	 */
	void insertBath(List<NjProductBusinessDict> insertBathList);
	/**
	 * 根据产品ID清除交易配置信息
	 * @param string
	 */
	void deleteByProductId(String string);

	/**
	 * 根据产品id、类型id获取产品配置项
	 * @param paramMap
	 * @return
	 */
	List<SysBusinessDictModel> getProductBusinessByType(Map<String, Object> paramMap);

	/**
	 * 根据产品id，展示类型获取展示大类列表
	 * @param paramMap
	 * @return
	 */
	List<Map> getProductBusinessTypeList(Map<String, Object> paramMap);
}