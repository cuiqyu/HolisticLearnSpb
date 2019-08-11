package com.limpid.holisticlearnspb.controller;

import com.limpid.holisticlearnspb.entity.StudentEntity;
import com.limpid.holisticlearnspb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author cuiqiongyu
 * @Date 2019-08-10 19:08
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * @Author cuiqiongyu
     * @Description 添加学生信息
     * @Date 19:12 2019-08-10
     * @Param [student]
     * @return int
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int insertStudent(StudentEntity student) {
        return studentService.insert(student);
    }

    /**
     * @Author cuiqiongyu
     * @Description 查询所有学生信息
     * @Date 19:13 2019-08-10
     * @Param []
     * @return java.util.List<com.limpid.holisticlearnspb.entity.StudentEntity>
     **/
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentEntity> findAll() {
        return studentService.findAll();
    }

}
