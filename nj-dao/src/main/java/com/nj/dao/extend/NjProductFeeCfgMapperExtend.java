package com.nj.dao.extend;

import java.util.Set;

public interface NjProductFeeCfgMapperExtend {

	/**
	 * 获取企业下所有产品，还款计划配置的费用code，去重
	 */
	public Set<String> getFeeCodeSetByCoporateId(String coporateId);
}
