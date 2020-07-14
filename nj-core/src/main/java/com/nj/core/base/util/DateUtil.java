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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

/**
 * @FileName DateUtil.java
 * @Description: 
 *
 * @Date Apr 19, 2015 
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final Lock LOCK = new ReentrantLock();
	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * @Title: compareDate
	 * @Description:(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return
	 * @date Apr 19, 2015
	 */
	public static boolean compareDate(String s, String e) {
		if (parseDate(s) == null || parseDate(e) == null) {
			return false;
		}
		return parseDate(s).getTime() >= parseDate(e).getTime();
	}
	
	public static boolean compareDate(Date d1, Date d2) {
		return d1.getTime() >= d2.getTime();
	}

	/**
	 * 字符转日期
	 * 
	 * @return
	 */
	public static Date parseDateTime(String date) {
		return parseDate(date,"yyyy-MM-dd HH:mm:ss");
		
	}
	
	/**
	 * 字符转日期
	 * 
	 * @return
	 */
	public static Date parseDate(String date) {
		return parseDate(date,"yyyy-MM-dd");
		
	}
	
	/**
	 * 字符转日期
	 * 
	 * @return
	 */
	public static Date parseDate(String date,String pattern) {
		
		LOCK.lock();
		try {
			DateFormat fmt = new SimpleDateFormat(pattern);
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}finally{
			LOCK.unlock();
		}
	}
	
	
	/**
	 * 日期转字符
	 * 
	 * @return
	 */
	public static String formatDate(Date date) {
		return formatDate(date,"yyyy-MM-dd");
		
	}
	
	/**
	 * 日期转字符
	 * 
	 * @return
	 */
	public static String formatDate(Date date,String pattern) {
		if(null == date){
			return null;
		}
		
		LOCK.lock();
		try {
			DateFormat fmt = new SimpleDateFormat(pattern);
			return fmt.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			LOCK.unlock();
		}
	}

	public static String formatLongToString(long time,String pattern){
		Date date = new Date();
		date.setTime(time);
		return formatDate(date,pattern);
	}
	

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * @Title: getDaySub
	 * @Description:时间相减得到天数
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 * @date Apr 19, 2015
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}
	
	public static Date getAfterDayDate(Date date,int days){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
		return c.getTime();
	}
	
	public static Date getAfterYearDate(Date date,int years){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, years); // 日期减 如果不够减会将月变动
		return c.getTime();
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	public static Date formatDateToDate(Date date,String pattern){
		if(null == date){
			return null;
		}
		return parseDate(formatDate(date, pattern),pattern);
	}
	
	public static Date getAfterMonth(Date date,int monthnumber){
		if(null == date){
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, monthnumber);
		return c.getTime();
	}
	
	public static Long dateToUnixDate(Date date)
	{
		return date.getTime()/1000;
	}
	
	public static Long dateToUnixDate(String date)
	{
		return DateUtil.parseDate(date).getTime()/1000;
	}
	
	public static Long dateTimeToUnixDateTime(String date)
	{
		return DateUtil.parseDateTime(date).getTime()/1000;
	}
	
	/**
	 * 获取YYYYMMDDHHmmss格式
	 * 
	 * @return
	 */
	public static String getOrderNo() {
		return new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
	}
	
	/**
	 * 获取YYYYMMDDHHmmss格式
	 * 
	 * @return
	 */
	public static String getOrderTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	/**
	 * 获取指定日期之前的日期
	 * @param date 指定日期
	 * @param field 类型 ，传Calendar常量。  如Calendar.Month
	 * @param num 数量
	 */
	public static Date getBeforeDate(Date date,int field,Integer num){
		
		if(null == date){
			return null;
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, -num);
		return c.getTime();
	}
	
	/**
	 * 获取指定日期之后的日期
	 * @param date 指定日期
	 * @param field 类型 ，传Calendar常量。  如Calendar.Month
	 * @param num 数量
	 */
	public static Date getAfterDate(Date date,int field,Integer num){
		if(null == date){
			return null;
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, num);
		return c.getTime();
	}
	
	/**
	 * 获取某天的开始日期
	 * 如：2018-1-1 18:02:23 则值为2018-1-1 00:00:00
	 */
	public static Date getBeginDateForDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取某天的结束日期
	 * 如：2018-1-1 18:02:23 则值为2018-1-1 00:00:00
	 */
	public static Date getEndDateForDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 获取某日期所在月份的开始日期
	 * 如：2018-2-18 18:02:23 则值为2018-2-1 00:00:00
	 */
	public static Date getBeginDateForMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(daysBetween(new Date(), DateUtil.parseDate("2018-9-11", "yyyy-MM-dd")));
	}
}
