package com.nj.admin.stockQueryApi.test;


import com.nj.admin.stockQueryApi.OrderGoodsObj;
import com.nj.admin.stockQueryApi.StockSynchModel;
import com.nj.admin.stockQueryApi.WareHouseCreateModel;
import com.nj.admin.stockQueryApi.pojo.OpenApi;
import com.nj.admin.stockQueryApi.pojo.PojoConfig;
import com.nj.admin.stockQueryApi.utils.MessageUtil;
import com.nj.admin.stockQueryApi.utils.OpenApiUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class OpenApiTest {
	
	public OpenApi TestCommon(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PojoConfig.class);
		return (OpenApi) ctx.getBean(OpenApi.class);
	}
	
	/**
	 * 测试 查询商品 接口 文档地址：http://open.wdgj.com/OpenApiDoc/ApiInfo.html?OpenAPIID=5102
	 */
	public void TestGoodsList(){
	    OpenApi openApi = TestCommon();
		
		//设置系统级参数
		//openApi.setAppkey("40420831");//默认值40420831
		//openApi.setAppsecret("malc12m3agg1285kk2ae20eag19797b9");//默认值malc12m3agg1285kk2ae20eag19797b9
		//openApi.setAccesstoken("1d9f5fd4962244c9b70c3950c3faf366");//默认值1d9f5fd4962244c9b70c3950c3faf366
		openApi.setFormat("json");//默认值xml
		openApi.setMethod("wdgj.erp.goods.list");//默认值wdgj.erp.warehouse.detail
		openApi.setVersions("1.0");//默认1.1
		
		//设置应用参数/请求参数
		openApi.requestparas.put("page_no", "1");
		openApi.requestparas.put("page_size", "2");
		
		//发送请求
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("发送的参数："+openApi.getPostparas());
		System.out.println("返回的结果："+res);
	}
	
	/**
	 * 测试 查询物流 接口 文档地址：http://open.wdgj.com/OpenApiDoc/ApiInfo.html?openApiID=5106
	 */
	public void TestLogisticList(){
	    OpenApi openApi = TestCommon();
		
		//设置系统级参数
		openApi.setFormat("json");
		openApi.setMethod("wdgj.erp.logistic.list");
		openApi.setVersions("1.1");
		//设置应用参数/请求参数
		
		//发送请求
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("发送的参数："+openApi.getPostparas());
		System.out.println("返回的结果："+res);
	}
	
	/**
	 * 测试 仓库创建 接口 文档地址：http://open.wdgj.com/OpenApiDoc/ApiInfo.html?openApiID=5133
	 */
	public void TestWarehouseCreate(){
		WareHouseCreateModel obj = new WareHouseCreateModel();
		obj.setWarehouse_name("zcl测试");
		obj.setProvince("未知省");
		obj.setCity("未知市");
		obj.setTown("未知区");
		obj.setAdr("未知地址");
		obj.setTel("12145845124");
		obj.setLinkman("我我我");
		obj.setZip("145124");
		obj.setBnegativestock("0");
		obj.setWarehousetype("0");
		obj.setCountry("中国");
		obj.setBblockup("0");
		obj.setBautoaddgoods("1");
		
		//String content = MessageUtil.ObjToXml(obj,"request");
		String content = MessageUtil.ObjToJson(obj);
		
		System.out.println(content);
		OpenApi openApi = TestCommon();
		
		//设置系统级参数
		openApi.setFormat("json");
		openApi.setMethod("wdgj.com.warehouse.create");
		openApi.setVersions("1.0");
		//设置应用参数/请求参数
		openApi.requestparas.put("content", content);
		
		//发送请求
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("发送的参数："+openApi.getPostparas());
		System.out.println("返回的结果："+res);
	}
	
	/**
	 * 测试 wdgj.stock.synchronize 库存异动 接口 文档地址：http://open.wdgj.com/OpenApiDoc/ApiInfo.html?OpenAPIID=70019
	 */
	public void TestStockSynchronize(){
		//构建对象
		StockSynchModel stockSynchModel = new StockSynchModel();
		stockSynchModel.warehouseno = "2018052510";//管家测试仓库1
		stockSynchModel.tradeno = "测试库存修改";
		stockSynchModel.operater = "测试人员";
		stockSynchModel.type = "1";//全量更新库存
		stockSynchModel.keytype = "3";//条码(条码+附加码)
		stockSynchModel.goodslist = new ArrayList<>();
		
		OrderGoodsObj orderGoodsObj = new OrderGoodsObj();
		orderGoodsObj.barcode = "yz0001";//商品条码
		orderGoodsObj.goodscount = "11";//商品数量
		
		stockSynchModel.goodslist.add(orderGoodsObj);
		
		//序列化得到content参数
		String content = MessageUtil.ObjToJson(stockSynchModel);
		
		
		
	    OpenApi openApi = TestCommon();
		//设置系统级参数
		openApi.setAppkey("40420831");//默认值40420831
		openApi.setAppsecret("malc12m3agg1285kk2ae20eag19797b9");//默认值malc12m3agg1285kk2ae20eag19797b9
		openApi.setAccesstoken("1d9f5fd4962244c9b70c3950c3faf366");//默认值1d9f5fd4962244c9b70c3950c3faf366
		openApi.setFormat("json");//默认值xml
		openApi.setMethod("wdgj.stock.synchronize");
		openApi.setVersions("1.1");
		
		//设置应用参数/请求参数
		openApi.requestparas.put("content", content);
		
		//发送请求
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("发送的参数："+openApi.getPostparas());
		System.out.println("返回的结果："+res);
	}
}
