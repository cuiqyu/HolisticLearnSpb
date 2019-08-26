package com.limpid.holisticlearnspb.proxy;

import java.util.List;

/**
 * @ClassName Chain
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 15:47
 */
public class Chain {

    private List<HandlerChain> handlerChainList;

    private int index = 0;

    public Chain(List<HandlerChain> handlerChainList) {
        this.handlerChainList = handlerChainList;
    }

    public void proceed() {
        if (index >= handlerChainList.size()) {
            return;
        }
        handlerChainList.get(index++).execute(this);
    }

}
