package com.nj.enterprise.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.extend.SysRoleMapperExtend;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.enterprise.controller.product.ProductController;
import com.nj.enterprise.utils.Util;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserInfoExample;
import com.nj.model.generate.SysResource;
import com.nj.service.enterprise.NjUserService;

/**
 * 
 * @Name com.nj.enterprise.shiro.AuthRealm
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年3月5日 下午3:23:14
 * @Copyright 金鼎财富
 *
 */
public class AuthRealm extends AuthorizingRealm{
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	NjUserInfoMapper userInfoMapper;
	@Autowired
	SysRoleMapperExtend sysRoleMapperExtend;
	
	@Resource(name ="njUserService")
	private NjUserService njUserService;
	@Autowired
	private RetryLimitCredentialsMatcher retryLimitCredentialsMatcher;
	//认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
    	CaptchaUsernamePasswordToken utoken=(CaptchaUsernamePasswordToken) token;//获取用户输入的token
    	Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
    	if (utoken.getCaptcha() == null || !session.getAttribute("sessionSecCode").equals(utoken.getCaptcha())) {
            throw new DisabledAccountException("校验码错误!");
        }
    	
    	NjUserInfoExample ex = new NjUserInfoExample();
    	ex.createCriteria().andUserMobileEqualTo(utoken.getUsername()).andDelFlagEqualTo(false);
		List<NjUserInfo> uList = userInfoMapper.selectByExample(ex);
        if(CollectionUtils.isEmpty(uList)) {
        	throw new DisabledAccountException("用户账号不存在！");
        }
        NjUserInfo userInfo = uList.get(0);
        if(userInfo.getState()==1) {
        	throw new DisabledAccountException("用户已禁用！");
        }
        //放入shiro.调用CredentialsMatcher检验密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),getName());
        session.setAttribute(EntpriseConstant.SessionKey.USER_ID, userInfo.getId()); 
        session.setAttribute(EntpriseConstant.SessionKey.TOKEN_NAME,userInfo.getUserMobile());
        session.setAttribute(EntpriseConstant.SessionKey.USER, userInfo);
        //获取用户所在企业
	    String corppid = null;
		try {
			corppid = njUserService.getUserCoporateId(userInfo.getId());
		} catch (Exception e) {
			logger.error("登陆出错:用户所在企业未知"+e.getMessage());
			throw new DisabledAccountException("用户所在企业未知");
		}
	    session.setAttribute(EntpriseConstant.SessionKey.COPORATE_ID, corppid);
	    try {
	    	String roleType = njUserService.getUserRole(userInfo.getId());
		    session.setAttribute(EntpriseConstant.SessionKey.ROLE_TYPE, roleType);
		} catch (Exception e) {
			logger.error("登陆出错:用户尚未绑定角色"+e.getMessage());
			throw new DisabledAccountException("用户尚未绑定角色");
		}
	    retryLimitCredentialsMatcher.setMaxRetryNum(5);
	    boolean limitCount = retryLimitCredentialsMatcher.doCredentialsMatch(token, authenticationInfo);
//	    if(limitCount) {
//	    	throw new DisabledAccountException("用户尚未绑定角色");
//	    }
	    
        return authenticationInfo;
    	
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
    	NjUserInfo user=(NjUserInfo) super.getAvailablePrincipal(principal);
    	//String loginName = (String)super.getAvailablePrincipal(principal); 
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("userId", user.getId());
        condition.put("coporateId", Util.getCurrentCoporateId());
        List<Map> roles = sysRoleMapperExtend.findNjUserRolesByUserId(condition);
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        if(roles.size()>0) {
            for(Map role : roles) {
            	info.addRole(role.get("id").toString());
            	
            	List<SysResource> srList = sysRoleMapperExtend.selectResourceByRoleId(role.get("id").toString());
            	for (SysResource sr : srList) {  
            		String uri=sr.getHref();
                    int index = uri.indexOf("?");
            		if(index>0) {
            			uri = uri.substring(0,index);
            		}
            		info.addStringPermission(uri);
            	}
            }
        }
        return info;
    }

}
