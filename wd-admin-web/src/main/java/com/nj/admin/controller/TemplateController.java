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
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.Page;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.model.generate.NjTemplate;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysUser;
import com.nj.service.base.system.LoginService;
import com.nj.service.base.system.TemplateService;
import com.nj.service.base.system.UserService;
import com.nj.core.base.util.AppUtil;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.Tools;

/**
 * @FileName LoginController.java
 * @Description:
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/template")
public class TemplateController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(TemplateController.class);

	@Resource(name = "templateService")
	private TemplateService templateService;
	

	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<NjTemplate> list = templateService.getTemplateList(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(list.size());				
			}
		} catch (Exception e) {
			logger.error("list template error", e);
//			result = new PageData(request);
		}
		
//		Map<String,Object> mp1 = new HashMap<>();
//		mp1.put("id", 1);
//		mp1.put("templateName", "aa");
//		mp1.put("description","aaaaaaaaaaa");
//		Map<String,Object> mp2 = new HashMap<>();
//		mp2.put("id", 2);
//		mp2.put("templateName", "bb");
//		mp2.put("description","bbbbbbb");
		
//		result.addDataMap(mp1);
//		result.addDataMap(mp2);
		
		return result;
	}

	
	@RequestMapping(value = { "upload" })
	@ResponseBody
	public PageData upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model, RedirectAttributes redirectAttributes) {
		PageData result = new PageData();
		
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		if(fileName.indexOf(".xml") == -1){
			result.put("status", 0);
			result.put("msg", "请上传XML格式文件！");
			return result;
		}
		
		fileName = "t_"+System.currentTimeMillis()+".xml";
		
		String rePath = "/upload/";
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);

			NjTemplate template = new NjTemplate();
			// 创建saxReader对象
			SAXReader reader = new SAXReader();
			// 通过read方法读取一个文件 转换成Document对象
			Document document = reader.read(targetFile);
			// 获取根节点元素对象
			Element node = document.getRootElement().element("prodBasicInfo");
			if(node == null){
				result.put("status", 0);
				result.put("msg", "XML模板格式不正确！");
				return result;
			}
			// 遍历所有的元素节点
			for (Iterator it = node.elementIterator(); it.hasNext();) {
				Element element = (Element) it.next();
				String name = element.getName();
				String value = element.getTextTrim();
				if("productName".equals(name)){
					template.setTemplateName(value);
				}
				if("productDescription".equals(name)){
					template.setDescription(value);
				}
				if("isMortgage".equals(name)){
//					template.setTemplateName(value);
				}
				if("payDeadline".equals(name)){
//					template.setTemplateName(value);
				}
				System.out.println(name + " --- " + value);
			}
			template.setFilePath(rePath+fileName);
			boolean bl = false;//templateService.isSaveTemplate(template);
			if(bl){
				result.put("status", 0);
				result.put("msg", "当前模板已经存在！");
				return result;
			}
//			templateService.save(template);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", 1);
		result.put("msg", "上传成功！");
		
		return result;
	}
}
