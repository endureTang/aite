package com.nj.core.fee.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nj.core.base.util.StringUtils;

/**
 * 业务费用枚举
 * 如：本金、利息、罚息、渠道费、居间费......
 */
public enum EBusinessFee implements Comparator<EBusinessFee>{
	
	CAPITAL("capital","本金",true,1),
	INTEREST("interest","利息",true,2),
	PENALTYINTEREST("penaltyInterest","罚息",false,3),
	CHANNELFEE("channelFee","渠道费",false,4),
	MEDIACYFEE("mediacyFee","居间费",false,5);
	
	private String code;				//费用编码
	private String name;				//费用名称
	private Boolean isMustSelected;		//是否必选
	private Integer index;				//展示顺序
	
	private EBusinessFee(String code,String name,Boolean isMustSelected,Integer index){
		this.code = code;
		this.name = name;
		this.isMustSelected = isMustSelected;
		this.index = index;
	}
	
	/**
	 * 获取应还字段的code
	 */
	public String getPlanFeeCode(){
		return "plan_" + this.getCode();
	}
	
	/**
	 * 获取实还字段的code
	 */
	public String getAccFeeCode(){
		return "acc_" + this.getCode();
	}
	
	/**
	 * 根据费用编码得到显示名称
	 */
	public static String getNameByFeeCode(String feeCode){
		if(feeCode.contains("_")){
			String [] arr = feeCode.split("_");
			
			String pre = "";
			if(arr[0].equals("plan")){
				pre += "应还";
			}else if(arr[0].equals("acc")){
				pre += "实还";
			}
			
			return pre + getEBusinessFeeInfo(arr[1]).getName();
		}else{
			return getEBusinessFeeInfo(feeCode).getName();
		}
	}
	
	/**
	 * 根据应还或实还的编码得到应还的编码
	 */
	public static String getPlanFeeCode(String planCodeOrAccCode){
		if(StringUtils.isNotEmpty(planCodeOrAccCode)){
			String[] codeArr = planCodeOrAccCode.split("_");
			if(codeArr.length == 2){
				EBusinessFee fee = getEBusinessFeeInfo(codeArr[1]);
				if(null != fee){
					return fee.getPlanFeeCode();
				}
			}
		}
		return "";
	}
	
	/**
	 * 根据应还或实还的编码得到实还的编码
	 */
	public static String getAccFeeCode(String planCodeOrAccCode){
		if(StringUtils.isNotEmpty(planCodeOrAccCode)){
			String[] codeArr = planCodeOrAccCode.split("_");
			if(codeArr.length == 2){
				EBusinessFee fee = getEBusinessFeeInfo(codeArr[1]);
				if(null != fee){
					return fee.getAccFeeCode();
				}
			}
		}
		return "";
	}
	
