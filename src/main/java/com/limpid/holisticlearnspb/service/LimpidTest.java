package com.limpid.holisticlearnspb.service;

import com.limpid.holisticlearnspb.service.impl.AnimalServiceImpl;

/**
 * @auther cuiqiongyu
 * @create 2019/8/14 19:26
 */
public class LimpidTest {

    public static void main(String[] args) {
        LimpidTest test = new LimpidTest();
        System.out.println(test.testEat());
        System.out.println(test.testSpeak());
        System.out.println(test.testSleep());
        System.out.println(test.testWork());
    }

    private String testEat() {
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return operate.execute(userName -> animalService.eatting(userName), limpid);
    }

    private String testSpeak() {
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return operate.execute(userName -> animalService.sleeping(userName), limpid);
    }

    private String testSleep() {
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return operate.execute(userName -> animalService.sleeping(userName), limpid);
    }

    private String testWork() {
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return operate.execute(userName -> animalService.working(userName), limpid);
    }

}
