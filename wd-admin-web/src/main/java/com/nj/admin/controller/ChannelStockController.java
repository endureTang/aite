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
import com.nj.core.utils.excel.ExportUtil;
import com.nj.model.datamodel.ChannelStockModel;
import com.nj.model.datamodel.ChannelStockModelNew;
import com.nj.model.generate.ChannelStock;
import com.nj.model.generate.StockBase;
import com.nj.model.generate.StockFormat;
import com.nj.model.generate.StockFormatDict;
import com.nj.service.base.system.ChannelStockService;
import com.nj.service.base.system.StockBaseService;
import com.nj.service.base.system.StockFormatService;
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
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value = "/channelStock")
public class ChannelStockController extends BaseController {


	@Resource(name = "stockBaseService")
	private StockBaseService stockBaseService;

	private static Logger logger = LoggerFactory.getLogger(ChannelStockController.class);
	
	@Resource(name = "channelStockService")
	private ChannelStockService channelStockService;

    @Resource(name = "stockFormatService")
    private StockFormatService stockFormatService;

	@ResourcesAnnotion(uri="/channelStock/page",name="渠道基础库存",resourceType=1,parentId="2")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		PageData pd = super.getPageData();
		ModelAndView mv = super.getModelAndView();
		pd.put("type", 1);
		int baseCount = channelStockService.listAllCount(pd);
		pd.put("type", 2);
		int errorCount = channelStockService.listAllCount(pd);
		pd.put("type", 3);
		int newCount = channelStockService.listAllCount(pd);
		mv.addObject("baseCount", baseCount);
		mv.addObject("errorCount", errorCount);
		mv.addObject("newCount", newCount);
		mv.setViewName("business/channelStock/list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<ChannelStock> list = channelStockService.list(pd);
			int count = channelStockService.listAllCount(pd);

			pd.put("type", 1);
			int baseCount = channelStockService.listAllCount(pd);
			pd.put("type", 2);
			int errorCount = channelStockService.listAllCount(pd);
			pd.put("type", 3);
			int newCount = channelStockService.listAllCount(pd);

			logger.info("");
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(count);
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, count);
				result.put(Const.RECORDSFILTERED, count);
				result.put("baseCount", baseCount);
				result.put("errorCount", errorCount);
				result.put("newCount", newCount);
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam String id) {
		ModelAndView mv = super.getModelAndView();
		ChannelStock pd = null;
		try {
			pd = channelStockService.getById(id);
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		mv.addObject("pd", pd);
		mv.setViewName("business/channelStock/edit");
		return mv;
	}

	@RequestMapping(value = "/goExportChannel", method = RequestMethod.GET)
	public ModelAndView goExportChannel() {
		ModelAndView mv = super.getModelAndView();
        List<StockFormat> list = null;
		try {
            list = stockFormatService.list(null);
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		mv.addObject("list", list);
		mv.setViewName("business/channelStock/channelExport");
		return mv;
	}

	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = channelStockService.delete(id);
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

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(ChannelStock stockBase){
		PageData result = new PageData();
		try {
			channelStockService.edit(stockBase);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add ChannelStock error", e);
			result.put("status", 0);
			result.put("msg", "修改失败");
		}
		return result;
	}

	@RequestMapping(value="/clearData", method=RequestMethod.POST)
	@ResponseBody
	public PageData clearData(ChannelStock stockBase){
		PageData result = new PageData();
		try {
			channelStockService.clearData();
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add ChannelStock error", e);
			result.put("status", 0);
			result.put("msg", "清空失败");
		}
		return result;
	}

	@RequestMapping(value="/exportNewData", method=RequestMethod.GET)
	@ResponseBody
	public PageData exportNewData(HttpServletRequest reqst, HttpServletResponse response){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			pd.put("type", 3);
			List<ChannelStockModelNew> channelStocks = channelStockService.listModelNew(pd);

			//设置文件名称和文件存放位置
			StringBuilder tempfilename = new StringBuilder();
			tempfilename.append("疑似新品数据.xlsx");

			ExportUtil.baseExport(channelStocks, ChannelStockModelNew.class, tempfilename.toString(), "疑似新品数据", "疑似新品数据", response);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add ChannelStock error", e);
			result.put("status", 0);
			result.put("msg", "清空失败");
		}
		return result;
	}

	@RequestMapping(value="/exportErrorData", method=RequestMethod.GET)
	@ResponseBody
	public PageData exportErrorData(HttpServletRequest reqst, HttpServletResponse response){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			pd.put("type", 2);
			List<ChannelStockModel> channelStocks = channelStockService.listModel(pd);

			//设置文件名称和文件存放位置
			StringBuilder tempfilename = new StringBuilder();
			tempfilename.append("问题数据.xlsx");

			ExportUtil.baseExport(channelStocks, ChannelStockModel.class, tempfilename.toString(), "问题数据", "问题数据", response);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add ChannelStock error", e);
			result.put("status", 0);
			result.put("msg", "清空失败");
		}
		return result;
	}

    @RequestMapping(value="/exportChannelData", method=RequestMethod.GET)
    @ResponseBody
    public PageData exportChannelData(HttpServletRequest reqst, HttpServletResponse response){
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            List<StockFormatDict> stockFormatDicts = stockFormatService.getDictByFormatId(pd.getString("id"));
            channelStockService.exportChannelData(stockFormatDicts,reqst,response,pd.getString("id"));
            result.put("status", 1);
        } catch (Exception e) {
            logger.error("add ChannelStock error", e);
            result.put("status", 0);
            result.put("msg", "清空失败");
        }
        return result;
    }
	@RequestMapping(value = "/uploadChannelStock", method = RequestMethod.POST)
	@ResponseBody
	public PageData uploadStock(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		PageData result = new PageData();
		try {
			if (file.isEmpty()) {
				result.put("msg", "上传失败，文件为空");
			} else {
				InputStream input = null;
				Workbook wb = null;
				List<Map<String, Object>> transModelList = null;
				ArrayList<ChannelStock> channelStocks = new ArrayList<>();
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
						File erpFile = new File(realPath1 + File.separator + "ERP库存模板.xlsx");

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
							ChannelStock channelStock = new ChannelStock();

							//读取列，从第一列开始
							if(xssfRow.getCell(0) == null){
								logger.error("第"+rowNum+1+"货品编号为空");
								channelStock.setRemark("货品编号为空");
								channelStock.setType(2);
							}
							String stockNo = ExcelUtil.getXValue(xssfRow.getCell(0)).trim();//获取货号

							if(xssfRow.getCell(1) == null){
								logger.error("第"+rowNum+1+"规格为空");
								channelStock.setRemark("规格为空");
								channelStock.setType(2);
							}

							if(xssfRow.getCell(4) == null){
								logger.error("第"+rowNum+1+"品牌为空");
								channelStock.setRemark("品牌为空");
								channelStock.setType(2);
							}
							xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
							String brand = ExcelUtil.getXValue(xssfRow.getCell(4)).trim();//获取品牌

							String specification = ExcelUtil.getXValue(xssfRow.getCell(1)).trim();//获取尺码、规格
							if(xssfRow.getCell(6) == null){
								logger.error("第"+rowNum+1+"可订购为空");
								channelStock.setRemark("可订购为空");
								channelStock.setType(2);
							}
							xssfRow.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
							String amount = ExcelUtil.getXValue(xssfRow.getCell(6)).trim();//获取可订购数量

							channelStock.setId(UuidUtil.get32UUID());
							channelStock.setAmount(amount);
							channelStock.setSpecification(specification);
							channelStock.setStockNo(stockNo);
							channelStock.setBrand(brand);
							channelStocks.add(channelStock);
						}
					}
					if(channelStocks.size() == 0){
						result.put("status", 0);
						result.put("msg", "请勿上传空文件");
						return result;
					}
					channelStockService.insertBath(channelStocks);
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

	/** 
	* @Description: 导入增补库存
	* @Param:  
	* @return:  
	* @Author: endure
	* @Date: 2020/7/31 
	*/
	@RequestMapping(value = "/uploadChannelStockAndBaseStock", method = RequestMethod.POST)
	@ResponseBody
	public PageData uploadChannelStockAndBaseStock(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
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
							//读取列，从第一列开始
							if(xssfRow.getCell(0) == null){
								logger.error("第"+rowNum+1+"货号为空");
								continue;
							}
							String stockNo = ExcelUtil.getXValue(xssfRow.getCell(0)).trim();//获取货号

							if(xssfRow.getCell(1) == null){
								logger.error("第"+rowNum+1+"尺码为空");
								continue;
							}
							String specification = ExcelUtil.getXValue(xssfRow.getCell(1)).trim();//获取尺码、规格
							if(xssfRow.getCell(2) == null){
								logger.error("第"+rowNum+1+"数量为空");
								continue;
							}
							xssfRow.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							String amount = ExcelUtil.getXValue(xssfRow.getCell(2)).trim();//获取数量

//							if(xssfRow.getCell(3) == null){
//								logger.error("第"+rowNum+1+"折扣为空");
//								continue;
//							}
//							xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
//							String discount = ExcelUtil.getXValue(xssfRow.getCell(3)).trim();//获取折扣

							if(xssfRow.getCell(4) == null){
								logger.error("第"+rowNum+1+"吊牌价为空");
								continue;
							}
							xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
							String basePrice = ExcelUtil.getXValue(xssfRow.getCell(4)).trim();//获取吊牌价
							if(xssfRow.getCell(5) == null){
								logger.error("第"+rowNum+1+"吊牌价为空");
								continue;
							}

							xssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
							String channelPrice = ExcelUtil.getXValue(xssfRow.getCell(5)).trim();//获取渠道价
							//剔除吊牌价、渠道价不合法的数据
							if(!StringUtils.isNumeric(basePrice) || !StringUtils.isNumeric(channelPrice)){
								logger.error("第"+rowNum+1+"吊牌价或者渠道价不合法");
								continue;
							}
							StockBase stockBase = new StockBase();
							stockBase.setId(UuidUtil.get32UUID());
							stockBase.setAmount(amount);
							stockBase.setBasePrice(basePrice);
							stockBase.setChannelPrice(channelPrice);
							stockBase.setSpecification(specification);
							stockBase.setStockNo(stockNo);
							stockBases.add(stockBase);
						}
					}
					if(stockBases.size() == 0){
						result.put("status", 0);
						result.put("msg", "请勿上传空文件");
						return result;
					}
					stockBaseService.insertBathBaseAndChannel(stockBases);
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
