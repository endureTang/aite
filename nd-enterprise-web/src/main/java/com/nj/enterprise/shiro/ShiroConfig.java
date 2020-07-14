package com.nj.enterprise.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * 
 * @Name com.nj.enterprise.filter.ShiroConfig
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月5日 下午3:15:36
 * @Copyright 金鼎财富
 *
 */
@Configuration
public class ShiroConfig {
	@Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 自定义过滤器
        Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
        //Map<String, Filter> filterMap = new LinkedHashMap<String, Filter>();
        filterMap.put("hasToken",new AccessShiroFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/tdScore.html", "anon");
        filterChainDefinitionMap.put("/statistics/**", "anon");
        filterChainDefinitionMap.put("/repaySituation/getDynamicFeeInfo", "anon");
        filterChainDefinitionMap.put("/repayStatistics/getRepayStatistics", "anon");
        filterChainDefinitionMap.put("/repayStatistics/exportStatistics", "anon");
        
        filterChainDefinitionMap.put("/baseInfoPrint.html", "anon");
        filterChainDefinitionMap.put("/investigatePrint.html", "anon");
        filterChainDefinitionMap.put("/businessApprovePrint.html", "anon");
        filterChainDefinitionMap.put("/loanApprovePrint.html", "anon");
        
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/attachment/**", "anon");
        filterChainDefinitionMap.put("/index.jsp", "anon");
        filterChainDefinitionMap.put("/welcomePage", "anon");
        filterChainDefinitionMap.put("/code", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        filterChainDefinitionMap.put("/user/checkAuthority", "anon");
        filterChainDefinitionMap.put("/areaCtr/**", "anon");
        filterChainDefinitionMap.put("/common/**", "anon");
        filterChainDefinitionMap.put("/customer/relation/getBusiCommForCoro", "anon");
        filterChainDefinitionMap.put("/afterDataDraw/**", "anon");
        //filterChainDefinitionMap.put("/*/get**", "anon");
        //filterChainDefinitionMap.put("/*/get/*", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "hasToken");
        //filterChainDefinitionMap.put("/**", "anon");
        
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/home");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthRealm myShiroRealm(){
    	AuthRealm myShiroRealm = new AuthRealm();
//    	myShiroRealm.setAuthenticationCachingEnabled(false);
        return myShiroRealm;
    }
    /*@Bean
    public AccessShiroFilter accessTokenFilter(){
        return new AccessShiroFilter();
    }*/

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
    
    @Bean  
    public HashedCredentialsMatcher hashedCredentialsMatcher() {  
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();  
        hashedCredentialsMatcher.setHashAlgorithmName("sha1");
        hashedCredentialsMatcher.setHashIterations(1);  
        return hashedCredentialsMatcher;  
    }  
    @Bean  
    public HandlerExceptionResolver solver(){  
        HandlerExceptionResolver handlerExceptionResolver=new MyExceptionResolver();  
        return handlerExceptionResolver;  
    }  
    
    
}
