package com.hello.spring.factory;

import com.hello.spring.pojo.Person;

public class PersonFactory {

	// 静态工厂创建Person对象
	public static Person createPerson1( ) {
		System.out.println("PersonFactory - 静态工厂创建Person");
		return new Person();
	}

	// 实例工厂创建Person
	public Person createPerson2() {
		System.out.println("PersonFactory - 实例创建Person");
		return new Person();
	}
}
