package com.limpid.holisticlearnspb.service.impl;

import com.limpid.holisticlearnspb.service.AnimalService;
import org.springframework.stereotype.Service;

/**
 * @auther cuiqiongyu
 * @create 2019/8/14 19:15
 */
@Service
public class AnimalServiceImpl implements AnimalService {

    @Override
    public String eatting(String userName) {
        return userName + "在吃东西";
    }

    @Override
    public String speaking(String userName) {
        return userName + "在说话";
    }

    @Override
    public String sleeping(String userName) {
        return userName + "在睡觉";
    }

    @Override
    public String working(String userName) {
        return userName + "在工作";
    }
}
