package com.nj.admin.controller.stockCollect;

import com.nj.admin.util.ExportMaxUtil;
import com.nj.core.base.util.DateUtil;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportUtil;
import com.nj.core.utils.excel.ZipHelperUtils;
import com.nj.model.datamodel.StockCollectModel;
import com.nj.model.datamodel.StockCollectZipModel;
import com.nj.model.generate.ActivityStock;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Package com.nj.admin.controller
 * @ClassName StockCollectLocalServcie
 * @Description:
 * @Date 2021年01月10:59
 * @Author endure
 */
@Component
public class StockCollectLocalServcie {

    @Resource
    private StockCollectModelOne stockCollectModelOne;
    @Resource
    private StockCollectModelTwo stockCollectModelTwo;
    @Resource
    private StockCollectModelThree stockCollectModelThree;

    @Resource
    private StockCollectLocalServcie stockCollectLocalServcie;
    //清除数据
    public void clearStockCollect() {
    }

    public void generateStockCollect(HttpServletRequest request,String type, String tempPath, String xmlPath) throws Exception {
        Date start = new Date();
        System.out.println("开始解析上传压缩包....");
        System.out.println("开始时间："+ DateUtil.formatDate(start,"yyyy-MM-dd HH:mm:ss"));
        List<String> activityStocks = (List<String>) request.getSession().getAttribute("activityList");
//        if(activityStocks==null || activityStocks.isEmpty()){
//            System.out.println("请先上传活动文件！");
//            throw new Exception("活动文件未上传");
//            System.out.println("=======================================");
//            System.out.println("读取活动文件数据开始......");
//            XStream xs = new XStream(new DomDriver());
//            xs.allowTypesByRegExp(new String[] { ".*" });
//            File activityFile = new File(activityPath);
//            File xmlFile = new File(activityFile, "活动列表.xml");
//            FileInputStream fis = new FileInputStream(xmlFile);
//            xs.alias("temp", ArrayList.class); // 类别名
//            xs.alias("activity", ActivityStock.class);
//            activityStocks = (List<String>) xs.fromXML(fis);
//            System.out.println("读取活动文件数据结束！");
//            request.getSession().setAttribute("activityList", activityStocks);
//        }
        File tempFile = new File(tempPath);
        File[] excelFiles = tempFile.listFiles();
        List<StockCollectZipModel> saveStockCollect = new ArrayList<>();
        int fileNo = 0;
        for(File file:excelFiles){ //遍历File[]数组
            if(!file.isDirectory()){//若非目录(即文件)
                fileNo++;
                System.out.println("第"+fileNo+"个文件，"+file.getName()+"处理中...");
                //根据不同模板执行不同汇总策略
                if (type.equals("1")) {
                    saveStockCollect = stockCollectModelOne.execExcel(file,type,activityStocks);
                }else if(type.equals("2")){
                    saveStockCollect = stockCollectModelTwo.execExcel(file,type,activityStocks);
                }else if(type.equals("3")){
                    saveStockCollect = stockCollectModelThree.execExcel(file,type,activityStocks);
                }
                if(saveStockCollect.size()>0) {
                    stockCollectLocalServcie.saveStockXml(file.getName(),saveStockCollect,xmlPath+File.separator+type);
                }
            }
        }
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        System.out.println("==============================================================================================================================================");

        System.out.println("程序处理完成，结束时间："+DateUtil.formatDate(endDate,"yyyy-MM-dd HH:mm:ss")+"，总共耗时："+ sec+"秒！");
    }

