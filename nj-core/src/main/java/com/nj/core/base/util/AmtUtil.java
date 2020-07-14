package com.nj.core.base.util;

import java.math.BigDecimal;

/**
 * 金额相关工具
 */
public class AmtUtil {

	/**
	 * 汉语中数字大写
	 */
	private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	/**
	 * 汉语中货币单位大写，这样的设计类似于占位符
	 */
	private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾",
			"佰", "仟", "兆", "拾", "佰", "仟" };
	/**
	 * 特殊字符：整
	 */
	private static final String CN_FULL = "整";
	/**
	 * 特殊字符：负
	 */
	private static final String CN_NEGATIVE = "负";
	/**
	 * 金额的精度，默认值为2
	 */
	private static final int MONEY_PRECISION = 2;
	/**
	 * 特殊字符：零元整
	 */
	private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

	/**
	 * 把输入的金额转换为汉语中人民币的大写
	 */
	public static String amt2CNMontrayUnit(BigDecimal numberOfMoney) {
		int signum = numberOfMoney.signum();
		
		// 零元整的情况
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}
		
		// 金额为整数
		if(new BigDecimal(numberOfMoney.intValue()).compareTo(numberOfMoney)==0){
			return int2CNMontrayUnit(numberOfMoney);
		}
		
		// 金额为小数
		return double2CNMontrayUnit(numberOfMoney);
	}
	
	/**
	 * 整数转换成大写。
	 * 网上找的方法。由于存在整数转换有bug的问题，现将整数转成小数，然后减去小数部分的方式完成
	 */
	private static String int2CNMontrayUnit(BigDecimal numberOfMoney){
		BigDecimal temp = numberOfMoney.add(new BigDecimal(0.01));
		String tempStr = double2CNMontrayUnit(temp);
		return tempStr.substring(0, tempStr.indexOf("元")+1);
	}
	
	private static String double2CNMontrayUnit(BigDecimal numberOfMoney){
		int signum = numberOfMoney.signum();
		StringBuffer sb = new StringBuffer();
		
		// 这里会进行金额的四舍五入
		long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();
		// 得到小数点后两位值
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			// 每次获取到最后一个数
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			// 让number每次都去掉最后一个数
			number = number / 10;
			++numIndex;
		}
		// 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		// 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BigDecimal numberOfMoney = new BigDecimal(5000000);
		String s = AmtUtil.amt2CNMontrayUnit(numberOfMoney);
		System.out.println(s.toString());
	}
}
