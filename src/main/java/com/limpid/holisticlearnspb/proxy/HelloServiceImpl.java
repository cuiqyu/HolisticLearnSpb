package com.limpid.holisticlearnspb.proxy;

import com.limpid.holisticlearnspb.proxy.HelloService;

/**
 * @ClassName HelloServiceImpl
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 12:58
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("hello welcome to springboot study");
    }

    @Override
    public void sayHello1() {
        System.out.println("hello welcome to jdk proxy");
    }

}
