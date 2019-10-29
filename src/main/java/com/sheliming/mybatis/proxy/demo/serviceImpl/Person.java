package com.sheliming.mybatis.proxy.demo.serviceImpl;


import com.sheliming.mybatis.proxy.demo.service.BaseService;

public class Person implements BaseService {

	@Override
	public void eat() {//主要业务，代理模式要求开发人员只关心主要业务
	
        System.out.println("使用筷子吃饭....");
	}

	@Override
	public void wc() {
		   System.out.println("测试地球重力是否存在");

	}

}
