package com.limpid.holisticlearnspb;

import com.limpid.holisticlearnspb.proxy.Handler;

/**
 * @ClassName TestHandler
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 15:29
 */
public class TestHandler {

    public static void main(String[] args) {
        Handler handlerA = new Handler() {
            @Override
            public void hanlerProcess() {
                System.out.println("Handle A");
            }
        };
        Handler handlerB = new Handler() {
            @Override
            public void hanlerProcess() {
                System.out.println("Handle B");
            }
        };
        Handler handlerC = new Handler() {
            @Override
            public void hanlerProcess() {
                System.out.println("Handle C");
            }
        };

        handlerA.setSessior(handlerB);
        handlerB.setSessior(handlerC);
        handlerA.execute();

    }

}
