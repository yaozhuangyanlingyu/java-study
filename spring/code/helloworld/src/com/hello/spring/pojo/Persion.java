package com.hello.spring.pojo;

public class Persion {

	private String name;
	private Integer age;
	
	public Persion() {
		super();
		System.out.println("���췽����������");
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