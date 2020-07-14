package com.nj.core.base.exception;

public class ItfException extends Exception {
	private String message;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}
	public ItfException(){
		super();
	}
	
	public ItfException(String msg){
		super(msg);
		this.message= msg;
	}
	
	public ItfException(String code , String msg){
		super(msg);
		this.message =msg;
		this.code = code;
	}
}
