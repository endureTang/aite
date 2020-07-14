package com.nj.enterprise.shiro;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.util.AES;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.enterprise.controller.LoginController;
import com.nj.enterprise.utils.EnterpriseConfig;
import com.nj.model.generate.NjUserInfo;
import com.nj.service.enterprise.NjUserService;

/**
 * 
 * @Name com.nj.enterprise.shiro.CaptchaShiroFilter
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月6日 下午1:16:12
 * @Copyright 金鼎财富
 *
 */
public class AccessShiroFilter extends AccessControlFilter {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getServletPath();
		/*String params = req.getQueryString();
		if(params!=null) {
			url =url+"?"+params;
		}*/
		if (isLoginRequest(request, response)) {
			return true;
		} else {
			Subject subject = SecurityUtils.getSubject();
			if (subject.getPrincipal() != null) {
				// 判断该请求是否包含在要求过滤的列表中，如果是则判断访问的用户是否有权限访问资源。
				//if(url.startsWith("/")) url=url.substring(1);
				if(url.equals("/home") || url.equals("/index.jsp")) {
					return true;
				}
				boolean hasPermition=subject.isPermitted(url);
				return hasPermition;
				//return true;
			}else {
				
				// 获取一个cookie数组
				Cookie[] cookies = req.getCookies();
				String loginToken = "";
				if(cookies!=null){
					for(Cookie cookie : cookies){
					    String name=cookie.getName();
					    String value=cookie.getValue(); 
					    if("login_token".equals(name)){
					    	loginToken=value;
					    }
					}
				}
				
				// 解析token
				if (!"".equals(loginToken)) {

					ApplicationContext application = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
					EnterpriseConfig enterpriseConfig = application.getBean(EnterpriseConfig.class);
					NjUserService njUserService =application.getBean(NjUserService.class);

					// 解析token
					logger.info("loginToken"+ loginToken);
					logger.info("loginToken秘钥"+ enterpriseConfig.getTokenSecret());
					String cookieJson = AES.Decrypt(loginToken, enterpriseConfig.getTokenSecret());
					logger.info("loginToken解析后"+cookieJson);
					Map<String,Object> cookieMap = (Map<String,Object>) JSONObject.parseObject(cookieJson);
					if (cookieMap==null) {
						WebUtils.issueRedirect(request, response, "/user/login");
						return false;
					}
					Object loginTokenObj = cookieMap.get("login_token");
					if (loginTokenObj == null) {
						WebUtils.issueRedirect(request, response, "/user/login");
						return false;
					}
					String loginTokenStr = loginTokenObj.toString();
					long loginTime =Long.parseLong(cookieMap.get("login_time").toString());
					String mobile = cookieMap.get("mobile").toString();

					// 检查数据库中的token是否正确
					NjUserInfo userInfo = njUserService.getUserInfoByMobile(mobile);
					if (loginTokenStr.equals(userInfo.getToken())){
						long currentTime =System.currentTimeMillis();
						long overTime = Long.parseLong(enterpriseConfig.getTokenOverTime());
						if (currentTime - loginTime < overTime) {

							// 重置用户信息到shrio
							Subject currentUser = SecurityUtils.getSubject();
					 	    Session session = currentUser.getSession();
					 	    session.setAttribute(EntpriseConstant.SessionKey.USER_ID, userInfo.getId());
					        session.setAttribute(EntpriseConstant.SessionKey.TOKEN_NAME,userInfo.getUserMobile());
					        session.setAttribute(EntpriseConstant.SessionKey.USER, userInfo);
					    	String corppid = njUserService.getUserCoporateId(userInfo.getId());
					    	session.setAttribute(EntpriseConstant.SessionKey.COPORATE_ID, corppid);
					    	String roleType = njUserService.getUserRole(userInfo.getId());
						    session.setAttribute(EntpriseConstant.SessionKey.ROLE_TYPE, roleType);

							return true;
						}
					}
				}
				
				WebUtils.issueRedirect(request, response, "/user/login"); 
				return false;
			}
			
		}
	}
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/*WebUtils.toHttp(response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
		return false;*/
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getServletPath();
		logger.info("AccessDeniedUrl===="+url);
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        if (StringUtils.isNotEmpty(requestedWith)&&StringUtils.equals(requestedWith, "XMLHttpRequest")) {//如果是ajax返回指定格式数据
        	ResponseDto<String> result = new ResponseDto<String>(2000,"没有授权的访问");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
           // WebUtils.toHttp(response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
        } else {//如果是普通请求进行重定向
//        	WebUtils.toHttp(response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
        }
        return false;
	}
}
