package com.nj.core.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间类型的工具类，提供对日期和时间基于毫秒及以上精度的格式化方法、
 * 运算方法、比较方法等。注意:大部分对日期对象(java.util.Date)操作的方法,
 * 不会修改原日期对象,而以一个新的日期对象返回。
 * 
 * @author MaSong
 *
 */
public final class DateTimeHelper {
	
	public final static String FMT_yyyyMMddHHmmssSS="yyyyMMddKKmmssS";
	
	public final static String FMT_yyyyMMddHHmmss1="yyyyMMddHHmmss";

	/**
	 * 把时间格式化成如：2002-08-03 8:26:30.400 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmssSa_12 = "yyyy-MM-dd KK:mm:ss.S a";

	/**
	 * 把时间格式化成如：2002-08-03 8:26:16 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmssa_12 = "yyyy-MM-dd KK:mm:ss a";

	/**
	 * 把时间格式化成如：2002-08-03 8:26 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmma_12 = "yyyy-MM-dd KK:mm a";

	/**
	 * 把时间格式化成如：2002-08-03 8 am 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHa_12 = "yyyy-MM-dd KK a";

	/**
	 * 把时间格式化成如：2002-07-05 am 格式的字符串
	 */
	public final static String FMT_yyyyMMdda_12 = "yyyy-MM-dd a";

	/**
	 * 把时间格式化成如：2002-08-03 08:26:30.400 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";

	/**
	 * 把时间格式化成如：2002-08-03 08:26:16 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 把时间格式化成如：2002-08-03 08:26 格式的字符串
	 */
	public final static String FMT_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";

	/**
	 * 把时间格式化成如：2002-08-03 08 格式的字符串
	 */
	public final static String FMT_yyyyMMddHH = "yyyy-MM-dd HH";

	/**
	 * 把时间格式化成如：2002-07-05 格式的字符串
	 */
	public final static String FMT_yyyyMMdd = "yyyy-MM-dd";

	/**
	 * 把时间格式化成如：12:08 PM(下午) 格式的字符串
	 */
	public final static String FMT_HHmmA_12 = "KK:mm a";

	/**
	 * 把时间格式化成如：0:55 AM上午, CST 格式的字符串
	 */
	public final static String FMT_HHmmAz_12 = "KK:mm a,z";

	/**
	 * 把时间格式化成如：0:56 AM上午, 中国标准时间 格式的字符串
	 */
	public final static String FMT_HHmmAzzzz_12 = "KK:mm a,zzzz";

	/**
	 * 把时间格式化成如：12:08:23 am 格式的字符串
	 */
	public final static String FMT_HHmmssA_12 = "KK:mm:ss a";

	/**
	 * 把时间格式化成如：0:55:33 AM上午, CST 格式的字符串
	 */
	public final static String FMT_HHmmssAz_12 = "KK:mm:ss a,z";

	/**
	 * 把时间格式化成如：0:56:23 AM上午, 中国标准时间 格式的字符串
	 */
	public final static String FMT_HHmmssAzzzz_12 = "KK:mm:ss a,zzzz";

	/**
	 * 把时间格式化成如：22:04:45 格式的字符串
	 */
	public final static String FMT_HHmmss = "HH:mm:ss";

	/**
	 * 把时间格式化成如：22:04:45.824 格式的字符串
	 */
	public final static String FMT_HHmmssS = "HH:mm:ss.S";

	/**
	 * 把时间格式化成如：22:04 格式的字符串
	 */
	public final static String FMT_HHmm = "HH:mm";

	/**
	 * 把时间格式化成如：22:04,CST 格式的字符串
	 */
	public final static String FMT_HHmmz = "HH:mm,z";

	/**
	 * 把时间格式化成如：22:04,中国标准时间 格式的字符串
	 */
	public final static String FMT_HHmmzzzz = "HH:mm,zzzz";

	/**
	 * 把时间格式化成如：Sun,Nov 14,'2004 格式的字符串
	 */
	public final static String FMT_WWMMDDYY_EN = "EEE,MMM d,''yyyy";

