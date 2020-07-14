package com.nj.enterprise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableFeignClients(basePackages={"com.nj.service"})
@ServletComponentScan
@EnableTransactionManagement
@ComponentScan(basePackages={"com.nj"})
@SpringBootApplication(exclude = {MongoAutoConfiguration.class,MongoDataAutoConfiguration.class})
public class EnterpriseApplication extends SpringBootServletInitializer{ 
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(this.getClass());
        return super.configure(application);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EnterpriseApplication.class, args);
    }
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
           return new EmbeddedServletContainerCustomizer() {
               @Override
               public void customize(ConfigurableEmbeddedServletContainer container) {
                    container.setSessionTimeout(60*60*60);//单位为S
              }
        };
    }
}
