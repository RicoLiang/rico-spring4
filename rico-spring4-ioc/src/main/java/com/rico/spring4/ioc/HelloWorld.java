package com.rico.spring4.ioc;

public class HelloWorld {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void hello() {
		System.out.println("Hello " + this.name);
	}
}
