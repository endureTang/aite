package com.nj.admin.controller;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.util.AppUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.Tools;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController
  extends BaseController
{
  private static Logger logger = LoggerFactory.getLogger(LoginController.class);
  
  public void getRemoteIP(String loginName)
    throws Exception
  {
    PageData pd = new PageData();
    HttpServletRequest request = getRequest();
    String ip = "";
    if (request.getHeader("x-forwarded-for") == null) {
      ip = request.getRemoteAddr();
    } else {
      ip = request.getHeader("x-forwarded-for");
    }
    pd.put("loginName", loginName);
    pd.put("ip", ip);
  }
  
  @RequestMapping({"/login_toLogin"})
  public ModelAndView toLogin()
    throws Exception
  {
    ModelAndView mv = getModelAndView();
    PageData pd = new PageData();
    pd = getPageData();
    pd.put("sysname", Tools.readTxtFile("admin/config/SYSNAME.txt"));
    
    String password = new SimpleHash("SHA-1", "MD5", "123456").toString();
    
    mv.setViewName("sys/admin/index");
    mv.addObject("pd", pd);
    return mv;
  }
  
  @RequestMapping({"/login_login"})
  @ResponseBody
  public Object login()
    throws Exception
  {
    Map<String, String> map = new HashMap();
    PageData pd = getPageData();
    String errInfo = "";
    String keyData = pd.getString("keyData");
    keyData = keyData.replaceAll("ksbadmtn1f2izwqy", "");
    keyData = keyData.replaceAll("ipvb5cxat0zn9eg7", "");
    String[] keyDatas = keyData.split(",00,");
    
    map.put("result", "success");
    Object obj = AppUtil.returnObject(new PageData(), map);
    return obj;
  }
  
  @RequestMapping({"/sys/index"})
  public ModelAndView login_index(Page page)
  {
    ModelAndView mv = getModelAndView();
    
    mv.setViewName("sys/admin/index");
    return mv;
  }
  
  @RequestMapping({"/tab"})
  public String tab()
  {
    return "system/admin/tab";
  }
  
  @RequestMapping({"/login_default"})
  public String defaultPage()
  {
    return "system/admin/default";
  }
  
  @RequestMapping(value={"/auth"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Object auth()
    throws Exception
  {
    Map<String, String> map = new HashMap();
    PageData pd = getPageData();
    String errInfo = "";
    String keyData = pd.getString("keyData");
    keyData = keyData.replaceAll("ksbadmtn1f2izwqy", "");
    keyData = keyData.replaceAll("ipvb5cxat0zn9eg7", "");
    String[] keyDatas = keyData.split(",00,");
    
    map.put("result", "success");
    
    Object obj = AppUtil.returnObject(new PageData(), map);
    return obj;
  }
  
  @RequestMapping({"/app/logout"})
  public void appLogout()
  {
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
  }
}
