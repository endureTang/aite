package com.nj.enterprise.filter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nj.core.base.util.UuidUtil;

@Component
//@Aspect
public class EntityHelpler {
	Logger logger = LoggerFactory.getLogger(EntityHelpler.class);
    public EntityHelpler(){
        
    }
    
    /*
     * 开始调用前
     */
    @Around("execution(* com.nj.enterprise..*.*(*)) &&  args(record,..)")
    public void beforeSave(ProceedingJoinPoint joinpoint) throws Throwable{
    	
    	Object[] args = joinpoint.getArgs(); 
    	Object record = args[0];
    	if(record != null){
    		try {  
                BeanInfo beanInfo = Introspector.getBeanInfo(record.getClass());  
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
                //默认值
                Map<String,Object> defaultVals = new HashMap();
                defaultVals.put("id", UuidUtil.get32UUID());
                defaultVals.put("createBy", "admin");
                defaultVals.put("createDate", new Date());
                defaultVals.put("delFlag", false);
                
                for (PropertyDescriptor property : propertyDescriptors) {  
                    String key = property.getName();  
                    logger.info("transMapToNewBean key:" + key);
                    if(defaultVals.containsKey(key)){
                    	 Object value = defaultVals.get(key);  
                         // 得到property对应的setter方法  
                         Method setter = property.getWriteMethod();  
                         setter.invoke(record, value);  
                    }
                }  
                
                logger.debug("obj info: " + String.valueOf(record));
                
                joinpoint.proceed(args);
            } catch (Exception e) {  
                System.out.println("transMap2Bean Error " + e);  
            }  
    	}
  
       logger.debug("before save" + String.valueOf(record));
    }
    
    /*
     * 调用实例方法
     */
//    @Pointcut("execution(* com.nj..*.*(..))")
//    public void savePoint(){
//    	logger.debug("save in porgress");
//    	
//    	System.out.println("=====");
//    	logger.debug("save finished");
//    }
    
    
    @Pointcut("execution(* com.nj..*.*(..)) ")
    public void savePoint(){
    	
    	logger.debug("save in porgress");
    	
    	System.out.println("=====");
    	logger.debug("save finished");
    }
    
    @AfterReturning("savePoint()")
    public void afterSave(){
       
    	
    }
    
}