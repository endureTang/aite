package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjRepayOfflineLine;
import com.nj.model.generate.NjRepayOfflineLineExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjRepayOfflineLineMapperExtend {
	
	List<Map> getRepayOfflineList(PageData pd);

	int getRepayOfflineListCount(PageData pd);
    
}