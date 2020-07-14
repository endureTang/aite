package com.nj.model.esign.bean;

/**
 * 单位类型
 * @author wkh
 */
public enum OrgType {
	
	PTQY(0),		//普通企业
	SHTT(1),		//社会团体
	SYDW(2),		//事业单位
	MBFQYDW(3),		//民办非企业单位
	DZJGJJG(4);		//党政及国家机构
	
	private int value;
	
	private OrgType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
