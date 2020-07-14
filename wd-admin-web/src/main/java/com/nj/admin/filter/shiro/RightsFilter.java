/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * May 6, 2015     YangShengJun         Create the class
 */

package com.nj.admin.filter.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.nj.core.base.util.Const;



/**
 * @FileName RightsFilter.java
 * @Description:
 *
 * @Date May 6, 2015 
 * @author YangShengJun
 * @version 1.0
 *
 */
public class RightsFilter extends AccessControlFilter {

	private String unauthorizedUrl = "/user/unauthorized";

//    public static final String DEFAULT_UNAUTH_URL = "/unAuth.jsp";
//
//    private String unAuthUrl = DEFAULT_UNAUTH_URL;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		if (isLoginRequest(request, response)) {
			return true;
		} else {
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getServletPath();
			Subject subject = SecurityUtils.getSubject();

			if(url.indexOf("/outApi/") != -1) return true;
			if (subject.getPrincipal() != null) {
				// 判断该请求是否包含在要求过滤的列表中，如果是则判断访问的用户是否有权限访问资源。
				//if(url.startsWith("/")) url=url.substring(1);
				//if(url.endsWith("/list")) url=url.substring(0, url.lastIndexOf("/list"));
				//if(url.endsWith("/form")) url=url.substring(0, url.lastIndexOf("/form"));
				boolean hasPermition=subject.isPermitted(url);
				//boolean isAdmin= subject.hasRole(Const.ADMIN_ROLE);
				//isAdmin=false;

				return hasPermition;
//				return (hasPermition || isAdmin);
			}
			return false;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		Subject subject = SecurityUtils.getSubject();
		//已登录，权限不够
		if (subject.isAuthenticated()) {
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getServletPath();

//			if (StringUtils.hasText(unauthorizedUrl)) {//如果有未授权页面跳转过去  
//                WebUtils.issueRedirect(request, response, unauthorizedUrl);  
//            } else {//否则返回401未授权状态码  

			//203
			// WebUtils.toHttp(response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
//            } 

			return true;
			//isAccessAllowed 有一些本不应该拦截的url, 若理顺后，改方法可以直接返回false
			//将上面url答应出来的放在shiro的匿名访问列表中就可以了， 例如url:/tab.do； main/index
		}
		//401 
		WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
		return false;
	}

//	protected void redirectToAuthInfo(ServletRequest request, ServletResponse response) throws IOException {
//        String url = getUnAuthUrl();
//        WebUtils.issueRedirect(request, response, url);
//    }
//
//	public String getUnAuthUrl() {
//		return unAuthUrl;
//	}
//
//	public void setUnAuthUrl(String unAuthUrl) {
//		this.unAuthUrl = unAuthUrl;
//	}

}