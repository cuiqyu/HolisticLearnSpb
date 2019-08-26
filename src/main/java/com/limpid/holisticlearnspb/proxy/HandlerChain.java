package com.limpid.holisticlearnspb.proxy;

import java.util.List;

/**
 * @ClassName HandlerChain
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 15:43
 */
public abstract class HandlerChain {

    public abstract void handleProcess();

    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }


}
