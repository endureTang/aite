package com.nj.admin.controller;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.exception.BaseException;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.model.generate.ErpOrder;
import com.nj.model.generate.StrategyOrder;
import com.nj.service.base.system.ErpOrderService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/file")
public class TFileController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(TFileController.class);

    @Resource(name = "erpOrderService")
    private ErpOrderService erpOrderService;


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public PageData add(@RequestParam("file") MultipartFile file) {
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            if (file.isEmpty()) {
                result.put("msg", "上传失败");
            } else {
                InputStream input = null;
                XSSFWorkbook wb = null;
                ArrayList<ErpOrder> erpOrderList = new ArrayList<>();
                try {
                    input = file.getInputStream();
                    // 创建文档
                    wb = new XSSFWorkbook(input);
                    //读取sheet(页)
                    for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
                        XSSFSheet xssfSheet = wb.getSheetAt(numSheet);
                        if (xssfSheet == null) {
                            continue;
                        }
                        int totalRows; //sheet中总行数
                        int totalCells;
                        totalRows = xssfSheet.getLastRowNum();
                        //读取Row,从第二行开始
                        for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
                            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                            totalCells = xssfRow.getPhysicalNumberOfCells(); //总列数
                            if (xssfRow != null) {
                                //读取列，从第一列开始
                                String sourceOrderNos = ExcelUtil.getXValue(xssfRow.getCell(22)).trim();//获取原始订单号
                                if (sourceOrderNos != null) {
                                    List<String> sourceOrderNo = Arrays.asList(sourceOrderNos.split(","));
                                    for (String sourceNo : sourceOrderNo) {
                                        ErpOrder erpOrder = new ErpOrder();
                                        erpOrder.setOrderNo(ExcelUtil.getXValue(xssfRow.getCell(0)).trim());
                                        erpOrder.setSourceOrderNo(sourceNo);
                                        erpOrder.setTransWay(ExcelUtil.getXValue(xssfRow.getCell(20)).trim());
                                        erpOrder.setTransNo(ExcelUtil.getXValue(xssfRow.getCell(19)).trim());
                                        erpOrder.setTransMoney("待计算");
                                        erpOrder.setAmount(ExcelUtil.getXValue(xssfRow.getCell(10)).trim());
                                        erpOrder.setSourceType(ExcelUtil.getXValue(xssfRow.getCell(28)).trim());
                                        erpOrder.setRemark(ExcelUtil.getXValue(xssfRow.getCell(30)).trim());
                                        erpOrderList.add(erpOrder);
                                    }
                                }
                            }
                        }
                    }
                    erpOrderService.insertBath(erpOrderList);
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
            logger.error("ERP订单上传出错：" + e);
            result.put("status", 0);
            result.put("msg", "上传失败");
        }
        return result;
    }


    @RequestMapping(value = "/uploadReturnFile", method = RequestMethod.POST)
    @ResponseBody
    public PageData uploadReturnFile(@RequestParam("file") MultipartFile file, @RequestParam("strategyId") String strategyId, HttpServletRequest reqst) {
        PageData result = new PageData();
        try {
            if (file.isEmpty()) {
                result.put("status", 0);
                result.put("msg", "文件为空");
            } else {
                String basePath = reqst.getContextPath();
                basePath = reqst.getScheme()+"://"+reqst.getServerName()+":"+reqst.getServerPort()+basePath+"/";
                String realPath = reqst.getSession().getServletContext().getRealPath("upload"+File.separator+"excelFile"+File.separator);
                File dir = new File(realPath);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String fileName = file.getOriginalFilename();
                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(realPath, fileName));

                StrategyOrder strategyOrder = new StrategyOrder();
                strategyOrder.setFileName(fileName);
                strategyOrder.setFilePath(basePath +"upload/excelFile/"+fileName);
                strategyOrder.setStrategyId(strategyId);
                strategyOrder.setCreateDate(new Date());
                erpOrderService.insertStrategyOrder(strategyOrder);
            }
            result.put("status", 1);
        } catch (BaseException e) {
            result.put("status", 0);
            result.put("msg", e.getMessage());
        } catch (Exception e) {
            result.put("status", 0);
            result.put("msg", "上传失败");
        }
        return result;
    }

}
