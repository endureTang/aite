package com.nj.enterprise.filter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UserSessions;
import com.nj.core.base.util.UuidUtil;

/**
 * 插入、更新时，动态设置或更新id、创建人、创建时间、更新人、更新时间、是否删除等字段
 */
public class DbActionsFilter implements MethodInterceptor {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {

		Object[] args = arg0.getArguments();
		String methodName = arg0.getMethod().getName();
		int methodType = getMethodType(methodName);
		logger.debug("method filter: " + methodName + " method type: " + methodType );
		
		//设置为过滤条件
		if( methodType > 0){
			for (Object record : args){
				if(record != null){
					String userSession = null;
					try {
						userSession = String.valueOf(UserSessions.get(Constants.USER_SESSION_KEY));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						userSession = "后台任务";
					}
					String filerPackage = "com.nj.model";
		    		try {  
		                BeanInfo beanInfo = Introspector.getBeanInfo(record.getClass());  
		                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
		                //默认值
		                if(record instanceof PageData){
		                	PageData temp = (PageData)record;
		                	if(methodType == 1){
		                		if(!StringUtils.isNotEmptyAndNull(temp.getString(Constants.ID_KEY))){
		                			temp.put(Constants.ID_KEY, UuidUtil.get32UUID());
		                		}
			                	temp.put(Constants.CREATE_KEY,userSession);
			                	temp.put(Constants.CREATE_DATE_KEY, new Date());
			                	temp.put(Constants.DEL_KEY, Boolean.FALSE);
		                	}else{
		                		temp.put(Constants.UPDATE_KEY, userSession);
			                	temp.put(Constants.UPDATE_DATE_KEY, new Date());
		                	}
		                	
		                }else if(record.getClass().getPackage().getName().contains(filerPackage)){		                	
		                	 Map<String,Object> defaultVals = new HashMap<String, Object>();
		                	 Method getIdMethod = record.getClass().getMethod("getId");
		                	 if(getIdMethod !=null){
		                		 Object idVal = getIdMethod.invoke(record);
			                	 if(idVal == null){
			                		 methodType = 1;
			                	 }
		                	 }
		                	 if(methodType == 1){
			                     defaultVals.put(Constants.ID_KEY, UuidUtil.get32UUID());
			                     defaultVals.put(Constants.CREATE_KEY, userSession);
			                     defaultVals.put(Constants.CREATE_DATE_KEY, new Date());
			                     defaultVals.put(Constants.DEL_KEY, Boolean.FALSE);
		                	 }else{
		                		 defaultVals.put(Constants.UPDATE_KEY, userSession);
		                		 defaultVals.put(Constants.UPDATE_DATE_KEY, new Date());
		                	 }
		                     for (PropertyDescriptor property : propertyDescriptors) {  
		                         String key = property.getName();  
		                         if(defaultVals.containsKey(key)){
		                         	 Object value = defaultVals.get(key); 
		                              // 得到property对应的setter方法  
		                              Method setter = property.getWriteMethod();  
		                              Method getter = property.getReadMethod();
		                        
		                              setter.invoke(record, value);  
		                         }
		                     }  
		                }
		                logger.debug("obj info: " + String.valueOf(record));
		            } catch (Exception e) {  
		                logger.error("invoke Error " + e);  
		                throw e;
		            }  
		    	}
			}
		}else{
			
		}

		 Object returnObject = arg0.proceed();
		return returnObject;
	}

	private int getMethodType(String input){
		String[] filterMethods = {"create","add","insert"};
		String[] updateMethods = {"update"};
		for(String filter : filterMethods){
			if(input.contains(filter)) return 1;
		}
		for(String filter : updateMethods){
			if(input.contains(filter)) return 2;
		}
		return 0;
	}
}
