package com.limpid.holisticlearnspb;

import com.limpid.holisticlearnspb.entity.StudentEntity;

/**
 * @auther cuiqiongyu
 * @create 2019/8/16 18:08
 */
public class Test {

    public static void main(String[] args) {
        StudentEntityFactory<StudentEntity> studentEntityConsumer = StudentEntity::new;
        StudentEntity studentEntity = studentEntityConsumer.create();
    }

}
