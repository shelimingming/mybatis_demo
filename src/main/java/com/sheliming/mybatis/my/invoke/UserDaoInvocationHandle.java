package com.sheliming.mybatis.my.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserDaoInvocationHandle implements InvocationHandler {

    private DefaultSqlSession  defaultSqlSession;

    public UserDaoInvocationHandle(DefaultSqlSession defaultSqlSession) {
        this.defaultSqlSession = defaultSqlSession;
    }

    public UserDaoInvocationHandle() {
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("userDao InvocationHandler enter");
        defaultSqlSession.selectList();
        return null;
    }
}
