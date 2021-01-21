package com.nj.service.base.system;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.utils.excel.ExportUtil;
import com.nj.core.utils.excel.ZipHelperUtils;
import com.nj.dao.ActivityStockMapper;
import com.nj.dao.StockCollectMapper;
import com.nj.dao.extend.StockCollectMapperExtend;
import com.nj.model.datamodel.StockCollectModel;
import com.nj.model.datamodel.StockCollectZipModel;
import com.nj.model.generate.StockCollect;
import com.nj.model.generate.StockCollectExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<StockCollectModel> stockList = stockCollectMapperExtend.selectCollectList();
        ExportUtil.baseExportStockCollect(savePath,stockList, StockCollectModel.class, "总库存数据.xlsx", "总库存数据");
        Date endDate = new Date();
        long sec = (endDate.getTime() - start.getTime()) / 1000;
        System.out.println("耗时："+ sec);
        return sec;
    }

    public void clearStockCollect() {
        stockCollectMapper.deleteByExample(null);
    }
}
