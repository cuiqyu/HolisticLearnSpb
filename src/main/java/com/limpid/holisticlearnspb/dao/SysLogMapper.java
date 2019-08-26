package com.limpid.holisticlearnspb.dao;

import com.limpid.holisticlearnspb.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SysLogMapper {

    int insert(SysLogEntity record);

    List<SysLogEntity> selectAll();

}