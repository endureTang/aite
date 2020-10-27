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
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExportUtil;
import com.nj.dao.*;
import com.nj.dao.extend.NjStrategyMapperExtend;
import com.nj.model.datamodel.ChannelStockModel;
import com.nj.model.datamodel.ChannelStockModelNew;
import com.nj.model.generate.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author dzk
 * @version 1.0
 * @FileName RoleService.java
 * @Description:
 * @Date 2015年5月9日
 */
@Transactional
@Service("channelStockService")
public class ChannelStockService {

    @Resource(name = "BaseDao")
    private BaseDao dao;
    @Resource
    private ChannelStockMapper channelStockMapper;
    @Resource
    private StockBaseMapper stockBaseMapper;
    @Resource
    private NjStrategyMapperExtend njStrategyMapperExtend;
    @Resource
    private SysDictMapper sysDictMapper;
    @Resource
    private StockFormatMapper stockFormatMapper;
    @Resource
    private BlackStockMapper blackStockMapper;

    public List<ChannelStock> list(PageData pd) {
        if (pd != null) {
            pd.put("start", pd.getInteger("start"));
            pd.put("length", pd.getInteger("length"));
        }
        return njStrategyMapperExtend.selectPageChannelStock(pd);
    }

    public int listAllCount(PageData pd) {
        ChannelStockExample stockBaseExample = new ChannelStockExample();
        String keyword = pd.getString("keyword");
        if (pd.containsKey("type") && pd.getInteger("type") != null) {
            stockBaseExample.createCriteria().andTypeEqualTo(pd.getInteger("type"));
        }
        if (StringUtils.isNotEmpty(keyword)) {
            stockBaseExample.createCriteria().andStockNoEqualTo(keyword);
        }
        return channelStockMapper.countByExample(stockBaseExample);
    }

    public void add(ChannelStock stockBase) {
        stockBase.setId(UuidUtil.get32UUID());
        channelStockMapper.insertSelective(stockBase);
    }

    public Integer delete(String id) {
        return channelStockMapper.deleteByPrimaryKey(id);
    }

    public ChannelStock getById(String id) {
        return channelStockMapper.selectByPrimaryKey(id);
    }

    public void insertBath(ArrayList<ChannelStock> channelStocks) {

        //获取黑名单货号列表
        List<BlackStock> blackStockList = blackStockMapper.selectByExample(null);
        //导入ERP基础库存前，清理之前的数据
        channelStockMapper.deleteByExample(null);
        for (ChannelStock channelStock : channelStocks) {
            boolean isBlack = false; //是否存在黑名单中标识
            String stockNo = channelStock.getStockNo();
            for (BlackStock blackStock : blackStockList) {
                //先过滤掉黑名单的货号（匹配货号+尺寸）
                boolean match = doMatchBlack(channelStock,blackStock);
                if(match){
                    isBlack = true;
                    break;
                }
            }
            if(isBlack){
                channelStock.setType(2);
                channelStock.setChannelPrice("");
                channelStock.setBasePrice("");
                channelStock.setDiscount("");
                channelStock.setRemark("货号存在黑名单中");
            }else{
                if (channelStock.getType() != null && channelStock.getType() == 2) { // 如果导入表格中存在空数据，默认为问题数据
                    channelStock.setChannelPrice("");
                    channelStock.setBasePrice("");
                    channelStock.setDiscount("");
                    continue;
                } else {
                    // 数量、价格是否合法
                    String amount = channelStock.getAmount();
                    String basePrice = channelStock.getBasePrice();
                    if(!StringUtils.isNumeric(amount)){//如果数量不合法
                        channelStock.setType(2);
                        channelStock.setRemark("可订购数量为非法数字");
                        continue;
                    }
                    if(!StringUtils.isNumeric(basePrice)){//如果零售价不合法
                        channelStock.setType(2);
                        channelStock.setRemark("零售价为非法数字");
                        continue;
                    }
                    if (Integer.parseInt(amount) <= 0 || Integer.parseInt(basePrice) <= 0) { //过滤掉根数量、零售价小于0的数据
                        channelStock.setType(2);
                        channelStock.setChannelPrice("");
                        channelStock.setDiscount("");
                        channelStock.setRemark("可订购数量或零售价小于0");
                    }else{
                        //根据货号获取档案库信息
                        StockBaseExample stockBaseExample = new StockBaseExample();
                        stockBaseExample.createCriteria().andStockNoEqualTo(stockNo);
                        stockBaseExample.setOrderByClause("channel_price DESC"); //如果存在多个相同货号的档案数据，根据价格排序取最大
                        List<StockBase> stockBases = stockBaseMapper.selectByExample(stockBaseExample);
                        if (stockBases != null && stockBases.size() > 0) { // 如果存在，则添加为渠道基础库
                            StockBase stockBase = stockBases.get(0);
                            channelStock.setType(1);
                            channelStock.setChannelPrice(stockBase.getChannelPrice());
                            channelStock.setBasePrice(stockBase.getBasePrice());
                            channelStock.setDiscount(stockBase.getDiscount());
                        } else { //至此，只能作为新品数据
                            channelStock.setChannelPrice("");
                            channelStock.setDiscount("");
                            channelStock.setType(3);
                        }
                    }
                }
            }

        }
        njStrategyMapperExtend.insertBath(channelStocks);
    }

