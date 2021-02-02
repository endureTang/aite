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

package com.nj.admin.controller.stockCollect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.core.utils.excel.ZipHelperUtils;
import com.nj.model.generate.ActivityStock;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @FileName com.nj.admin.controller.stockCollect
 * @Description: 库存汇总controller
 * @Date 2021年01月10:37
 * @Author endure
 */
@Controller
@RequestMapping(value = "/stockCollect")
public class StockCollectController extends BaseController {
	//模板上传路径地址
	private static final String MODEL_UPLOAD_PATH = "static" + File.separator + "upload" + File.separator + "zipFile" + File.separator + "upload" + File.separator;
	//生成文件以供下载地址
	private static final String DOWNLOAD_PATH = "static" + File.separator + "upload" + File.separator + "zipFile" + File.separator + "download" + File.separator;
	//父级地址
	private static final String BASE_PATH = "static" + File.separator + "upload" + File.separator + "zipFile" + File.separator;

	private static final String XML_PATN = "static" + File.separator + "upload" + File.separator + "xml" + File.separator;

	private static Logger logger = LoggerFactory.getLogger(StockCollectController.class);
	@Resource
	private StockCollectLocalServcie stockCollectLocalServcie;
	@Resource
	private ActivityServcie activityStockService;

	/**
	* @description: 跳转到参与过活动的库存上传页面
	* @param: [s]
	* @return: org.springframework.web.servlet.ModelAndView
	* @author endure
	* @date: 2021-01-11 11:16
	 */
	@ResourcesAnnotion(uri="/stockCollect/goEventUpload",name="活动库存上传",resourceType=1,parentId="2")
	@RequestMapping("goEventUpload")
	public ModelAndView goEventUpload (String s){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("business/stockCollection/activityUpload");
		return mv;
	}

	/**
	* @description: 跳转到库存汇总操作页面
	* @param: []
	* @return: org.springframework.web.servlet.ModelAndView
	* @author endure
	* @date: 2021-01-11 11:17
	 */
	@ResourcesAnnotion(uri="/stockCollect/goCollect",name="库存汇总",resourceType=1,parentId="2")
	@RequestMapping("goCollect")
	public ModelAndView goCollect (){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("business/stockCollection/list");
		return mv;
	}

