package com.limpid.holisticlearnspb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author cuiqiongyu
 * @Description 使用日志切面aop记录用户操作日志
 * @Date 11:41 2019-08-11
 * @Param
 * @return
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";

}
