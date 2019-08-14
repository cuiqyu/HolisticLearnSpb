package com.limpid.holisticlearnspb.service;

/**
 * 人类
 *
 * @auther cuiqiongyu
 * @create 2019/8/14 19:13
 */
public interface AnimalService {

    /**
     * 吃东西
     * @param userName
     * @return
     */
    String eatting(String userName);

    /**
     * 说话
     * @param userName
     * @return
     */
    String speaking(String userName);

    /**
     * 睡觉
     * @param userName
     * @return
     */
    String sleeping(String userName);

    /**
     * 工作
     * @param userName
     * @return
     */
    String working(String userName);

}
