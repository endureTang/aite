package com.nj.dao.extend;

import com.nj.model.generate.NjProdRepaymentObj;

public interface NjProdRepaymentObjMapperExtend {

	/**
	 * 根据产品ID获取还款人信息
	 * @param productId
	 * @return
	 */
	NjProdRepaymentObj selectByProductId(String productId);

	
}