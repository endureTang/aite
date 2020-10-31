package com.nj.admin.controller;

import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;

import java.util.ArrayList;
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
    public String saveStock(HttpServletRequest request, String type, String stockNo, String brandName, String unit, String amount, String price, String discountPrice, String basePrice, String remark) {
        HttpSession session = request.getSession();
        List<StockModel> mapList = (List) session.getAttribute("stockList");
        if (mapList == null) {
            mapList = new ArrayList();
        }
        List<String> list = generateSpec(type);
        for (int i = 0; i < list.size(); i++) {
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

    private List<String> generateSpec(String type) {
        List<String> specList = new ArrayList();
        if (type.equals("1")) {
            specList.add("39");
            specList.add("40");
            specList.add("40.5");
            specList.add("41");
            specList.add("42");
            specList.add("42.5");
            specList.add("43");
            specList.add("44");
            specList.add("44.5");
            specList.add("45");
        } else if (type.equals("2")) {
            specList.add("36");
            specList.add("36.5");
            specList.add("37");
            specList.add("38");
            specList.add("38.5");
            specList.add("39");
        } else if (type.equals("3")) {
            specList.add("36");
            specList.add("36.5");
            specList.add("37");
            specList.add("38");
            specList.add("38.5");
            specList.add("39");
            specList.add("40");
            specList.add("40.5");
            specList.add("41");
            specList.add("42");
            specList.add("42.5");
            specList.add("43");
            specList.add("44");
            specList.add("44.5");
            specList.add("45");
        } else if (type.equals("4")) {
            specList.add("XS");
            specList.add("S");
            specList.add("M");
            specList.add("L");
            specList.add("XL");
            specList.add("XXL");
        } else if (type.equals("5")) {
            specList.add("XS");
            specList.add("S");
            specList.add("M");
            specList.add("L");
            specList.add("XL");
        } else if (type.equals("6")) {
            specList.add("30");
            specList.add("32");
            specList.add("34");
            specList.add("36");
            specList.add("38");
            specList.add("40");
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
