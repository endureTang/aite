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
import com.nj.dao.NjStrategyMapper;
import com.nj.dao.StrategyOrderMapper;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.generate.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.java2d.pipe.ValidatePipe;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

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


	public List<ErpOrder> list(PageData pd) {
		pd.put("start", pd.getInteger("start"));
		pd.put("length", pd.getInteger("length"));
		return njStrategyMapperExtend.selectPageErpOrder(pd);
	}

	public int listAllCount(PageData pd) {
		return erpOrderMapper.countByExample(null);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertBath(ArrayList<ErpOrder> erpOrderList) throws Exception{
		for (ErpOrder erpOrder : erpOrderList) {
			erpOrder.setId(UuidUtil.get32UUID());
			erpOrderMapper.insertSelective(erpOrder);
		}
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertStrategyOrder(StrategyOrder strategyOrder) throws Exception{
		StrategyOrderMapper strategyOrderMapper = dao.getMapper(StrategyOrderMapper.class);
		StrategyOrderExample example = new StrategyOrderExample();
		example.createCriteria().andStrategyIdEqualTo(strategyOrder.getStrategyId());
		List<StrategyOrder> strategyOrders = strategyOrderMapper.selectByExample(example);
		if(strategyOrders != null && strategyOrders.size() > 0){
			strategyOrder.setId(strategyOrders.get(0).getId());
			strategyOrderMapper.updateByPrimaryKeySelective(strategyOrder);
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
		for (StrategyOrder strategyOrder : strategyOrders) {
			NjStrategy njStrategy = njStrategyMapper.selectByPrimaryKey(strategyOrder.getStrategyId());
			String realPath=request.getSession().getServletContext().getRealPath("upload"+File.separator+"excelFile"+File.separator);
			File file = new File(realPath+File.separator+strategyOrder.getFileName());
			completeExcel(file,njStrategy);
			retList.add(strategyOrder);
		}
		return retList;
	}

	private void completeExcel(File file,NjStrategy njStrategy) throws BaseException {
		InputStream input = null;
		OutputStream out = null;
		XSSFWorkbook wb = null;
		try {
			input = new FileInputStream(file);
			// 创建文档
			wb = new XSSFWorkbook(input);
			//读取sheet(页)
			for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
				XSSFSheet xssfSheet = wb.getSheetAt(numSheet);
				if (xssfSheet == null || xssfSheet.getPhysicalNumberOfRows() == 0) {
					continue;
				}
				int totalRows = xssfSheet.getLastRowNum(); //总行数
				int totalCells;//总列数
				//读取excel标题，默认第一行为标题
				XSSFRow titleRow = xssfSheet.getRow(0);
				totalCells = titleRow.getPhysicalNumberOfCells(); //总列数
				List<Map<String,Object>> completeInfo = new ArrayList<>();
				Integer sourceNoCellIndex = null;
				for (int i = 0; i < totalCells; i++) { //遍历标题，同时与订单关联策略key对比，获取需要进行匹配的列数以及对应ERP订单的表字段
					Map<String,Object> tempMap = new HashMap<>();
					String title = ExcelUtil.getXValue(titleRow.getCell(i)).trim();//获取标题
					if(njStrategy.getSourceNoStus() == 1 && title.equals(njStrategy.getSourceNo())){ //是否是原始订单号
						tempMap.put("cellIndex", i);
						tempMap.put("keyWord", "sourceNo");
						sourceNoCellIndex = i;
						completeInfo.add(tempMap);
					} else if(njStrategy.getTransWayStus() == 1 && title.equals(njStrategy.getTransWay())){//是否是物流方式
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
					}

				}
				if(sourceNoCellIndex == null){
					throw new BaseException("没有找到原始订单号，或者策略中尚未启用");
				}
				//读取Row,从第二行开始
				for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
					XSSFRow xssfRow = xssfSheet.getRow(rowNum);
					if (xssfRow != null) {
						String souruceNo = ExcelUtil.getXValue(xssfRow.getCell(sourceNoCellIndex)).trim();//获取原始订单号
						List<ErpOrder> erpOrders = njStrategyMapperExtend.getErpOrderBySourceNo(souruceNo);
						if(erpOrders == null || erpOrders.size() ==0){
							System.out.println("没有匹配到原始订单");
							continue;
						}
						if(erpOrders.size() > 1){
							System.out.println("原始订单重复");
							continue;
						}
						ErpOrder erpOrder = erpOrders.get(0);

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
							}
							if(cellValue != null && !cellValue.equals("")){
								XSSFCell cell= xssfSheet.getRow(rowNum).getCell(cellIndex);
								if(cell == null){
									cell = xssfSheet.getRow(rowNum).createCell(cellIndex);
								}
								if(cell != null){
									cell.setCellValue(cellValue);
								}
							}
						}
					}
				}
			}
			out = new FileOutputStream(file);
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
