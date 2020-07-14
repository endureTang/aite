package com.nj.enterprise.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.model.generate.SysArea;
import com.nj.service.common.SysAreaService;

/**
 * 区域工具类
 * @author MaSong
 * @date 2018-06-27 13:52:50
 */
@Component
public class AreaUtil {
	
	/**区域Service*/
	@Resource
	SysAreaService sysAreaService;
	
	
	/**
	 * 通过类型查询区域
	 * @param type 1省 2市 3县
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaByType(String type) throws Exception {
		
		List<SysArea> listSysAreaCache = (List<SysArea>) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.SYS_AREA, "ALL");
		List<SysArea> listSysArea = new ArrayList<SysArea>();
		if (listSysAreaCache != null){
			for(SysArea sysArea : listSysAreaCache){
				if (type.equals(sysArea.getType())) {
					listSysArea.add(sysArea);
				}
			}
		} else {
			listSysArea = sysAreaService.getAreaByType(type);
		}
		return listSysArea;
	}
	
	/**
	 * 通过ID查询区域
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysArea getAreaById(String id) throws Exception{
		
		List<SysArea> listSysAreaCache = (List<SysArea>) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.SYS_AREA, "ALL");
		SysArea sysAreaRe = null;
		if (listSysAreaCache != null) {
			for(SysArea sysArea : listSysAreaCache) {
				if(id.equals(sysArea.getId())){
					sysAreaRe = sysArea;
				}
			}
		} else {
			sysAreaRe = sysAreaService.getAreaById(id);
		}
		return sysAreaRe;
	}
	
	/**
	 * 通过父级ID查询子级区域
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<SysArea> getAreaByParentId(String parentId) throws Exception{
		
		List<SysArea> listSysAreaCache = (List<SysArea>) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.SYS_AREA, "ALL");
		List<SysArea> listSysArea = new ArrayList<SysArea>();
		if (listSysAreaCache != null){
			for(SysArea sysArea : listSysAreaCache){
				if (parentId.equals(sysArea.getParentId())) {
					listSysArea.add(sysArea);
				}
			}
		} else {
			listSysArea = sysAreaService.getAreaByParentId(parentId);
		}
		return listSysArea;
	} 
	
	/**
	 * 通过区域 ID 查询父级区域
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysArea getAreaParentById(String id) throws Exception{
		
		SysArea sysArea = getAreaById(id);
		return getAreaById(sysArea.getParentId());
	}
	
}
