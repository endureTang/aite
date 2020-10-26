package com.nj.admin.controller;

import com.github.pagehelper.util.StringUtil;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.utils.excel.ExcelUtil;
import com.nj.core.utils.excel.ExportUtil;
import com.nj.model.datamodel.ErrorErpModel;
import com.nj.model.generate.ErpOrder;
import com.nj.model.generate.ErrorErpOrderModel;
import com.nj.model.generate.StrategyOrder;
import com.nj.service.base.system.ErpOrderService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
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
import javax.servlet.http.HttpServletResponse;
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
    public PageData add(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        PageData result = new PageData();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator + "excelFile" + File.separator);
            File dir = new File(realPath);
            if(dir.exists()){
                deleteFolder(dir);
            }
            PageData pd = super.getPageData();
            if (file.isEmpty()) {
                result.put("msg", "上传失败");
            } else {
                InputStream input = null;
                Workbook wb = null;
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
                    wb = WorkbookFactory.create(input);
                    //读取sheet(页)
                    Sheet xssfSheet = wb.getSheetAt(0);
                    int totalRows; //sheet中总行数
                    totalRows = xssfSheet.getLastRowNum();
                    if(totalRows == 0){
                        result.put("status", 0);
                        result.put("msg", "请勿上传空文件");
                        return result;
                    }
                    //标题行
                    Row titleRow = xssfSheet.getRow(0);
                    InputStream inputTemp = null;
                    Workbook wbTemp = null;
                    try {
                        int totalCell = titleRow.getLastCellNum();
                        String realPath1 = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator);
                        File erpFile = new File(realPath1 + File.separator + "ERP模板.xlsx");

                        inputTemp = new FileInputStream(erpFile);
                        wbTemp = new XSSFWorkbook(inputTemp);
                        Row modelTitleRow = wbTemp.getSheetAt(0).getRow(0);
                        int totalCell2 = modelTitleRow.getLastCellNum();
                        if(totalCell2 != totalCell2){
                            result.put("status", 0);
                            result.put("msg", "请上传正确格式文件");
                            return result;
                        }
                        for (int i = 0; i < totalCell; i++) {
                            String one = ExcelUtil.getXValue(titleRow.getCell(i));
                            String two = ExcelUtil.getXValue(modelTitleRow.getCell(i));
                            if(!one.equals(two)){
                                result.put("status", 0);
                                int errorIndex = i +1;
                                result.put("msg", "上传文件与模板格式有出入：第"+errorIndex+"行，标题："+one);
                                return result;
                            }
                        }
                    } catch (IOException e) {
                        result.put("status", 0);
                        result.put("msg", "文件读取出错");
                        return result;
                    } finally {
                        inputTemp.close();
                    }
                    List<ErrorErpOrderModel> errorErpOrderModels = new ArrayList<>();
                    //读取Row,从第二行开始
                    for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
                        Row xssfRow = xssfSheet.getRow(rowNum);
                        if (xssfRow != null) {
                            //读取列，从第一列开始
                            String sourceOrderNos = ExcelUtil.getXValue(xssfRow.getCell(22)).trim();//获取原始订单号
                            if (sourceOrderNos != null) {
                                List<String> sourceOrderNo = Arrays.asList(sourceOrderNos.split(","));
                                for (String sourceNo : sourceOrderNo) {
                                    ErpOrder erpOrder = new ErpOrder();
                                    String orderNo = ExcelUtil.getXValue(xssfRow.getCell(0));
                                    if(StringUtil.isEmpty(orderNo)){
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("订单编号为空");
                                        errorErpOrderModels.add(em);
                                        em.setId(UuidUtil.get32UUID());
                                        logger.error("订单编号为空");
                                        continue;
                                    }

                                    erpOrder.setOrderNo(orderNo.trim());
                                    erpOrder.setSourceOrderNo(sourceNo);
                                    String name = ExcelUtil.getXValue(xssfRow.getCell(1)); // 获取姓名
                                    erpOrder.setName(name);
                                    String transWay = ExcelUtil.getXValue(xssfRow.getCell(20));
                                    if(StringUtil.isEmpty(transWay)){
                                        logger.error("物流方式为空");
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("物流方式为空");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        continue;
                                    }
                                    erpOrder.setTransWay(ExcelUtil.getXValue(xssfRow.getCell(20)));
                                    String transNo = ExcelUtil.getXValue(xssfRow.getCell(19));
                                    if(StringUtil.isEmpty(transNo)){
                                        logger.error("物流单号为空");
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("物流单号为空");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        continue;
                                    }
                                    erpOrder.setTransNo(ExcelUtil.getXValue(xssfRow.getCell(19)));
                                    String address = ExcelUtil.getXValue(xssfRow.getCell(18));
                                    if(StringUtil.isEmpty(address)){
                                        logger.error("地址为空");
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("地址为空");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        continue;
                                    }

                                    String amount = ExcelUtil.getXValue(xssfRow.getCell(10));
                                    if(StringUtil.isEmpty(amount)){
                                        logger.error("数量为空");
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("数量为空");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        continue;
                                    }
                                    erpOrder.setAmount(amount);

                                    String specification = ExcelUtil.getXValue(xssfRow.getCell(6));
                                    if(StringUtil.isEmpty(specification)){
                                        logger.error("规格、尺码为空");
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("规格、尺码为空");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        continue;
                                    }
                                    String channelSpec = transSpecification(specification);
                                    erpOrder.setSpecification(channelSpec);

                                    String stockNo = ExcelUtil.getXValue(xssfRow.getCell(3));
                                    if(StringUtil.isEmpty(stockNo)){
                                        logger.error("货号为空");
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("货号为空");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        continue;
                                    }
                                    erpOrder.setStockNo(stockNo);

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
                                            if(StringUtil.isEmpty(province)){
                                                province = address.substring(0, i);
                                            }
                                            String transMoney = calcTransMoney(province, amount, transModelList);
                                            erpOrder.setTransMoney(transMoney);
                                        }
                                    } catch (Exception e) {
                                        ErrorErpOrderModel em = new ErrorErpOrderModel();
                                        em.setRownumber(rowNum+1);
                                        em.setMessage("计算运费出错");
                                        em.setId(UuidUtil.get32UUID());
                                        errorErpOrderModels.add(em);
                                        logger.error("订单号,{}系统错误，错误信息{}",erpOrder.getOrderNo(),e);
                                        continue;
                                    }

                                    erpOrder.setSourceType(ExcelUtil.getXValue(xssfRow.getCell(28)));
                                    erpOrder.setRemark(ExcelUtil.getXValue(xssfRow.getCell(30)));
                                    erpOrder.setId(UuidUtil.get32UUID());
                                    erpOrderList.add(erpOrder);
                                }
                            }else{
                                ErrorErpOrderModel em = new ErrorErpOrderModel();
                                em.setRownumber(rowNum+1);
                                em.setMessage("原始单号为空");
                                em.setId(UuidUtil.get32UUID());
                                errorErpOrderModels.add(em);
                            }
                        }
                    }
                    if(errorErpOrderModels!= null && errorErpOrderModels.size() > 0){
                        result.put("errData", 1);
                    }else{
                        result.put("errData", 0);
                    }
                    erpOrderService.insertBath(erpOrderList,errorErpOrderModels);
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

    private String transSpecification(String specification) {
        if("XXS".equals(specification)){
            return "2XS";
        }else if("XXL".equals(specification)){
            return "2XL";
        }else if("XXXL".equals(specification)){
            return "3XL";
        }else{
            return specification;
        }
    }

    private String calcTransMoney(String province, String amount, List<Map<String, Object>> list) {
        String money = "省份匹配失败";
        for (Map<String, Object> map : list) {
            String value = (String) map.get(province);
            if (!StringUtil.isEmpty(value)) {
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
        Workbook wb = null;
        List<Map<String, Object>> mapList = new ArrayList<>();
        String realPath = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator);
        File file = new File(realPath + File.separator + "运费模板 （成都耐克）.xlsx");
        try {
            input = new FileInputStream(file);
            wb = WorkbookFactory.create(input);
            Sheet xssfSheet = wb.getSheetAt(0);
            if (xssfSheet == null || xssfSheet.getPhysicalNumberOfRows() == 0) {
                logger.error("模板数据为空");
            }
            int totalRows = xssfSheet.getLastRowNum(); //总行数
            int totalCells;//总列数
            //读取row，从第三行开始
            for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
                Map<String, Object> map = new HashMap<>();
                Row xssfRow = xssfSheet.getRow(rowNum);
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
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
//                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
//                if(suffix.equals("xls")){
//                    result.put("status", 0);
//                    result.put("msg", "暂时只支持office2007以后的版本，请打开文件另存为xlsx格式");
//                    return result;
//                }
                String basePath = reqst.getContextPath();
                basePath = reqst.getScheme() + "://" + reqst.getServerName() + ":" + reqst.getServerPort() + basePath ;
                String realPath = reqst.getSession().getServletContext().getRealPath("static"+File.separator +"upload" + File.separator + "excelFile" + File.separator);
                File dir = new File(realPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                FileUtils.copyInputStreamToFile(file.getInputStream(),
                        new File(realPath, fileName));

                StrategyOrder strategyOrder = new StrategyOrder();
                strategyOrder.setId(id);
                strategyOrder.setFileName(fileName);
                strategyOrder.setFilePath(basePath + "/static/upload/excelFile/" + fileName);
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

    @RequestMapping(value="/errorErpData", method=RequestMethod.GET)
    @ResponseBody
    public void errorErpData(HttpServletRequest reqst, HttpServletResponse response){
        PageData result = new PageData();
        try {
            List<ErrorErpModel> channelStocks = erpOrderService.listErrorErp();
            //设置文件名称和文件存放位置
            StringBuilder tempfilename = new StringBuilder();
            tempfilename.append("ERP订单导入失败数据.xlsx");
            ExportUtil.baseExport(channelStocks, ErrorErpModel.class, tempfilename.toString(), "ERP订单导入失败数据", "ERP订单导入失败数据", response);
        } catch (Exception e) {
            logger.error("add ChannelStock error", e);
        }
    }
}
