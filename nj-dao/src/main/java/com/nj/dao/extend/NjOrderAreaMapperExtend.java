package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

/**
 * 订单区域扩展Mapper
 * @author MaSong
 * @date 2018-07-26 14:57:23
 */
public interface NjOrderAreaMapperExtend {
	
	public List<Map> getOrderAreaCount();
	
	public void deleteAll();

}
