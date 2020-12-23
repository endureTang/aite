package com.nj.service.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Configuration
public class AppConfigService {

	@Resource
    private Environment env;

	private static Properties properties= new Properties();


	private static Logger logger = LoggerFactory.getLogger(AppConfigService.class);

	/**
	 * spring mvc 配置使用
	 */
	/*public AppConfigService(@Resource List<String> files){
		properties.clear();
		for(String file: files){
			if(!StringUtils.isEmpty(file)){
				//Properties p = new Properties();
				try {
					System.out.println("url is :"+file);
					properties.load(AppConfigService.class.getResourceAsStream(file));
					//properties.load(Thread.currentThread().getContextClassLoader().getSystemResourceAsStream(file));
				} catch (IOException e) {
					logger.info("load properties file:"+file+" error,",e);
					e.printStackTrace();
				};
			}
		}
	}*/
	/**
	 * spring boot 配置使用
	 */
	/*public AppConfigService(){
		properties.clear();
		List<String> files =new ArrayList<String>();
		String appFile="/"+getActive()+"/appConfig.properties";
		logger.info("app file:{}",appFile);
		files.add(appFile);
		for(String file: files){
			if(!StringUtils.isEmpty(file)){
				//Properties p = new Properties();
				try {
					System.out.println("url is :"+file);
					properties.load(AppConfigService.class.getResourceAsStream(file));
					//properties.load(Thread.currentThread().getContextClassLoader().getSystemResourceAsStream(file));
				} catch (IOException e) {
					logger.info("load properties file:"+file+" error,",e);
					e.printStackTrace();
				};				
			}
		}		
	}*/


	public String get(String name){
		return properties.getProperty(name);
	}

	private void remove(String name){
		 properties.remove(name);
	}

	public void destroy(){
		properties.clear();
	}


}
