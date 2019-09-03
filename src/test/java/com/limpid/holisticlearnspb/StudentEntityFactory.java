package com.limpid.holisticlearnspb;

import com.limpid.holisticlearnspb.entity.StudentEntity;

/**
 * @auther cuiqiongyu
 * @create 2019/8/16 18:20
 */
public interface StudentEntityFactory<S extends StudentEntity> {

    StudentEntity create();

}
