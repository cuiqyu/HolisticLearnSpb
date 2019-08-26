package com.limpid.holisticlearnspb.service;

import com.limpid.holisticlearnspb.entity.StudentEntity;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-10 19:03
 */
public interface StudentService {

    int insert(StudentEntity student);

    List<StudentEntity> findAll();

    void testRetry() throws Exception;

}
