package com.limpid.holisticlearnspb.event.listener;

import com.limpid.holisticlearnspb.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @auther cuiqiongyu
 * @create 2019/7/22 15:11
 */
@Component
public class UserRegisterListen implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println(userRegisterEvent);
    }

}
