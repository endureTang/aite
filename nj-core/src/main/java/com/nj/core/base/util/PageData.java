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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.nj.core.base.entity.Page;


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
@Component
public class PageData extends HashMap implements Map {

	private static final long serialVersionUID = 1L;

	Map map = null;
	HttpServletRequest request;

	@SuppressWarnings("unchecked")
	public PageData(HttpServletRequest request) {
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap();
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
		map.put("from", getInteger("iDisplayStart"));
		map.put("size", getInteger("iDisplayLength"));
	}

	public Page getPage(){
		Page page = new Page();
		page.setCurrentResult(Integer.valueOf(map.get("from").toString()));
		page.setShowCount(Integer.valueOf(map.get("size").toString()));
		return page;
	}
	
	public Page getPageInfo(){
		Page page =(Page) map.get("page");
		return page;
	}
	
	public PageData() {
		map = new HashMap();
	}
	
	public PageData(int type){
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
	            	if(val != null)
	                DateUtil.formatDate((Date) val, "yyyy-MM-dd HH:mm:ss");
	            }else{
					map.put(f.getName(), val);
	            }
			} catch (Exception e) {
			}
		}
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	

}
