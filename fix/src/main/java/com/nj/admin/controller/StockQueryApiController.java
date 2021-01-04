package com.nj.admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nj.admin.stockQueryApi.pojo.OpenApi;
import com.nj.admin.stockQueryApi.utils.StockQueryApiUtil;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 库存第三方查询接口
 */
@RestController
@RequestMapping("stockQueryApi")
public class StockQueryApiController {
    @Resource
    private OpenApi openApi;

    @RequestMapping(value={"/goQueryStock"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public ModelAndView goStockIndex()    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("stock/query");
        return mv;
    }
    @RequestMapping(value = {"/getStockByCode"}, method = {RequestMethod.POST})
    public PageData getStockData(HttpServletRequest request, @RequestParam("code") String code) {
        PageData result = new PageData();
        result.put("status", 0);
        try {
            String resultList = StockQueryApiUtil.queryStockByCode(code);
            if (StringUtils.isNotEmpty(resultList)) {
                HttpSession session = request.getSession();
                Map<String,Object> retObj = JSONObject.parseObject(resultList);
                if(retObj.get("returncode").toString().equals("0")){
                    List<Map<String,Object>> datalist = (List<Map<String,Object>>) retObj.get("datalist");
                    if(datalist == null || datalist.size() == 0){
                        result.put("msg", "没有获取到相关库存信息");
                        session.setAttribute("queryStockList", null);
                        return result;
                    }
                    List<QueryStockModel> models = new ArrayList<>();
                    for (Map<String, Object> data : datalist) {
                        if((data.get("stock")+"").equals("0.0000")){
                            continue;
                        }
                        QueryStockModel stockModel = new QueryStockModel();
                        stockModel.setWarehouseid(data.get("data")+"");
                        stockModel.setWarehousename(data.get("warehousename")+"");
                        stockModel.setWarehouseid(data.get("data")+"");
                        stockModel.setGoodsid(data.get("goodsid")+"");
                        stockModel.setSpecid(data.get("specid")+"");
                        stockModel.setStock(doubleStrToIntStr(data.get("stock")+""));
                        stockModel.setSndcount(doubleStrToIntStr(data.get("sndcount")+""));
                        stockModel.setOrdercount(doubleStrToIntStr(data.get("ordercount")+""));
                        stockModel.setDbincount(doubleStrToIntStr(data.get("dbincount")+""));
                        stockModel.setDboutcount(doubleStrToIntStr(data.get("dboutcount")+""));
                        stockModel.setPurchasecount(doubleStrToIntStr(data.get("purchasecount")+""));
                        stockModel.setPurchaseplan(data.get("purchaseplan")+"");
                        stockModel.setGoodsno(data.get("goodsno")+"");
                        stockModel.setGoodsname(data.get("goodsname")+"");
                        stockModel.setBarcode(data.get("barcode")+"");
                        stockModel.setSpecname(data.get("specname")+"");
                        stockModel.setPricecost(data.get("pricecost")+"");
                        stockModel.setWarehouseno(data.get("warehouseno")+"");
                        stockModel.setStock3(doubleStrToIntStr(data.get("stock3")+""));
                        models.add(stockModel);
                    }
                    session.setAttribute("queryStockList", models);
                    result.put("status", 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String doubleStrToIntStr(String old){
        Double dbValue = Double.parseDouble(old);
        return dbValue.intValue() + "";
    }

    /**
     * 获取通过接口查询的货品信息
     * @param request
     * @return
     */
    @RequestMapping(value = {"/getStockInfoFromApi"}, method = {RequestMethod.POST})
    public DataTableResult getStockData(HttpServletRequest request) {
        DataTableResult result = new DataTableResult(request);
        try {
            HttpSession session = request.getSession();
            List<QueryStockModel> list = (List<QueryStockModel>) session.getAttribute("queryStockList");
            if ((list != null) && (list.size() > 0)) {
                List<QueryStockModel> newList = list.stream().sorted(Comparator.comparing(QueryStockModel::getSpecname)).collect(Collectors.toList());
                result.insertDataList(newList);
                result.put("draw", "draw");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "3.00";
        System.out.println(new Integer(s
        ));
    }

}
