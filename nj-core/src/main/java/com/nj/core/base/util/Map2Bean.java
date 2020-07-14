package com.nj.core.base.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Map2Bean {
	
	static Logger logger = LoggerFactory.getLogger(Map2Bean.class);

	 /*
	  * 将map误操作的转换为实体bean
	  */
    public static void transMap2Bean(Map<String, Object> map, Object obj) {  
  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
  
            }  
  
        } catch (Exception e) {  
            System.out.println("transMap2Bean Error " + e);  
        }  
  
        return;  
  
    }  
    
    /*
	  * 将业务map的转换为可直接入库的bean
	  */
    public static void transMapToNewBean(Map<String, Object> map, Object obj) {  
    	  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            //默认值
            Map<String,Object> defaultVals = new HashMap();
//            defaultVals.put("id", UuidUtil.get32UUID());
//            defaultVals.put("createBy", "admin");
//            defaultVals.put("createDate", new Date());
//            defaultVals.put("delFlag", false);
            
//            if(!StringUtils.isNotEmptyAndNull(String.valueOf(map.get("id")))){
//            	map.put("id", UuidUtil.get32UUID());
//            }
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
//                logger.info("transMapToNewBean key:" + key);
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                } 
//                else if(defaultVals.containsKey(key)){
//                	 Object value = defaultVals.get(key);  
//                     // 得到property对应的setter方法  
//                     Method setter = property.getWriteMethod();  
//                     setter.invoke(obj, value);  
//                }
            }  
            
            
  
        } catch (Exception e) {  
            System.out.println("transMap2Bean Error " + e);  
        }  
  
        return;  
  
    }  
}
