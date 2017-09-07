package com.rico.spring4.ioc;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTester {

	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() {

		if (null != context) {
			context = null;
		}
	}

	@Test
	public void testHello() {
		HelloWorld hello = new HelloWorld();
		hello.setName("World");
		hello.hello();
	}

	@Test
	public void testHelloWorld2() {
		// HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");

		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.hello();
	}
}
