package com.sheliming.mybatis.spring.service;

import com.sheliming.mybatis.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void query(){
        System.out.println(userDao.query());
    }
}
