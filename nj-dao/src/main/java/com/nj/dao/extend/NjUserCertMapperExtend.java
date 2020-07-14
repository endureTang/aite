package com.nj.dao.extend;

import com.nj.model.generate.NjUserCert;

public interface NjUserCertMapperExtend {
	public NjUserCert getRecentUserCertByUserId(String userId);
	
	public NjUserCert getUserCertByOrderId(String orderId);
}
