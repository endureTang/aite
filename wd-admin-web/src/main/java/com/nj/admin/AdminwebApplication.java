package com.nj.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
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
@MapperScan("com.nj.dao")
@ComponentScan(basePackages={"com.nj.core","com.nj.service","com.nj.admin","com.nj.dao"})
@EnableFeignClients(basePackages={"com.nj.service"})
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication(exclude = {MongoAutoConfiguration.class,MongoDataAutoConfiguration.class})
public class AdminwebApplication extends SpringBootServletInitializer{ 
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminwebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdminwebApplication.class, args);
    }
}
