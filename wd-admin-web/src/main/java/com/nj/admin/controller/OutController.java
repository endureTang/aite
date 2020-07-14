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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nj.admin.constants.PathConstant;
import com.nj.core.base.controller.BaseController;
import com.nj.service.enterprise.OrderLogService;
import com.nj.service.enterprise.OrderService;
import com.nj.service.enterprise.ProductService;

@Controller
@RequestMapping(value = "/outApi")
public class OutController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(OutController.class);
	
	@Resource(name ="orderService")
	private OrderService orderService;
	
	@Resource(name ="orderLogService")
	private OrderLogService orderLogService;
	
	@Resource(name = "productService")
	private ProductService productService;

	/*
	 * 更新订单状态为已放款
	 */

	@RequestMapping(value = "download",method = RequestMethod.POST)
	public void downloadRelative(String fileName,HttpServletRequest request,HttpServletResponse response){
		String path = null;
		if(fileName.indexOf(".bpmn") != -1){
			path = PathConstant.PROCESS_TEMP_PATH_BPMN;
		}else{
			path = PathConstant.PROCESS_TEMP_PATH_PNG;
		}
		
		File file = new File(path, fileName);
		if (file.exists()) {
			try {
				download(path, fileName, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	/**
	 * 下载
	 */
	private static void download(String fileDirpath, String filename, HttpServletResponse response)
			throws Exception, IOException {
		
		response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		
		InputStream is = null;
		OutputStream out = null;
		try {
			is = new FileInputStream(new File(fileDirpath + File.separator + filename));
			out = response.getOutputStream();
			byte[] buffer = new byte[40960];
			int byteCount = is.read(buffer);
			while (byteCount > 0) {
				out.write(buffer, 0, byteCount);
				byteCount = is.read(buffer);
			}
			out.flush();
		}catch(Exception e){
			throw e;
		}finally {
			if (is != null)
				is.close();
			if (out != null)
				out.close();
			
//			File file = new File(fileDirpath + File.separator + filename);
//			file.delete();
		}
	}
}
