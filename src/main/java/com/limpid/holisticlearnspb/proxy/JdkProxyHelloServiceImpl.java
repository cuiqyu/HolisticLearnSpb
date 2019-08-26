package com.limpid.holisticlearnspb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName JdkProxyHelloServiceImpl
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 13:31
 */
public class JdkProxyHelloServiceImpl implements InvocationHandler {

    private HelloServiceImpl helloService;

    public JdkProxyHelloServiceImpl(HelloServiceImpl helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===begin");
        Object result = null;
        try {
            result = method.invoke(helloService, args);
        } catch (Exception e) {
            System.out.println("===ex");
            throw e;
        } finally {
            System.out.println("finally");
        }
        return result;
    }
}
