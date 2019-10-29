package com.sheliming.mybatis.kaikeba.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;



public class SqlSessionFactory {
	
	public static SqlSession build(Class classFile) throws InstantiationException, IllegalAccessException{
		
		 //1.创建本次被监控的实例对象  SqlSession dao = new DeptDao()
		 SqlSession dao= (SqlSession) classFile.newInstance();
		 //2.创建本次负责监控的实例对象
		 InvocationHandler agent= new Agent(dao);
		 //3.向JVM发送监控申请,此时JVM返回[资源调度器]假扮(dao)
		 SqlSession dao_False= (SqlSession) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), agent);
		 
		 return dao_False;
	}

}
