package com.sheliming.mybatis.proxy.demo.serviceImpl;


import com.sheliming.mybatis.proxy.demo.service.BaseService;

public class Dog implements BaseService {

	@Override
	public void eat() {
	   System.out.println("啃骨头");
	}

	@Override
	public void wc() {
		 System.out.println("三腿立");

	}

}
