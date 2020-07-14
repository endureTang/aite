package com.nj.service.base.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.dao.SysOperateLogMapper;
import com.nj.dao.extend.SysOperateLogMapperExtend;
import com.nj.model.generate.SysOperateLog;

/**
 * @FileName LogService.java
 * @Description: 
 *
 * @Date 2018年2月11日 
 * @author Alan
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("logService")
public class LogService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public List<SysOperateLog> selectList(PageData pd) throws Exception {
		SysOperateLogMapperExtend extend = dao.getMapper(SysOperateLogMapperExtend.class);
		int count = extend.selectCount(pd);
		pd.put("count", count);
		return extend.selectList(pd);
	}
	public SysOperateLog view(PageData pd) throws Exception {
		
		SysOperateLogMapper sm = dao.getMapper(SysOperateLogMapper.class);
		
		long id = pd.getInteger("logId");
		
		return sm.selectByPrimaryKey(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer delete(long id) throws Exception {
		SysOperateLogMapper sm = dao.getMapper(SysOperateLogMapper.class);
		return sm.deleteByPrimaryKey(id);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer batchDelete(PageData pd) throws Exception {
		List<String> idList = com.nj.core.base.util.StringUtils.splitToStr(pd.getString("ids"), Const.COMMA);
		if (null != idList && idList.size() > 0) {
			pd.put("idList", idList);
			SysOperateLogMapper sm = dao.getMapper(SysOperateLogMapper.class);
			return sm.batchDelete(pd);
		}
		return 0;
	}
}
