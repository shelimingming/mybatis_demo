package com.sheliming.mybatis.my.dao;


import com.sheliming.mybatis.my.anno.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from user where id=1")
    public List<Map<String,Object>> query();
}
