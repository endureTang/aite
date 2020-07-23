package com.nj.admin.controller;

import com.jd.core.util.StringUtil;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.exception.BaseException;
import com.nj.core.base.util.PageData;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.model.generate.ErpOrder;
import com.nj.model.generate.StrategyOrder;
import com.nj.service.base.system.ErpOrderService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
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
import java.io.*;
import java.util.*;


@Controller
@RequestMapping("/file")
public class TFileController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(TFileController.class);

    @Resource(name = "erpOrderService")
    private ErpOrderService erpOrderService;

    //需要注意的是当删除某一目录时，必须保证该目录下没有其他文件才能正确删除，否则将删除失败。
    private void deleteFolder(File folder) throws Exception {
        if (!folder.exists()) {
            throw new Exception("文件不存在");
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //递归直到目录下没有文件
                    deleteFolder(file);
                } else {
                    //删除
                    file.delete();
                }
            }
        }
        //删除
        folder.delete();

    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public PageData add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        PageData result = new PageData();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("upload" + File.separator + "excelFile" + File.separator);
            File dir = new File(realPath);
            deleteFolder(dir);
            PageData pd = super.getPageData();
            if (file.isEmpty()) {
                result.put("msg", "上传失败");
            } else {
                InputStream input = null;
                XSSFWorkbook wb = null;
                List<Map<String, Object>> transModelList = null;
                ArrayList<ErpOrder> erpOrderList = new ArrayList<>();
                try {
                    List<String> lists = new ArrayList<>();
                    lists.add("北京");
                    lists.add("上海");
                    lists.add("天津");
                    lists.add("重庆");
                    lists.add("澳门特别行政区");
                    lists.add("广西壮族自治区");
                    lists.add("内蒙古自治区");
                    lists.add("宁夏回族自治区");
                    lists.add("西藏自治区");
                    lists.add("香港特别行政区");
                    lists.add("新疆维吾尔自治区");
                    lists.add("河北");
                    lists.add("山西");
                    lists.add("辽宁");
                    lists.add("吉林");
                    lists.add("黑龙江");
                    lists.add("江苏");
                    lists.add("浙江");
                    lists.add("安徽");
                    lists.add("福建");
                    lists.add("江西");
                    lists.add("山东");
                    lists.add("河南");
                    lists.add("湖北");
                    lists.add("湖南");
                    lists.add("广东");
                    lists.add("海南");
                    lists.add("四川");
                    lists.add("贵州");
                    lists.add("云南");
                    lists.add("陕西");
                    lists.add("甘肃");
                    lists.add("青海");
                    lists.add("台湾");

                    input = file.getInputStream();
                    // 创建文档
                    wb = new XSSFWorkbook(input);
                    //读取sheet(页)
                    XSSFSheet xssfSheet = wb.getSheetAt(0);
                    int totalRows; //sheet中总行数
                    totalRows = xssfSheet.getLastRowNum();
                    //读取Row,从第二行开始
                    for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
                        XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                        if (xssfRow != null) {
                            //读取列，从第一列开始
                            String sourceOrderNos = ExcelUtil.getXValue(xssfRow.getCell(22)).trim();//获取原始订单号
                            if (sourceOrderNos != null) {
                                List<String> sourceOrderNo = Arrays.asList(sourceOrderNos.split(","));
                                for (String sourceNo : sourceOrderNo) {
                                    ErpOrder erpOrder = new ErpOrder();
                                    String orderNo = ExcelUtil.getXValue(xssfRow.getCell(0));
                                    if(StringUtil.isBlank(orderNo)){
                                        logger.error("订单编号为空");
                                        continue;
                                    }
                                    erpOrder.setOrderNo(orderNo.trim());
                                    erpOrder.setSourceOrderNo(sourceNo);
                                    String transWay = ExcelUtil.getXValue(xssfRow.getCell(20));
                                    if(StringUtil.isBlank(transWay)){
                                        logger.error("物流方式为空");
                                        continue;
                                    }
                                    erpOrder.setTransWay(ExcelUtil.getXValue(xssfRow.getCell(20)));
                                    String transNo = ExcelUtil.getXValue(xssfRow.getCell(19));
                                    if(StringUtil.isBlank(transNo)){
                                        logger.error("物流单号为空");
                                        continue;
                                    }
                                    erpOrder.setTransNo(ExcelUtil.getXValue(xssfRow.getCell(19)));
                                    String address = ExcelUtil.getXValue(xssfRow.getCell(18));
                                    if(StringUtil.isBlank(address)){
                                        logger.error("地址为空");
                                        continue;
                                    }
                                    String amount = ExcelUtil.getXValue(xssfRow.getCell(10));
                                    String province = "";
                                    try {
                                        int i = -1;
                                        int count = 0;
                                        for (String key : lists) {
                                            i = address.indexOf(key);
                                            if (i != -1) {
                                                i += key.length();
                                                province =  address.substring(0, i);
                                                if(count >= 11){
                                                    province += "省";
                                                }
                                                break;
                                            }
                                            count ++;
                                        }
                                        if (i == -1) {
                                            erpOrder.setTransMoney("省份匹配失败");
                                        } else {
                                            if (transModelList == null) {
                                                transModelList = getTransModel(request);
                                            }
                                            if(StringUtil.isBlank(province)){
                                                province = address.substring(0, i);
                                            }
                                            String transMoney = calcTransMoney(province, amount, transModelList);
                                            erpOrder.setTransMoney(transMoney);
                                        }
                                    } catch (Exception e) {
                                        logger.error("订单号,{}系统错误，错误信息{}",erpOrder.getOrderNo(),e);
                                        continue;
                                    }
                                    erpOrder.setAmount(amount);
                                    erpOrder.setSourceType(ExcelUtil.getXValue(xssfRow.getCell(28)));
                                    erpOrder.setRemark(ExcelUtil.getXValue(xssfRow.getCell(30)));
                                    erpOrderList.add(erpOrder);
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
            e.printStackTrace();
            logger.error("ERP订单上传出错：" + e);
            result.put("status", 0);
            result.put("msg", "上传失败");
        }
        return result;
    }

    private String calcTransMoney(String province, String amount, List<Map<String, Object>> list) {
        String money = "省份匹配失败";
        for (Map<String, Object> map : list) {
            String value = (String) map.get(province);
            if (!StringUtil.isBlank(value)) {
                List<String> strings = Arrays.asList(value.split(","));
                String baseMoney = strings.get(0);
                String moreMoney = strings.get(1);
                if (Integer.parseInt(amount) <= 1) {
                    money = baseMoney;
                } else {
                    Double aDouble = Double.parseDouble(baseMoney) + Double.parseDouble(amount) * Double.parseDouble(moreMoney);
                    money = aDouble.toString();
                }
            }
        }
        return money;
    }

    private List<Map<String, Object>> getTransModel(HttpServletRequest request) {
        InputStream input = null;
        XSSFWorkbook wb = null;
        List<Map<String, Object>> mapList = new ArrayList<>();
        String realPath = request.getSession().getServletContext().getRealPath("upload" + File.separator);
        File file = new File(realPath + File.separator + "运费模板 （成都耐克）.xlsx");
        try {
            input = new FileInputStream(file);
            wb = new XSSFWorkbook(input);
            XSSFSheet xssfSheet = wb.getSheetAt(0);
            if (xssfSheet == null || xssfSheet.getPhysicalNumberOfRows() == 0) {
                logger.error("模板数据为空");
            }
            int totalRows = xssfSheet.getLastRowNum(); //总行数
            int totalCells;//总列数
            //读取row，从第三行开始
            for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
                Map<String, Object> map = new HashMap<>();
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    String provinceKey = ExcelUtil.getXValue(xssfRow.getCell(0)).trim();
                    String baseMoney = ExcelUtil.getXValue(xssfRow.getCell(1)).trim();
                    String moreMoney = ExcelUtil.getXValue(xssfRow.getCell(2)).trim();
                    //省份作为key，首重续重作为value，英文逗号分割
                    map.put(provinceKey, baseMoney + "," + moreMoney);
                    mapList.add(map);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mapList;
    }


    @RequestMapping(value = "/uploadReturnFile", method = RequestMethod.POST)
    @ResponseBody
    public PageData uploadReturnFile(@RequestParam("file") MultipartFile file, @RequestParam("strategyId") String strategyId,@RequestParam("id") String id, HttpServletRequest reqst) {
        PageData result = new PageData();
        try {
            if (file.isEmpty()) {
                result.put("status", 0);
                result.put("msg", "文件为空");
            } else {
                String fileName = file.getOriginalFilename();
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                if(suffix.equals("xls")){
                    result.put("status", 0);
                    result.put("msg", "请修改文件后缀为xlsx");
                }
                String basePath = reqst.getContextPath();
                basePath = reqst.getScheme() + "://" + reqst.getServerName() + ":" + reqst.getServerPort() + basePath + "/";
                String realPath = reqst.getSession().getServletContext().getRealPath("upload" + File.separator + "excelFile" + File.separator);
                File dir = new File(realPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(realPath, fileName));

                StrategyOrder strategyOrder = new StrategyOrder();
                strategyOrder.setId(id);
                strategyOrder.setFileName(fileName);
                strategyOrder.setFilePath(basePath + "upload/excelFile/" + fileName);
                strategyOrder.setStrategyId(strategyId);
                strategyOrder.setCreateDate(new Date());
                erpOrderService.insertStrategyOrder(strategyOrder);
            }
            result.put("status", 1);
        } catch (RuntimeException e) {
            result.put("status", 0);
            result.put("msg", e.getMessage());
        } catch (Exception e) {
            result.put("status", 0);
            result.put("msg", "上传失败");
        }
        return result;
    }
}
