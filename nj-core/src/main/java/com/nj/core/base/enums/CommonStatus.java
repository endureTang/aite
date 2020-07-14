package com.nj.core.base.enums;

/**
 * 操作状态枚举
 *
 * @author Lizy
 * @version 2018/4/9.
 */
public enum CommonStatus {
    SUCCEED(0, "操作成功"),

    PARAMS_ERROR(10001, "参数错误"),

    SYSTEM_ERROR(10002, "系统错误"),

    SMS_ERROR(10003, "验证短信错误"),

    ORDER_NULL(10004, "订单不存在"),
    
    TD_ERROR(10005,"用户审核未通过或还未审核"),
	
	DECRYPT_ERROR(10006,"验签失败"),
    
	REQUEST_ERROR(10007,"请求失败"),
	
	UPLOAD_ERROR(10008,"上传数据失败");

    /**
     * 返回码
     */
    int code;
    /**
     * 返回信息
     */
    String message;

    CommonStatus(int code, String message) {
        this.code = code;
        this.message = message;

    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
