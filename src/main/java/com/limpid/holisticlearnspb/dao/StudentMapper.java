package com.limpid.holisticlearnspb.dao;

import com.limpid.holisticlearnspb.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    int insert(StudentEntity record);

    List<StudentEntity> selectAll();

}