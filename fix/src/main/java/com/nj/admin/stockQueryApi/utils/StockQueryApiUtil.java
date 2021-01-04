package com.nj.admin.stockQueryApi.utils;

import com.nj.admin.stockQueryApi.pojo.OpenApi;
import com.nj.admin.stockQueryApi.pojo.PojoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StockQueryApiUtil {
    public static OpenApi testCommon(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PojoConfig.class);
        return (OpenApi) ctx.getBean(OpenApi.class);
    }
    /**
     * 测试 库存获取
     * Appkey：28557242
     * AppSecret：27i8c60b1mgeeo6ggg6n81f384egknng
     * AccessToken：75ab0cb54aad43f0a1ebd552c314e022
     * api地址：http://open.wdgj.com/OpenApiDoc/GetChildParams?name=&dictid=88&rectid=3998
     */
    public static String queryStockByCode(String stockNo){
        //设置系统级参数
        OpenApi openApi = testCommon();
        //设置系统级参数
        openApi.setAppkey("28557242");//默认值40420831
        openApi.setAppsecret("27i8c60b1mgeeo6ggg6n81f384egknng");//默认值malc12m3agg1285kk2ae20eag19797b9
        openApi.setAccesstoken("75ab0cb54aad43f0a1ebd552c314e022");//默认值1d9f5fd4962244c9b70c3950c3faf366
        openApi.setFormat("json");//默认值xml
        openApi.setMethod("wdgj.stock.list.get");
        openApi.setVersions("1.1");

        //设置应用参数/请求参数
        openApi.requestparas.put("pageno", "1");
        openApi.requestparas.put("pagesize", "100");
        openApi.requestparas.put("searchtype", "1");
        openApi.requestparas.put("searchcode", stockNo);

        //发送请求
        String res = OpenApiUtil.HttpPostString(openApi);
        System.out.println("发送的参数："+openApi.getPostparas());
        System.out.println("返回的结果："+res);
        return res;
    }

}
