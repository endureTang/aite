package com.nj.enterprise.constant;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.nj.model.datamodel.WebInitConfig;

/**
 * 
 * @Name com.nj.enterprise.constant.WebConfig
 * @Description 多登录样式切换
 * 
 * @Author TangRenjian
 * @Version 2018年2月5日 下午3:30:39
 * @Copyright 金鼎财富
 *
 */
@Component("webConfig") 
@Configuration
@PropertySource(value = {"classpath:${spring.profiles.active}/webConfig.properties"},encoding="utf-8") 
@ConfigurationProperties(prefix="webConfig")
public class WebConfig {
	private List<WebInitConfig> webInit;
	
	public List<WebInitConfig> getWebInit() {
		return webInit;
	}
	public void setWebInit(List<WebInitConfig> webInit) {
		this.webInit = webInit;
	}
	@Bean
	public WebInitConfig getWdjrConfig() {
		return webInit.get(0);
	}
	@Bean
	public WebInitConfig getJdndConfig() {
		return webInit.get(1);
	}
}
