package com.czy.exception;

/**
 * 基本异常类
 * @author czy
 * @date 2020/07/26 20:28
 */
public abstract class BaseException extends RuntimeException {

    private final ErrorCode errorCode;

    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, Throwable e, Object... args) {
        super(errorCode.formatMessage(errorCode, args), e);
        this.errorCode = errorCode;

    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

}
