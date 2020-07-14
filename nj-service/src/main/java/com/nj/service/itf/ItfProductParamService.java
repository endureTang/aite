package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjProductParaMapper;
import com.nj.model.generate.NjProductPara;
import com.nj.model.generate.NjProductParaExample;

@Transactional(readOnly = true)
@Service("itfProductParamService")
public class ItfProductParamService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public List<NjProductPara> getProductParamById( String value) throws Exception{
		NjProductParaMapper sm = dao.getMapper(NjProductParaMapper.class);
		NjProductParaExample example = new NjProductParaExample();
		example.createCriteria().andProductIdEqualTo(value);
		return sm.selectByExample(example);
	}
	
/*	public boolean isValidApplySum(String productId, Double sum) throws Exception{
		if(sum==null)
			return false;
		List<NjProductPara> paras=getProductParamById(productId);
		if(paras==null || paras.isEmpty())
			return false;
		
		if(sum>paras.get(0).getMinLoan().doubleValue() && sum<paras.get(0).getMaxLoan().doubleValue())
			return true;
		return false;
		return true;
	}*/
}
