package com.limpid.holisticlearnspb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 博客配置对象
 *
 * @auther cuiqiongyu
 * @create 2019/7/17 20:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "limpid.blog")
@PropertySource("classpath:config/blog.yml")
public class BlogEntity {

    private String name;
    private String tile;
    private String desc;

}


