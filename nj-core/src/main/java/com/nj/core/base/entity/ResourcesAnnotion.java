package com.nj.core.base.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Name com.nj.enterprise.utils.ResourcesAnnotion
 * @Description 资源自定义注解
 * 
 * @Author bruce
 * @Version 2018年3月23日 下午4:50:15
 * @Copyright 金鼎财富
 *
 */
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface ResourcesAnnotion {
	public String uri();
	/**
	 * 资源名称
	 * @return
	 */
	public String name();
	/**
	 * 资源类型(1:管理后台菜单,2:业务后台菜单,3:业务后台权限)
	 * @return
	 */
	public int resourceType();
	
	public String parentId();
	/**
	 * 排序
	 */
	public int sort() default 0;
}