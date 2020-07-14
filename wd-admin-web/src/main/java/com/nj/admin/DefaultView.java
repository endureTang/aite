package com.nj.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @Name com.nj.enterprise.DefaultView
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年2月24日 上午10:01:58
 * @Copyright 金鼎财富
 *
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/sys/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
