package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

public interface NjOrderHuotiMapperExtend {
	public List<Map> getHuotiByOrderId(String orderId);
	public void deleteHuotiByOrderId(String orderId);
}
