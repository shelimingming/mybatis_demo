package com.sheliming.mybatis.proxy.mybatis;

import com.sheliming.mybatis.proxy.mybatis.service.SqlSession;
import com.sheliming.mybatis.proxy.mybatis.serviceImpl.DeptMapper;
import com.sheliming.mybatis.proxy.mybatis.util.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) throws Exception {
	   
		Map StatementMapper = new HashMap();
	    StatementMapper.put("dept.save", "insert into user values(50,'TEST','2018-10-21')");
		
		SqlSession dao =   SqlSessionFactory.Builder(DeptMapper.class);
		dao.save((String)StatementMapper.get("dept.save"));
	}

}
