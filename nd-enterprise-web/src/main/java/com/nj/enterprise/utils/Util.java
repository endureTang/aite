package com.nj.enterprise.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.model.generate.NjUserInfo;

/**
 * 
 * @Name com.nj.enterprise.utils.Util
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月6日 下午2:26:05
 * @Copyright 金鼎财富
 *
 */
public class Util {
	public static String getCurrentUserId() {
		String userId="";
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    Object obj = session.getAttribute(EntpriseConstant.SessionKey.USER_ID);
 	    if(obj!=null) {
 	    	userId=obj.toString();
 	    }
 	    return userId;
	}
	public static NjUserInfo getCurrentUser() {
		NjUserInfo user = null;
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    Object obj = session.getAttribute(EntpriseConstant.SessionKey.USER);
 	    if(obj!=null)
 	    	user=(NjUserInfo)obj;
 	    return user;
	}
	
	/**
	 * 获取用户所在企业id
	 * @return
	 */
	public static String getCurrentCoporateId() {
		String coporateId="";
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    Object obj = session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID);
 	    if(obj!=null) {
 	    	coporateId=obj.toString();
 	    }
 	    return coporateId;
	}
	/**
	 * 获取用户角色类型
	 * @return
	 */
	public static String getCurrentRoleType() {
		String roleType="";
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    Object obj = session.getAttribute(EntpriseConstant.SessionKey.ROLE_TYPE);
 	    if(obj!=null) {
 	    	roleType=obj.toString();
 	    }
 	    return roleType;
	}
}
