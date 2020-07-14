package com.nj.dao.extend;

import java.util.List;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysOperateLog;

public interface SysOperateLogMapperExtend {
	
	List<SysOperateLog> selectList(PageData pd);

	int selectCount(PageData pd);
}