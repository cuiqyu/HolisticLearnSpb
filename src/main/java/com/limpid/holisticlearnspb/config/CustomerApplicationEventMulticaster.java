package com.limpid.holisticlearnspb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.*;

/**
 * @auther cuiqiongyu
 * @create 2019/7/22 14:37
 */
@Configuration("applicationEventMulticaster")
public class CustomerApplicationEventMulticaster extends SimpleApplicationEventMulticaster {

    public CustomerApplicationEventMulticaster() {
        setTaskExecutor(getExecutor());
    }

    private Executor getExecutor() {
        return new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                //设置线程名称,以便排查
                thread.setName("--eventMulticaster thread---");
                return thread;
            }
        });
    }

}
