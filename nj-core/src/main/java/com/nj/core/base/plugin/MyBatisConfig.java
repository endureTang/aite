package com.nj.core.base.plugin;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @Name com.nj.core.base.plugin.MyBatisConfig
 * @Description Mybatis分页控件配置
 * 
 * @Author bruce
 * @Version 2018年2月7日 下午1:25:19
 * @Copyright 金鼎财富
 *
 */
@Configuration
public class MyBatisConfig {
	@Bean
    public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
	    Properties p = new Properties();
	    p.setProperty("offsetAsPageNum", "true");
	    p.setProperty("rowBoundsWithCount", "true");
	    p.setProperty("reasonable", "true");
	    p.setProperty("dialect", "mysql");
	    p.setProperty("supportMethodsArguments", "false");
	     p.setProperty("pageSizeZero", "true");
	    pageHelper.setProperties(p);
	    return pageHelper;
    }
}
