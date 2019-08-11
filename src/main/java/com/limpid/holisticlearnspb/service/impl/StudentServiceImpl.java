package com.limpid.holisticlearnspb.service.impl;

import com.limpid.holisticlearnspb.dao.StudentMapper;
import com.limpid.holisticlearnspb.entity.StudentEntity;
import com.limpid.holisticlearnspb.service.StudentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-10 19:05
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int insert(StudentEntity student) {
        return studentMapper.insert(student);

    }

    @Override
    public List<StudentEntity> findAll() {
        return studentMapper.selectAll();
    }

}
