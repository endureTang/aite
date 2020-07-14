package com.nj.dao.extend;

import java.util.List;

import com.nj.model.generate.NjProdRepayObj;

public interface NjProdRepayObjMapperExtend {

	/**
	 * 根据产品ID获取还款人信息
	 * @param productId
	 * @return
	 */
	List<NjProdRepayObj> selectByProductId(String productId);

	
}