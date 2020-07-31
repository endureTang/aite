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

package com.nj.service.base.system;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.exception.BaseException;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.dao.ErpOrderMapper;
import com.nj.dao.ErrorErpOrderModelMapper;
import com.nj.dao.NjStrategyMapper;
import com.nj.dao.StrategyOrderMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.ErrorErpModel;
import com.nj.model.generate.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName RoleService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly = true)
@Service("erpOrderService")
public class ErpOrderService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
    @Resource
    private ErpOrderMapper erpOrderMapper;
	@Resource
	private NjStrategyMapperExtend njStrategyMapperExtend;
	@Resource
	private NjStrategyMapper njStrategyMapper;
	@Resource
	private  StrategyOrderMapper strategyOrderMapper;
	@Resource
	private ErrorErpOrderModelMapper errorErpOrderModelMapper;

	private static Logger logger = LoggerFactory.getLogger(ErpOrderService.class);

	public List<ErpOrder> list(PageData pd) {
		pd.put("start", pd.getInteger("start"));
		pd.put("length", pd.getInteger("length"));
		return njStrategyMapperExtend.selectPageErpOrder(pd);
	}

	public int listAllCount(PageData pd) {
		return erpOrderMapper.countByExample(null);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertBath(ArrayList<ErpOrder> erpOrderList, List<ErrorErpOrderModel> errorErpOrderModels) throws Exception{
		//导入ERP基础订单前，清理之前的数据
		erpOrderMapper.deleteByExample(null);
		strategyOrderMapper.deleteByExample(null);
		errorErpOrderModelMapper.deleteByExample(null);
//		Map<String, String> repeatMap = new HashedMap(); //根据原始单号、货号、规格生成key，实现list对象去重
		for (ErpOrder erpOrder : erpOrderList) {
			String mapKey = erpOrder.getOrderNo()+erpOrder.getSourceOrderNo() + erpOrder.getSpecification();
//			String data = repeatMap.get(mapKey);
//			if(data != null && !data.equals("")){
//				continue;
//			}
			erpOrder.setId(UuidUtil.get32UUID());
			erpOrderMapper.insertSelective(erpOrder);
//			repeatMap.put(mapKey, "data");
		}
		if(errorErpOrderModels != null && errorErpOrderModels.size() > 0){
			for (ErrorErpOrderModel errorErpOrderModel : errorErpOrderModels) {
				errorErpOrderModel.setId(UuidUtil.get32UUID());
				errorErpOrderModelMapper.insertSelective(errorErpOrderModel);
			}
		}

	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertStrategyOrder(StrategyOrder strategyOrder) throws Exception{
		StrategyOrderMapper strategyOrderMapper = dao.getMapper(StrategyOrderMapper.class);
		StrategyOrderExample example = new StrategyOrderExample();
		example.createCriteria().andStrategyIdEqualTo(strategyOrder.getStrategyId());
		List<StrategyOrder> strategyOrders = strategyOrderMapper.selectByExample(example);
		if(strategyOrders != null && strategyOrders.size() > 0){
			if(strategyOrder.getId().equals("0")){
				throw new RuntimeException("该策略已上传,请勿重复上传");
			}else{
				strategyOrder.setId(strategyOrders.get(0).getId());
				strategyOrderMapper.updateByPrimaryKeySelective(strategyOrder);
			}
		}else{
			strategyOrder.setId(UuidUtil.get32UUID());
			strategyOrderMapper.insertSelective(strategyOrder);
		}

	}

	public List<StrategyOrder> updateChannelOrder(HttpServletRequest request) throws Exception {
		StrategyOrderMapper strategyOrderMapper = dao.getMapper(StrategyOrderMapper.class);
		//获取需要反馈的渠道订单列表及对应的策略，保证有且只有一个渠道、策略
		List<StrategyOrder> strategyOrders = strategyOrderMapper.selectByExample(null);
		List<StrategyOrder> retList = new ArrayList<>();
		List<Map<String,Object>> errorData = new ArrayList<>();
		for (StrategyOrder strategyOrder : strategyOrders) {
			NjStrategy njStrategy = njStrategyMapper.selectByPrimaryKey(strategyOrder.getStrategyId());
			String realPath=request.getSession().getServletContext().getRealPath("static"+File.separator +"upload"+File.separator+"excelFile"+File.separator);
			File file = new File(realPath+File.separator+strategyOrder.getFileName());
			List<Map<String,Object>> retErrorData = completeExcel(file,njStrategy,request,strategyOrder.getFileName());
			if(retErrorData != null){
				errorData.addAll(retErrorData);
			}
			retList.add(strategyOrder);
		}
		if(errorData.size() > 0){
			Map<String, Object> outExcel = generateExcel(request, errorData);
			if(outExcel != null){
				StrategyOrder strategyOrder = new StrategyOrder();
				strategyOrder.setFileName(outExcel.get("name").toString());
				strategyOrder.setFilePath(outExcel.get("url").toString());
				retList.add(strategyOrder);
			}
		}
		return retList;
	}

	private List<Map<String,Object>> completeExcel(File file,NjStrategy njStrategy,HttpServletRequest request,String fileName) throws BaseException {
		InputStream input = null;
		OutputStream out = null;
		Workbook wb = null;
		List<Map<String,Object>> errorData = new ArrayList<>();
		try {
			input = new FileInputStream(file);
			// 创建文档
			wb = WorkbookFactory.create(input);
			//读取sheet(页)
			Sheet xssfSheet = wb.getSheetAt(0);
			int totalRows = xssfSheet.getLastRowNum(); //总行数
			int totalCells;//总列数
			//读取excel标题，默认第一行为标题
			Row titleRow = xssfSheet.getRow(0);
			totalCells = titleRow.getPhysicalNumberOfCells(); //总列数
			List<Map<String,Object>> completeInfo = new ArrayList<>();
			Integer sourceNoCellIndex = null; //单号所在列
			Integer stockNoCellIndex = null; //货号所在列
			Integer specificationCellIndex = null; //规格、尺码所在列
			try {
				for (int i = 0; i < totalCells; i++) { //遍历标题，同时与订单关联策略key对比，获取需要进行匹配的列数以及对应ERP订单的表字段
					Map<String,Object> tempMap = new HashMap<>();
					String title = ExcelUtil.getXValue(titleRow.getCell(i)).trim();//获取标题
					if(njStrategy.getSourceNoStus() == 1 && title.equals(njStrategy.getSourceNo())){ //是否是原始订单号
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "sourceNo");
						sourceNoCellIndex = i;
						completeInfo.add(tempMap);
					} else if(title.equals(njStrategy.getStockNo())){//是否是货号匹配
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "stockNo");
						stockNoCellIndex = i;
						completeInfo.add(tempMap);
					}else if(title.equals(njStrategy.getSpecification())){//是否是规格、尺码匹配
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "specification");
						specificationCellIndex = i;
						completeInfo.add(tempMap);
					}else if(njStrategy.getTransWayStus() == 1 && title.equals(njStrategy.getTransWay())){//是否是物流方式
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "transWay");
						completeInfo.add(tempMap);
					} else if(njStrategy.getTransNoStus() == 1 && title.equals(njStrategy.getTransNo())){//是否是物流订单号
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "transNo");
						completeInfo.add(tempMap);
					} else if(njStrategy.getTransMoneyStus() == 1 && title.equals(njStrategy.getTransMoney())){//是否是运费
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "transMoney");
						completeInfo.add(tempMap);
					} else if(njStrategy.getAmountStus() == 1 && title.equals(njStrategy.getAmount())){//是否是数量
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "amount");
						completeInfo.add(tempMap);
					}else if(title.equals(njStrategy.getRemark())){//是否是备注
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "remark");
						completeInfo.add(tempMap);
					}

				}
				if(sourceNoCellIndex == null){
					throw new BaseException("没有找到原始订单号，或者策略中尚未启用");
				}
				if(stockNoCellIndex == null){
					throw new BaseException("没有找到货号所在匹配列");
				}
				if(specificationCellIndex == null){
					throw new BaseException("没有找到规格、尺码所在匹配列");
				}
			} catch (BaseException e) {
				logger.error(e.getMessage());
			}
			//读取Row,从第二行开始

			for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
				Row xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					try {
						String sourceNo = ExcelUtil.getXValue(xssfRow.getCell(sourceNoCellIndex)).trim();//获取原始订单号
						String stockNo = ExcelUtil.getXValue(xssfRow.getCell(stockNoCellIndex)).trim();//获取货号
						String specification = ExcelUtil.getXValue(xssfRow.getCell(specificationCellIndex)).trim();//获取规格、尺码

						List<ErpOrder> erpOrders = njStrategyMapperExtend.getErpOrderBySourceNo(sourceNo,stockNo,specification);
						if(erpOrders == null || erpOrders.size() ==0){
							Map<String,Object> map = new HashMap<>();
							map.put("sourceType", fileName);
							map.put("sourceNo", sourceNo);
							map.put("message", "没有匹配到原始订单");
							errorData.add(map);
							throw new BaseException("没有匹配到原始订单："+sourceNo);
						}
						ErpOrder erpOrder = null;
						//如果匹配到多条，将多余的放入备注字段
						if(erpOrders.size() > 1){
							erpOrder = erpOrders.get(0);
						}
						StringBuilder remark = new StringBuilder();
						remark.append("订单：" + sourceNo + "，存在多条相同规格、货号的数据。");
						for (int i = 1; i < erpOrders.size(); i++) {
							ErpOrder erpOrderTemp = erpOrders.get(i);
							remark.append("规格：：" + specification);
							remark.append("，货号：：" + stockNo);
							remark.append("，物流方式：" + erpOrderTemp.getTransWay());
							remark.append("，物流单号：" + erpOrderTemp.getTransNo());
							remark.append("，运费：" + erpOrderTemp.getTransMoney());
							remark.append("，数量：" + erpOrderTemp.getAmount());
						}


						for (Map<String, Object> map : completeInfo) {
							Integer cellIndex = (Integer) map.get("cellIndex");
							String cellValue = "";
							if(map.get("keyWord").equals("transWay")){
								cellValue = erpOrder.getTransWay();
							}else if(map.get("keyWord").equals("transWay")){
								cellValue = erpOrder.getTransWay();
							}else if(map.get("keyWord").equals("transNo")){
								cellValue = erpOrder.getTransNo();
							}else if(map.get("keyWord").equals("transMoney")){
								cellValue = erpOrder.getTransMoney();
							}else if(map.get("keyWord").equals("amount")){
								cellValue = erpOrder.getAmount();
							}else if(map.get("keyWord").equals("remark")){
								cellValue = remark.toString();
							}
							if(cellValue != null && !cellValue.equals("")){
								Cell cell= xssfSheet.getRow(rowNum).getCell(cellIndex);
								if(cell == null){
									cell = xssfSheet.getRow(rowNum).createCell(cellIndex);
								}
								if(cell != null){
									cell.setCellValue(cellValue);
								}
							}
						}
					} catch (BaseException e){
						logger.error(e.getMessage());
					}catch (Exception e) {
						logger.error(e.getMessage());
					}
				}
			}
			out = new FileOutputStream(file);
			wb.write(out);
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("文件读取出错");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("系统错误"+e.getMessage());
		}finally {
			try {
				input.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return errorData;
	}
	Map<String,Object> generateExcel( HttpServletRequest reqst, List<Map<String,Object>> datas) {
		XSSFWorkbook wb = new XSSFWorkbook();
		FileOutputStream fileOut = null;
		Map<String,Object> retMap = null;
		XSSFSheet sheet = wb.createSheet("问题数据");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		XSSFCell cell2 = row.createCell(1);
		XSSFCell cell3 = row.createCell(2);
		cell.setCellValue("来源所属文件名");
		cell2.setCellValue("原始单号");
		cell3.setCellValue("错误信息");
		for (int i = 0; i < datas.size(); i++) {
			Map<String, Object> data = datas.get(i);
			XSSFRow rowTemp = sheet.createRow(i+1);
			XSSFCell cellOne = rowTemp.createCell(0);
			XSSFCell cellTwo = rowTemp.createCell(1);
			XSSFCell cellThree = rowTemp.createCell(2);
			cellOne.setCellValue(data.get("sourceType").toString());
			cellTwo.setCellValue(data.get("sourceNo").toString());
			cellThree.setCellValue(data.get("message").toString());
		}
		try {
			String basePath = reqst.getContextPath();
			basePath = reqst.getScheme() + ":"+File.separator +File.separator  + reqst.getServerName() + ":" + reqst.getServerPort() + basePath + File.separator ;
			String realPath = reqst.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator + "excelFile" + File.separator);
			File dir = new File(realPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			fileOut = new FileOutputStream(realPath+File.separator+"问题数据.xlsx");
			wb.write(fileOut);
			retMap = new HashMap<>();
			retMap.put("name", "问题数据.xlsx");
			retMap.put("url", basePath + "static/upload/excelFile/问题数据.xlsx");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retMap;
	}


	public List<StrategyOrder> selectStrategyOrderList() {
		return strategyOrderMapper.selectByExample(null);
	}

	public List<ErrorErpModel> listErrorErp() {
		return njStrategyMapperExtend.listErrorErp();
	}
}
