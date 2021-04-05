package com.czy.exception;

import com.alibaba.fastjson.JSON;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 错误码接口
 * @author czy
 * @date 2020/07/26
 */
public interface ErrorCode {

    /**
     * 错误码Code
     * @return
     */
    String getCode();

    /**
     * 错误码信息，支持{}占位符
     * @return
     */
    String getMessage();

    default String formatMessage(ErrorCode errorCode, Object... args) {
        Object[] formatObjects = Arrays.stream(args).map(arg -> JSON.toJSONString(args)).toArray();
        return MessageFormat.format(errorCode.getMessage(), formatObjects);
    }
}
