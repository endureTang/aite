package com.nj.admin.stockQueryApi.utils;

import com.alibaba.fastjson.JSON;

public class MessageUtil {
	
	/**
	 * ����ת����json
	 * @param object
	 * @return
	 */
	public static String ObjToJson(Object object) {
		return JSON.toJSONString(object);
	}
	/**
	 * jsonת����
	 * @param json
	 * @param tClass
	 * @return
	 */
	public static Object JsonToObj(String json,Class<?> tClass) {
		return JSON.parseObject(json, tClass);
	}
	

}
