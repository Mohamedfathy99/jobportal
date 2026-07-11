package com.fathy.demo;


import com.fathy.demo.beans.Vehicle;
import com.fathy.demo.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {

    static void main() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Audi");
		System.out.println("Vehicle name from non-spring context is: "+vehicle.getName());

		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var veh  = context.getBean(Vehicle.class);
		System.out.println("Vehicle name from spring context is: "+veh.getName());

		/*
			We don't need to do any explicit casting while fetching a bean from context.
			Spring is smart enough to look for a bean of the type your requested in its context
			If such a bean doesn't exist, Spring will throw an exception
		 */

		String hello = context.getBean(String.class);
		System.out.println("String value from Spring context is: "+hello);

		Integer number = context.getBean(Integer.class);
		System.out.println("Integer value from Spring context is: "+number);

		// Using name of the bean method 
		String helloWorld = (String) context.getBean("hello");
		System.out.println("String value from Spring context is: "+ helloWorld);
//		context.getBean(Double.class);
	}

}
