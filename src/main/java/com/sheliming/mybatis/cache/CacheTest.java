package com.sheliming.mybatis.cache;

import com.sheliming.mybatis.demo.User;
import com.sheliming.mybatis.demo2.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class CacheTest {
    public SqlSessionFactory sqlSessionFactory;
    public UserMapper userMapper;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 在mybatis中，一级缓存默认是开启的，并且一直无法关闭
     *
     * 一级缓存满足条件：
     * 1、同一个session中
     * 2、相同的SQL和参数
     *
     * mybatis的一级缓存在spring中失效
     * 因为Spring中session的创建交给spring的SQLSessionFactory，session使用完就删除了
     */
    @Test
    public void testOneCache() {
        System.out.println(this.userMapper.queryUserById("1"));
        System.out.println(this.userMapper.queryUserById("1"));
    }
    /**
     * 使用：sqlSession.clearCache();可以强制清除缓存
     */
    @Test
    public void testOneCache2() {
        System.out.println(this.userMapper.queryUserById("1"));
        sqlSession.clearCache();
        System.out.println(this.userMapper.queryUserById("1"));
    }


    /**
     * 执行update、insert、delete的时候，会清空缓存
     */
    @Test
    public void testOneCache3() {
        System.out.println(this.userMapper.queryUserById("1"));
        //sqlSession.clearCache();

        User user=new User();
        user.setName("美女");
        user.setId(1);
        userMapper.updateUser(user);

        System.out.println(this.userMapper.queryUserById("1"));
    }

    /**
     * mybatis 的二级缓存的作用域是一个mapper的namespace ，同一个namespace中查询sql可以从缓存中命中。
     */
    @Test
    public void testCache() {
        System.out.println(this.userMapper.queryUserById("1"));

        sqlSession.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.queryUserById("1"));
    }
}
