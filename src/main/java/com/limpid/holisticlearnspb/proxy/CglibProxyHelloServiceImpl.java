package com.limpid.holisticlearnspb.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxyHelloServiceImpl
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 14:27
 */
public class CglibProxyHelloServiceImpl implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before cglib");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            System.out.println("ex cglib");
            throw e;
        } finally {
            System.out.println("finally cglib");
        }
        return result;
    }
}
