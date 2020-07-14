package com.nj.core.base.exception;

/**
 * 所以异常继承该类
 * @author MaSong
 */
public class BaseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BaseException(){
		
	}
	
	public BaseException(String msg){
		super(msg);
	}

}
