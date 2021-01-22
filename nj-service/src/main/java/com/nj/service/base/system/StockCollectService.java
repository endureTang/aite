package com.nj.service.base.system;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportUtil;
import com.nj.core.utils.excel.ZipHelperUtils;
import com.nj.dao.ActivityStockMapper;
import com.nj.dao.StockCollectMapper;
import com.nj.dao.extend.StockCollectMapperExtend;
import com.nj.model.datamodel.StockCollectModel;
import com.nj.model.datamodel.StockCollectZipModel;
import com.nj.model.generate.StockCollect;
import com.nj.model.generate.StockCollectExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @description: 库存汇总service
* @author endure
* @date: 2021-01-19 9:32
 */
@Transactional
@Service
public class StockCollectService {
    private static Logger logger = LoggerFactory.getLogger(StockCollectService.class);
    @Resource(name = "BaseDao")
    private BaseDao dao;
    @Resource
    private ActivityStockMapper activityStockMapper;
    @Resource
    private StockCollectMapperExtend stockCollectMapperExtend;
    @Resource
    private StockCollectMapper stockCollectMapper;
    @Resource
    private StockCollectModelOne stockCollectModelOne;
    @Resource
    private StockCollectModelTwo stockCollectModelTwo;
    @Resource
    private StockCollectModelThree stockCollectModelThree;

    /**
    * @description: 执行库存汇总，tempPath根据type的不同区分
    * @param: [type, tempPath]
    * @return: void
    * @author endure
    * @date: 2021-01-19 16:18
     */
    public void generateStockCollect(String type,String tempPath) throws Exception {
        File tempFile = new File(tempPath);
        File[] excelFiles = tempFile.listFiles();
        List<StockCollect> saveStockCollect = new ArrayList<>();
        for(File file:excelFiles){ //遍历File[]数组
            if(!file.isDirectory()){//若非目录(即文件)
                //根据不同模板执行不同汇总策略
                if (type.equals("1")) {
                    saveStockCollect = stockCollectModelOne.execExcel(file,type);
                }else if(type.equals("2")){
                    saveStockCollect = stockCollectModelTwo.execExcel(file,type);
                }else if(type.equals("3")){
                    saveStockCollect = stockCollectModelThree.execExcel(file,type);
                }
                if(saveStockCollect.size()>0) {
                    stockCollectMapperExtend.insertBath(saveStockCollect);
                }
            }
        }
    }
    public Long selectDownLoadZipList(String savePath) throws Exception {
        Date start = new Date();
        System.out.println("开始执行时间："+start);
        List<String> storeNameList = stockCollectMapperExtend.getStoreNameList();
        for (String storeName : storeNameList) {
            List<StockCollectZipModel> stockList = stockCollectMapperExtend.selectByStoreName(storeName);
            StringBuilder tempfilename = new StringBuilder();
            tempfilename.append(storeName+".xlsx");
            ExportUtil.baseExportStockCollect(savePath+ File.separator + "exportExcel",stockList, StockCollectZipModel.class, tempfilename.toString(), storeName);
        }
        File tempFile = new File(savePath+ File.separator + "exportExcel");
        File[] excelFiles = tempFile.listFiles();
        ZipHelperUtils.zip(excelFiles,savePath +File.separator+"全部门店.zip","全部门店");
        ZipHelperUtils.deletefile(savePath+ File.separator + "exportExcel");
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        System.out.println("耗时："+ sec);
        return sec;
    }

    public long execCollect(String savePath) throws Exception{
        Date start = new Date();
        System.out.println("开始执行时间："+start);
        long totalCount = stockCollectMapperExtend.selectCollectCount();

//        List<StockCollectModel> stockList = stockCollectMapperExtend.selectCollectList();
//        logger.info("查询数据结束，一共："+stockList.size()+"条数据");
//        ExportUtil.baseExportStockCollect(savePath,stockList, StockCollectModel.class, "总库存数据.xlsx", "总库存数据");
        exportBigDataExcel(totalCount,savePath);
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        System.out.println("耗时："+ sec);
        return sec;
    }

