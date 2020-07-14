package com.nj.core.base.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Name com.nj.core.base.enums.EProductTemplate
 * @Description 产品模板
 * 
 * @Author bruce
 * @Version 2018年6月14日 下午2:10:12
 * @Copyright 金鼎财富
 *
 */
public enum EProductTemplate {
	
	Credit(1,"3C消费类",TemplateType.PERSON),
	Housing(2,"房屋类",TemplateType.PERSON),
	AUTO_FINANCE(3,"汽车金融类",TemplateType.PERSON),
	CASH(4,"现金类",TemplateType.PERSON),
	
	company_base(101,"企业进件基础类",TemplateType.COMPANY);			
	
	protected int id;			//产品模板id。id为3位数，前1位代表大分类，如1代表企业。  后2位代表该类中的编号。如01代表基础类。则101则代表企业的基础类。   个人产品模板是以前就存在的，不改变以前的设置，不在该规范内.
	protected String name;		//产品模板名称
	protected String type;		//产品模板分类
    
    
	private EProductTemplate(int id,String name,String type){
        this.name=name;
        this.id=id;
        this.type = type;
    }
	
	/**
	 * 模板类型
	 */
	public class TemplateType{
		public static final String PERSON = "person";			//个人模板
		public static final String COMPANY = "company";			//企业模板
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public static EProductTemplate getEProductTemplate(int id) {
    	for(EProductTemplate einfo:EProductTemplate.values()) {
    		if(einfo.getId()==id) {
    			return einfo;
    		}
    	}
    	return null;
    }
	
	/**
	 * 获取某一类的所有模板
	 */
	public static List<EProductTemplate> getEProductTemplateByType(String type){
		List<EProductTemplate> data = new ArrayList<EProductTemplate>();
		
		for (EProductTemplate eProductTemplate : EProductTemplate.values()) {
			if(eProductTemplate.getType().equals(type)){
				data.add(eProductTemplate);
			}
		}
		
		return data;
	}
}
