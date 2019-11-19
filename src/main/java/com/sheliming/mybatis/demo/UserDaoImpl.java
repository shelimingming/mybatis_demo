package com.sheliming.mybatis.demo;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao{
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(String id) {
        return this.sqlSession.selectOne("com.sheliming.dao.queryUserById", id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("com.sheliming.dao.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        this.sqlSession.insert("com.sheliming.dao.insertUser", user);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("com.sheliming.dao.updateUser", user);
    }

    @Override
    public void deleteUser(String id) {
        this.sqlSession.delete("com.sheliming.dao.deleteUser", id);
    }

}
