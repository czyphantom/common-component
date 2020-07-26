package com.czy.exception;

/**
 * 基本异常类
 * @author czy
 * @date 2020/07/26 20:28
 */
public class BaseException extends RuntimeException {

    private final ErrorCode errorCode;

    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
