package com.nj.dao.extend;

import com.nj.model.generate.NjProdPayeeObj;

public interface NjProdPayeeObjMapperExtend {

	/**
	 * 根据产品ID获取收款人信息
	 * @param productId
	 * @return
	 */
	NjProdPayeeObj selectByProductId(String productId);
	
}