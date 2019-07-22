package com.limpid.holisticlearnspb.controller;

import com.limpid.holisticlearnspb.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther cuiqiongyu
 * @create 2019/7/17 20:30
 */
@RestController
public class HelloWorldController {

    @Autowired
    private BlogEntity blogEntity;

    @RequestMapping(value = "/hello")
    public String hello() {
        return blogEntity.getName() + " " + blogEntity.getTile() + " " + blogEntity.getDesc();
    }

}
