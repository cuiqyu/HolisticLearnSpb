package com.limpid.holisticlearnspb.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = -5524994417674273337L;

    private Integer sno;
    private String name;
    private String sex;
    private Integer age;
    private String cellphone;

}