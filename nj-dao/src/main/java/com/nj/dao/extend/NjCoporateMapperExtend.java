package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjFund;
import com.nj.model.generate.NjFundExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjCoporateMapperExtend {


	List<NjCoporate> getCompanyList(PageData pd);
	
	List<Map> selectCompany(PageData pd);

	int update(PageData pd);

	List<Map> selectAllList(PageData pd);

	List<NjCoporate> getAllCompany();
	
	List<NjCoporate> getAllCompanyForApp();
}