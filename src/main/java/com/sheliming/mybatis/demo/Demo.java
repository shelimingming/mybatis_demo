package com.sheliming.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("zhangsan");
        user.setBirth(new Date());

        InputStream is = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("saveUser",user);
        sqlSession.commit();
        sqlSession.close();

    }
}
