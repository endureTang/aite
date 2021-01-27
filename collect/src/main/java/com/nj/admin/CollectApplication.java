package com.nj.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @Name com.nj.enterprise.EnterpriseApplication
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年2月23日 上午11:07:03
 * @Copyright 金鼎财富
 *
 */
@ComponentScan(basePackages={"com.nj.core", "com.nj.admin"})
@ServletComponentScan
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class CollectApplication
        extends SpringBootServletInitializer
{
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(new Class[] { CollectApplication.class });
    }

    public static void main(String[] args)
            throws Exception
    {
        SpringApplication.run(CollectApplication.class, args);
    }
}
