package com.nj.core.base.enums;

import java.util.ArrayList;
import java.util.List;

import com.nj.core.base.entity.ValueName;

/**
 * 
 * @Name com.nj.core.base.enums.ERepaystatus
 * @Description 还款状态
 * 
 * @Author bruce
 * @Version 2018年7月20日 下午4:16:26
 * @Copyright 金鼎财富
 *
 */
public enum ERepayStatus {
	REPAYING("repaying","还款中"),			//主表
	NORMAL("normal","正常还款"),				//行表
    COLLECTION("collection","催收还款"),		//行表。催收还清了所有费用，即逾期后还清了所有费用。  
    COLLECTION_BENXI("collection_benxi","催收仅本息还款"),	//行表。催收还清了本息。  目前未用。
    PART("part","部分还款"),					//行表。还了部分。  目前未用。
    EARLY_CLEARANCE("clearup","提前结清"),		//主表、行表。
    NOT("not","未还款"),						//行表
    OVERDUE("overdue","逾期"),				//主表、行表
	SETTLE("settle","结清");					//主表
	
	
	protected String name;
    protected String value;
    
	private ERepayStatus(String value, String name){
        this.name=name;
        this.value=value;
    }
	
	public String getValue(){
		return this.value;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static String getNameByValue(String value){
		for (ERepayStatus rs : ERepayStatus.values()) {
			if(rs.getValue().equals(value)){
				return rs.getName();
			}
		}
		return "";
	}
	
	public static String getValueByName(String name){
		for (ERepayStatus rs : ERepayStatus.values()) {
			if(rs.getName().equals(name)){
				return rs.getValue();
			}
		}
		return "";
	}
	
	private ValueName convertVn(){
		ValueName vn = new ValueName();
		vn.setValue(this.getValue());
		vn.setName(this.getName());
		return vn;
	}
	
	/**
	 * 获取主表所有状态
	 */
	public static List<ValueName> getMainStatus(){
		List<ValueName> list = new ArrayList<ValueName>();
		list.add(NORMAL.convertVn());
		list.add(COLLECTION.convertVn());
		list.add(OVERDUE.convertVn());
		list.add(SETTLE.convertVn());
		return list;
	}
	
	/**
	 * 获取所有行表的状态
	 */
	public static List<ValueName> getLineStatus(){
		List<ValueName> list = new ArrayList<ValueName>();
		list.add(NORMAL.convertVn());
		list.add(COLLECTION.convertVn());
		list.add(EARLY_CLEARANCE.convertVn());
		list.add(NOT.convertVn());
		list.add(OVERDUE.convertVn());
		return list;
	}
	
	/**
	 * 获取线下还款用到的行表状态
	 */
	public static List<ValueName> getLineStatusForOfflineRepay(){
		List<ValueName> list = new ArrayList<ValueName>();
		list.add(NORMAL.convertVn());
		list.add(COLLECTION.convertVn());
		return list;
	}
}
