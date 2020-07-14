package com.nj.admin.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class SymbolConfigurer extends WebMvcConfigurerAdapter {
    @Resource
    private Environment env;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        String active = env.getProperty("spring.profiles.active");
//        if ("test".equals(active)) {
//            registry.addInterceptor(new SymbolInterceptor()).addPathPatterns("/**");
//        }
        super.addInterceptors(registry);
    }

}