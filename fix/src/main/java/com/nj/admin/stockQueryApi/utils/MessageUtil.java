package com.nj.admin.stockQueryApi.utils;

import com.alibaba.fastjson.JSON;

public class MessageUtil {
	
	/**
	 * 对象转换成json
	 * @param object
	 * @return
	 */
	public static String ObjToJson(Object object) {
		return JSON.toJSONString(object);
	}
	/**
	 * json转对象
	 * @param json
	 * @param tClass
	 * @return
	 */
	public static Object JsonToObj(String json,Class<?> tClass) {
		return JSON.parseObject(json, tClass);
	}
	

}
