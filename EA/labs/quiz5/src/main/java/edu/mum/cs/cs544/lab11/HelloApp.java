package edu.mum.cs.cs544.lab11;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("Testing Spring Startup");
		ClassA classA = context.getBean("classA", ClassA.class);
		classA.showText();
		context.close();
	}
}
