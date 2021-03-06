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
import com.nj.core.base.util.*;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.model.generate.StockBase;
import com.nj.model.generate.SysDict;
import com.nj.service.base.system.StockBaseService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
@RequestMapping(value = "/stockBase")
public class StockBaseController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(StockBaseController.class);
	
	@Resource(name = "stockBaseService")
	private StockBaseService stockBaseService;

	@ResourcesAnnotion(uri="/stockBase/page",name="库存档案",resourceType=1,parentId="2")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("business/stockBase/list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<StockBase> list = stockBaseService.list(pd);
			int count = stockBaseService.listAllCount(pd);
			logger.info("");
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView toAdd() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("WEB-INF/jsp/business/stockBase/add.jsp");
		return mv;
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(StockBase stockBase){
		PageData result = new PageData();
		try {
			stockBaseService.add(stockBase);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add njstockBase error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam String id) {
		ModelAndView mv = super.getModelAndView();
		StockBase pd = null;
		List<SysDict> dictList = null;
		try {
			pd = stockBaseService.getById(id);
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		mv.addObject("pd", pd);
		mv.setViewName("WEB-INF/jsp/business/stockBase/edit.jsp");
		return mv;
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(StockBase stockBase){
		PageData result = new PageData();
		try {
			stockBaseService.edit(stockBase);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add njstockBase error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}

	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = stockBaseService.delete(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败");
			}
		} catch (Exception e) {
			logger.error("delete njstockBase error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}

	@RequestMapping(value = "/uploadStock", method = RequestMethod.POST)
	@ResponseBody
	public PageData uploadStock(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		PageData result = new PageData();
		try {
			if (file.isEmpty()) {
				result.put("msg", "上传失败");
			} else {
				InputStream input = null;
				Workbook wb = null;
				List<Map<String, Object>> transModelList = null;
				ArrayList<StockBase> stockBases = new ArrayList<>();
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
						File erpFile = new File(realPath1 + File.separator + "库存档案.xlsx");

						inputTemp = new FileInputStream(erpFile);
						wbTemp = new XSSFWorkbook(inputTemp);
						XSSFRow modelTitleRow = wbTemp.getSheetAt(0).getRow(0);
						int totalCell2 = modelTitleRow.getLastCellNum();
						if(totalCell != totalCell2){
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
						int rowCount = rowNum + 1;
						if (xssfRow != null) {

							//读取列，从第一列开始
							if(xssfRow.getCell(0) == null){
								logger.error("第"+rowCount+"行：货号为空");
								continue;
							}
							String stockNo = ExcelUtil.getXValue(xssfRow.getCell(0)).trim();//获取货号

							if(xssfRow.getCell(1) == null){
								logger.error("第"+rowNum+1+"尺码为空");
								continue;
							}
							String specification = ExcelUtil.getXValue(xssfRow.getCell(1)).trim();//获取尺码、规格
							xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);

							if(xssfRow.getCell(2) == null){
								logger.error("第"+rowNum+1+"数量为空");
								continue;
							}
							xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							String amount = ExcelUtil.getXValue(xssfRow.getCell(2)).trim();//获取数量

							if(xssfRow.getCell(3) == null){
								logger.error("第"+rowNum+1+"折扣为空");
								continue;
							}
							xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
							String discount = ExcelUtil.getXValue(xssfRow.getCell(3)).trim();//获取折扣
							xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
							if(xssfRow.getCell(4) == null){
								logger.error("第"+rowNum+1+"吊牌价为空");
								continue;
							}
							xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
							String basePrice = ExcelUtil.getXValue(xssfRow.getCell(4)).trim();//获取吊牌价
							String channelPrice = ExcelUtil.getXValue(xssfRow.getCell(5)).trim();//获取渠道价
							xssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);

							//剔除吊牌价、渠道价不合法的数据
							if(!StringUtils.isNumeric(basePrice) || !StringUtils.isNumeric(channelPrice)){
								logger.error("第"+rowCount+"行：吊牌价或者渠道价不合法");
								continue;
							}
							StockBase stockBase = new StockBase();
							stockBase.setId(UuidUtil.get32UUID());
							stockBase.setSpecification(specification);
							stockBase.setAmount(amount);
							stockBase.setBasePrice(basePrice);
							stockBase.setChannelPrice(channelPrice);
							stockBase.setStockNo(stockNo);
							BigDecimal bignum = new BigDecimal(discount);
							stockBase.setDiscount( bignum.setScale(3, BigDecimal.ROUND_HALF_UP)+"");
							stockBase.setId(UuidUtil.get32UUID());
							stockBases.add(stockBase);
						}
					}
					if(stockBases.size() == 0){
						result.put("status", 0);
						result.put("msg", "请勿上传空文件");
						return result;
					}
					stockBaseService.insertBath(stockBases);
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
