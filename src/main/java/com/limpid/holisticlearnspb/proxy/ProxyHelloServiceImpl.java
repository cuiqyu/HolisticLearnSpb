package com.limpid.holisticlearnspb.proxy;

/**
 * @ClassName ProxyHelloServiceImpl
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 12:59
 */
public class ProxyHelloServiceImpl implements HelloService {

    private HelloServiceImpl helloServiceImpl;

    public ProxyHelloServiceImpl(HelloServiceImpl helloServiceImpl) {
        this.helloServiceImpl = helloServiceImpl;
    }

    @Override
    public void sayHello() {
        System.out.println("###begin");
        try {
            helloServiceImpl.sayHello();
        } catch (Exception e) {
            System.out.println("###ex");
            throw e;
        } finally {
            System.out.println("###finally");
        }
    }

    @Override
    public void sayHello1() {
        helloServiceImpl.sayHello1();
    }

}
