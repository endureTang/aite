package com.nj.enterprise.shiro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Name com.nj.enterprise.shiro.MyExceptionResolver
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月23日 上午9:18:28
 * @Copyright 金鼎财富
 *
 */
public class MyExceptionResolver implements HandlerExceptionResolver{
	public ModelAndView resolveException(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex) {    
        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url    
        if(ex instanceof UnauthorizedException){    
            ModelAndView mv = new ModelAndView("/error");    
            return mv;    
        }    
        return null;    
    }  
}
