package com.limpid.holisticlearnspb.annotation;

import com.limpid.holisticlearnspb.register.RetryImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自动注入enable注解空能
 *
 * @auther cuiqiongyu
 * @create 2019/9/3 13:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import(RetryImportBeanDefinitionRegistrar.class)
public @interface EnableRetry {

}
