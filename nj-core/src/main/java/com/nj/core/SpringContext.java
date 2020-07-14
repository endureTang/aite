package com.nj.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring上下文
 * 用于通过该类获取spring容器中配置的bean
 */
@Component
public class SpringContext implements ApplicationContextAware{

	private static ApplicationContext ac;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		ac = arg0;
	}
	
	public static Object getBean(String id){
		if(null == ac){
			return null;
		}
		return ac.getBean(id);
	}
}
