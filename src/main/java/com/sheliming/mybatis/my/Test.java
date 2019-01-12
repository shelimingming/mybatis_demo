package com.sheliming.mybatis.my;

import com.sheliming.mybatis.my.dao.UserDao;
import com.sheliming.mybatis.my.invoke.UserDaoInvocationHandle;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, new UserDaoInvocationHandle());
        userDao.query();
    }
}
