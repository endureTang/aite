package com.nj.admin.controller.stockCollect;

import com.nj.core.utils.excel.ExportUtil;
import com.nj.core.utils.excel.ZipHelperUtils;
import com.nj.model.datamodel.StockCollectZipModel;
import com.nj.model.generate.StockCollect;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
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

    public void generateStockCollect(String type,String tempPath,String xmlPath,String activityPath) throws Exception {

        File activityFile = new File(activityPath);
        File xmlFile = new File(activityFile, "活动列表.xml");
        File tempFile = new File(tempPath);
        File[] excelFiles = tempFile.listFiles();
        List<StockCollectZipModel> saveStockCollect = new ArrayList<>();
        for(File file:excelFiles){ //遍历File[]数组
            if(!file.isDirectory()){//若非目录(即文件)
                //根据不同模板执行不同汇总策略
                if (type.equals("1")) {
                    saveStockCollect = stockCollectModelOne.execExcel(file,type,xmlFile);
                }else if(type.equals("2")){
                    saveStockCollect = stockCollectModelTwo.execExcel(file,type,xmlFile);
                }else if(type.equals("3")){
                    saveStockCollect = stockCollectModelThree.execExcel(file,type,xmlFile);
                }
                if(saveStockCollect.size()>0) {
                    stockCollectLocalServcie.saveStockXml(file.getName(),saveStockCollect,xmlPath+File.separator+type);
                }
            }
        }
    }

    private void saveStockXml(String fileName,List<StockCollectZipModel> saveStockCollect, String tempPath) {
        System.out.println("保存zip开始");
        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("stockModel", StockCollectZipModel.class);
        File file = new File(tempPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File outFile = new File(file, fileName+"库存数据.xml");
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
            BufferedWriter bw = new BufferedWriter(osw);
            xs.toXML(saveStockCollect, bw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("保存zip成功");
    }

    public long selectDownLoadZipList(String savePath,String xmlPath) throws Exception {
        Date start = new Date();
        System.out.println("开始执行时间："+start);

        XStream xs = new XStream(new DomDriver());
        xs.alias("temp", ArrayList.class); // 类别名
        xs.alias("stockModel", StockCollectZipModel.class);
        FileInputStream fis = null;
        List<StockCollectZipModel> totalStockList = new ArrayList<>();
        File xmlFile = new File(xmlPath);
        File[] xmlFiles = xmlFile.listFiles();
        for (File xmFile : xmlFiles) {
            if (xmFile.isDirectory()) {
                File[] files = xmFile.listFiles();
                for (File xFile : files) {
                    if (!xFile.isDirectory()) {
                        fis = new FileInputStream(xFile);
                        List<StockCollectZipModel> stockCollectList = (List<StockCollectZipModel>) xs.fromXML(fis);
                        totalStockList.addAll(stockCollectList);
                    }

                }
            }
        }
        Map<String,List<StockCollectZipModel>> stockGroup = totalStockList.stream().collect(Collectors.groupingBy(StockCollectZipModel::getStoreName));
        Set<String> strings = stockGroup.keySet();
        for (String key : strings) {
            List<StockCollectZipModel> stockList = stockGroup.get(key);
            StringBuilder tempfilename = new StringBuilder();
            tempfilename.append(key+".xlsx");
            ExportUtil.baseExportStockCollect(savePath+ File.separator + "exportExcel",stockList, StockCollectZipModel.class, tempfilename.toString(), key);
        }
        File tempFile = new File(savePath+ File.separator + "exportExcel");
        File[] excelFiles = tempFile.listFiles();
        File file = new File(savePath);
        if(!file.exists()){
            file.mkdirs();
        }
        ZipHelperUtils.zip(excelFiles,savePath +File.separator+"全部门店.zip","全部门店");
        ZipHelperUtils.deletefile(savePath+ File.separator + "exportExcel");
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        System.out.println("耗时："+ sec);
        return sec;
    }

    public long execCollect(String realPath) {
        return 0;
    }
}
