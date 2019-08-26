package com.limpid.holisticlearnspb.service.impl;

import com.limpid.holisticlearnspb.annotation.Retry;
import com.limpid.holisticlearnspb.dao.StudentMapper;
import com.limpid.holisticlearnspb.entity.StudentEntity;
import com.limpid.holisticlearnspb.service.StudentService;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private static int i = 0;

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

    /**
     * @Author cuiqiongyu
     * @Description 测试接口重试
     * @Date 22:04 2019-08-26
     * @Param []
     * @return void
     **/
    @Override
    @Retry(delayed = 5, interval = 10, retryTimes = 5, needThrowExceptions = {RuntimeException.class})
    public void testRetry() throws Exception {
        // 开始测试接口重试aop
        logger.info("开始测试接口重试aop，当前i={}", i );
        if (i++ < 4) {
            if (i== 3) {
                throw new RuntimeException("");
            } else {
                throw new Exception("");
            }
        }

        logger.info("接口调用成功");
    }

}
