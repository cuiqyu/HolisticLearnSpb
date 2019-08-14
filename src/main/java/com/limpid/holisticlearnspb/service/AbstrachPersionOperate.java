package com.limpid.holisticlearnspb.service;

/**
 * 人类在干嘛
 *
 * @auther cuiqiongyu
 * @create 2019/8/14 19:20
 */
public class AbstrachPersionOperate {

    public String execute(PersionCallback callback, String userName) {
        return callback.doInOperation(userName);
    }

}