	/**
	 * 把时间格式化成如：星期日,2004年十一月14号 格式的字符串
	 */
	public final static String FMT_WWMMDDYY_CN = "EEE,yyyy年MMMd号";

	/**
	 * 把时间格式化成如：Sun,Nov 14,'2004 格式的字符串
	 */
	public final static String FMT_MMDDYY_EN = "MMM d,''yyyy";

	/**
	 * 把时间格式化成如：星期日,2004年十一月14号 格式的字符串
	 */
	public final static String FMT_MMDDYY_CN = "yyyy年MMMd号";

	/**
	 * 把时间格式化成如：星期几 格式的字符串,即可获得该日这个时间是星期几
	 */
	public final static String FMT_WW = "EEE";

	/**
	 *常用的格式化时间的格式组，用于本类中格式化字符串成时间型
	 */
	private final static String[] formatStr ={
			FMT_yyyyMMddHHmmssS,
			FMT_yyyyMMddHHmmss,
			FMT_yyyyMMddHHmm,
			FMT_yyyyMMddHH,
			FMT_yyyyMMdd,
			FMT_HHmmss,
			FMT_HHmmssS,
			FMT_HHmm,
			FMT_HHmmz,
			FMT_HHmmzzzz,
			FMT_yyyyMMddHHmmssSa_12,
			FMT_yyyyMMddHHmmssa_12,
			FMT_yyyyMMddHHmma_12,
			FMT_yyyyMMddHHa_12,
			FMT_yyyyMMdda_12,
			FMT_HHmmA_12,
			FMT_HHmmAz_12,
			FMT_HHmmAzzzz_12,
			FMT_HHmmssA_12,
			FMT_HHmmssAz_12,
			FMT_HHmmssAzzzz_12
	};


	/**
	 *
	 *私有化构造器，使得不能产生该类对象，类中所有的方法均为静态方法
	 *
	 */
	private DateTimeHelper() {
	}

