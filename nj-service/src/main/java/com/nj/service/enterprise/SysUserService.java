package com.nj.service.enterprise;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.SysUserMapperExtend;
import com.nj.model.generate.SysUser;

@Transactional(readOnly = true)
@Service("sysUserService")
public class SysUserService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(SysUserService.class);

	public PageData list(PageData pd) throws Exception {
		//pd.put("start", pd.getInteger("start"));
		//pd.put("length", pd.getInteger("length"));
		Integer start = pd.getInteger("start");
		Integer length = pd.getInteger("length");
		int  page  = start/length;
		SysUserMapperExtend sysUserMapper = dao.getMapper(SysUserMapperExtend.class);
		//Long count = sysUserMapper.selectListCount(pd);
		PageHelper.startPage(page+1,length );
		List<SysUser> results = sysUserMapper.selectList(pd);
		
		PageInfo<SysUser>  pageInfo = new PageInfo<>(results);
		PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSFILTERED, pageInfo.getTotal());
		pd1.put(Constants.Datas.NDATA, pageInfo.getList());
		return pd1;
	}

	public SysUser getByMobile(String userMobile) throws Exception {
		SysUserMapperExtend extend = dao.getMapper(SysUserMapperExtend.class);
		return extend.getByMobile(userMobile);
	}

	public SysUser getByUserId(String userId) throws Exception {
		SysUserMapper mapper = dao.getMapper(SysUserMapper.class);
		return mapper.selectByPrimaryKey(userId);
	}

}
