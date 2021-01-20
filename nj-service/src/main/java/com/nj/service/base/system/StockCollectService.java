package com.nj.service.base.system;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.dao.ActivityStockMapper;
import com.nj.dao.extend.StockCollectMapperExtend;
import com.nj.model.generate.StockCollect;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        List<StockCollect> saveStockCollect = null;
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
            }
        }
        if(saveStockCollect != null && saveStockCollect.size()>0) {
            stockCollectMapperExtend.insertBath(saveStockCollect);
        }
    }

}