	/**
	 * 根据给出的Date值和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
	 * @param date
	 * @param formatStr
	 * @return 如果为null，返回字符串""
	 */
	public static String formatDateTimetoString(Date date, String formatStr) {
		String reStr = "";
		if (date == null || formatStr == null || formatStr.trim().length() < 1) {
			return reStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(formatStr);
		reStr = sdf.format(date);
		return reStr == null ? "" : reStr;
	}
	
	public static Date getSystemDate(String fmtstr){
		try {
			return parseToDate(formatDateTimetoString(getSystemDate(),fmtstr));
		} catch (Exception e) {
			e.printStackTrace();
			return getSystemDate();
		}
		
	}
	/**
	 * 根据给出的Date值和格式串采用给定的国家所在的国家风格来格式化时间，并返回相应的字符串
	 * @param date 日期对象
	 * @param formatStr 日期格式
	 * @return 如果为null，返回字符串""
	 */
	public static String formatDateTimetoString(Date date, String formatStr, Locale locale) {
		String reStr = "";
		if (date == null || formatStr == null || locale == null || formatStr.trim().length() < 1) {
			return reStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
		reStr = sdf.format(date);
		return reStr == null ? "" : reStr;
	}

	/**
	 * 根据给出的Date值字符串和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
	 * @param dateStr 日期串
	 * @param formatStr 日期格式
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatDateTimetoString(String dateStr, String formatStr) throws Exception {
		String dStr = "";
		if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null && formatStr.trim().length() > 0) {
			dStr = formatDateTimetoString(parseToDate(dateStr), formatStr);
		}
		return dStr;
	}

	/**
	 * 根据给出的Date值字符串和格式串采用指定国家的风格来格式化时间，并返回相应的字符串
	 * @param dateStr 日期串
	 * @param formatStr 日期格式
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatDateTimetoString(String dateStr, String formatStr, Locale locale) throws Exception {
		String dStr = "";
		if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null && formatStr.trim().length() > 0 && locale != null) {
			dStr = formatDateTimetoString(parseToDate(dateStr, locale), formatStr, locale);
		}
		return dStr;
	}

	/**
	 * 按指定的格式和操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @param formatStr
	 * @return java.util.Date类型对象
	 * @throws Exception 
	 */
	public static Date parseToDate(String dateTimeStr, String formatStr) throws Exception {
		if (dateTimeStr == null || formatStr == null || dateTimeStr.trim().length() < 1 || formatStr.trim().length() < 1) {
			throw new IllegalArgumentException("参数dateTimeStr、formatStr不能是null或空格串!");
		}

		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			return sdf.parse(dateTimeStr);
		} catch (ParseException e) {
			throw new Exception(e);			
		}
	}

	/**
	 * 按指定的格式和指定国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @param formatStr
	 * @param locale
	 * @return java.util.Date类型对象
	 * @throws Exception 
	 */
	public static Date parseToDate(String dateTimeStr, String formatStr, Locale locale) throws Exception {
		if (dateTimeStr != null && formatStr != null && locale != null && dateTimeStr.trim().length() > 0 && formatStr.trim().length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {
				throw new Exception(e);		
			}
		}else{
			throw new IllegalArgumentException("参数dateTimeStr、formatStr、locale不能是null或空格串!");
		}

	}

	/**
	 * 按操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @return java.util.Date类型对象
	 * @throws Exception 
	 */
	public static Date parseToDate(String dateTimeStr) throws Exception{
		if (dateTimeStr == null || dateTimeStr.trim().length() < 1) {
			throw new IllegalArgumentException("参数dateTimeSt不能是null或空格串!");
		}
		int formatStrLength = formatStr.length;
		int i = 0;
		
		for (i = 0; i < formatStrLength; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i]);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {}
		}
		throw new Exception("日期格式不正确!");		
	}

	/**
	 * 根据给出的年月和日返回一个日期型的对象
	 * @param year 年 
	 * @param month 月 ，1到12
	 * @param day 日 ，1到31
	 * @return java.util.Date类型对象
	 * @throws Exception 
	 */
	public static Date parseToDate(int year,int month,int day) throws Exception {
		if(month<1 || month>12 || day<1 || day>31){
			throw new IllegalArgumentException("参数不正确!");
		}
		String yearStr = String.valueOf(year);
		String monthStr = String.valueOf(month);
		String dayStr = String.valueOf(day);
		
		return parseToDate(yearStr+"-"+monthStr+"-"+dayStr);

	}
	/**
	 * 根据给出的年月日、时分秒、返回一个对应的Date型对象
	 * @param year 年
	 * @param month 月 ，1到12
	 * @param day 日 ，1到31
	 * @param h 小时，从0到23
	 * @param m 分，从0到60
	 * @param s 秒，从0到60
	 * @return java.util.Date类型对象
	 * @throws Exception 
	 */
	public static Date parseToDate(int year,int month,int day,int h,int m,int s) throws Exception{
		if(month<1 || month>12 || day<1 || day>31 || h<0 || h>23 || m<0 || m>60 || s<0 || s>60){
			throw new IllegalArgumentException("参数不正确!");
		}
		String yearStr = String.valueOf(year);
		String monthStr = String.valueOf(month);
		String dayStr = String.valueOf(day);
		String hStr = String.valueOf(h);
		String mStr = String.valueOf(m);
		String sStr = String.valueOf(s);

		return parseToDate(yearStr+"-"+monthStr+"-"+dayStr+" "+hStr+":"+mStr+":"+sStr);


	}

	/**
	 * 按指定国家的风格把给定的日期字符串格式化为一个Date型日期
	 * @param dateTimeStr
	 * @return java.util.Date类型对象
	 * @throws Exception 
	 */
	public static Date parseToDate(String dateTimeStr, Locale locale) throws Exception {
		if (dateTimeStr == null || dateTimeStr.trim().length() < 1 || locale == null) {
			throw new IllegalArgumentException("参数dateTimeSt、locale不能是null或空格串!");
		}
		int formatStrLength = formatStr.length;
		int i = 0;
		for (i = 0; i < formatStrLength; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i], locale);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {}
		}
		throw new Exception("日期格式不正确!");
	}

	/**
	 * 将给定的日期时间字符串按操作系统默认的国家风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTimeStr
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatDateTimetoString(String dateTimeStr) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_yyyyMMddHHmmss);
	}

	/**
	 * 将给定的日期时间字符串按指定国家的风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTimeStr
	 * @param locale
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatDateTimetoString(String dateTimeStr, Locale locale) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_yyyyMMddHHmmss, locale);
	}

	/**
	 * 将给定的日期时间按操作系统默认的国家内格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTime
	 * @return 如果为null，返回""
	 */
	public static String formatDateTimetoString(Date dateTime) {
		return formatDateTimetoString(dateTime, FMT_yyyyMMddHHmmss);
	}

	/**
	 * 将给定的日期时间按指定国家的风格格式化成"yyyy-MM-dd HH:mm:ss"格式的日期时间串;
	 * @param dateTime
	 * @param locale
	 * @return 如果为null，返回""
	 */
	public static String formatDateTimetoString(Date dateTime, Locale locale) {
		return formatDateTimetoString(dateTime, FMT_yyyyMMddHHmmss, locale);
	}

	/**
	 * 将给定的日期字符串按操作系统默认的国家风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param dateStr 日期串
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatDatetoString(String dateStr) throws Exception {
		return formatDateTimetoString(dateStr, FMT_yyyyMMdd);
	}

	/**
	 * 将给定的日期字符串按指定国家的风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param dateStr 日期串
	 * @param locale Locale
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatDatetoString(String dateStr, Locale locale) throws Exception {
		return formatDateTimetoString(dateStr, FMT_yyyyMMdd, locale);
	}

	/**
	 * 将给定的日期按指定操作系统默认国家的风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param d 日期对象
	 * @return 如果为null，返回""
	 */
	public static String formatDatetoString(Date d) {
		return formatDateTimetoString(d, FMT_yyyyMMdd);
	}

	/**
	 * 将给定的日期按指定国家的风格格式化成"yyyy-MM-dd"格式的日期串;
	 * @param d 日期对象
	 * @param locale Locale
	 * @return 如果为null，返回""
	 */
	public static String formatDatetoString(Date d, Locale locale) {
		return formatDateTimetoString(d, FMT_yyyyMMdd, locale);
	}

	/**
	 * 将给定的日期时间字符串按操作系统默认的国家风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatTimetoString(String dateTimeStr) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss);
	}

	/**
	 * 将给定的日期时间字符串按指定国家的风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @param locale
	 * @return 如果为null，返回""
	 * @throws Exception 
	 */
	public static String formatTimetoString(String dateTimeStr, Locale locale) throws Exception {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss, locale);
	}

	/**
	 * 将给定的日期时间按指定操作系统默认国家的风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @return 如果为null，返回""
	 */
	public static String formatTimetoString(Date dateTimeStr) {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss);
	}

	/**
	 * 将给定的日期时间按指定国家的风格格式化成"HH:mm:ss"格式的时间串;
	 * @param dateTimeStr
	 * @param locale
	 * @return 如果为null，返回""
	 */
	public static String formatTimetoString(Date dateTimeStr, Locale locale) {
		return formatDateTimetoString(dateTimeStr, FMT_HHmmss, locale);
	}

	/**
	 * 返回一个时间的年份整数
	 * @param d
	 * @return  年份
	 */
	public static int getYearOfDate(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 返回一个时间的月份整数
	 * @param d
	 * @return 月份
	 */
	public static int getMonthOfYear(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回一个时间的天份整数，是这个月的第几天
	 * @param d
	 * @return 天份
	 */
	public static int getDayOfMonth(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回一个时间的天份整数，是这个年份的第几天
	 * @param d
	 * @return 天份
	 */
	public static int getDayOfYear(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 返回一个时间的天份整数，是这个周的第几天
	 * @param d
	 * @return 天份
	 */
	public static int getDayOfWeek(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 返回一个时间的周的整数，是这个月的第几周
	 * @param d
	 * @return 周
	 */
	public static int getWeekOfMonth(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 返回一个时间的周的整数，是这个年份的第几周
	 * @param d
	 * @return 周
	 */
	public static int getWeekOfYear(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回该时间所对应的在一天中的小时数的整数，如当前(Date now)是下午3点，返回为15
	 * @param d
	 * @return 小时
	 */
	public static int getHoursOfDay(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		return hours;
	}

	/**
	 * 返回该时间所对应的在一天中的小时数的整数(采用12小时制)，如当前(Date now)是下午3点，返回为3
	 * @param d
	 * @return 小时
	 */
	public static int getHoursOfDay12(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int hours = calendar.get(Calendar.HOUR);
		return hours;
	}


	/**
	 * 返回该时间所对应的分钟数中的整数，如now是15点14分，则返回14
	 * @param d
	 * @return 分钟
	 */
	public static int getMinutesOfHour(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int minutes = calendar.get(Calendar.MINUTE);

		return minutes;
	}

	/**
	 * 返回该时间所对应的秒数中的整数,如now是15点14分34秒，则返回34
	 * @param d
	 * @return 秒
	 */
	public static int getSecondsOfMinute(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int seconds = calendar.get(Calendar.SECOND);

		return seconds;
	}

	/**
	 * 返回该时间所对应的毫秒数中的整数,如now是15点14分34秒470毫秒，则返回470
	 * @param d
	 * @return 毫秒
	 */
	public static int getMillisecondsOfSecond(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		return millisecond;
	}

	/**
	 * 返回该时间相对于1970年1月1日开始计算的对应的毫秒数
	 * @param d
	 * @return 毫秒数
	 */
	public static long getTime(Date d) {
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		return d.getTime();
	}

	/**
	 * 比较两个时间的先后顺序。
	 * 如果时间d1在d2之前，返回1,
	 * 如果时间d1在d2之后，返回-1，
	 * 如果二者相等，返回0
	 * @param d1
	 * @param d2
	 * @return 
	 *          如果时间d1在d2之前，返回1,
	 *          如果时间d1在d2之后，返回-1，
	 *          如果二者相等，返回0
	 */
	public static int compareTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}

		long dI1 = d1.getTime();
		long dI2 = d2.getTime();

		if(dI1>dI2){
			return -1;
		}else if(dI1<dI2){
			return 1;
		}else {
			return 0;
		}

	}
	
	/**
	 * 判断时间d3 是否在 时间d1 和时间 d2 之间
	 * @param d1
	 * @param d2
	 * @param d3
	 * @return
	 */
	public static boolean  betweenTwoDate(Date d1 , Date d2 ,Date d3) {
		
		if (compareTwoDate(d1,d3)==-1) {
			return false;
		} else  if (compareTwoDate(d2,d3 ) == 1) {
			return false;
		}
		return true;
	}
	/**
	 * 返回两个日期之间的毫秒数的差距
	 * @param d1
	 * @param d2
	 * @return 二者至1970年1.1后的毫秒数的差值
	 */
	public static long getMillisecondsOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long dI1 = d1.getTime();
		long dI2 = d2.getTime();
		return (dI1-dI2);
	}

	/**
	 * 获得两个日期之间相差的秒数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的秒数
	 */
	public static double getSecondsOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long i = getMillisecondsOfTwoDate(d1,d2);

		return (double)i/1000;
	}

	/**
	 * 获得两个日期之间相差的分钟数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的分钟数
	 */
	public static double getMinutesOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/60/1000;
	}

	/**
	 * 获得两个日期之间相差的小时数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的小时数
	 */
	public static double getHoursOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/60/60/1000;
	}

	/**
	 * 获得两个日期之间相差的天数
	 * @param d1
	 * @param d2
	 * @return 两日期之间相差的天数
	 */
	public static double getDaysOfTwoDate(Date d1,Date d2){
		if(d1==null || d2==null){
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		}
		long millions = getMillisecondsOfTwoDate(d1,d2);
		return (double)millions/24/60/60/1000;
	}


  /**
   * 把给定的时间加上指定的时间值，可以为负。
   * @param d 日期对象
   * @param times 时间值
   * @param type 类型，
   *           Calendar.MILLISECOND,毫秒<BR>
   *           Calendar.SECOND,秒<BR>
   *           Calendar.MINUTE,分钟<BR>
   *           Calendar.HOUR,小时<BR>
   *           Calendar.DATE,日<BR>
   * @return 如果d为null，返回null
   */
  public static Date addTime(Date d, double times, int type) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
	  long qv = 1;
	  switch(type){
	    case Calendar.MILLISECOND : qv = 1;break;
	    case Calendar.SECOND : qv = 1000;break;
	    case Calendar.MINUTE : qv = 1000*60;break;
	    case Calendar.HOUR : qv = 1000*60*60;break;
	    case Calendar.DATE : qv = 1000*60*60*24;break;
	    default:
	      throw new RuntimeException("时间类型不正确！type＝"+type);
      }
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(d);
      long milliseconds = (long)Math.round(Math.abs(times) * qv);
      if(times>0){
        for (; milliseconds > 0; milliseconds -= 2147483647) {
          if (milliseconds > 2147483647) {
            calendar.add(Calendar.MILLISECOND, 2147483647);
          }
          else {
            calendar.add(Calendar.MILLISECOND, (int) milliseconds);
          }
        }
      }else{
        for (; milliseconds > 0; milliseconds -= 2147483647) {
          if (milliseconds > 2147483647) {
            calendar.add(Calendar.MILLISECOND, -2147483647);
          }
          else {
            calendar.add(Calendar.MILLISECOND, -(int) milliseconds);
          }
        }
      }
      return calendar.getTime();
  }


	/**
	 * 把给定的时间加上指定的年份，可以为负, 返回新的被加上了年份的日期对象,不影响参数日期对象值
	 * @param d
	 * @param years
	 * @return 日期对象
	 */
	public static Date addYears(Date d, int years) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}


	/**
	 * 把给定的时间加上指定的月份，可以为负
	 * @param d
	 * @param months
	 * @return  日期对象
	 */
	public static Date addMonths(Date d, int months) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的天数，可以为负
	 * @param d 日期对象
	 * @param days
	 * @return 日期对象
	 */
	public static Date addDays(Date d, int days) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.HOUR, days * 24);
		return calendar.getTime();
	}

	/**
	 * 把给定的时间加上指定的小时，可以为负
	 * @param d 日期对象
	 * @param hours
	 * @return 日期对象
	 */
	public static Date addHours(Date d, int hours) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的分钟，可以为负
	 * @param d
	 * @param minutes
	 * @return 日期对象
	 */
	public static Date addMinutes(Date d, int minutes) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的秒数，可以为负
	 * @param d
	 * @param seconds
	 * @return 日期对象
	 */
	public static Date addSeconds(Date d, int seconds) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}
	/**
	 * 把给定的时间加上指定的毫秒数，可以为负
	 * @param d
	 * @param milliseconds
	 * @return 日期对象
	 */
	public static Date addMilliseconds(Date d, int milliseconds) {
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.MILLISECOND, milliseconds);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的年份是新的给定的年份
	 * @param d 需要设定的日期对象
	 * @param year 新的年份
	 * @return 日期对象
	 */
	public static Date setYearOfDate(Date d,int year){
		if(d==null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.YEAR,year);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的月份是新的给定的月份
	 * @param d 需要设定的日期对象
	 * @param month 新的月份
	 * @return 新日期对象
	 */
	public static Date setMonthOfDate(Date d,int month){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MONTH,month);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的天是新的给定的天
	 * @param d 需要设定的日期对象
	 * @param day 新的天
	 * @return 新日期对象
	 */
	public static Date setDayOfDate(Date d,int day){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的小时是新的给定的小时
	 * @param d 需要设定的日期对象
	 * @param hour 新的小时数
	 * @return 新日期对象
	 */
	public static Date setHourOfDate(Date d,int hour){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.HOUR_OF_DAY,hour);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的分钟是新的给定的分钟数
	 * @param d 需要设定的日期对象
	 * @param minute 新的分钟数
	 * @return 新日期对象
	 */
	public static Date setMinuteOfDate(Date d,int minute){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MINUTE,minute);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的秒数是新的给定的分钟数
	 * @param d 需要设定的日期对象
	 * @param second 新的秒数
	 * @return 新日期对象
	 */
	public static Date setSecondOfDate(Date d,int second){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.SECOND,second);
		return calendar.getTime();
	}

	/**
	 * 设置一个日期对象的毫秒数是新的给定的分钟数
	 * @param d 需要设定的日期对象
	 * @param millisecond 新的毫秒数
	 * @return 新日期对象
	 */
	public static Date setMillisecondOfDate(Date d,int millisecond){
		if (d == null){
			throw new IllegalArgumentException("参数d不能是null对象!");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MILLISECOND,millisecond);
		return calendar.getTime();
	}
	
	/**
	 * 返回当期日期月份最后一天
	 * @param d
	 * @return
	 * @throws Exception
	 */
	public static Date getDateOfMonthForLast(Date d) throws Exception{
		int year =getYearOfDate(d);
		int month = getMonthOfYear(d);
		int day = getDaysOfMonth(d);
		return parseToDate(year,month,day);
	}

    /**
     * 返回指定日期的月份的天数量
     * @param d 日期对象
     */
    public  static int getDaysOfMonth(Date d){
        int year = getYearOfDate(d);
        int month = getMonthOfYear(d);
       return getDaysOfMonth(year, month);
    }
    /**
    * 返回指定日期的月份的天数量
    * @param year 年
    * @param month 月
    */
   public static int getDaysOfMonth(int year, int month){
        int days = 0;
       if(month==2){
           if(((year%4==0)&&(year%100 != 0))||(year%400==0)){
               days = 29;
            }
           else{
               days = 28;
           }
       }
       if((month==4)||(month==6)||(month==9)||(month==11)){
           days = 30;
       }
       if ((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)){
            days = 31;
       }
      return days;
   }


	/**
	 * 返回系统时间,以日期对象形式返回
	 * 
	 * @return 日期对象
	 */
	public static Date getSystemDate(){
    return new Date(System.currentTimeMillis());
  }

	/**
	 * 返回系统时间,以毫秒形式返回
	 * 
	 * @return 毫秒数
	 */
	public static long getSystemTime(){
		return System.currentTimeMillis();
	}

	/**
	 * 返回24小时前的时间
	 * @param date
	 * @return
	 */
	public static Date getLastDay(Date date)
	{
		long day = date.getTime();
		long lastDay = day - 24*60*60*1000;
		return new Date(lastDay);
	}
	
	/**
	 * 返回24小时后的时间
	 * @param date
	 * @return
	 */
	public static Date getTomorrow(Date date)
	{
		long day = date.getTime();
		long tomorrow = day + 24*60*60*1000;
		return new Date(tomorrow);
	}
	
	/**
	 * 取得30天前的这个时间
	 * @param date
	 * @return
	 */
	public static Date getDayLastMonth()
	{
		long day = new Date().getTime();
		long dayLastMonth = day - 24*60*60*1000*20;
		return new Date(dayLastMonth);
	}
	
	/**
	 * 取得30天后的这个时间
	 * @param date
	 * @return
	 */
	public static Date getDayNextMonth()
	{
		long day = new Date().getTime();
		long dayNextMonth = day + 20*24*60*60*1000;
		return new Date(dayNextMonth);
	}
	
	/**
	 * 取得当前时间的前后某天的这个时间
	 * @param date
	 * @param day  可以为正负
	 * @return
	 */
	public static Date getDayLastMonth(Date date,int day){
		
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
	     c.add(Calendar.DATE, day);
	     return  c.getTime();
	}
	
	public static int getMonthCount(Date sDate, Date eDate)
	{
		String sDateStr = DateTimeHelper.formatDateTimetoString(sDate, "MM");
		String eDateStr = DateTimeHelper.formatDateTimetoString(eDate, "MM");
		int monthCount = Integer.parseInt(eDateStr) - Integer.parseInt(sDateStr) + 1;
		return monthCount;
	}
	
	/**
	 * 取得下个月的这天，比如2月1日可取得3月1日，此方法有很大局限性，不能用于月末的天数
	 * @param date
	 * @return
	 */
	public static Date getDayNextMonth(Date date)
	{
		String yearStr = DateTimeHelper.formatDateTimetoString(date, "yyyy");
		String monthStr = DateTimeHelper.formatDateTimetoString(date, "MM");
		String dayStr = DateTimeHelper.formatDateTimetoString(date, "dd");
		int year = Integer.parseInt(yearStr);
		int month = Integer.parseInt(monthStr);
		if(month == 12)
		{
			month = 1;
			year = year + 1;
			yearStr = String.valueOf(year);
			monthStr = String.valueOf(month);
		} else {
			month = month + 1;
			yearStr = String.valueOf(year);
			monthStr = String.valueOf(month);
		}
		
		String dateStr = yearStr + "-" + monthStr + "-" + dayStr;
		try {
			date = DateTimeHelper.parseToDate(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * 获得当前时间戳
	 * @return
	 */
	public static long getCurrentTimestamp(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 获得php格式的当前时间戳
	 * @return
	 */
	public static long getCurrentTimestampOfPHP(){
		
		return javaToPhpTimestamp(System.currentTimeMillis());
	}
	
	
	/**
	 * Java时间戳转换成PHP的
	 * @param time
	 * @return
	 */
	public static long javaToPhpTimestamp(long time){
		
		String timeMsg=time+"";
		String phpTimestamp=timeMsg.substring(0, 10);
		
		return Long.parseLong(phpTimestamp);
	}
	
	
	/**
	 * PHP时间戳转换成Java
	 * @param time
	 * @return
	 */
	public static long phptoJavaTimestamp(long time){
		
		return Long.parseLong(time+"000");
	}
	
	
	/**
	 * 时间戳转Date类型
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date timestampToDate(long time) throws ParseException{
		
		SimpleDateFormat format=new SimpleDateFormat(FMT_yyyyMMddHHmmss);
		String timeStr=format.format(time);
		return format.parse(timeStr);
		
	}
	
	/**
	 * 返回下月的这天
	 * @param date
	 * @return
	 */
	public static Date getDateNextMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, +1);
		return cal.getTime();
	}
	
	/**
	 * 获得指定年月的当月第一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getDateMonthOfFirst(int year,int month){
		 Calendar cale = Calendar.getInstance();
		// 获取前月的第一天
	     cale = Calendar.getInstance();
	     cale.set(Calendar.YEAR, year);
	     cale.set(Calendar.MONTH, month-1);
	     cale.set(Calendar.DAY_OF_MONTH, 1);
	     cale.set(Calendar.HOUR_OF_DAY, 0);
	     cale.set(Calendar.MINUTE, 0);
	     cale.set(Calendar.SECOND, 0);
	     return cale.getTime();
	}
	
	/**
	 * 查询指定年月的当月最后一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getDateMonthOfLast(int year,int month){
		
		 Calendar cale = Calendar.getInstance();
		 // 获取前月的最后一天
		 cale = Calendar.getInstance();
		 cale.set(Calendar.YEAR, year);
		 cale.set(Calendar.MONTH, month);
		 cale.set(Calendar.DAY_OF_MONTH, 0);
		 cale.set(Calendar.HOUR_OF_DAY, 23);
		 cale.set(Calendar.MINUTE, 59);
		 cale.set(Calendar.SECOND, 59);
		 return cale.getTime();
	}
	
	public static void main(String[] args){
		
//		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(format.format(getDateMonthOfLast(2018,9)));
		Date d =new Date();
		System.out.println(getDayNextMonth(d));


	}
}