    public boolean doMatchBlack(ChannelStock channelStock, BlackStock blackStock) {
        String sizeRang = blackStock.getSizeRange();
        boolean isMatch = false;
        if (channelStock.getStockNo().equals(blackStock.getStockNo())) {
            if(sizeRang.equals("ALL")){
                isMatch = true;
            }else{
                String [] sizes = sizeRang.split(",");
                List<String> sizeList = Arrays.asList(sizes);
                if(sizeList.indexOf(channelStock.getSpecification()) != -1){
                    isMatch = true;
                }
            }
        }
        return isMatch;
    }

    public void edit(ChannelStock stockBase) {
        channelStockMapper.updateByPrimaryKeySelective(stockBase);
    }

    public void clearData() {
        channelStockMapper.deleteByExample(null);
    }

    public List<ChannelStockModel> listModel(PageData pd) {
        return njStrategyMapperExtend.selectPageChannelStockModel(pd);
    }

    public List<ChannelStockModelNew> listModelNew(PageData pd) {
        return njStrategyMapperExtend.selectPageChannelStockModelNew(pd);
    }

    public void exportChannelData(List<StockFormatDict> stockFormatDicts, HttpServletRequest reqst, HttpServletResponse response, String formatId) {
        String basePath = reqst.getContextPath();
        basePath = reqst.getScheme() + "://" + reqst.getServerName() + ":" + reqst.getServerPort() + basePath + "/";
        String realPath = reqst.getSession().getServletContext().getRealPath("static" + File.separator + "upload" + File.separator + "excelFile" + File.separator);
        String filename = "";
        StockFormat stockFormat = stockFormatMapper.selectByPrimaryKey(formatId);
        filename = stockFormat.getName() + ".xlsx";
        XSSFWorkbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = null;
        XSSFSheet sheet = wb.createSheet(stockFormat.getName());
        XSSFRow row = sheet.createRow(0);
        //创建表头
        Map<Integer, String> cellMap = new HashMap<>();
        for (int i = 0; i < stockFormatDicts.size(); i++) {
            StockFormatDict stockFormatDict = stockFormatDicts.get(i);
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(stockFormatDict.getColumName());
            SysDict sysDict = sysDictMapper.selectByPrimaryKey(stockFormatDict.getDictId());
            cellMap.put(i, sysDict.getValue());
        }
        try {
            ChannelStockExample channelStockExample = new ChannelStockExample();
            channelStockExample.createCriteria().andTypeEqualTo(1);
            List<ChannelStock> channelStockList = channelStockMapper.selectByExample(channelStockExample);
            //设置数据
            for (int i = 0; i < channelStockList.size(); i++) {
                ChannelStock channelStock = channelStockList.get(i);
                XSSFRow rowTemp = sheet.createRow(i + 1);
                for (Integer key : cellMap.keySet()) {
                    XSSFCell cell = rowTemp.createCell(key);
                    String columName = cellMap.get(key);
                    Class<ChannelStock> clz = ChannelStock.class;
                    Field field = clz.getDeclaredField(columName);
                    String fileValue = field.get(channelStock) + "";
                    cell.setCellValue(fileValue);
                }
            }
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            fileOut = new FileOutputStream(realPath + File.separator + filename);
            wb.write(fileOut);
            ExportUtil.download(realPath, filename, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