	/**
	* @description: 活动文件上传
	* @param: [file, request, response]
	* @return: com.nj.core.base.util.PageData
	* @author endure
	* @date: 2021-01-18 16:41
	 */ 
	@RequestMapping(value = "/uploadActivityFile", method = RequestMethod.POST)
	@ResponseBody
	public PageData add(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		PageData result = new PageData();
		try {
			if(file==null|| ExcelUtil.EMPTY.equals(file.getOriginalFilename().trim())){
				result.put("msg", "文件不能为空");
				result.put("status", 0);
			}else{
				System.out.println("开始处理活动文件......");
				InputStream input = null;
				ArrayList<String> rowList = null;
				List<String> stockNoStr = new ArrayList<>();
				String postfix = ExcelUtil.getPostfix(file.getOriginalFilename());
				String fileName = file.getOriginalFilename();
				//如果是xls文件格式
				if(!ExcelUtil.EMPTY.equals(postfix)){
					if(ExcelUtil.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)){
						HSSFWorkbook wb = null;
						input = file.getInputStream();
						// 创建文档
						wb = new HSSFWorkbook(input);
						String msg = checkFormatXls(wb);
						if(msg != null){
							result.put("msg", msg);
							return result;
						}
						HSSFSheet hssfSheet = wb.getSheetAt(1); //获取第一个sheet
						int totalRows = hssfSheet.getLastRowNum();
						//读取Row,从第7行开始
						for(int rowNum = 7;rowNum <= totalRows;rowNum++){
							HSSFRow hssfRow = hssfSheet.getRow(rowNum);
							if(hssfRow!=null){
								rowList = new ArrayList<String>();
								//只读取第一列
								HSSFCell cell = hssfRow.getCell(0);
								if(cell!=null){
									String stockNo = ExcelUtil.getHValue(cell).trim();
									stockNoStr.add(stockNo);
								}
							}
						}
						//如果是xls文件格式
					}else if(ExcelUtil.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)){
						input = file.getInputStream();
						// 创建文档
						Workbook wb = WorkbookFactory.create(input);
						Sheet xssfSheet = wb.getSheetAt(1); //获取第一个sheet
						int totalRows = xssfSheet.getLastRowNum();
						String msg = checkFormatXlsx(wb);
						if(msg != null){
							result.put("msg", msg);
							return result;
						}
						//读取Row,从第7行开始
						for(int rowNum = 7;rowNum <= totalRows;rowNum++){
							Row xssfRow = xssfSheet.getRow(rowNum);
							if(xssfRow!=null){
								rowList = new ArrayList<String>();
								//只读取第一列
								Cell cell = xssfRow.getCell(0);
								if(cell!=null){
									String stockNo = ExcelUtil.getXValue(cell).trim();
									stockNoStr.add(stockNo);
								}
							}
						}
					}else{
						result.put("msg", "暂不支持的Excel版本");
						result.put("status", 0);
					}
					if(stockNoStr.size() == 0){
						result.put("msg", "上传数据为空");
						result.put("status", 0);
						return result;
					}
					System.out.println("活动文件读取结束！");
//					String realPath = request.getSession().getServletContext().getRealPath("static" + File.separator + "upload" + File.separator+"xml" + File.separator+"activity");
					request.getSession().setAttribute("activityList", stockNoStr);
//					activityStockService.saveXml(stockNoStr,realPath);
					result.put("status", 1);
				}
			}
		} catch (Exception e) {
			logger.error(e+"");
			result.put("status", 0);
			result.put("msg", "上传出错："+e.getMessage());
		}
		return result;
	}

	private String checkFormatXls(HSSFWorkbook wb) {
		if(wb.getNumberOfSheets()<2){
			return "上传文件格式不一致";
		}
		Sheet xssfSheet = wb.getSheetAt(1); //获取第一个sheet
		int totalRows = xssfSheet.getLastRowNum();
		//比较模板是否一样
		if(xssfSheet.getLastRowNum() < 6){
			return "上传文件格式不一致";
		}
		Row titleRow = xssfSheet.getRow(6);
		int totalCell = titleRow.getLastCellNum();
		if(totalCell < 56){
			return "上传文件格式不一致";
		}
		return null;
	}
	private String checkFormatXlsx(Workbook wb) {
		if(wb.getNumberOfSheets()<2){
			return "上传文件格式不一致";
		}
		Sheet xssfSheet = wb.getSheetAt(1); //获取第一个sheet
		int totalRows = xssfSheet.getLastRowNum();
		//比较模板是否一样
		if(xssfSheet.getLastRowNum() < 6){
			return "上传文件格式不一致";
		}
		Row titleRow = xssfSheet.getRow(6);
		int totalCell = titleRow.getLastCellNum();
		if(totalCell < 56){
			return "上传文件格式不一致";
		}
		return null;
	}


	/**
	* @description: 清空活动数据
	* @param: [request]
	* @return: com.nj.core.base.util.PageData
	* @author endure
	* @date: 2021-01-19 10:10
	 */
	@RequestMapping(value="/clearData", method = RequestMethod.POST)
	@ResponseBody
	public PageData clearData(HttpServletRequest request){
		PageData result = new PageData();
		try {
			//清理之前的xml文件
			String realPath = request.getSession().getServletContext().getRealPath("static" + File.separator + "upload" + File.separator+"xml" + File.separator+"activity");
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			File outFile = new File(file, "活动列表.xml");
			outFile.delete();
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "清空失败");
		}
		return result;
	}

	/**
	 * @description: 清空汇总数据和文件
	 * @param: [request]
	 * @return: com.nj.core.base.util.PageData
	 * @author endure
	 * @date: 2021-01-19 10:10
	 */
	@RequestMapping(value="/clearStockCollectAndFiles", method = RequestMethod.POST)
	@ResponseBody
	public PageData clearStockCollectAndFiles(HttpServletRequest request){
		PageData result = new PageData();
		try {
			String realPath = request.getSession().getServletContext().getRealPath(BASE_PATH);
			ZipHelperUtils.deletefile(realPath); //删除文件excel文件
			String xmlPath = request.getSession().getServletContext().getRealPath(XML_PATN+File.separator+"stock");
			ZipHelperUtils.deletefile(xmlPath); //删除文件xml文件
			stockCollectLocalServcie.clearStockCollect();//删除数据
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "清空失败");
		}
		return result;
	}

	@RequestMapping(value = "/updateZipFile", method = RequestMethod.POST)
	@ResponseBody
	public PageData updateZipFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,@RequestParam("type") String type) {
		PageData result = new PageData();
		try {
			List<String> activityStocks = (List<String>) request.getSession().getAttribute("activityList");
			if(activityStocks==null || activityStocks.isEmpty()) {
				throw new Exception("活动文件未上传");
			}
			String realPath = request.getSession().getServletContext().getRealPath(MODEL_UPLOAD_PATH);
			File zipFile = new File(realPath+File.separator+file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), zipFile);
			String tempPath = realPath + File.separator + "temp" + type;//tempPath根据type的不同区分
			ZipHelperUtils.unzipFile(zipFile, tempPath);
			String xmlPath = request.getSession().getServletContext().getRealPath("static" + File.separator + "upload" + File.separator+"xml" + File.separator+"stock");
			stockCollectLocalServcie.generateStockCollect(request,type,tempPath,xmlPath);
			result.put("status", 1);
		} catch (Exception e) {
			result.put("msg", e.getMessage());
			logger.error(e.fillInStackTrace()+"");
		}

		return result;
	}

	/**
	* @description: 导出zip和xml文件
	* @param: [request, response]
	* @return: com.nj.core.base.util.PageData
	* @author endure
	* @date: 2021-01-28 13:42
	 */ 
	@RequestMapping(value={"/execZip"})
	@ResponseBody
	public PageData execZip(HttpServletRequest request, HttpServletResponse response)	{
		PageData result = new PageData();
		try{
			String realPath = request.getSession().getServletContext().getRealPath(DOWNLOAD_PATH);
			String xmlPath = request.getSession().getServletContext().getRealPath("static" + File.separator + "upload" + File.separator+"xml" + File.separator+"stock");
			long totalSec = stockCollectLocalServcie.selectDownLoadZipList(realPath,xmlPath);
			if(totalSec >60){
				result.put("msg", totalSec / 60 +"分");
			}else{
				result.put("msg", totalSec+"秒");
			}
			result.put("status", 1);

		}catch (Exception e){
			logger.error(e.fillInStackTrace()+"");
			result.put("msg", "压缩失败，错误信息：" + e.getMessage());
		}
		return result;
	}

	/**
	* @description: 导出zip和汇总excel
	* @param: [request, response]
	* @return: com.nj.core.base.util.PageData
	* @author endure
	* @date: 2021-01-28 13:42
	 */ 
	@RequestMapping(value={"/execZipAndExcel"})
	@ResponseBody
	public PageData execZipAndExcel(HttpServletRequest request, HttpServletResponse response)	{
		PageData result = new PageData();
		try{
			String realPath = request.getSession().getServletContext().getRealPath(DOWNLOAD_PATH);
			String xmlPath = request.getSession().getServletContext().getRealPath("static" + File.separator + "upload" + File.separator+"xml" + File.separator+"stock");
			long totalSec = stockCollectLocalServcie.selectDownLoadZipAndExcelList(realPath,xmlPath);
			if(totalSec >60){
				result.put("msg", totalSec / 60 +"分");
			}else{
				result.put("msg", totalSec+"秒");
			}
			result.put("status", 1);

		}catch (Exception e){
			logger.error(e.fillInStackTrace()+"");
			result.put("msg", "压缩失败，错误信息：" + e.getMessage());
		}
		return result;
	}
	@RequestMapping(value = "/getUploadFiles", method = RequestMethod.POST)
	@ResponseBody
	public PageData getUploadFiles(HttpServletRequest request) {
		PageData result = new PageData();
		try {
			String realPath = request.getSession().getServletContext().getRealPath(MODEL_UPLOAD_PATH);
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			File tempFile = new File(realPath);
			File[] excelFiles = tempFile.listFiles();
			List<Map<String,String>> fileStr = new ArrayList<>();
			if(excelFiles != null && excelFiles.length>0){
				for(File file:excelFiles) { //遍历File[]数组
					if (!file.isDirectory()) {//若非目录(即文件)
						Map<String, String> fileMap = new HashMap<>();
						fileMap.put("fileName", file.getName());
						fileMap.put("filePath", basePath +MODEL_UPLOAD_PATH+ file.getName());
						fileStr.add(fileMap);
					}
				}
			}

			result.put("status", 1);
			result.put("files", fileStr);
		} catch (Exception e) {
			result.put("status", 0);
			logger.error(e.fillInStackTrace()+"");
		}
		return result;
	}
	@RequestMapping(value = "/getDownloadFiles", method = RequestMethod.POST)
	@ResponseBody
	public PageData getDownloadFiles(HttpServletRequest request) {
		PageData result = new PageData();
		try {
			String realPath = request.getSession().getServletContext().getRealPath(DOWNLOAD_PATH);
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			File tempFile = new File(realPath);
			File[] excelFiles = tempFile.listFiles();
			List<Map<String,String>> fileStr = new ArrayList<>();
			if(excelFiles != null && excelFiles.length>0){
				for(File file:excelFiles) { //遍历File[]数组
					if (!file.isDirectory()) {//若非目录(即文件)
						Map<String, String> fileMap = new HashMap<>();
						fileMap.put("fileName", file.getName());
						fileMap.put("filePath", basePath +DOWNLOAD_PATH+ file.getName());
						fileStr.add(fileMap);
					}
				}
			}
			result.put("status", 1);
			result.put("files", fileStr);
		} catch (Exception e) {
			result.put("status", 0);
			logger.error(e.fillInStackTrace()+"");
		}
		return result;
	}
}
