package com.limpid.holisticlearnspb;

import com.limpid.holisticlearnspb.proxy.*;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @ClassName TestProxy
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 13:01
 */
public class TestProxy {

    public static void main(String[] args) {
//        HelloService helloService = new ProxyHelloServiceImpl(new HelloServiceImpl());
//        helloService.sayHello();

//        HelloService helloService = (HelloService) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{HelloService.class}, new JdkProxyHelloServiceImpl(new HelloServiceImpl()));
//        helloService.sayHello();
//        helloService.sayHello1();

        Enhancer enHancer = new Enhancer();
        enHancer.setSuperclass(HelloServiceImpl.class);
        enHancer.setCallback(new CglibProxyHelloServiceImpl());
        HelloService helloService = (HelloService) enHancer.create();
        helloService.sayHello();
        helloService.sayHello1();
    }

}
