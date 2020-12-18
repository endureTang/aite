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
	 * ���� ��ѯ��Ʒ �ӿ� �ĵ���ַ��http://open.wdgj.com/OpenApiDoc/ApiInfo.html?OpenAPIID=5102
	 */
	public void TestGoodsList(){
	    OpenApi openApi = TestCommon();
		
		//����ϵͳ������
		//openApi.setAppkey("40420831");//Ĭ��ֵ40420831
		//openApi.setAppsecret("malc12m3agg1285kk2ae20eag19797b9");//Ĭ��ֵmalc12m3agg1285kk2ae20eag19797b9
		//openApi.setAccesstoken("1d9f5fd4962244c9b70c3950c3faf366");//Ĭ��ֵ1d9f5fd4962244c9b70c3950c3faf366
		openApi.setFormat("json");//Ĭ��ֵxml
		openApi.setMethod("wdgj.erp.goods.list");//Ĭ��ֵwdgj.erp.warehouse.detail
		openApi.setVersions("1.0");//Ĭ��1.1
		
		//����Ӧ�ò���/�������
		openApi.requestparas.put("page_no", "1");
		openApi.requestparas.put("page_size", "2");
		
		//��������
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("���͵Ĳ�����"+openApi.getPostparas());
		System.out.println("���صĽ����"+res);
	}
	
	/**
	 * ���� ��ѯ���� �ӿ� �ĵ���ַ��http://open.wdgj.com/OpenApiDoc/ApiInfo.html?openApiID=5106
	 */
	public void TestLogisticList(){
	    OpenApi openApi = TestCommon();
		
		//����ϵͳ������
		openApi.setFormat("json");
		openApi.setMethod("wdgj.erp.logistic.list");
		openApi.setVersions("1.1");
		//����Ӧ�ò���/�������
		
		//��������
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("���͵Ĳ�����"+openApi.getPostparas());
		System.out.println("���صĽ����"+res);
	}
	
	/**
	 * ���� �ֿⴴ�� �ӿ� �ĵ���ַ��http://open.wdgj.com/OpenApiDoc/ApiInfo.html?openApiID=5133
	 */
	public void TestWarehouseCreate(){
		WareHouseCreateModel obj = new WareHouseCreateModel();
		obj.setWarehouse_name("zcl����");
		obj.setProvince("δ֪ʡ");
		obj.setCity("δ֪��");
		obj.setTown("δ֪��");
		obj.setAdr("δ֪��ַ");
		obj.setTel("12145845124");
		obj.setLinkman("������");
		obj.setZip("145124");
		obj.setBnegativestock("0");
		obj.setWarehousetype("0");
		obj.setCountry("�й�");
		obj.setBblockup("0");
		obj.setBautoaddgoods("1");
		
		//String content = MessageUtil.ObjToXml(obj,"request");
		String content = MessageUtil.ObjToJson(obj);
		
		System.out.println(content);
		OpenApi openApi = TestCommon();
		
		//����ϵͳ������
		openApi.setFormat("json");
		openApi.setMethod("wdgj.com.warehouse.create");
		openApi.setVersions("1.0");
		//����Ӧ�ò���/�������
		openApi.requestparas.put("content", content);
		
		//��������
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("���͵Ĳ�����"+openApi.getPostparas());
		System.out.println("���صĽ����"+res);
	}
	
	/**
	 * ���� wdgj.stock.synchronize ����춯 �ӿ� �ĵ���ַ��http://open.wdgj.com/OpenApiDoc/ApiInfo.html?OpenAPIID=70019
	 */
	public void TestStockSynchronize(){
		//��������
		StockSynchModel stockSynchModel = new StockSynchModel();
		stockSynchModel.warehouseno = "2018052510";//�ܼҲ��Բֿ�1
		stockSynchModel.tradeno = "���Կ���޸�";
		stockSynchModel.operater = "������Ա";
		stockSynchModel.type = "1";//ȫ�����¿��
		stockSynchModel.keytype = "3";//����(����+������)
		stockSynchModel.goodslist = new ArrayList<>();
		
		OrderGoodsObj orderGoodsObj = new OrderGoodsObj();
		orderGoodsObj.barcode = "yz0001";//��Ʒ����
		orderGoodsObj.goodscount = "11";//��Ʒ����
		
		stockSynchModel.goodslist.add(orderGoodsObj);
		
		//���л��õ�content����
		String content = MessageUtil.ObjToJson(stockSynchModel);
		
		
		
	    OpenApi openApi = TestCommon();
		//����ϵͳ������
		openApi.setAppkey("40420831");//Ĭ��ֵ40420831
		openApi.setAppsecret("malc12m3agg1285kk2ae20eag19797b9");//Ĭ��ֵmalc12m3agg1285kk2ae20eag19797b9
		openApi.setAccesstoken("1d9f5fd4962244c9b70c3950c3faf366");//Ĭ��ֵ1d9f5fd4962244c9b70c3950c3faf366
		openApi.setFormat("json");//Ĭ��ֵxml
		openApi.setMethod("wdgj.stock.synchronize");
		openApi.setVersions("1.1");
		
		//����Ӧ�ò���/�������
		openApi.requestparas.put("content", content);
		
		//��������
		String res = OpenApiUtil.HttpPostString(openApi);
		System.out.println("���͵Ĳ�����"+openApi.getPostparas());
		System.out.println("���صĽ����"+res);
	}
}
