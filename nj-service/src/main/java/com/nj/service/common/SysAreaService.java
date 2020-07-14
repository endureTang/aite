package com.nj.service.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.SysAreaMapper;
import com.nj.model.generate.SysArea;
import com.nj.model.generate.SysAreaExample;

/**
 * 地区省市县Service
 * @author MaSong
 * @date 2018-06-27 09:41:55
 */
@Service("sysAreaService")
public class SysAreaService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	private static Logger logger = LoggerFactory.getLogger(SysAreaService.class);
	
	
	/**
	 * 根据类型查询省市县
	 * @param type	1省 2市 3县
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaByType(String type) throws Exception{
		
		SysAreaMapper mapper = dao.getMapper(SysAreaMapper.class);
		SysAreaExample example = new SysAreaExample();
		example.createCriteria().andTypeEqualTo(type);
		List<SysArea> listArea = mapper.selectByExample(example);
		return listArea;
	}
	
	/**
	 * 通过 ID 查询区域
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysArea getAreaById(String id) throws Exception{
		
		SysAreaMapper mapper = dao.getMapper(SysAreaMapper.class);
		return mapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 通过父级查询子级区域
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaByParentId(String parentId) throws Exception{
		
		SysAreaMapper mapper = dao.getMapper(SysAreaMapper.class);
		SysAreaExample example = new SysAreaExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<SysArea> listArea = mapper.selectByExample(example);
		return listArea;
	}
	
	/**
	 * 查询所有省级区域
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaForProvince() throws Exception{
		
		return 	getAreaByType("1");
	}
	
	/**
	 * 查询所有市级区域
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaForCity() throws Exception {
		
		return 	getAreaByType("2");
	}
	
	/**
	 * 查询所有县级区域
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaForCounty() throws Exception {
		
		return 	getAreaByType("3");
	}
	
	/**
	 * 查询所有区域
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaAll()throws Exception {
		
		SysAreaMapper mapper = dao.getMapper(SysAreaMapper.class);
		SysAreaExample example = new SysAreaExample();
		return mapper.selectByExample(example);
	}
	
	/**
	 * 保存区域
	 * @param sysArea
	 * @throws Exception
	 */
	public void saveSysArea(SysArea sysArea)throws Exception {
		SysAreaMapper mapper = dao.getMapper(SysAreaMapper.class);
		mapper.insert(sysArea);
	}
	
	/**
	 * 通过区域名称查询区域
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public SysArea getSysAreaByName(String name)throws Exception {
		
		SysAreaMapper mapper = dao.getMapper(SysAreaMapper.class);
		SysAreaExample example = new SysAreaExample();
		example.createCriteria().andNameLike("%"+name+"%");
		List<SysArea> list =mapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}

	}
	
}
