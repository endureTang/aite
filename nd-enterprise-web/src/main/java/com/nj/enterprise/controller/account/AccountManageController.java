package com.nj.enterprise.controller.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.core.util.StringUtil;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.enums.ERoleType;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.RegExpUtil;
import com.nj.core.base.util.SHA;
import com.nj.core.base.util.UuidUtil;
import com.nj.enterprise.constant.EntpriseConstant;
import com.nj.enterprise.utils.Util;
import com.nj.model.generate.NjChannel;
import com.nj.model.generate.NjChannelUser;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjProductUser;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.SysRole;
import com.nj.model.generate.SysUserRole;
import com.nj.service.enterprise.ChannelService;
import com.nj.service.enterprise.NjUserService;
import com.nj.service.enterprise.ProductService;
import com.nj.service.enterprise.RoleService;
import com.nj.service.enterprise.UserRoleService;

/**
 * 账号管理
 * @author wkh
 */
@RestController
@RequestMapping(value = "/acctManage")
public class AccountManageController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(AccountManageController.class);
	
	@Resource
	private NjUserService njUserService;
	@Resource
	private RoleService njRoleService;
	@Resource
	private UserRoleService userRoleService;
	@Resource
	private ProductService productService;
	@Resource
	private ChannelService channelService;
	
	@ResourcesAnnotion(uri="/acctManage/acctListPage",name="所有账号",parentId="206",resourceType=2)
	@GetMapping(value = "/acctListPage")
	public ModelAndView toAcctListPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("acctManage/acct_list");
		return mv;
	}
	
	@ResourcesAnnotion(uri="/acctManage/acctListPage",name="所有账号",parentId="206",resourceType=2)
	@PostMapping(value = "/acctListPage")
	@ResponseBody
	public PageData getAcctList(){
		PageData result = new PageData();
		
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    String coporateId = (String) session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID);

 	    PageData param = this.getPageData();
 	    PageHelper.startPage(param.getInteger("start"), param.getInteger("length"));
 	    param.put("coporateId", coporateId);
	 	
 	    try {
	 		PageInfo<?> info = new PageInfo<>(njUserService.getCopoUserForAcctManagePage(param));
            result.put(Constants.Datas.RECORDSTOTAL, info.getTotal());
            result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
            result.put(Constants.Datas.NDATA, info.getList());
	 		
            result.put(Constants.Datas.STATUS, 0);
		} catch (Exception e) {
			logger.error("查询用户列表时发生异常：",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "查询失败");
		}
		
		return result;
	}
	
	@ResourcesAnnotion(uri="/acctManage/delete",name="所有账号->删除",resourceType=3, parentId = "206")
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public PageData delete(){
		PageData result = new PageData();
		
		PageData param = this.getPageData();
		String ids = param.getString("ids");
		try {
			njUserService.deleteAcct(Arrays.asList(ids.split(",")));
		} catch (Exception e) {
			logger.error("删除发生异常:",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "删除失败，请联系管理员");
		}
		
		result.put("status", 0);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@ResourcesAnnotion(uri="/acctManage/toAddPage",name="新建账号",resourceType=3, parentId = "206")
	@RequestMapping(value = "/toAddPage",method=RequestMethod.GET)
	public ModelAndView toAddPage(){
		ModelAndView mv = new ModelAndView();
		
		PageData pd = new PageData();
		pd.put("coporateId", Util.getCurrentCoporateId());
		pd.put("state", 5);
		try {
			List<Map> products = productService.getAllProductList(pd);
			mv.addObject("products", products);
		} catch (Exception e) {
			logger.error("调用getAllProductList()时报错：",e);
		}
		
		List<NjChannel> channelList = channelService.getChannelForCoporate(Util.getCurrentCoporateId());
		mv.addObject("channelList", channelList);
		
		mv.setViewName("acctManage/acct_add");
		return mv;
	}
	
	@ResourcesAnnotion(uri="/acctManage/add",name="新建账号->保存",resourceType=3, parentId = "206")
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public PageData add(){
		PageData result = new PageData();
		
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    String curUserId = (String) session.getAttribute(EntpriseConstant.SessionKey.USER_ID);
 	    String coporateId = (String) session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID);
 	    
 	    PageData param = this.getPageData();
 	    String mobile = param.getString("mobile");
 	    PageData pd = new PageData();
 	    pd.put("userMobile", mobile);
 	    try {
 		   NjUserInfo dbUser = njUserService.getNjUserInfo(pd);
 		   if(null != dbUser && dbUser.getDelFlag() != true){
 				result.put(Constants.Datas.STATUS, -1);
 				result.put(Constants.Datas.MSG, "登陆账号为："+mobile+"的用户已存在");
 				return result;
 		   }
		} catch (Exception e1) {
			logger.error("新增角色时发生异常:",e1);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "新增角色失败，请联系管理员");
		}
 	   
 	    String password = param.getString("password");
 	    if(!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)){
			result.put(Constants.Datas.STATUS,-1);
			result.put(Constants.Datas.MSG, "密码必须为8到16位的数字字母组成");
			return result;
		} 
 	    
		NjUserInfo user = new NjUserInfo();
		user.setId(UuidUtil.get32UUID());
		user.setUserName(param.getString("userName"));
		user.setParentId(param.getString("leaderSelect"));
		user.setUserMobile(param.getString("mobile"));
		user.setPassword(SHA.getSHA256StrJava(param.getString("password")));
		user.setRemarks(param.getString("reamrks"));
		user.setState(param.getInteger("state"));
		user.setCreateBy(curUserId);
		user.setCreateDate(new Date());
		user.setUpdateBy(curUserId);
		user.setUpdateDate(new Date());
		user.setDelFlag(false);
		
		List<SysUserRole> urList = new ArrayList<SysUserRole>();
		String[] roleIds = param.getString("role").split(",");
		
		for (int i = 0; i < roleIds.length; i++) {
			if(!StringUtil.isBlank(roleIds[i])){
				SysUserRole ur = new SysUserRole();
				ur.setCoporateId(coporateId);
				ur.setId(UuidUtil.get32UUID());
				ur.setRoleId(roleIds[i].split("-")[0]);
				ur.setUserId(user.getId());
				
				urList.add(ur);
			}
		}
		
		List<NjProductUser> pUserLsit = new ArrayList<NjProductUser>();
		String[] productIds = param.getString("products").split(",");
		for (int i = 0; i < productIds.length; i++) {
			if(!StringUtil.isBlank(productIds[i])){
				NjProductUser pu = new NjProductUser();
				pu.setId(UuidUtil.get32UUID());
				pu.setProductId(productIds[i]);
				pu.setRoleId("0");		//领导确认该字段不用，因此传默认值0
				pu.setUserId(user.getId());
				
				pUserLsit.add(pu);
			}
		}
		
		List<NjChannelUser> cuList = new ArrayList<NjChannelUser>();
		String[] channelIds = param.getString("channels").split(",");
		for (int i = 0; i < channelIds.length; i++) {
			if(!StringUtil.isBlank(channelIds[i])){
				NjChannelUser cu = new NjChannelUser();
				cu.setId(UuidUtil.get32UUID());
				cu.setChannelId(channelIds[i]);
				cu.setUserInfoId(user.getId());
				cu.setCreateTime(new Date());
				cuList.add(cu);
			}
		}
		
		NjCoporateUser cu = new NjCoporateUser();
		cu.setId(UuidUtil.get32UUID());
		cu.setUserId(user.getId());
		cu.setCoporateId(coporateId);
		cu.setState(1);
		
		try {
			userRoleService.saveDate(user, urList,pUserLsit,cuList,cu);
			result.put(Constants.Datas.STATUS, 0);
		} catch (Exception e) {
			logger.error("新增角色时发生异常:",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "新增角色失败，请联系管理员");
		}
		
		return result;
	}
	
	/**
	 * 获取企业的角色
	 */
	@ResourcesAnnotion(uri="/acctManage/getRoleByCoporateId",name="新建账号、编辑->获取企业的角色",resourceType=3, parentId = "206")
	@RequestMapping(value = "/getRoleByCoporateId",method=RequestMethod.POST)
	@ResponseBody
	public PageData getRoleByCoporateId(){
		PageData result = new PageData();
		
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    String coporateId = (String) session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID);
		try {
			List<SysRole> data = njRoleService.getRolesByOfficeId(coporateId);
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, data);
		} catch (Exception e) {
			logger.error("获取企业角色时发生异常:",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "获取企业角色失败，请联系管理员");
		}
		
		return result;
	}
	
	/**
	 * 获取企业的业务主管的用户
	 */
	@ResourcesAnnotion(uri="/acctManage/getBusinessManagerByCoporateId",name="新建账号、编辑->获取企业的业务主管的用户",resourceType=3, parentId = "206")
	@PostMapping(value = "/getBusinessManagerByCoporateId")
	@ResponseBody
	public PageData getBusinessManagerByCoporateId(){
		PageData result = new PageData();
		
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    String coporateId = (String) session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID);
 	    
 	    try {
 	    	List<Map> data = userRoleService.getUserByRoleTypeCoporateId(ERoleType.BUSINESSMANAGER.getValue(), coporateId);
 	    	result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, data);
		} catch (Exception e) {
			logger.error("获取企业的业务主管的用户时发生异常:",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "获取企业的业务主管的用户失败，请联系管理员");
		}
 	    
 	    return result;
	}
	
	@ResourcesAnnotion(uri="/acctManage/toEditPage",name="所有账号->编辑",resourceType=3, parentId = "206")
	@RequestMapping(value = "/toEditPage",method=RequestMethod.GET)
	public ModelAndView toEditPage(String userId){
		ModelAndView mv = new ModelAndView();
		
		Subject currentUser = SecurityUtils.getSubject();
 	    Session session = currentUser.getSession();
 	    String coporateId = (String) session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID);
		try {
			List<SysRole> roleData = njRoleService.getRolesByOfficeId(coporateId);		//企业角色
			List<Map> bmData = userRoleService.getUserByRoleTypeCoporateId(ERoleType.BUSINESSMANAGER.getValue(), coporateId);	//企业业务经理
			
			PageData pd = new PageData();
			pd.put("coporateId", Util.getCurrentCoporateId());
			pd.put("state", 5);
			try {
				List<Map> products = productService.getAllProductList(pd);	
				mv.addObject("products", products);		//当前企业所有产品
			} catch (Exception e) {
				logger.error("调用getAllProductList()时报错：",e);
			}
			
			List<NjChannel> channelList = channelService.getChannelForCoporate(Util.getCurrentCoporateId());
			mv.addObject("channelList", channelList);		//当前企业所有渠道
			
			mv.setViewName("acctManage/acct_edit");
			mv.addObject("userId", userId);
			mv.addObject("roleData", roleData);
			mv.addObject("bmData", bmData);
		} catch (Exception e) {
			logger.error("发生异常:",e);
		}
		
		return mv;
	}
	
	@ResourcesAnnotion(uri="/acctManage/toEditPage",name="编辑",resourceType=3, parentId = "206")
	@RequestMapping(value = "/toEditPage",method=RequestMethod.POST)
	public PageData getEditData(String userId){
		PageData result = new PageData();
		
		try {
			Map userData = userRoleService.getUserEditData(userId);		//查询当前用户数据，包括有权限的产品和渠道id等
			
			result.put(Constants.Datas.STATUS, 0);
			result.put(Constants.Datas.NDATA, userData);
		} catch (Exception e) {
			logger.error("获取编辑数据时发生异常:",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "获取编辑数据时失败，请联系管理员");
		}
		return result;
	}
	
	@ResourcesAnnotion(uri="/acctManage/edit",name="账号编辑保存",resourceType=3, parentId = "206")
	@RequestMapping(value = "/edit",method=RequestMethod.POST)
	public PageData edit(){
		PageData result = new PageData();
		
		PageData param = this.getPageData();
		PageData pd = new PageData();
		pd.put("userId", param.getString("userId"));
		
		try {
			NjUserInfo user = njUserService.getNjUserInfo(pd);
			user.setUserName(param.getString("userName"));
			user.setParentId(param.getString("leaderSelect"));
			user.setUserMobile(param.getString("mobile"));
			String oldpassword = param.getString("oldpassword");
			String password = param.getString("password");
			if(oldpassword.equals(password)){
				user.setPassword(oldpassword);
			}else{
		 	    if(!RegExpUtil.regExp(RegExpUtil.PASSWORD_ONE, password)){
					result.put(Constants.Datas.STATUS,-1);
					result.put(Constants.Datas.MSG, "密码必须为8到16位的数字字母组成");
					return result;
				} 
				
				user.setPassword(SHA.getSHA256StrJava(param.getString("password")));
			}
			user.setRemarks(param.getString("reamrks"));
			user.setState(param.getInteger("state"));
			
			Subject currentUser = SecurityUtils.getSubject();
	 	    Session session = currentUser.getSession();
	 	    String curUserId = (String) session.getAttribute(EntpriseConstant.SessionKey.USER_ID);

			user.setUpdateBy(curUserId);
			user.setUpdateDate(new Date());
			
			List<SysUserRole> insertList = new ArrayList<SysUserRole>();
			String roleIds = param.getString("role");
			if(!StringUtil.isBlank(roleIds)){
				String[] roleIdArr = roleIds.split(",");
				for (int i = 0; i < roleIdArr.length; i++) {
					SysUserRole ur = new SysUserRole();
					ur.setId(UuidUtil.get32UUID());
					ur.setCoporateId((String) session.getAttribute(EntpriseConstant.SessionKey.COPORATE_ID));
					ur.setRoleId(roleIdArr[i].split("-")[0]);
					ur.setUserId(param.getString("userId"));
					
					insertList.add(ur);
				}
			}
			
			List<NjProductUser> insertPUserList = new ArrayList<NjProductUser>();
			String[] productIds = param.getString("products").split(",");
			for (int i = 0; i < productIds.length; i++) {
				if(!StringUtil.isBlank(productIds[i])){
					NjProductUser pu = new NjProductUser();
					pu.setId(UuidUtil.get32UUID());
					pu.setProductId(productIds[i]);
					pu.setRoleId("0");		//领导确认该字段不用，因此传默认值0
					pu.setUserId(user.getId());
					
					insertPUserList.add(pu);
				}
			}
			
			List<NjChannelUser> insertCcuList = new ArrayList<NjChannelUser>();
			String[] channelIds = param.getString("channels").split(",");
			for (int i = 0; i < channelIds.length; i++) {
				if(!StringUtil.isBlank(channelIds[i])){
					NjChannelUser cu = new NjChannelUser();
					cu.setId(UuidUtil.get32UUID());
					cu.setChannelId(channelIds[i]);
					cu.setUserInfoId(user.getId());
					cu.setCreateTime(new Date());
					insertCcuList.add(cu);
				}
			}
			
			//更新user数据   全删全插用户角色数据
			userRoleService.userEditSave(user, insertList ,insertPUserList,insertCcuList);
			
			result.put(Constants.Datas.STATUS, 0);
		} catch (Exception e) {
			logger.error("编辑数据时发生异常:",e);
			result.put(Constants.Datas.STATUS, -1);
			result.put(Constants.Datas.MSG, "编辑数据时失败，请联系管理员");
		}
		
		return result;
	}
}
