package com.nj.core.ehcache;

public class EhCacheConstant {
	public final static String NOR_CACH = "com.nj.cache2";
	public final static String NOR_CACH3 = "com.nj.cache3";
	//缓存系统可用的角色
	public final static String ROLES_CACH = "ROLES_CACHE";
	public final static String USERS_CACHE = "USERS_CACHE";
	//缓存
	public final static String ORDER_PROCEDURE = "ORDER_PROCEDURE";
	public final static String ORDER_FLOWS = "ORDER_FLOWS";
	public final static String ORDER_PROCESSES = "ORDER_PROCESSES";
	public final static String PROCESSES_STATUS = "PROCESSES_STATUS";
	//數據字典
	public final static String SYS_DIC_CACHE = "SYS_DIC_CACHE";
	
	public interface ITF{
		public final static String APP_USER ="APP_USER";
		public final static String APP_USER_LOGIN_DEV ="APP_USER_LOGIN_DEV";
		public final static String APP_USER_CAR ="APP_USER_CAR";
		public final static String APP_USER_BASIC ="APP_USER_BASIC";
		public final static String APP_USER_WORK ="APP_USER_WORK";
		public final static String APP_USER_RELATION = "APP_USER_RELATIVE";
		public final static String ORDER_FLOWS ="ORDER_FLOWS";
		public final static String SYSTEM ="ITF_SYSTEM";
		public final static String SMS="SMS";
		public final static String SYS_DICT ="sys_dict";
		public final static String SYS_AREA ="sys_area";
		public final static String PRODUCT_PERIOD ="PRODUCT_PERIOD";
		public final static String PRODUCT_CHANNEL="PRODUCT_CHANNEL";
		public final static String PRODUCT_TAG="PRODUCT_TAG";
		public final static String REAPY_WAY ="repayway";
	}
}
