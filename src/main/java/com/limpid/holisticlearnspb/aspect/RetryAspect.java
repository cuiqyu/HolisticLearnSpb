package com.limpid.holisticlearnspb.aspect;

import com.limpid.holisticlearnspb.annotation.Retry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName RetryAspect
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-26 21:30
 */
@Aspect
public class RetryAspect {

    private final static Logger logger = LoggerFactory.getLogger(RetryAspect.class);

    @Pointcut("@annotation(com.limpid.holisticlearnspb.annotation.Retry)")
    public void retryPointcut() {

    }

    @Around("retryPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Retry annotation = method.getAnnotation(Retry.class);
        // 获取注解中的参数
        long delayed = annotation.delayed(); // 延时执行的时间
        long interval = annotation.interval(); // 重复执行间隔时间
        int retryTimes = annotation.retryTimes(); // 重试的次数
        Class[] classes = annotation.needThrowExceptions();
        retryTimes = retryTimes < 1 ? 1 : (retryTimes > 10 ? 10 : retryTimes); // 最大重试10次，最少重复一次
        Thread.sleep(delayed * 1000);

        // 开始执行方法
        for (int i = 0; i < retryTimes; i++) {
            try {
                return joinPoint.proceed();
            } catch (Throwable t) {
                // 判断异常是否是指定需要直接抛出的异常，如果是，则直接抛出
                if (classes.length > 0) {
                    for (Class aClass : classes) {
                        if (aClass == t.getClass()) {
                            logger.info("碰到指定的异常，直接抛出");
                            // 直接抛出
                            throw t;
                        }
                    }
                }
                logger.info("第{}次尝试失败，等待下一次尝试，等待时间间隔：{}s", i + 1, interval);
                Thread.sleep(interval * 1000); // 等待间隔后重试
            }
        }

        return null;
    }

}
