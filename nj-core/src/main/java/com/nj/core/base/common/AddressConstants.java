package com.nj.core.base.common;

import org.springframework.stereotype.Component;

/**
 * 
 * @Name com.nj.core.base.common.UserCenter
 * @Description http调用地址常量
 * 
 * @Author bruce
 * @Version 2018年3月2日 下午6:56:49
 * @Copyright 金鼎财富
 *
 */
@Component
public class AddressConstants {
	/**
	 * 统一用户中心地址
	 */
	public static String CaBaseUrl;
	/**
	 * 微鼎金融提供回掉地址
	 */
	public static String WdjrCallBack;
	/**
	 * 支付宝查询所属银行URL
	 */
	public static String AliBankInfoUrl;
	/**
	 * 金鼎金融地址
	 */
	public static String JdcfUrl;
	
	public static String JdcfAesKey;
	
	public static String jdcfCallBackKey;
	// 统计项目url
	public static String JdcfReportUrl;
	/**
	 * 金鼎财富资金端默认userId
	 */
	public static String jdcfWdDefaultCompanyUserId;
	
	/**
	 * 成都金坤订单流程个数
	 */
	public static Integer CdjkProcessNumber ;
	
	/**
	 * 用户注册
	 */
	private static String RegisterUri = "/channel/v1/regist";
	/**
	 * 微鼎回调更新订单
	 */
	private static String UpdateOrder = "/outApi/updateOrder";
	
	public static String getRegisterUri() {
		return  CaBaseUrl+RegisterUri;
	}
	/**
	 * 获取微鼎金融回调更新订单全路径
	 * @return
	 */
	public static String getUpdateOrder() {
		return WdjrCallBack + UpdateOrder;
	}

}