	/**
	 * 验证费用编码是否是合法的应还费用
	 */
	public static Boolean isPlan(String feeCode){
		if(!"plan_".equals(feeCode.substring(0,5))){
			return false;
		}
		String tail = feeCode.substring(5);
		for (EBusinessFee bFee : EBusinessFee.values()) {
			if(bFee.getCode().equals(tail)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 验证费用编码是否是合法的实还费用
	 */
	public static Boolean isAcc(String feeCode){
		if(!"acc_".equals(feeCode.substring(0,4))){
			return false;
		}
		String tail = feeCode.substring(4);
		for (EBusinessFee bFee : EBusinessFee.values()) {
			if(bFee.getCode().equals(tail)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 通过code获取枚举
	 */
	public static EBusinessFee getEBusinessFeeInfo(String code) {
    	for(EBusinessFee fee:EBusinessFee.values()) {
    		if(fee.getCode().equalsIgnoreCase(code)) {
    			return fee;
    		}
    	}
    	return null;
    }
	
	/**
	 * 通过任意费用编码set，获取按显示顺序排好序的应还费用编码
	 * @param feeCodeSet EbusinessFee的code集合
	 */
	public static List<String> getPlanFeeCodeSortByFeeCode(Set<String> feeCodeSet){
		List<String> planFeeCodeList = new ArrayList<String>();
		
		List<EBusinessFee> sortedFeeList = Arrays.asList(EBusinessFee.values());
		Collections.sort(sortedFeeList);
		
		for (EBusinessFee eBusinessFee : sortedFeeList) {
			if(feeCodeSet.contains(eBusinessFee.getCode())){
				planFeeCodeList.add(eBusinessFee.getPlanFeeCode());
			}
		}
		
		return planFeeCodeList;
	}
	
	/**
	 * 为应还费用code进行排序
	 */
	public static List<String> sortPlanFeeCode(Set<String> planFeeCodeSet){
		List<String> planFeeCodeList = new ArrayList<String>();
		
		List<EBusinessFee> sortedFeeList = Arrays.asList(EBusinessFee.values());
		Collections.sort(sortedFeeList);
		
		for (EBusinessFee eBusinessFee : sortedFeeList) {
			if(planFeeCodeSet.contains(eBusinessFee.getPlanFeeCode())){
				planFeeCodeList.add(eBusinessFee.getPlanFeeCode());
			}
		}
		
		return planFeeCodeList;
	}
	
	/**
	 * 通过任意费用编码set，获取按显示顺序排好序的实还费用编码
	 * @param feeCodeSet EbusinessFee的code集合
	 */
	public static List<String> getAccFeeCodeSortByFeeCode(Set<String> feeCodeSet){
		List<String> accFeeCodeList = new ArrayList<String>();
		
		List<EBusinessFee> sortedFeeList = Arrays.asList(EBusinessFee.values());
		Collections.sort(sortedFeeList);
		
		for (EBusinessFee eBusinessFee : sortedFeeList) {
			if(feeCodeSet.contains(eBusinessFee.getCode())){
				accFeeCodeList.add(eBusinessFee.getAccFeeCode());
			}
		}
		
		return accFeeCodeList;
	}
	
	/**
	 * 为实还费用code进行排序
	 */
	public static List<String> sortAccFeeCode(Set<String> accFeeCodeSet){
		List<String> accFeeCodeList = new ArrayList<String>();
		
		List<EBusinessFee> sortedFeeList = Arrays.asList(EBusinessFee.values());
		Collections.sort(sortedFeeList);
		
		for (EBusinessFee eBusinessFee : sortedFeeList) {
			if(accFeeCodeSet.contains(eBusinessFee.getAccFeeCode())){
				accFeeCodeList.add(eBusinessFee.getAccFeeCode());
			}
		}
		
		return accFeeCodeList;
	}
	
	public static Map<String,String> getAllFee(){
		Map<String,String> map = new HashMap<String,String>();
		for (EBusinessFee bf : EBusinessFee.values()) {
			map.put(bf.getPlanFeeCode(), EBusinessFee.getNameByFeeCode(bf.getPlanFeeCode()));
			map.put(bf.getAccFeeCode(), EBusinessFee.getNameByFeeCode(bf.getAccFeeCode()));
		}
//		map.put("plan_capital", "应还本金");
//		map.put("acc_capital", "实还本金");		
//		map.put("plan_interest", "应还利息");
//		map.put("acc_interest", "实还利息");		
//		map.put("plan_penaltyInterest", "应还罚息");
//		map.put("acc_penaltyInterest", "实还罚息");		
//		map.put("plan_channelFee", "应还渠道费");
//		map.put("acc_channelFee", "实还渠道费");		
//		map.put("plan_mediacyFee", "应还居间费");
//		map.put("acc_mediacyFee", "实还居间费");
		return map;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsMustSelected() {
		return isMustSelected;
	}
	public void setIsMustSelected(Boolean isMustSelected) {
		this.isMustSelected = isMustSelected;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public int compare(EBusinessFee o1, EBusinessFee o2) {
		if(o1.getIndex() < o2.getIndex()){
			return -1;
		}else if(o1.getIndex() == o2.getIndex()){
			return 0;
		}else{
			return 1;
		}
	}
}
