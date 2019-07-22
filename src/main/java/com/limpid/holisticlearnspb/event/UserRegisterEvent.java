package com.limpid.holisticlearnspb.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件
 *
 * @auther cuiqiongyu
 * @create 2019/7/22 15:03
 */
@Data
public class UserRegisterEvent extends ApplicationEvent {

    private String userId;
    private String userName;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String userId, String userName) {
        super(source);
        this.userId = userId;
        this.userName = userName;
    }

}
