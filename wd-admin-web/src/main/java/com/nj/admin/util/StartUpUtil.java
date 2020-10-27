package com.nj.admin.util;

import java.util.List;

import javax.annotation.Resource;

import com.nj.model.generate.SysResourceExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.nj.core.base.util.ClassUtil;
import com.nj.dao.SysResourceMapper;
import com.nj.model.generate.SysResource;

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
	
	
	public void afterPropertiesSet() throws Exception {
		logger.info("----------------系统初始化开始---------------------");
        // 获取特定包下所有的类(包括接口和类)  
        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName("com.nj.admin.controller");
        //输出所有使用了特定注解的类的注解值  
        annotationUtil.validAnnotation(clsList);  
        logger.info("加载授权资源：{}个",annotationUtil.getResourceList().size());
		for(SysResource resource:annotationUtil.getResourceList()) {
			SysResource oldResource=null;
			SysResourceExample example = new SysResourceExample();
			example.createCriteria().andNameEqualTo(resource.getName());
			List<SysResource> sysResourceList = sysResourceMapper.selectByExample(example);
			if(sysResourceList != null && sysResourceList.size() >0){
				oldResource = sysResourceList.get(0);
			}
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
		logger.info("----------------系统初始化结束---------------------");
	}
}
