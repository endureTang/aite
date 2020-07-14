package com.nj.core.base.exception;

/**
 * 自动流程异常
 *
 * @author Lizy
 * @version 2018/8/27.
 */
public class AutoProcessException extends RuntimeException {
    public AutoProcessException() {
        super();
    }

    public AutoProcessException(String msg) {
        super(msg);
    }
}
