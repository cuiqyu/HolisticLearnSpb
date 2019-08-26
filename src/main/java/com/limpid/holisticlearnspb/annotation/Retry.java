package com.limpid.holisticlearnspb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Retry
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-26 21:21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retry {

    /**
     * @Author cuiqiongyu
     * @Description 延时执行的时间（单位：秒）
     * @Date 21:25 2019-08-26
     * @Param []
     * @return long
     **/
    long delayed() default 0;

    /**
     * @Author cuiqiongyu
     * @Description 重复执行间隔时间（单位：秒）
     * @Date 21:25 2019-08-26
     * @Param []
     * @return long
     **/
    long interval() default 0;

    /**
     * @Author cuiqiongyu
     * @Description 重复的次数
     * @Date 21:24 2019-08-26
     * @Param []
     * @return int
     **/
    int retryTimes() default 1;

    /**
     * @Author cuiqiongyu
     * @Description 需要直接抛出的异常，这类异常不需要重试
     * @Date 21:49 2019-08-26
     * @Param []
     * @return java.lang.Class[]
     **/
    Class[] needThrowExceptions() default {};

}
