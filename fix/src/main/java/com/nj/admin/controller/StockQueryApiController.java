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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 库存第三方查询接口
 */
@RestController
@RequestMapping("stockQueryApi")
public class StockQueryApiController {
    @Resource
    private OpenApi openApi;
    @RequestMapping(value = {"/getStockByCode"}, method = {RequestMethod.POST})
    public PageData getStockData(HttpServletRequest request, @RequestParam("code") String code) {
        PageData result = new PageData();
        result.put("status", 0);
        try {
            String resultList = StockQueryApiUtil.queryStockByCode(openApi, code);
            if (StringUtils.isNotEmpty(resultList)) {
                result.put("data", resultList);
                result.put("status", 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
