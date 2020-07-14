package com.nj.core.base.common.api;

public enum RespCode {
	 
		/**
		 * Token验证，登录失败
		 */
		SUCCESS("0000","OK"),
		NOT_LOGIN("9000","登录验证失败，请重新登录"),
		LOGIN_ON_OTHER_DEVICE("9012","用户在其他设备登录"),
		/**
		 * data数据有效性验证
		 */
		DC0002("9001","数据有效性验证验证失败"),
		/**
		 * 参数不完整
		 * */
		PARAM_INVALID("9002","参数不完整"),
		
		KEY_NOT_EXIST("9003","查询失败，数据库未命中key"),
		
		USER_NOT_EXIST("9004","用户不存在"),
		
		USER_NOT_COMPLETE("9005","用户没有完善资料"),
	
		ORDER_COMMIT_ERROR("9006","提交订单错误"),
		
		AUTH_FAIL("9007","登录校验失败"),
		
		TFCF_ERROR("9008","天府财富操作失败"),
		
		SMS_ERROR("9009","短信错误"),
		SMRZ_ERROR("9010","用户已经实名认证"),
		SMRZ_INVALID("9011","实名认证失败"),
		
		ZHIMA_ERROR("9100","芝麻操作失败"),
		
		ZHIMA_ERROR_NOT_AUTH("9101","芝麻没有授权"),
		
		ZHIMA_ERROR_AUTH_FAIL("9102","芝麻授权失败"),
		
		
		INNER_ERROR("9999","系统错误");
		
		private String code;
		private String msg;

		private RespCode() {
		}

		private RespCode(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}


}
