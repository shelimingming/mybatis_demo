package com.sheliming.mybatis.my;

import com.sheliming.mybatis.my.anno.Select;
import com.sheliming.mybatis.my.dao.UserDao;
import com.sheliming.mybatis.my.invoke.DefaultSqlSession;
import com.sheliming.mybatis.my.invoke.UserDaoInvocationHandle;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 自己写的山寨版mybatis+spring
 */
public class Test {
    public static void main(String[] args) {
        init();
        System.out.println(map);

        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(),
                new Class[]{UserDao.class}, new UserDaoInvocationHandle(new DefaultSqlSession()));
        userDao.query();
    }

    public static Map<String ,String > map = new HashMap<String,String>();

    public static void init() {
        try {
            Class clazz = Class.forName("com.sheliming.mybatis.my.dao.UserDao");
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method:declaredMethods) {
                if(method.isAnnotationPresent(Select.class)) {
                    Select select = method.getAnnotation(Select.class);
                    map.put(method.getDeclaringClass().getName()+"."+ method.getName(),select.value());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
