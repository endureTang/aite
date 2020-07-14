/**
 * 
 * @Name com.nj.core.base.entity.SystemLog
 * @Description 
 * 
 * @Author JDCF
 * @Version 2018年1月26日 下午1:26:02
 * @Copyright 金鼎财富
 *
 */
package com.nj.core.base.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Name com.nj.enterprise.aspect.SystemLog
 * @Description 系统日志自定义注解
 * 
 * @Author bruce
 * @Version 2018年1月26日 下午1:26:02
 * @Copyright 金鼎财富
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})      
@Retention(RetentionPolicy.RUNTIME) 
public @interface SystemLog {
	/**
	 * 操作描述
	 * @return
	 */
	String description()  default "";
}
