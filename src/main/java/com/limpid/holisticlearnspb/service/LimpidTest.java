package com.limpid.holisticlearnspb.service;

import com.limpid.holisticlearnspb.service.impl.AnimalServiceImpl;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @auther cuiqiongyu
 * @create 2019/8/14 19:26
 */
public class LimpidTest {

    private static BiFunction<Function<String, String>, String, String> biFunction = (s1, s2) -> s1.apply(s2);

    public static void main(String[] args) {
        LimpidTest test = new LimpidTest();
        System.out.println(test.testEat1());
        System.out.println(test.testEat2());
        System.out.println(test.testSpeak1());
        System.out.println(test.testSpeak2());
        System.out.println(test.testSleep1());
        System.out.println(test.testSleep2());
        System.out.println(test.testWork1());
        System.out.println(test.testWork2());
    }

    private String testEat1() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        return operate.execute(userName -> animalService.eatting(userName), limpid);
    }

    private String testEat2() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return biFunction.apply(userName -> animalService.eatting(userName), limpid);
    }

    private String testSpeak1() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        return operate.execute(userName -> animalService.speaking(userName), limpid);
    }

    private String testSpeak2() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return biFunction.apply(userName -> animalService.speaking(userName), limpid);
    }

    private String testSleep1() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        return operate.execute(userName -> animalService.sleeping(userName), limpid);
    }

    private String testSleep2() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return biFunction.apply(userName -> animalService.sleeping(userName), limpid);
    }

    private String testWork1() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        AbstrachPersionOperate operate = new AbstrachPersionOperate();
        return operate.execute(userName -> animalService.working(userName), limpid);
    }

    private String testWork2() {
        AnimalService animalService = new AnimalServiceImpl();
        String limpid = "limpid";
        return biFunction.apply(userName -> animalService.working(userName), limpid);
    }

}
