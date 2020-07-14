package com.nj.core.base.util;

import java.util.Date;
import java.util.UUID;

/**
 * 随机数生成工具类
 * @author MaSong
 *
 */
public class RandomUtil {
	
	/**
	 * 
	 * 获得一个6位纯数字的随机数
	 * 该方法是同步了的
	 * @return
	 * 	 返回 String 类型的随机数
	 */
	public static  String getRandomNumberOfSix() {
		
		String randomNumber = Math.ceil(Math.random() * 900000 + 100000) + "";
		int index = randomNumber.lastIndexOf(".");
		randomNumber = randomNumber.substring(0, index);
		return randomNumber;
	}
	
	/**
	 * 
	 * 获得一个3位纯数字的随机数
	 * 该方法是同步了的
	 * @return
	 * 	 返回 String 类型的随机数
	 */
	public static  String getRandomNumberOfThree() {
		
		String randomNumber = Math.ceil(Math.random() * 900 + 100) + "";
		int index = randomNumber.lastIndexOf(".");
		randomNumber = randomNumber.substring(0, index);
		return randomNumber;
	}
	
	
	/**
	 * 生成UUID
	 * @return
	 */
	public static synchronized String randomuuid()
	{
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 返回指定长度的数字验证码
	 * @param length 验证码长度，最短1字节，最长9字节
	 * @return
	 */
	public static int intActionCode(int length)
	{
		if (length > 9)
			throw new RuntimeException("数字验证码最长九字节");
		if (length < 1)
			throw new RuntimeException("验证码长度必须大于0字节");
		
		String str = "";
		int r = 0, i;
		for (i = 0; i < length; i++)
		{
			r = ((Double)(Math.random() * 10)).intValue();
			str += String.valueOf(r);
		}
		
		return Integer.valueOf(str);
	}

	/**
	 * 返回指定长度的数字字符混合验证码
	 * @param length 验证码长度，最短1字节，最长31字节
	 * @return
	 */
	public static String StrActionCode(int length)
	{
		if (length > 31)
			throw new RuntimeException("数字验证码最长三十一字节");
		if (length < 1)
			throw new RuntimeException("验证码长度必须大于0字节");
		
			return randomuuid().substring(0, length);
	}
	
	/**
	 * 当前时间毫秒数加UUID的唯一性字条串
	 * @return
	 */
	public static String timeAndUUID()
	{
		return System.currentTimeMillis() + randomuuid();
	}

	
	/**
	 * 货币小数第三位进1位,保留两位小数
	 * @param money
	 * @return
	 */
	public static Double transMoneyCeil(double money){
		
		money=Math.ceil(money*100)/100;
		
		return money;
	}
	
	
	/**
	 * 货币小数第三位退去，保留两位小数
	 * @param money
	 * @return
	 */
	public static Double transMoneyFloor(double money){
		
		money=Math.floor(money*100)/100;
		
		return money;
	}
	
	
	/**
	 * 返回订单SN码，年月日+10位时间戳+6位随机数
	 * @return
	 */
	public static String getOrderSn(){
		
		StringBuilder orderSn=new StringBuilder();
		orderSn.append(DateTimeHelper.formatDateTimetoString(new Date(),"yyyyMMdd"));
		orderSn.append(DateTimeHelper.getCurrentTimestampOfPHP());
		orderSn.append(getRandomNumberOfSix());
		return orderSn.toString();
	}
	
	/**
	 * 返回手机号码后6位
	 * @param mobile
	 * @return
	 */
	public static String getMobileForLastSix(String mobile){
		
		return 	mobile.substring(5);
	}
	
	/**
	 * 获得30位的数，该字符有yyyyMMddHHmmssSS+时间戳组成
	 * @return
	 */
	public static String getRandomNumberOfThirty(){
		StringBuilder random=new StringBuilder();
		random.append(DateTimeHelper.formatDateTimetoString(new Date(),DateTimeHelper.FMT_yyyyMMddHHmmssSS));
		random.append(System.currentTimeMillis());
		//System.out.println(random.toString().length());
		return random.toString();
	}
	
	
	/**
	 * 返回照片的临时名称
	 * @return
	 */
	public static String getPicRandomName(){
		
		String name="img_"+System.currentTimeMillis()+StrActionCode(6);
		//System.out.println(name);
		return name;
	}	
	
}
