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

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.model.datamodel.StockFormatForm;
import com.nj.model.generate.*;
import com.nj.service.base.system.BlackStockNoService;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.StockFormatService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @FileName RoleController.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/blackStockNo")
public class BlackStockNoController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(BlackStockNoController.class);
	
	@Resource(name = "blackStockNoService")
	private BlackStockNoService blackStockNoService;

	@ResourcesAnnotion(uri="/blackStockNo/page",name="库存黑名单",resourceType=1,parentId="3")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/blackStockNo/list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<BlackStock> list = blackStockNoService.list(pd);
			int count = blackStockNoService.listAllCount(pd);
			logger.info("");
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list blackStockNo error", e);
//			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = blackStockNoService.delete(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败");
			}
		} catch (Exception e) {
			logger.error("delete StockFormat error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}

	@RequestMapping(value="/modify",method = RequestMethod.GET)
	public ModelAndView goModify(@RequestParam Integer id){
		ModelAndView mv = super.getModelAndView();
		BlackStock blackStock = blackStockNoService.get(id);
		mv.addObject("pd", blackStock);
		mv.setViewName("sys/blackStockNo/edit");
		return mv;
	}

	@RequestMapping(value="/modify",method = RequestMethod.POST)
	@ResponseBody
	public PageData modify(@RequestParam Integer id,String stockNo,String sizeRange){
		PageData result = new PageData();
		try {
			BlackStock blackStock = new BlackStock();
			blackStock.setId(id);
			blackStock.setStockNo(stockNo);
			blackStock.setSizeRange(sizeRange);
			blackStockNoService.modify(blackStock);
			result.put("status", 1);
			result.put("msg", "修改成功");
		} catch (Exception e) {
			logger.error("delete StockFormat error", e);
			result.put("status", 0);
			result.put("msg", "修改失败");
		}
		return result;
	}

	@RequestMapping(value="/batchDeleteBtn")
	@ResponseBody
	public PageData batchDeleteBtn(@RequestParam String ids){
		PageData result = new PageData();
		try {
			blackStockNoService.batchDelete(ids);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete button error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}

	@RequestMapping(value = "/uploadBlackStockNo", method = RequestMethod.POST)
	@ResponseBody
	public PageData uploadStock(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		PageData result = new PageData();
		try {
			if (file.isEmpty()) {
				result.put("msg", "上传失败，文件为空");
			} else {
				InputStream input = null;
				Workbook wb;
				ArrayList<BlackStock> blackStocks = new ArrayList<>();
				try {
					input = file.getInputStream();
					// 创建文档
					wb = WorkbookFactory.create(input);
					//读取sheet(页)
					Sheet xssfSheet = wb.getSheetAt(0);
					int totalRows; //sheet中总行数
					totalRows = xssfSheet.getLastRowNum();
					if(totalRows == 0){
						result.put("status", 0);
						result.put("msg", "请勿上传空文件");
						return result;
					}
					//标题行
					Row titleRow = xssfSheet.getRow(0);
					InputStream inputTemp = null;
					XSSFWorkbook wbTemp = null;
					try {
						int totalCell = titleRow.getLastCellNum();
						String realPath1 = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator);
						File erpFile = new File(realPath1 + File.separator + "库存黑名单模板.xlsx");
						inputTemp = new FileInputStream(erpFile);
						wbTemp = new XSSFWorkbook(inputTemp);
						XSSFRow modelTitleRow = wbTemp.getSheetAt(0).getRow(0);
						int totalCell2 = modelTitleRow.getLastCellNum();
						if(totalCell2 != totalCell2){
							result.put("status", 0);
							result.put("msg", "请上传正确格式文件");
							return result;
						}
						for (int i = 0; i < totalCell; i++) {
							String one = ExcelUtil.getXValue(titleRow.getCell(i));
							String two = ExcelUtil.getXValue(modelTitleRow.getCell(i));
							if(!one.equals(two)){
								result.put("status", 0);
								int errorIndex = i +1;
								result.put("msg", "上传文件与模板格式有出入：第"+errorIndex+"行，标题："+one);
								return result;
							}
						}
					} catch (IOException e) {
						result.put("status", 0);
						result.put("msg", "文件读取出错");
						return result;
					} finally {
						inputTemp.close();
					}
					//读取Row,从第二行开始
					for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
						Row xssfRow = xssfSheet.getRow(rowNum);
						if (xssfRow != null) {
							BlackStock blackStock = new BlackStock();
							//读取列，从第一列开始
							if(xssfRow.getCell(0) == null){
								logger.error("第"+rowNum+1+"货品编号为空");
								result.put("status", 0);
								result.put("msg", "第"+rowNum+1+"货品编号为空");
								return result;
							}
							String stockNo = ExcelUtil.getXValue(xssfRow.getCell(0)).trim();//获取货号
							//读取列，从第一列开始
							String sizeRange = ExcelUtil.getXValue(xssfRow.getCell(1));//过滤尺码范围
							blackStock.setStockNo(stockNo);
							blackStock.setSizeRange(sizeRange == null ? "":sizeRange);
							blackStocks.add(blackStock);
						}
					}
					if(blackStocks.size() == 0){
						result.put("status", 0);
						result.put("msg", "请勿上传空文件");
						return result;
					}
					blackStockNoService.insertBath(blackStocks);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			result.put("status", 1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ERP订单上传出错：" + e);
			result.put("status", 0);
			result.put("msg", "上传失败");
		}
		return result;
	}
}
