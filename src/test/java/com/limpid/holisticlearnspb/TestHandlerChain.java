package com.limpid.holisticlearnspb;

import com.limpid.holisticlearnspb.proxy.Chain;
import com.limpid.holisticlearnspb.proxy.Handler;
import com.limpid.holisticlearnspb.proxy.HandlerChain;
import org.assertj.core.util.Lists;

/**
 * @ClassName TestHandlerChain
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 15:51
 */
public class TestHandlerChain {
    public static void main(String[] args) {
        HandlerChain handlerChainA = new HandlerChain(){
            @Override
            public void handleProcess() {
                System.out.println("handlerChainA");
            }
        };
        HandlerChain handlerChainB = new HandlerChain(){
            @Override
            public void handleProcess() {
                System.out.println("handlerChainB");
            }
        };
        HandlerChain handlerChainC = new HandlerChain(){
            @Override
            public void handleProcess() {
                System.out.println("handlerChainC");
            }
        };

        Chain chain = new Chain(Lists.newArrayList(handlerChainA, handlerChainB, handlerChainC));
        chain.proceed();
    }
    
}
