package com.nj.admin.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nj.core.base.entity.ResourcesAnnotion;
import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.FileMeta;
import com.nj.core.base.entity.Image;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/file")
public class TFileController extends BaseController {

	@ResourcesAnnotion(uri="/file/upload",name="反馈订单",resourceType=1,parentId="2")
	@RequestMapping(value="/upload")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("business/order/order_list");
		return mv;
	}

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(@RequestParam("file") MultipartFile file){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			StringBuilder sb = new StringBuilder();
			{
				//only one file
				if (file.isEmpty()) {
					result.put("msg","上传失败");
				} else {
					String fileName = file.getOriginalFilename();
					pd.put("moduleicon", fileName);
					FileUtils.copyInputStreamToFile(file.getInputStream(),
							new File(Const.FILEPATHIMG, fileName));
					sb.append(fileName);
					sb.append(",");
				}

				pd.put("imgs", sb.toString());
				
				result.put("status", 1);
			}
		} catch (Exception e) {
			
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}

}
