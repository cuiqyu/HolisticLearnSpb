package com.limpid.holisticlearnspb;

import com.limpid.holisticlearnspb.config.CustomerApplicationEventPublish;
import com.limpid.holisticlearnspb.entity.BlogEntity;
import com.limpid.holisticlearnspb.event.UserRegisterEvent;
import com.limpid.holisticlearnspb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {BlogEntity.class})
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerApplicationEventPublish eventPublish;

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        // application.setBannerMode(Banner.Mode.OFF); // 关闭启动的banner
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
//        eventPublish.publishEvent(new UserRegisterEvent("user_source", "2", "3"));
//        studentService.testRetry(); // 测试使用aop实现注解式的接口重试逻辑
    }

}
