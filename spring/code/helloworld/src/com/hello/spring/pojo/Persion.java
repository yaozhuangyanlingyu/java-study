package com.hello.spring.pojo;

public class Persion {

	private String name;
	private Integer age;
	
	public Persion() {
		super();
		System.out.println("构造方法被调用了");
	}
	
	public void init() {
		System.out.println("我是初始化方法");
	}
	
	public void destroy() {
		System.out.println("我是销毁方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + "]";
	}
}
