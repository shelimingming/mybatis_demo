package com.sheliming.mybatis.spring;

import com.sheliming.mybatis.spring.config.AppConfig;
import com.sheliming.mybatis.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring+mybatis整合
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.query();
    }
}
