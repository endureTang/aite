package com.nj.core.base.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alan,liu
 *
 */

public class IdentifyUtil {
	
	public static int getAge(String identifyId){
		int age = 0;
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getDefault());// 获取系统当前时间
		int currentYear = calendar.get(Calendar.YEAR);
		if (identifyId.matches("^\\d{15}$|^\\d{17}[\\dxX]$")) {
			if (identifyId.length() == 18) {
				Pattern pattern = Pattern.compile("\\d{6}(\\d{4})\\d{6}(\\d{1})[\\dxX]{1}");
				Matcher matcher = pattern.matcher(identifyId);
				if (matcher.matches()) {
					age = currentYear - Integer.parseInt(matcher.group(1));
				}
			} 
			else if (identifyId.length() == 15) {
				Pattern p = Pattern.compile("\\d{6}(\\d{2})\\d{5}(\\d{1})\\d{1}");
				Matcher m = p.matcher(identifyId);
				if (m.matches()) {
					int year = Integer.parseInt(m.group(1));
					year = 2000 + year;
					if (year > 2020) {
						year = year - 100;
					}
					age = currentYear - year;
				}
			}
		}
		return age;
	}
	
	// 1表示男，0表示女
	public static int getSex(String identifyId){
		int sex = 1;

		if (identifyId.matches("^\\d{15}$|^\\d{17}[\\dxX]$")) {
			if (identifyId.length() == 18) {
				Pattern pattern = Pattern.compile("\\d{6}(\\d{4})\\d{6}(\\d{1})[\\dxX]{1}");
				Matcher matcher = pattern.matcher(identifyId);
				if (matcher.matches()) {
					sex = Integer.parseInt(matcher.group(2)) % 2;
				}
			} 
			else if (identifyId.length() == 15) {
				Pattern p = Pattern.compile("\\d{6}(\\d{2})\\d{5}(\\d{1})\\d{1}");
				Matcher m = p.matcher(identifyId);
				if (m.matches()) {
					int year = Integer.parseInt(m.group(1));
					year = 2000 + year;
					if (year > 2020) {
						year = year - 100;
					}
					sex = Integer.parseInt(m.group(2)) % 2;
				}
			}
		}
		if (sex == 2) {
			sex = 0;
		}
		return sex;
	}
}
