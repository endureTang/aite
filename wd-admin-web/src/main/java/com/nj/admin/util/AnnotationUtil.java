package com.nj.admin.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.nj.core.base.util.UuidUtil;
import org.springframework.stereotype.Component;

import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.model.generate.SysResource;

/**
 * 
 * @Name com.nj.enterprise.utils.AnnotationUtil
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月23日 下午5:07:42
 * @Copyright 金鼎财富
 *
 */
@Component
public class AnnotationUtil {
	
	private List<SysResource> sysResourceList = new ArrayList();
	
	public void validAnnotation(List<Class<?>> clsList){  
        if (clsList != null && clsList.size() > 0) {  
            for (Class<?> cls : clsList) {  
                //获取类中的所有的方法  
                Method[] methods = cls.getDeclaredMethods();  
                if (methods != null && methods.length > 0) {  
                    for (Method method : methods) {  
                    	ResourcesAnnotion apiAnnotion = (ResourcesAnnotion) method.getAnnotation(ResourcesAnnotion.class);  
                        if (apiAnnotion != null) {  
                        	SysResource resource = new SysResource();
                        	resource.setId(UuidUtil.get32UUID());
                        	resource.setName(apiAnnotion.name());
                        	resource.setIsShow(String.valueOf(apiAnnotion.resourceType()));
                        	resource.setSort(0);
                        	resource.setHref(apiAnnotion.uri());
                        	resource.setCreateDate(new Date());
                        	resource.setDelFlag(false);
                        	resource.setParentId(apiAnnotion.parentId());
                        	resource.setParentIds(apiAnnotion.parentId());
                        	resource.setCreateBy("system");
                        	resource.setUpdateBy("system");
                        	resource.setUpdateDate(new Date());
                        	sysResourceList.add(resource);
                        }  
                    }  
                }  
            }  
        }  
    }  
	public List<SysResource> getResourceList(){
		return sysResourceList;
	}
}
