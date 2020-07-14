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
 * 2015年5月15日    yangzs         Create the class
 */

package com.nj.core.base.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @FileName StringUtils.java
 * @Description:
 *
 * @Date 2015年5月15日
 * @author yangzs
 * @version 1.0
 * 
 */
public class StringUtils {

	private static final Log logger = LogFactory.getLog(StringUtils.class);

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 * @author yangzs
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	public static boolean isNull(String str) {
		return str == null || "".equals(str.trim()) || "null".equals(str.trim());
	}
	/**
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 * @return
	 * @author yangzs
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isNotEmptyAndNull(String str){
		return !isNull(str);
	}
	/**
	 * 获取Object对象字符串
	 * 
	 * @param obj
	 * @return
	 * @author yangzs
	 */
	public static String string(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 生成32位的UUID字符串
	 * 
	 * @return
	 * @author yangzs
	 */
	public static String getUUID32() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static List<String> splitToStr(String fromString, String separate) {
		List<String> backList = new ArrayList<String>();
		if (isEmpty(fromString)) {
			return null;
		} else {
			String[] ids = fromString.split(separate);
			for (int i = 0; i < ids.length; i++) {
				if (isEmpty(ids[i])) {
					continue;
				}
				if (isEmpty(ids[i].trim()) || ids[i].trim().equals(separate)) {
					continue;
				}
				backList.add(ids[i]);
			}
		}
		return backList;
	}

	public static List<Integer> split(String fromString, String separate) {
		List<Integer> backList = new ArrayList<Integer>();
		if (isEmpty(fromString)) {
			return null;
		} else {
			String[] ids = fromString.split(separate);
			for (int i = 0; i < ids.length; i++) {
				if (isEmpty(ids[i])) {
					continue;
				}
				if (isEmpty(ids[i].trim()) || ids[i].trim().equals(separate)) {
					continue;
				}
				try {
					backList.add(Integer.parseInt(ids[i].trim()));
				} catch (Exception e) {
					logger.error("转换信息有误,无法转换为Integer类型。fromString = " + fromString);
					continue;
				}
			}
		}
		return backList;
	}

	public static String clean(String str, String separate) {
		List<Integer> list = split(str, separate);
		StringBuilder backStr = new StringBuilder();
		if (null != list && list.size() > 0) {
			int len = list.size();
			for (int i = 0; i < len; i++) {
				backStr.append(separate).append(list.get(i));
			}
			backStr.append(separate);
		}
		return backStr.toString();
	}

	public static String clear(String str) {
		if (isEmpty(str)) {
			return "";
		}
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 只允许字母和数字
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String rename(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		String regEx = "[^a-zA-Z0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
			'2', '3', '4', '5', '6', '7', '8', '9', '+', '/', };

	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4,
			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26,
			27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1,
			-1, -1, -1 };

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] decodeByte(String str) {
		byte[] data = str.getBytes();
		int len = data.length;
		ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
		int i = 0;
		int b1, b2, b3, b4;

		while (i < len) {
			do {
				b1 = base64DecodeChars[data[i++]];
			} while (i < len && b1 == -1);
			if (b1 == -1) {
				break;
			}

			do {
				b2 = base64DecodeChars[data[i++]];
			} while (i < len && b2 == -1);
			if (b2 == -1) {
				break;
			}
			buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

			do {
				b3 = data[i++];
				if (b3 == 61) {
					return buf.toByteArray();
				}
				b3 = base64DecodeChars[b3];
			} while (i < len && b3 == -1);
			if (b3 == -1) {
				break;
			}
			buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

			do {
				b4 = data[i++];
				if (b4 == 61) {
					return buf.toByteArray();
				}
				b4 = base64DecodeChars[b4];
			} while (i < len && b4 == -1);
			if (b4 == -1) {
				break;
			}
			buf.write((int) (((b3 & 0x03) << 6) | b4));
		}
		return buf.toByteArray();
	}
	
	/**
	 * 根据身份证号码，判断性别
	 * @param idCard
	 * @return
	 */
	public static String getIDCardSex(String idCard){
		String sex = "";
		if(!StringUtils.isEmpty(idCard)){
			try{
				if(idCard.length() == 15){
					int number = Integer.parseInt(idCard.substring(idCard.length() - 1));
					if(number % 2 == 0){
						sex = "女";
					}else{
						sex = "男";
					}
				}else if(idCard.length() == 18){
					int number = Integer.parseInt(idCard.substring(idCard.length() - 2,idCard.length() - 1));
					if(number % 2 == 0){
						sex = "女";
					}else{
						sex = "男";
					}
				}
			}catch (Exception e) {
			}
		}
		return sex;
	}

}
