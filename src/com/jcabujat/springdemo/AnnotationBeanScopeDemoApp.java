package com.jcabujat.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same object
		boolean result = (theCoach == alphaCoach);
		
		// print the result
		System.out.println("Pointing to the same object: " + result);
		System.out.println("theCoach   -> " + theCoach);
		System.out.println("alphaCoach -> " + alphaCoach);
		
		// close the context
		context.close();
		

	}

}
