package com.nj.admin.controller;

import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StockController {
    @RequestMapping(value = {"/goIndex"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public ModelAndView goIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("price/list");
        return mv;
    }
    @RequestMapping(value = {"/getStockData"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public DataTableResult getStockData(HttpServletRequest request) {
        DataTableResult result = new DataTableResult(request);
        try {
            HttpSession session = request.getSession();
            List<StockModel> list = (List) session.getAttribute("stockList");
            if(list != null && list.size()>0){
                Collections.sort(list);
            }
            if ((list != null) && (list.size() > 0)) {
                result.insertDataList(list);
                result.put("draw", "draw");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping({"saveStock"})
    public String saveStock(HttpServletRequest request, String type, String stockNo, String brandName, String unit, String amount, String price, String discountPrice, String basePrice, String remark,
                            String sizeType,String sizeStart,String sizeEnd) {
        HttpSession session = request.getSession();
        List<StockModel> mapList = (List) session.getAttribute("stockList");
        if (mapList == null) {
            mapList = new ArrayList();
        }
        List<String> list = null;
        try {
            list = generateSpec(type,sizeType,sizeStart,sizeEnd);
        } catch (Exception e) {
            return "100";
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("")){
                continue;
            }
            StockModel stockModel = new StockModel();
            stockModel.setId(UuidUtil.get32UUID());
            stockModel.setStockNo(stockNo);
            stockModel.setBrandName(brandName == null ? "" : brandName);
            stockModel.setUnit(unit == null ? "" : unit);
            stockModel.setAmount(amount);
            stockModel.setPrice(price);
            stockModel.setDiscountPrice(discountPrice == null ? "" : discountPrice);
            stockModel.setBasePrice(basePrice == null ? "" : basePrice);
            stockModel.setRemark(remark == null ? "" : remark);
            stockModel.setSpec((String) list.get(i));
            mapList.add(stockModel);
        }
        session.setAttribute("stockList", mapList);
        return "200";
    }

    //男鞋
    private static final String MAN_SHOES = ",39,40,40.5,41,42,42.5,43,44,44.5,45,46,46.5,47,48,";
    //女鞋
    private static final String WOMAN_SHOES = ",35,35.5,36,36.5,37,38,38.5,39,40,";
    //中性鞋
    private static final String MID_SHOES = ",36,36.5,37,38,38.5,39,40,40.5,41,42,42.5,43,44,44.5,45,";
    //童鞋
    private static final String CHILD_SHOES = ",2K,3K,4K,5K,5.5K,6K,6.5K,7K,7.5K,8K,8.5K,9K,9.5K,10K,10.5K,11K,11.5K,12K,12.5K,13K,13.5K,1UK,1.5UK,2UK,2.5UK,3UK,3.5UK,4UK,4.5UK,5UK,5.5UK,6UK,6.5UK,";
    //男装
    private static final String MAN_CLOTHES = ",XS,S,M,L,XL,XXL,XXXL,";
    //女装
    private static final String WOMAN_CLOTHES = ",XXS,XS,S,M,L,XL,XXL,";
    //三叶草男装
    private static final String SANYE_MAN_CLOTHES = ",42,46,50,54,58,62,64,";
    //三叶草女装
    private static final String SANYE_WOMAN_CLOTHES = ",30,32,34,36,38,40,42,";
    //服装日本码
    private static final String JAPAN_CLOTHES = ",J/XS,J/S,J/M,J/L,J/O,J/XO,";
    //童装尺码
    private static final String CHILD_CLOTHES = ",68,74,80,86,90,92,98,104,110,116,122,128,134,140,152,164,176,";
    //欧洲尺码
    private static final String EUROPE_CLOTHES = ",XST,ST,MT,LT,XLT,XXLT,XXXLT,";

    private String sizeSub(String sizeStart,String sizeEnd,String string) throws Exception {
        try {
            String sizeStartTemp = ","+sizeStart+",";
            String sizeEndTemp = ","+sizeEnd+",";
            int i = string.indexOf(sizeStartTemp);
            int j = string.indexOf(sizeEndTemp);
            String s = string.substring(i, j+sizeEndTemp.length());
            return s;
        } catch (Exception e) {
            throw new Exception("没有找到自定义的尺码");
        }
    }
    private List<String> generateSpec(String type,String sizeType,String sizeStart,String sizeEnd) throws Exception {
        List<String> specList = new ArrayList();
        if(sizeType.equals("1")){ //如果是系统尺码、规格
            if (type.equals("1")) {
                specList = Arrays.asList(MAN_SHOES.split(","));
            } else if (type.equals("2")) {
                specList = Arrays.asList(WOMAN_SHOES.split(","));
            } else if (type.equals("3")) {
                specList = Arrays.asList(MID_SHOES.split(","));
            } else if (type.equals("4")) {
                specList = Arrays.asList(CHILD_SHOES.split(","));
            } else if (type.equals("5")) {
                specList = Arrays.asList(MAN_CLOTHES.split(","));
            } else if (type.equals("6")) {
                specList = Arrays.asList(WOMAN_CLOTHES.split(","));
            }else if (type.equals("7")) {
                specList = Arrays.asList(SANYE_MAN_CLOTHES.split(","));
            }else if (type.equals("8")) {
                specList = Arrays.asList(SANYE_WOMAN_CLOTHES.split(","));
            }else if (type.equals("9")) {
                specList = Arrays.asList(JAPAN_CLOTHES.split(","));
            }else if (type.equals("10")) {
                specList = Arrays.asList(CHILD_CLOTHES.split(","));
            }else if (type.equals("11")) {
                specList = Arrays.asList(EUROPE_CLOTHES.split(","));
            }
        }else{//如果是用户自定义输入的尺码区间，截取系统尺码表
            if (type.equals("1")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, MAN_SHOES);
                specList = Arrays.asList(tempSize.split(","));
            } else if (type.equals("2")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, WOMAN_SHOES);
                specList = Arrays.asList(tempSize.split(","));
            } else if (type.equals("3")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, MID_SHOES);
                specList = Arrays.asList(tempSize.split(","));
            } else if (type.equals("4")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, CHILD_SHOES);
                specList = Arrays.asList(tempSize.split(","));
            } else if (type.equals("5")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, MAN_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            } else if (type.equals("6")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, WOMAN_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            }else if (type.equals("7")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, SANYE_MAN_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            }else if (type.equals("8")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, SANYE_WOMAN_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            }else if (type.equals("9")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, JAPAN_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            }else if (type.equals("10")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, CHILD_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            }else if (type.equals("11")) {
                String tempSize = sizeSub(sizeStart, sizeEnd, EUROPE_CLOTHES);
                specList = Arrays.asList(tempSize.split(","));
            }
        }
        return specList;
    }

    @RequestMapping({"clearStockData"})
    public String clearData(HttpServletRequest request) {
        request.getSession().removeAttribute("stockList");
        return "200";
    }

    @RequestMapping(value = {"/exportStockData"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    public String exportErrorData(HttpServletRequest reqst, HttpServletResponse response) {
        try {
            HttpSession session = reqst.getSession();
            List<StockModel> retList = (List) session.getAttribute("stockList");
            Collections.sort(retList);
            StringBuilder tempfilename = new StringBuilder();
            tempfilename.append("入库表格.xlsx");
            ExportUtil.baseExport(retList, StockModel.class, tempfilename.toString(), "入库表格", "入库表格", response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导出成功";
    }

    @RequestMapping({"/deleteStock"})
    @ResponseBody
    public PageData deletePrice(HttpServletRequest request, @RequestParam String id) {
        PageData result = new PageData();
        try {
            HttpSession session = request.getSession();
            List<StockModel> mapList = (List) session.getAttribute("stockList");
            StockModel pd = null;
            for (StockModel sto : mapList) {
                if (sto.getId().equals(id)) {
                    pd = sto;
                }
            }
            if (pd != null) {
                mapList.remove(pd);
                result.put("status", Integer.valueOf(1));
            } else {
                result.put("status", Integer.valueOf(0));
            }
        } catch (Exception e) {
            result.put("status", Integer.valueOf(0));
            result.put("msg", "删除失败");
        }
        return result;
    }

    @RequestMapping({"/batchDelete"})
    @ResponseBody
    public PageData batchDelete(HttpServletRequest request, @RequestParam String ids) {
        PageData result = new PageData();
        try {
            HttpSession session = request.getSession();
            List<StockModel> mapList = (List) session.getAttribute("stockList");
            List<String> idList = Arrays.asList(ids.split(","));
            for (String id : idList) {
                StockModel pd = null;
                for (StockModel sto : mapList) {
                    if (sto.getId().equals(id)) {
                        pd = sto;
                    }
                }
                if (pd != null) {
                    mapList.remove(pd);
                }
            }
            result.put("status", Integer.valueOf(1));
        } catch (Exception e) {
            result.put("status", Integer.valueOf(0));
            result.put("msg", "删除失败");
        }
        return result;
    }
    @RequestMapping(value = {"/editStock"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public ModelAndView toEdit(HttpServletRequest request, @RequestParam String id) {
        StockModel priceModelTemp = null;
        try {
            HttpSession session = request.getSession();
            List<StockModel> mapList = (List) session.getAttribute("stockList");
            for (StockModel priceModel : mapList) {
                if (priceModel.getId().equals(id)) {
                    priceModelTemp = priceModel;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("stockModel", priceModelTemp);
        mv.setViewName("stock/edit");
        return mv;
    }

    @RequestMapping(value = {"/addStock"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public ModelAndView toEdit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("stock/add");
        return mv;
    }

    @RequestMapping(value = {"/addStock"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public PageData addPrice(HttpServletRequest request, String type, String stockNo, String brandName, String unit, String amount, String price, String spec, String discountPrice, String basePrice, String remark) {
        PageData result = new PageData();
        try {
            HttpSession session = request.getSession();
            List<StockModel> mapList = (List) session.getAttribute("stockList");
            if (mapList == null) {
                mapList = new ArrayList();
            }
            StockModel stockModel = new StockModel();
            stockModel.setId(UuidUtil.get32UUID());
            stockModel.setStockNo(stockNo);
            stockModel.setBrandName(brandName == null ? "" : brandName);
            stockModel.setUnit(unit == null ? "" : unit);
            stockModel.setAmount(amount);
            stockModel.setPrice(price);
            stockModel.setDiscountPrice(discountPrice == null ? "" : discountPrice);
            stockModel.setBasePrice(basePrice == null ? "" : basePrice);
            stockModel.setRemark(remark == null ? "" : remark);
            stockModel.setSpec(spec);
            mapList.add(stockModel);
            session.setAttribute("stockList", mapList);
            result.put("status", Integer.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", Integer.valueOf(0));
            result.put("msg", "更新失败");
        }
        return result;
    }

    @RequestMapping(value = {"/editStock"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public PageData edit(HttpServletRequest request, String id, String type, String stockNo, String brandName, String unit, String amount, String price, String spec, String discountPrice, String basePrice, String remark) {
        PageData result = new PageData();
        try {
            HttpSession session = request.getSession();
            List<StockModel> mapList = (List) session.getAttribute("stockList");
            for (StockModel stockModel : mapList) {
                if (stockModel.getId().equals(id)) {
                    stockModel.setStockNo(stockNo);
                    stockModel.setBrandName(brandName == null ? "" : brandName);
                    stockModel.setUnit(unit == null ? "" : unit);
                    stockModel.setAmount(amount);
                    stockModel.setPrice(price);
                    stockModel.setDiscountPrice(discountPrice == null ? "" : discountPrice);
                    stockModel.setBasePrice(basePrice == null ? "" : basePrice);
                    stockModel.setRemark(remark == null ? "" : remark);
                    stockModel.setSpec(spec);
                }
            }
            result.put("status", Integer.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", Integer.valueOf(0));
            result.put("msg", "更新失败");
        }
        return result;
    }

    @RequestMapping(value = {"/editAmount"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public PageData editAmount(HttpServletRequest request, String id, String amount) {
        PageData result = new PageData();
        try {
            HttpSession session = request.getSession();
            List<StockModel> mapList = (List) session.getAttribute("stockList");
            for (StockModel stockModel : mapList) {
                if (stockModel.getId().equals(id)) {
                    stockModel.setAmount(amount);
                }
            }
            result.put("status", Integer.valueOf(1));
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", Integer.valueOf(0));
            result.put("msg", "更新失败");
        }
        return result;
    }
}
