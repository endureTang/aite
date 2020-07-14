package com.nj.service.itf;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjProductCycleMapper;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductCycleExample;

@Transactional(readOnly = true)
@Service("itfProductPeroidService")
public class ItfProductPeriodService {
	
	@Resource(name="BaseDao")
	private BaseDao dao;
	public List<NjProductCycle>  getProdPeriodByProdId(String productId) throws Exception {
		NjProductCycleMapper mapper = dao.getMapper(NjProductCycleMapper.class);
		NjProductCycleExample example = new NjProductCycleExample();
		example.createCriteria().andProductIdEqualTo(productId);
		return mapper.selectByExample(example);
	}
}
