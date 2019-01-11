package com.sheliming.mybatis.demo.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from user where id=1")
    public List<Map<String,Object>> query();
}
