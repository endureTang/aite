/**
 * 
 * @Name com.nj.enterprise.aspect.SystemLogAspect
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年1月26日 下午2:55:49
 * @Copyright 金鼎财富
 *
 */

package com.nj.enterprise.aspect;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.entity.SystemLog;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysOperateLogMapper;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysOperateLog;

@Aspect  
@Component
public class SystemLogAspect {
	private static Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Pointcut("@annotation(com.nj.core.base.entity.SystemLog)")
	public void serviceAspect() {
	}

	@Before("serviceAspect()")   
    public  void doBefore(JoinPoint joinPoint) {  
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
		try {
			String userId = String.valueOf(request.getSession().getAttribute(EntpriseConstant.SessionKey.USER_ID));
			String function = getServiceMthodDescription(joinPoint); 
			String params = getServiceMthodParams(joinPoint);
			//System.out.println("@Before：参数为：" + Arrays.toString(joinPoint.getArgs()));
			addSysLog(userId,function,params);
		}
		catch(Exception ex) {
			logger.error("SystemLogAspect.doServiceLog:",ex);
		}
	}
	@AfterReturning(pointcut="serviceAspect()")  
    public  void doAfter(JoinPoint joinPoint) {  
    }  
	
	private void addSysLog(String userId,String function,String params) throws Exception{
		if(params != null && params.length() > 2000) {
			params = params.substring(0, 2000);
		}
		params = URLEncoder.encode(params);
		NjUserInfoMapper uiMapper = dao.getMapper(NjUserInfoMapper.class);
		NjUserInfo userInfo = uiMapper.selectByPrimaryKey(userId);
		SysOperateLog sysLog = new SysOperateLog();
		sysLog.setUserId(userInfo.getId());
		sysLog.setUserName(userInfo.getUserName());
		sysLog.setOperateFunction(function);
		sysLog.setOperateContent(params);
		sysLog.setCreateTime(new Date());
		SysOperateLogMapper soLog = dao.getMapper(SysOperateLogMapper.class);
		soLog.insert(sysLog);
	}

	private String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemLog.class).description();
					break;
				}
			}
		}
		return description;
	}

	private String getServiceMthodParams(JoinPoint joinPoint) throws Exception {
		Object[] arguments = joinPoint.getArgs();
		Object[]  objs  =  new Object[arguments.length];
		int  j = 0;
		for(Object  obj:arguments){
			if( obj  instanceof org.apache.catalina.connector.ResponseFacade){
				continue;
			}
			objs[j] = obj;
			j++;
		}
		String params = "";
		if(null != objs){
			try {
				params = JSONObject.toJSONString(objs);
			} catch (Exception e) {
				String argumentsStr = "";
				for (int i = 0; i < objs.length; i++) {
					argumentsStr += objs[i] + ",";
				}
				logger.error("参数arguments的长度="+arguments.length+",参数argumentsStr="+argumentsStr,e);
			}
		}else{
			logger.info("参数objs=null");
		}
		logger.info("params："+params);
		logger.info("-------------------------------------------------");
		for (int i = 0; i < joinPoint.getArgs().length; i++) {  
			logger.info(i+" :"+joinPoint.getArgs()[i]);  
        }  
		return params;
	}
}