    private void saveStockXml(String fileName,List<StockCollectZipModel> saveStockCollect, String tempPath) {
        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("stockModel", StockCollectZipModel.class);
        File file = new File(tempPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        File outFile = new File(file, fileName+".xml");
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
            BufferedWriter bw = new BufferedWriter(osw);
            xs.toXML(saveStockCollect, bw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(fileName+"保存失败，错误信息："+e);
        }
    }

    /**
    * @description: 导出xml
    * @param: [savePath, xmlPath]
    * @return: long
    * @author endure
    * @date: 2021-01-28 13:46
     */ 
    public long selectDownLoadZipList(String savePath,String xmlPath) throws Exception {
        Date start = new Date();
        System.out.println("开始执行门店excel生成.......");
        System.out.println("开始时间："+ DateUtil.formatDate(start,"yyyy-MM-dd HH:mm:ss"));

        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("stockModel", StockCollectZipModel.class);
        FileInputStream fis = null;
        List<StockCollectZipModel> totalStockList = new ArrayList<>();
        File xmlFile = new File(xmlPath);
        File[] xmlFiles = xmlFile.listFiles();
        int fileNo = 0;
        for (File xmFile : xmlFiles) {
            if (xmFile.isDirectory()) {
                File[] files = xmFile.listFiles();
                for (File xFile : files) {
                    fileNo++;
                    if (!xFile.isDirectory()) {
                        String fileName = xFile.getName();
                        fileName = fileName.substring(0, fileName.lastIndexOf("."));
                        fis = new FileInputStream(xFile);
                        List<StockCollectZipModel> stockCollectList = (List<StockCollectZipModel>) xs.fromXML(fis);
                        ExportMaxUtil.baseExportStockCollect(savePath+ File.separator + "exportExcel",stockCollectList, StockCollectZipModel.class, fileName+".xlsx", fileName);
                        totalStockList.addAll(stockCollectList);
                        System.out.println("第"+fileNo+"个文件"+fileName+"处理完成");
                    }
                }
            }
        }
        System.out.println("门店excel生成执行完成，开始执行压缩......");
        File tempFile = new File(savePath+ File.separator + "exportExcel");
        File[] excelFiles = tempFile.listFiles();
        File file = new File(savePath);
        if(!file.exists()){
            file.mkdirs();
        }
        ZipHelperUtils.zip(excelFiles,savePath +File.separator+"全部门店.zip","全部门店");
        ZipHelperUtils.deletefile(savePath+ File.separator + "exportExcel");
        System.out.println("门店excel压缩执行完成！");
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        execCollectXml(totalStockList,savePath);
        System.out.println("==============================================================================================================================================");

        System.out.println("程序处理完成，结束时间："+DateUtil.formatDate(endDate,"yyyy-MM-dd HH:mm:ss")+"，总共耗时："+ sec+"秒！");
        return sec;
    }
    /**
    * @description: 导出excel
    * @param: [savePath, xmlPath]
    * @return: long
    * @author endure
    * @date: 2021-01-28 13:45
     */ 
    public long selectDownLoadZipAndExcelList(String savePath, String xmlPath) throws Exception {
        Date start = new Date();
        System.out.println("开始执行门店excel生成.......");
        System.out.println("开始时间："+ DateUtil.formatDate(start,"yyyy-MM-dd HH:mm:ss"));

        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("stockModel", StockCollectZipModel.class);
        FileInputStream fis = null;
        List<StockCollectZipModel> totalStockList = new ArrayList<>();
        File xmlFile = new File(xmlPath);
        File[] xmlFiles = xmlFile.listFiles();
        int fileNo = 0;
        for (File xmFile : xmlFiles) {
            if (xmFile.isDirectory()) {
                File[] files = xmFile.listFiles();
                for (File xFile : files) {
                    fileNo++;
                    if (!xFile.isDirectory()) {
                        String fileName = xFile.getName();
                        fileName = fileName.substring(0, fileName.lastIndexOf("."));
                        fis = new FileInputStream(xFile);
                        List<StockCollectZipModel> stockCollectList = (List<StockCollectZipModel>) xs.fromXML(fis);
                        ExportMaxUtil.baseExportStockCollect(savePath+ File.separator + "exportExcel",stockCollectList, StockCollectZipModel.class, fileName+".xlsx", fileName);
                        totalStockList.addAll(stockCollectList);
                        System.out.println("第"+fileNo+"个文件"+fileName+"处理完成");
                    }
                }
            }
        }
        File tempFile = new File(savePath+ File.separator + "exportExcel");
        File[] excelFiles = tempFile.listFiles();
        File file = new File(savePath);
        if(!file.exists()){
            file.mkdirs();
        }
        ZipHelperUtils.zip(excelFiles,savePath +File.separator+"全部门店.zip","全部门店");
        ZipHelperUtils.deletefile(savePath+ File.separator + "exportExcel");
        System.out.println("门店excel压缩执行完成！");
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        execCollectExcel(totalStockList,savePath);
        System.out.println("==============================================================================================================================================");

        System.out.println("程序处理完成，结束时间："+DateUtil.formatDate(endDate,"yyyy-MM-dd HH:mm:ss")+"，总共耗时："+ sec+"秒！");
        return sec;
    }

    public void execCollectExcel(List<StockCollectZipModel> stockCollectZipModels, String savePath) {
        System.out.println("保存库存汇总excel开始......");
        System.out.println("共有"+stockCollectZipModels.size()+"条数据，请耐心等待。");
        try {
            AtomicInteger index=new AtomicInteger(1);
            List<StockCollectModel> stockCollectModels =
            stockCollectZipModels.stream().map(stockCollectZipModel -> {
                StockCollectModel stockCollectModel = new StockCollectModel();
                stockCollectModel.setSortName(index.getAndIncrement());
                stockCollectModel.setDepartment(stockCollectZipModel.getDepartment());
                stockCollectModel.setMeterialNo(stockCollectZipModel.getMeterialNo());
                stockCollectModel.setIsActivity(stockCollectZipModel.getIsActivity());
                stockCollectModel.setDescription(stockCollectZipModel.getDescription());
                stockCollectModel.setBradCode(stockCollectZipModel.getBradCode());
                stockCollectModel.setBrand(stockCollectZipModel.getBrand());
                stockCollectModel.setPubDate(stockCollectZipModel.getPubDate());
                stockCollectModel.setSexType(stockCollectZipModel.getSexType());
                stockCollectModel.setSportType(stockCollectZipModel.getSportType());
                stockCollectModel.setSeasonCode(stockCollectZipModel.getSeasonCode());
                stockCollectModel.setColorAll(stockCollectZipModel.getColorAll());
                stockCollectModel.setFirstReceiveDate(stockCollectZipModel.getFirstReceiveDate());
                stockCollectModel.setCostPrice(stockCollectZipModel.getCostPrice());
                stockCollectModel.setRrp(stockCollectZipModel.getRrp());
                stockCollectModel.setCrp(stockCollectZipModel.getCrp());
                stockCollectModel.setErp(stockCollectZipModel.getErp());
                stockCollectModel.setAmount(stockCollectZipModel.getAmount());
                stockCollectModel.setOnWayAmount(stockCollectZipModel.getOnWayAmount());
                stockCollectModel.setStorage(stockCollectZipModel.getStorage());
                stockCollectModel.setSize(stockCollectZipModel.getSize());
                stockCollectModel.setStoreName(stockCollectZipModel.getStoreName());
                return stockCollectModel;
            }).collect(Collectors.toList());
            stockCollectZipModels.clear();
            ExportMaxUtil.baseExportStockCollect(savePath,stockCollectModels, StockCollectModel.class, "库存汇总.xlsx", "库存汇总");
        } catch (Exception e) {
            System.out.println("保存库存汇总excel失败，错误信息："+e);
            e.printStackTrace();
        }
        System.out.println("保存库存汇总excel成功！");
    }
    public void execCollectXml(List<StockCollectZipModel> stockCollectZipModels, String savePath){
        System.out.println("库存汇总xml保存中......");
        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("stockModel",StockCollectZipModel.class);
        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File outFile = new File(file, "库存汇总.xml");
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
            BufferedWriter bw = new BufferedWriter(osw);
            xs.toXML(stockCollectZipModels, bw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("库存汇总保存xml失败，错误信息："+e);
        }
        System.out.println("库存汇总xml保存成功");
    }


    public static void main(String[] args) {
        System.out.println(100000/200000);
    }
}
