package com.nj.core.base.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 各种正则表达式的匹配
 * @author MaSong
 *
 */
public class RegExpUtil {
	
	//11位的手机号码
	public static final String MOBILENUMBER="1[0-9]{10}";
	
	//密码为6到20位的数字、符号、字母组成，符号位键盘上面的可见字符
	public static final String PASSWORD="[\\@A-Za-z0-9\\!\\#\\$\\%\\^\\&\\*\\.\\~]{6,20}";
	
	//密码为8到16位的数字、字母组成
	public static final String PASSWORD_ONE="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
	
	//验证码  4位验证码  字母 数字  字母数字组成
	public static final String CODE="^([a-z]|[A-Z]|[0-9]){4}$";
	
	//姓名，2到8位汉字
	public static final String USERNAME="([\u4e00-\u9fa5]){2,8}";
	
	//邮箱
	public static final String EMAIL = "[a-zA-Z0-9_\\-]+@[a-zA-Z0-9_\\-.]+\\.[a-zA-Z0-9_\\-]+";
	
	//固话
	public static final String TEL = "[0-9]{1,4}\\-[0-9]{5,9}";
	
	//字符串中的关键字更具需要添加
    public static final  String inj_str = "|and|exec|union|create|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|xp_|or|--|+";
	
    //6位数字
    public static final String SZ_SIX="^\\d{6}";
    
    // 货币 保留两位小数，且不能为0,两为小数可以省略
    public static final String MONEY = "^(([1-9]\\d*)(\\.\\d{1,2})?)$|^(0\\.0?([1-9]\\d?))$";
    
    // 非0的正整数
    public static final String  POSITIVE_INTEGER="^[1-9]\\d*$";
    
	/**
	 * 正则表达式 公用方法
	 * @param regStr    正则表达式
	 * @param content	内容
	 * @return
	 * true 表示匹配  false 表示不匹配
	 */
	public static boolean regExp(String regStr,String content){
		Pattern pp = Pattern.compile(regStr);
		Matcher m = pp.matcher(content);
		if (!m.matches()) {
			 return false;
		}
		return true;
	}
	
	/**
	 * 防SQL注入
	 * @param str
	 * @return 如果含有 则返回true
	 */
	public static boolean sql_inj(String str){

		String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,|or'1'='1'|1=1|1=0";

		//这里的东西还可以自己添加

		String[] inj_stra=inj_str.split("\\|");

		for (int i=0 ; i<inj_stra.length ; i++ ){
				
			if (str.indexOf(inj_stra[i])>=0){
				return true;
			}
//			if(inj_stra[i].equals(str)){
//				return true;
//			}
		}
		return false;

	}
	
	
	/**
	 * 判断非0的正整数
	 * @param number
	 * @return
	 */
	public static boolean checkPositiveInteger(String number){
		if(null == number){
			return false;
		}
		return RegExpUtil.regExp(RegExpUtil.POSITIVE_INTEGER, number);
	}
	
	/**
	 * 判断年龄的合法性,非0的正整数
	 * @param age
	 * @return
	 */
	public static boolean checkAge(String age) {
		return checkPositiveInteger(age);
	}
	
	/**
	 * 判断手机号码的合法性
	 * @param mobile
	 * @return
	 */
	public static boolean cheackMobile(String mobile) {
		if (null == mobile){
			return false;
		}
		return RegExpUtil.regExp(RegExpUtil.MOBILENUMBER, mobile);
	}
	
	/**
	 * 判断浮点数，保留两位小数,且不为0，
	 * @return
	 */
	public static boolean  checkDecimalNumber(String number){
		
		if(null == number){
			return false;
		}
		return RegExpUtil.regExp(RegExpUtil.MONEY, number);
	}

	
	/**
	 * 动态判断数字
	 * @param number    数字
	 * @param length	长度，这里指小数点前的长度
	 * @param scale		小数点后的长度
	 * @param isZero	货币能否为0
	 * @return
	 */
	public static boolean checkAutoNumber(String number,int length,int scale,boolean isZero){
		
		if(null == number){
			return  false;
		}
		
		try {
			BigDecimal moneyBigDecimal = new BigDecimal(number);
			double moneyDouble =moneyBigDecimal.doubleValue();
			NumberFormat nf = NumberFormat.getInstance();
			number = nf.format(moneyDouble);
			number = number.replace(",", "");
		} catch(NumberFormatException e){
			return false;
		} catch(IllegalArgumentException e){
			return false;
		} catch(Exception e){
			return false;
		}
		
		// 是否为0判断
		if("0".equals(number)){
			if(isZero){
				return true;
			}else {
				return false;
			}
		}
		
		// 长度判断
		int index = number.indexOf(".");
		if(index == -1){
			if(number.length()>length){
				return false;
			}
		} else {
			String front = number.substring(0, index);
			String after = number.substring(index+1);
			if(front.length()>length){
				return false;
			}
			if(after.length()>scale){
				return false;
			}
			
		}
		return true;
	}
	
	
	public static boolean  checkDate(String date){
		
		Date t =new Date(date);
		return false;
	}
	
	public static void main(String [] args) throws Exception{
		
		/**手机格式错误  IllegalArgumentException ParseException*/
//		BigDecimal m =new BigDecimal("sdf");
//		if(!RegExpUtil.regExp(RegExpUtil.MONEY, "123456789123455678")){
//			System.out.println("123");
//		}else{
//			System.out.println("true");
//		}
		
		if(checkAutoNumber("5333399444.999",12,3,false)){
			System.out.println("通过");
		}else {
			System.out.println("不通过");
		}
		
		
		//DateTimeHelper.parseToDate("123123",DateTimeHelper.FMT_yyyyMMdd);
		
//		NumberFormat nf = NumberFormat.getInstance();
//		String str = nf.format("3.30000");
//		System.out.println(str);
	}
	
}
