package com.nj.admin.stockQueryApi.test;

import com.nj.admin.FixApplication;
import com.nj.admin.stockQueryApi.pojo.OpenApi;
import com.nj.admin.stockQueryApi.pojo.PojoConfig;
import com.nj.admin.stockQueryApi.utils.OpenApiUtil;
import com.nj.admin.stockQueryApi.utils.StockQueryApiUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FixApplication.class)
public class TestKucun {

    public OpenApi TestCommon(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PojoConfig.class);
        return (OpenApi) ctx.getBean(OpenApi.class);
    }
    /**
     * ���� ����ȡ
     * Appkey��28557242
     * AppSecret��27i8c60b1mgeeo6ggg6n81f384egknng
     * AccessToken��75ab0cb54aad43f0a1ebd552c314e022
     */
    @Test
    public void TestStockSynchronize(){
        StockQueryApiUtil.queryStockByCode("C77154");
//        OpenApi openApi = TestCommon();
//        //����ϵͳ������
//        openApi.setAppkey("28557242");//Ĭ��ֵ40420831
//        openApi.setAppsecret("27i8c60b1mgeeo6ggg6n81f384egknng");//Ĭ��ֵmalc12m3agg1285kk2ae20eag19797b9
//        openApi.setAccesstoken("75ab0cb54aad43f0a1ebd552c314e022");//Ĭ��ֵ1d9f5fd4962244c9b70c3950c3faf366
//        openApi.setFormat("json");//Ĭ��ֵxml
//        openApi.setMethod("wdgj.stock.list.get");
//        openApi.setVersions("1.1");
//
//        //����Ӧ�ò���/�������
//        openApi.requestparas.put("pageno", "1");
//        openApi.requestparas.put("pagesize", "100");
//        openApi.requestparas.put("searchtype", "1");
//        openApi.requestparas.put("searchcode", "C77154");
//
//        //��������
//        String res = OpenApiUtil.HttpPostString(openApi);
//        System.out.println("���͵Ĳ�����"+openApi.getPostparas());
//        System.out.println("���صĽ����"+res);
    }

}
