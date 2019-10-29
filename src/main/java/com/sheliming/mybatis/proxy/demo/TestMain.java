package com.sheliming.mybatis.proxy.demo;

import com.sheliming.mybatis.proxy.demo.service.BaseService;
import com.sheliming.mybatis.proxy.demo.serviceImpl.Dog;
import com.sheliming.mybatis.proxy.demo.serviceImpl.Person;
import com.sheliming.mybatis.proxy.demo.util.ProxyFactory;

public class TestMain {

	public static void main(String[] args) throws Exception {
	   
		//mike.eat();
		//Person mike = new Person();
        BaseService dog= ProxyFactory.Builder(Dog.class);
        dog.eat();//专门负责监控mike的代理对象
        
        BaseService mike= ProxyFactory.Builder(Person.class);
        mike.eat();
       
	}

}
