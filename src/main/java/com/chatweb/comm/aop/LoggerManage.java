package com.chatweb.comm.aop;

import java.lang.annotation.*;

/**
 * @author teacher wang
 * @version 1.0
 * @Description: 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

    public String description();
}
