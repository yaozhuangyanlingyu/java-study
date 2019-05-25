package com.hello.spring.pojo;

public class Car {
	private String name;
	private String Color;

	public Car() {
		super();
		System.out.println("Car - 类构造方法被调用了");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", Color=" + Color + "]";
	}
}
