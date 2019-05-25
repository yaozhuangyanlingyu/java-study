package com.hello.spring.factory;

import com.hello.spring.pojo.Person;

public class PersonFactory {

	// 静态工厂创建Person对象
	public static Person createPerson( ) {
		return new Person();
	}
}
