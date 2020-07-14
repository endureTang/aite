/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.core.base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @FileName PageData.java
 * @Description:
 *
 * @Date Apr 19, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
@SuppressWarnings("rawtypes")
public class DataTableResult extends HashMap implements Map {

	private static final long serialVersionUID = 1L;

	List<Map<String,Object>> dataList = new ArrayList<>();
	Map map = null;
	HttpServletRequest request;

	@SuppressWarnings("unchecked")
	public DataTableResult(HttpServletRequest request) {
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap();
//		returnMap.put("draw", 100);
//		returnMap.put("recordsTotal", 2);

//		returnMap.put("start", 2);开始位置
//		returnMap.put("length", 2);//每页size
		returnMap.put("recordsFiltered", 0);//总条数
		returnMap.put("data", dataList);
		
		Iterator entries = properties.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String name = (String) entry.getKey();
			String value = "";
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value += values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		map = returnMap;
//		map.put("from", getInteger("iDisplayStart"));
//		map.put("size", getInteger("iDisplayLength"));
	}

	public DataTableResult() {
		map = new HashMap();
	}

	@Override
	public Object get(Object key) {
		Object obj = null;
		if (map.get(key) instanceof Object[]) {
			Object[] arr = (Object[]) map.get(key);
			obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}

	public String getString(Object key) {
		Object value = get(key);
		return value == null ? "" : value.toString();
	}

	public Integer getInteger(Object key) {
		String value = getString(key);
		if (null != value && NumberUtils.isNumber(value)) {
			return Integer.valueOf(value.toString());
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		// String formatedKey=Tools.toCamelhump(key.toString());
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public Set entrySet() {
		return map.entrySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set keySet() {
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		map.putAll(t);
	}

	public int size() {
		return map.size();
	}

	public Collection values() {
		return map.values();
	}

	public void insertData(Object obj) {
		Field[] fs = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			try {
				Field f = fs[i];
				f.setAccessible(true); // 设置些属性是可以访问的
				Class<?> filedType = f.getType();
				Object val = f.get(obj);// 得到此属性的值
	            if (filedType == Date.class) {
	                 DateUtil.formatDate((Date) val, "yyyy-MM-dd HH:mm:ss");
	            }else{
					map.put(f.getName(), val);
	            }
			} catch (Exception e) {
			}
		}
	}
	
	public void insertData(Object obj,Map map) {
		Field[] fs = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			try {
				Field f = fs[i];
				f.setAccessible(true); // 设置些属性是可以访问的
				Class<?> filedType = f.getType();
				Object val = f.get(obj);// 得到此属性的值
	            if (filedType == Date.class) {
	                 map.put(f.getName(), DateUtil.formatDate((Date) val, "yyyy-MM-dd HH:mm:ss"));
	            }else{
					map.put(f.getName(), val);
	            }
			} catch (Exception e) {
			}
		}
	}
	
	
	/**
	 * 根据查询bean集合,转换成分页数据集
	 * @param list
	 */
	public void insertDataList(List list) {
		for (Object object : list) {
			Map map = new HashMap<>();
			insertData(object,map);
			dataList.add(map);
		}
	}

	public List<Map<String, Object>> getDataList() {
		return dataList;
	}

	public void setDataList(List<Map<String, Object>> dataList) {
		if(dataList != null && dataList.size() > 0){
			this.dataList.addAll(dataList);
		}else{
			this.dataList.clear();
		}
	}
	
	public void addDataMap(Map<String, Object> map) {
		this.dataList.add(map);
	}
	
	/**
	 * 设置数据总数
	 * @param count
	 */
	public void setTotalCount(int count) {
		map.put("recordsFiltered", count);//总条数
	}

}
