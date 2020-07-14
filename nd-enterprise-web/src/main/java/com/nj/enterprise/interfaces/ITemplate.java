package com.nj.enterprise.interfaces;


public abstract class ITemplate {

	public static int BUSINESS_ZLSZ = 1;
	public static int BUSINESS_ZXSZ = 2;
	public static int BUSINESS_ED = 3;
	public static int BUSINESS_QX = 4;
	
	public static int RELEASE_QY = 1;
	public static int RELEASE_FW = 2;
	public static int RELEASE_FL = 3;
	
	
	/**
	 * 获取模板基本信息
	 *  @return
	 */
	public abstract Object getBasicConfiguration();
	/**
	 * 获取模板渠道信息
	 *  @return
	 */
	public abstract Object getChannelConfiguration();
	/**
	 * 获取模板业务受理信息
	 * @return
	 */
	public abstract Object getBusinessConfiguration(int type);
	/**
	 * 获取模板订单受理信息
	 * @return
	 */
	public abstract Object getOrderConfiguration();
	/**
	 * 获取模板发布信息
	 * @return
	 */
	public abstract Object getReleaseConfiguration(int type);
	
	

}
