package com.czy.log.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

/**
 * 通用日志，主要用于埋点
 * @author czy
 * @date 2021/4/4
 */

public class LoggerHelper {

    private final Logger logger;

    private static final int INFO = 0;

    private static final int WARN = 1;

    private static final int ERROR = 2;

    private LoggerHelper(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    public void infoKV(String activity, String status, String msg, Object... params) {

    }

    public void warnKV(String activity, String status, String msg, Object... params) {

    }

    public void errorKV(String activity, String status, String msg, Object... params) {

    }

    public void errorKV(String activity, String status, String msg, Throwable throwable, Object... params) {

    }

    public void info(String msg, Object... params) {
        log(msg, null, LoggerHelper.INFO, params);
    }

    public void warn(String msg, Object... params) {
        log(msg, null, LoggerHelper.WARN, params);
    }

    public void error(String msg, Throwable throwable, Object... params) {
        log(msg, throwable, LoggerHelper.ERROR, params);
    }

    private void log(String msg, Throwable throwable, int logLevel, Object... params) {
        if (params != null) {
            for (int i = 0;i < params.length;i++) {
                if (params[i] == null || params[i] instanceof String) {
                    continue;
                }
                params[i] = JSON.toJSONString(params[i], SerializerFeature.IgnoreNonFieldGetter, SerializerFeature.IgnoreErrorGetter);
            }
        }
        switch (logLevel) {
            case LoggerHelper.INFO:
                logger.info(msg, params);
                break;
            case LoggerHelper.WARN:
                logger.warn(msg, params);
                break;
            case LoggerHelper.ERROR:
                logger.error(MessageFormatter.arrayFormat(msg, params).getMessage(), throwable);
                break;
            default:
                break;
        }
    }
}
