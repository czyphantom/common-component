package com.czy.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务监控注解
 * @author czy
 * @date 2021/1/9
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GatewayServiceWatcher {

    /**
     * 服务名称
     * @return
     */
    String serviceName();

    /**
     * 是否只在异常时记录日志
     * @return
     */
    boolean printLogOnlyWhenException() default false;
}
