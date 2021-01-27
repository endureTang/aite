package com.nj.admin.util;//package com.nj.admin.util;
//
//import com.nj.admin.filter.shiro.RightsFilter;
//import org.apache.shiro.cache.MemoryConstrainedCacheManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfiguration
//{
//  private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
//
//  @Bean(name={"ShiroRealm"})
//  public ShiroRealm getShiroRealm()
//  {
//    return new ShiroRealm();
//  }
//
//  @Bean(name={"lifecycleBeanPostProcessor"})
//  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor()
//  {
//    return new LifecycleBeanPostProcessor();
//  }
//
//  @Bean
//  public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator()
//  {
//    DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//    daap.setProxyTargetClass(true);
//    return daap;
//  }
//
//  @Bean(name={"securityManager"})
//  public DefaultWebSecurityManager getDefaultWebSecurityManager()
//  {
//    DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
//    dwsm.setRealm(getShiroRealm());
//    dwsm.setCacheManager(new MemoryConstrainedCacheManager());
//    return dwsm;
//  }
//
//  @Bean
//  public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor()
//  {
//    AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
//    aasa.setSecurityManager(getDefaultWebSecurityManager());
//    return new AuthorizationAttributeSourceAdvisor();
//  }
//
//  @Bean(name={"shiroFilter"})
//  public ShiroFilterFactoryBean getShiroFilterFactoryBean()
//  {
//    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//    shiroFilterFactoryBean
//      .setSecurityManager(getDefaultWebSecurityManager());
//
//    Map<String, Filter> filtersMap = new LinkedHashMap();
//    filtersMap.put("rf", new RightsFilter());
//    shiroFilterFactoryBean.setFilters(filtersMap);
//
//    shiroFilterFactoryBean.setLoginUrl("/");
//    shiroFilterFactoryBean.setSuccessUrl("/main");
//    filterChainDefinitionMap.put("/static/**", "anon");
//    filterChainDefinitionMap.put("/sa/**", "authc");
//    filterChainDefinitionMap.put("/code/**", "anon");
//    filterChainDefinitionMap.put("/auth/**", "anon");
//    filterChainDefinitionMap.put("/sys/index/**", "authc");
//    filterChainDefinitionMap.put("/**", "rf");
//    shiroFilterFactoryBean
//      .setFilterChainDefinitionMap(filterChainDefinitionMap);
//
//    return shiroFilterFactoryBean;
//  }
//}
