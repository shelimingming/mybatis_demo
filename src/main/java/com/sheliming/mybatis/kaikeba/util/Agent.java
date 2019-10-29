package com.sheliming.mybatis.kaikeba.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Agent implements InvocationHandler {
	
	    Connection con;
	    PreparedStatement ps;
	   //1.声明一个属性,表示具体监控实例对象
          SqlSession dao=null;
          
       //2.声明一个构造方法,从外部获得监控实例对象
          public Agent(SqlSession param){
        	  this.dao = param;
          }
       //3.实现所有的[次要业务] 
          
          private void init()throws Exception{
        	  Class.forName("com.mysql.jdbc.Driver");//1
					  con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis_demo?serverTimezone=UTC&characterEncoding=utf8", "root", "123456");//2
        	  ps = con.prepareStatement("");//3
          }
          
          private void close()throws Exception{
        	  ps.close();
        	  con.close(); //5
          }
          
	// 通知JVM,如何将JDBC[主要业务]与[次要业务绑定]
	/*
	 *   BaseDao  dao = new DeptDaoImpl();
	 *   dao.save()
	 *   资源调度器调用invoke
	 *   
	 *   inovke(资源调度器,save,save方法实参)
	 */
	public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
		
		    //1.JDBC步骤1,2,3
		    init();
		    String sql = SQLUtil.createSaveSql(params[0]);
		    ps.execute(sql);
		    //3.JDBC主要业务 4
		    Object value=method.invoke(dao, params); //dao.save()
		    //4.JDBC 5
		    close();
		return value;
	}

}
