/**
 * 
 */
package com.nj.core.base.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @Name com.nj.core.base.controller.WebMvcCommonConfig
 * @Description 
 * 
 * @Author Frank
 * @Version 2018年3月21日下午4:54:28
 * @Copyright 金鼎财富
 *
 */
@Configuration
public class WebMvcCommonConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverterFactory(stringToEntityConverterFactory());
	}
	
	@Bean
	public StringToEntityConverterFactory stringToEntityConverterFactory() {
		return new StringToEntityConverterFactory();
	}
	
	@Bean
	public WebMvcErrorAttributes errorAttributes() {
		return new WebMvcErrorAttributes();
	}
}
