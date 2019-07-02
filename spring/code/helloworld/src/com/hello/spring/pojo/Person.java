package com.hello.spring.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

	private String name;
	private Integer age;
	private Car car;
	
	// 复杂类型
	private Object[] carts;				// 数组类型的注入
	private List list;					// list类型注入
	private Set set;					// set类型注入
	private Map map;					// map类型注入
	private Properties properties;		// properties类型的注入

	public Object[] getCarts() {
		return carts;
	}

	public void setCarts(Object[] carts) {
		this.carts = carts;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Person() {
		super();
		System.out.println("Person - 构造方法被调用了");
	}
	
	public void init() {
		System.out.println("Person - 我是初始化方法");
	}
	
	public void destroy() {
		System.out.println("Person - 我是销毁方法");
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
		return "Person [name=" + name + ", age=" + age + ", car=" + car + ", carts=" + Arrays.toString(carts)
				+ ", list=" + list + ", set=" + set + ", map=" + map + ", properties=" + properties + ", getCarts()="
				+ Arrays.toString(getCarts()) + ", getList()=" + getList() + ", getSet()=" + getSet() + ", getMap()="
				+ getMap() + ", getProperties()=" + getProperties() + ", getCar()=" + getCar() + ", getName()="
				+ getName() + ", getAge()=" + getAge() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
