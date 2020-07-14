package com.nj.enterprise.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.jd.core.util.Md5Util;
import com.nj.core.base.util.ClassUtil;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.SysResourceMapper;
import com.nj.model.generate.SysArea;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysResource;
import com.nj.service.base.system.DictService;
import com.nj.service.common.SysAreaService;

/**
 * 
 * @Name com.nj.enterprise.utils.startUpUtil
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月23日 下午5:30:56
 * @Copyright 金鼎财富
 *
 */
@Component
public class StartUpUtil implements InitializingBean{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	AnnotationUtil annotationUtil;
	@Resource
	SysResourceMapper sysResourceMapper;
	@Resource
	SysAreaService sysAreaService;
	
	@Resource 
	private  DictService  dictService;
	
	public void afterPropertiesSet() throws Exception {
		logger.info("----------------系统初始化开始---------------------");
        // 获取特定包下所有的类(包括接口和类)  
        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName("com.nj.enterprise.controller");
        //输出所有使用了特定注解的类的注解值  
        annotationUtil.validAnnotation(clsList);  
        
        logger.info("加载授权资源：{}个",annotationUtil.getResourceList().size());
		for(SysResource resource:annotationUtil.getResourceList()) {
			SysResource oldResource=sysResourceMapper.selectByPrimaryKey(resource.getId());
			if(oldResource==null) {
				sysResourceMapper.insert(resource);
			}else {
				if(!resource.getParentId().equals(oldResource.getParentId())) {
					if(oldResource.getParentId().length()<10) {
						sysResourceMapper.updateByPrimaryKey(resource);
					}
				}
			}
		}
		// 查询所有区域
//		List<SysArea> listSysArea = sysAreaService.getAreaAll();
//		EhCacheUtil.getInstance().put(EhCacheConstant.ITF.SYS_AREA, "ALL", listSysArea);
		logger.info("----------------系统初始化结束---------------------");
		//cacheReapyWay();
		
	}
	

}
