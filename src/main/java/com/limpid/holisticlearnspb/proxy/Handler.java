package com.limpid.holisticlearnspb.proxy;

/**
 * @ClassName Handler
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-25 15:26
 */
public abstract class Handler {

    private Handler sessior;

    public Handler getSessior() {
        return sessior;
    }

    public void setSessior(Handler sessior) {
        this.sessior = sessior;
    }

    protected abstract void hanlerProcess();

    public void execute() {
        hanlerProcess();
        if (null != sessior) {
            sessior.execute();
        }
    }

}
