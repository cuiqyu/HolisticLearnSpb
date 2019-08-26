package com.limpid.holisticlearnspb.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLogEntity implements Serializable {

    private static final long serialVersionUID = 2035011444652850327L;

    private Integer id;
    private String user_name;
    private String operation;
    private Integer timestamp;
    private String method;
    private String parms;
    private String ip;
    private Date createTime;
    private Date updateTime;

}