    public void clearStockCollect() {
        stockCollectMapper.deleteByExample(null);
    }
    /**
    * @description: 导出大量数据excel
    * @param: [path, totalCount, savePath]
    * @return: void
    * @author endure
    * @date: 2021-01-22 10:31
     */ 
    public void exportBigDataExcel(long totalCount, String savePath)
            throws IOException {
        // 最重要的就是使用SXSSFWorkbook，表示流的方式进行操作
        // 在内存中保持100行，超过100行将被刷新到磁盘
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet(); // 建立新的sheet对象
        Row row = sh.createRow(0);   // 创建第一行对象
        // -----------定义表头-----------
        int columnNum = 0;		//要导出的数据列数
        List<ExportFormat> formatList = new ArrayList();	//注解信息
        Field[] fields = StockCollectModel.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            ExportFormat exportFormat = fields[i].getAnnotation(ExportFormat.class);
            if(null != exportFormat){
                ++columnNum;
                formatList.add(exportFormat);
            }
        }

        Object[] rs = ExportUtil.sort(formatList);
        formatList = (List<ExportFormat>)rs[0];
        Map<Integer,Integer> sortMap = (Map<Integer, Integer>) rs[1];

        String[] tableHeaderArray = new String[columnNum];		//表头
        String[] fieldNameArray = new String[columnNum];		//要导出的列名


        for (int i = 0; i < fields.length; i++) {
            ExportFormat exportFormat = fields[i].getAnnotation(ExportFormat.class);
            if(null != exportFormat){
                int index = sortMap.get(exportFormat.sort());
                tableHeaderArray[index] = exportFormat.name();
                fieldNameArray[index] = fields[i].getName();
            }
        }
        for (int i = 0; i < tableHeaderArray.length; i++) {//创建表头
            row.createCell(i).setCellValue(tableHeaderArray[i]);
        }
        // ---------------------------
        List<StockCollectModel> list;
        // 数据库中存储的数据行
        int pageSize = 10000;
        // 求数据库中待导出数据的行数
        int listCount = (int) totalCount;
        // 根据行数求数据提取次数
        int exportTimes = listCount % pageSize > 0 ? listCount / pageSize
                + 1 : listCount / pageSize;
        // 按次数将数据写入文件
        for (int j = 0; j < exportTimes; j++) {
           list = stockCollectMapperExtend.selectCollectListPage((j+1)*pageSize,pageSize );
            int len = list.size() < pageSize ? list.size() : pageSize;
			for (int i = 0; i < len; i++) {
                Row dateRow = sh.createRow(j * pageSize + i + 1);
                dateRow.createCell(0).setCellValue(0);
                dateRow.createCell(1).setCellValue(list.get(i).getCrp());
                dateRow.createCell(2).setCellValue(list.get(i).getErp());
                dateRow.createCell(3).setCellValue(list.get(i).getRrp());
                dateRow.createCell(4).setCellValue(list.get(i).getStorage());
                dateRow.createCell(5).setCellValue(list.get(i).getPubDate());
                dateRow.createCell(6).setCellValue(list.get(i).getBrand());
                dateRow.createCell(7).setCellValue(list.get(i).getBradCode());
                dateRow.createCell(8).setCellValue(list.get(i).getOnWayAmount());
                dateRow.createCell(9).setCellValue(list.get(i).getSeasonCode());
                dateRow.createCell(10).setCellValue(list.get(i).getSize());
                dateRow.createCell(11).setCellValue(list.get(i).getAmount());
                dateRow.createCell(12).setCellValue(list.get(i).getStoreName());
                dateRow.createCell(13).setCellValue(list.get(i).getSexType());
                dateRow.createCell(14).setCellValue(list.get(i).getCostPrice());
                dateRow.createCell(15).setCellValue(list.get(i).getDescription());
                dateRow.createCell(16).setCellValue(list.get(i).getIsActivity());
                dateRow.createCell(17).setCellValue(list.get(i).getMeterialNo());
                dateRow.createCell(18).setCellValue(list.get(i).getSportType());
                dateRow.createCell(19).setCellValue(list.get(i).getDepartment());
                dateRow.createCell(20).setCellValue(list.get(i).getColorAll());
                dateRow.createCell(21).setCellValue(list.get(i).getFirstReceiveDate());
            }
            list.clear(); // 每次存储len行，用完了将内容清空，以便内存可重复利用
        }
        FileOutputStream fileOut = new FileOutputStream(savePath + File.separator + "总库存数据.xlsx");
        wb.write(fileOut);
        fileOut.close();
        wb.dispose();
    }
}
