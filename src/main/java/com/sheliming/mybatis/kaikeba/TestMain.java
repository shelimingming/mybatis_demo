package com.sheliming.mybatis.kaikeba;

import com.sheliming.mybatis.kaikeba.beans.Dept;
import com.sheliming.mybatis.kaikeba.util.DefaultSqlSession;
import com.sheliming.mybatis.kaikeba.util.SqlSession;
import com.sheliming.mybatis.kaikeba.util.SqlSessionFactory;

public class TestMain {

	public static void main(String[] args) throws Exception {
		
		 Dept dept = new Dept();
		 dept.setDeptNo(34);
		 dept.setDname("社保事业部");
		 dept.setLoc("北京");
		 
		 SqlSession session= SqlSessionFactory.build(DefaultSqlSession.class);
	     session.save(dept);
	}

}
