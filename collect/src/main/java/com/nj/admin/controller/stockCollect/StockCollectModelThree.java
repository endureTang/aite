package com.nj.admin.controller.stockCollect;

import com.nj.core.base.util.DateUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.model.datamodel.StockCollectZipModel;
import com.nj.model.generate.ActivityStock;
import com.nj.model.generate.StockCollect;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Package com.nj.service.base.system
 * @ClassName StockCollectModelOne
 * @Description: 库存汇总模板一service
 * @Date 2021年01月14:00
 * @Author endure
 */
@Component
public class StockCollectModelThree {
    /**
     * @description: 执行模板一库存汇总
     * @param: [file]
     * @return: void
     * @author endure
     * @date: 2021-01-19 16:24
     */
    public List<StockCollectZipModel> execExcel(File file, String type, List<String> activityStocks) throws Exception {
        InputStream input = null;
        String postfix = ExcelUtil.getPostfix(file.getName());
        String fileName = file.getName();
        //如果是xls文件格式
        if(!ExcelUtil.EMPTY.equals(postfix)){
            if(ExcelUtil.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)){
                HSSFWorkbook wb = null;
                input = new FileInputStream(file);
                // 创建文档
                wb = new HSSFWorkbook(input);
                HSSFSheet hssfSheet = wb.getSheetAt(0); //获取第一个sheet
                int totalRows = hssfSheet.getLastRowNum();

                //获取标题行在第几行，获取规则为：连续15列数据不为空
                Integer titleRow = null;
                for(int rowNum = 0;rowNum <= totalRows;rowNum++){
                    if(titleRow != null){ //如果已经找到标题行，跳出循环
                        break;
                    }
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if(hssfRow!=null){
                        short totalCells = hssfRow.getLastCellNum();
                        for (int i = 0; i < totalCells; i++) {//开始遍历每列数据
                            if(i >= 15){    //如果遍历了15列，则可认为是标题行
                                titleRow = rowNum;
                                break;
                            }
                            HSSFCell cell = hssfRow.getCell(i);//如果当前列为空，则执行下一列
                            if(cell == null || "".equals(ExcelUtil.getHValue(cell))){
                                break;
                            }
                        }
                    }
                }
                if(titleRow != null){
                    //读取Row,从标题行的下一行开始
                    List<StockCollectZipModel> stockCollectList = new ArrayList<>();
                    for(int rowNum = titleRow+1;rowNum <= totalRows;rowNum++){
                        HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                        if(hssfRow!=null){
                            //读取Row,从第titleRow+1行开始
                            HSSFCell cell = hssfRow.getCell(0);
                            if(cell!=null){
                                int emptyCount = 0;
                                String department = ExcelUtil.getXValue(hssfRow.getCell(0));
                                if(!(department.equals("APPAREL")||department.equals("FOOTWEAR")||department.equals("HARDWARE"))){
                                    continue;
                                }
                                String meterialNo = ExcelUtil.getXValue(hssfRow.getCell(1));
                                String description = ExcelUtil.getXValue(hssfRow.getCell(2));
                                String brandCode = ExcelUtil.getXValue(hssfRow.getCell(3));
                                String brand = ExcelUtil.getXValue(hssfRow.getCell(4));
                                String publishDate = ExcelUtil.getXValue(hssfRow.getCell(5));
                                if(StringUtils.isNotEmpty(publishDate)){
                                    try{
                                        if(publishDate.contains("/")){
                                            Date date = DateUtil.parseDate(publishDate,"yyyy/MM/dd");
                                            publishDate = DateUtil.formatDate(date);
                                        }

                                    }catch (Exception e){

                                    }
                                }
                                String sexType = ExcelUtil.getXValue(hssfRow.getCell(6));
                                String sportType = ExcelUtil.getXValue(hssfRow.getCell(7));
                                String seasonCOde = ExcelUtil.getXValue(hssfRow.getCell(8));
                                String colorAll = ExcelUtil.getXValue(hssfRow.getCell(9));
                                String size = ExcelUtil.getXValue(hssfRow.getCell(10));
                                String firstReceiveDate = ExcelUtil.getXValue(hssfRow.getCell(11));
                                if(StringUtils.isNotEmpty(firstReceiveDate)){
                                    try{
                                        if(publishDate.contains("/")){
                                            Date date = DateUtil.parseDate(firstReceiveDate,"yyyy/MM/dd");
                                            firstReceiveDate = DateUtil.formatDate(date);
                                        }
                                    }catch (Exception e){

                                    }
                                }
                                String costPrice = ExcelUtil.getXValue(hssfRow.getCell(12));
                                String rrp = ExcelUtil.getXValue(hssfRow.getCell(13));
                                //首先RRP必须是数字，并且大于9才插入数据库
                                if(StringUtils.isNumeric(rrp)){
                                    Double tmpDouble = Double.parseDouble(rrp);
                                    if(tmpDouble <=9){
                                        continue;
                                    }
                                }
                                String crp = ExcelUtil.getXValue(hssfRow.getCell(14));
                                String epr = ExcelUtil.getXValue(hssfRow.getCell(15));
                                String location = ExcelUtil.getXValue(hssfRow.getCell(16));
                                StockCollectZipModel stockCollectZipModel = new StockCollectZipModel();
                                if(location.equals("在途总数")){
                                    String amount = ExcelUtil.getXValue(hssfRow.getCell(17));
                                    stockCollectZipModel.setAmount(amount);
                                }else{
                                    stockCollectZipModel.setAmount("0");
                                }
                                stockCollectZipModel.setDepartment(department);
                                stockCollectZipModel.setMeterialNo(meterialNo);
                                stockCollectZipModel.setIsActivity(activityStocks.contains(meterialNo) ? "Y" : "N");
                                stockCollectZipModel.setDescription(description);
                                stockCollectZipModel.setBradCode(brandCode);
                                stockCollectZipModel.setBrand(brand);
                                stockCollectZipModel.setPubDate(publishDate);
                                stockCollectZipModel.setSexType(sexType);
                                stockCollectZipModel.setSportType(sportType);
                                stockCollectZipModel.setSeasonCode(seasonCOde);
                                stockCollectZipModel.setColorAll(colorAll);
                                stockCollectZipModel.setFirstReceiveDate(firstReceiveDate);
                                stockCollectZipModel.setCostPrice(costPrice);
                                stockCollectZipModel.setRrp(rrp);
                                stockCollectZipModel.setCrp(crp);
                                stockCollectZipModel.setErp(epr);
                                stockCollectZipModel.setOnWayAmount("");
                                stockCollectZipModel.setStorage("");
                                stockCollectZipModel.setStoreName(fileName.substring(0,fileName.lastIndexOf(".")));
                                stockCollectList.add(stockCollectZipModel);
                            }
                        }
                    }
                    return stockCollectList;
                }else{
                    throw new Exception("没有找到标题行");
                }
                //如果是xls文件格式
            }else if(ExcelUtil.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)){
                input = new FileInputStream(file);
                // 创建文档
                Workbook wb = WorkbookFactory.create(input);
                Sheet xssfSheet = wb.getSheetAt(0); //获取第一个sheet
                int totalRows = xssfSheet.getLastRowNum();

                //获取标题行在第几行，获取规则为：连续15列数据不为空
                Integer titleRow = null;
                for(int rowNum = 0;rowNum <= totalRows;rowNum++){
                    if(titleRow != null){//如果已经找到标题行，跳出循环
                        break;
                    }
                    Row xssfRow = xssfSheet.getRow(rowNum);
                    if(xssfRow!=null){
                        short totalCells = xssfRow.getLastCellNum();
                        for (int i = 0; i < totalCells; i++) {//开始遍历每列数据
                            if(i >= 15){ //如果遍历了15列，则可认为是标题行
                                titleRow = rowNum;
                                break;
                            }
                            Cell cell = xssfRow.getCell(i);
                            if(cell == null ||ExcelUtil.getXValue(cell).equals("")){//如果当前列为空，则执行下一列
                                break;
                            }
                        }
                    }
                }
                if(titleRow != null){
                    //读取Row,从第titleRow+1行开始
                    List<StockCollectZipModel> stockCollectList = new ArrayList<>();
                    for(int rowNum = titleRow+1;rowNum <= totalRows;rowNum++){
                        Row xssfRow = xssfSheet.getRow(rowNum);
                        if(xssfRow!=null){
                            String department = ExcelUtil.getXValue(xssfRow.getCell(0));
                            if(!(department.equals("APPAREL")||department.equals("FOOTWEAR")||department.equals("HARDWARE"))){
                                continue;
                            }
                            String meterialNo = ExcelUtil.getXValue(xssfRow.getCell(1));
                            String description = ExcelUtil.getXValue(xssfRow.getCell(2));
                            String brandCode = ExcelUtil.getXValue(xssfRow.getCell(3));
                            String brand = ExcelUtil.getXValue(xssfRow.getCell(4));
                            String publishDate = ExcelUtil.getXValue(xssfRow.getCell(5));
                            if(StringUtils.isNotEmpty(publishDate)){
                                try{
                                    if(publishDate.contains("/")){
                                        Date date = DateUtil.parseDate(publishDate,"yyyy/MM/dd");
                                        publishDate = DateUtil.formatDate(date);
                                    }

                                }catch (Exception e){

                                }
                            }
                            String sexType = ExcelUtil.getXValue(xssfRow.getCell(6));
                            String sportType = ExcelUtil.getXValue(xssfRow.getCell(7));
                            String seasonCOde = ExcelUtil.getXValue(xssfRow.getCell(8));
                            String colorAll = ExcelUtil.getXValue(xssfRow.getCell(9));
                            String size = ExcelUtil.getXValue(xssfRow.getCell(10));
                            String firstReceiveDate = ExcelUtil.getXValue(xssfRow.getCell(11));
                            if(StringUtils.isNotEmpty(firstReceiveDate)){
                                try{
                                    if(publishDate.contains("/")){
                                        Date date = DateUtil.parseDate(firstReceiveDate,"yyyy/MM/dd");
                                        firstReceiveDate = DateUtil.formatDate(date);
                                    }
                                }catch (Exception e){

                                }
                            }
                            String costPrice = ExcelUtil.getXValue(xssfRow.getCell(12));
                            String rrp = ExcelUtil.getXValue(xssfRow.getCell(13));
                            //首先RRP必须是数字，并且大于9才插入数据库
                            if(StringUtils.isNumeric(rrp)){
                                Double tmpDouble = Double.parseDouble(rrp);
                                if(tmpDouble <=9){
                                    continue;
                                }
                            }
                            String crp = ExcelUtil.getXValue(xssfRow.getCell(14));
                            String epr = ExcelUtil.getXValue(xssfRow.getCell(15));
                            String location = ExcelUtil.getXValue(xssfRow.getCell(16));
                            StockCollectZipModel stockCollectZipModel = new StockCollectZipModel();
                            if(location.equals("在途总数")){
                                String amount = ExcelUtil.getXValue(xssfRow.getCell(17));
                                stockCollectZipModel.setAmount(amount);
                            }else{
                                stockCollectZipModel.setAmount("0");
                            }
                            stockCollectZipModel.setDepartment(department);
                            stockCollectZipModel.setMeterialNo(meterialNo);
                            stockCollectZipModel.setIsActivity(activityStocks.contains(meterialNo) ? "Y" : "N");
                            stockCollectZipModel.setDescription(description);
                            stockCollectZipModel.setBradCode(brandCode);
                            stockCollectZipModel.setBrand(brand);
                            stockCollectZipModel.setPubDate(publishDate);
                            stockCollectZipModel.setSexType(sexType);
                            stockCollectZipModel.setSportType(sportType);
                            stockCollectZipModel.setSeasonCode(seasonCOde);
                            stockCollectZipModel.setColorAll(colorAll);
                            stockCollectZipModel.setFirstReceiveDate(firstReceiveDate);
                            stockCollectZipModel.setCostPrice(costPrice);
                            stockCollectZipModel.setRrp(rrp);
                            stockCollectZipModel.setCrp(crp);
                            stockCollectZipModel.setErp(epr);
                            stockCollectZipModel.setOnWayAmount("");
                            stockCollectZipModel.setStorage("");
                            stockCollectZipModel.setStoreName(fileName.substring(0,fileName.lastIndexOf(".")));
                            stockCollectList.add(stockCollectZipModel);
                        }
                    }
                    return stockCollectList;
                }else{
                    throw new Exception("没有找到标题行");
                }

            }else{
                throw new Exception("暂不支持的Excel版本");
            }
        }
        return null;
    }
}
