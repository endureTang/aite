package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @author Zhang.Hai
 *
 */
public interface NjProductPurposeMapperExtend {
	
	public List<Map> getProductPurposesById(@Param(value="id") String id);
}
