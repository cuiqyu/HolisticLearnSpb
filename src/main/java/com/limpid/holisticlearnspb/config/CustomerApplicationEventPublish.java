package com.limpid.holisticlearnspb.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

/**
 * 发送事件
 *
 * @auther cuiqiongyu
 * @create 2019/7/22 15:36
 */
@Configuration
public class CustomerApplicationEventPublish implements ApplicationEventPublisher, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void publishEvent(Object o) {
        applicationContext.publishEvent(o);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
