package com.sheliming.mybatis.demo;

import com.sheliming.mybatis.demo.config.AppConfig;
import com.sheliming.mybatis.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.query();
    }
}
