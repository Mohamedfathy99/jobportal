package com.fathy.ex3;


import com.fathy.ex3.beans.Vehicle;
import com.fathy.ex3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleThree {

	static void main() {


		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var veh  = context.getBean(Vehicle.class);
		System.out.println("Vehicle name from spring context is: "+veh.getName());
		veh.sayHello();
		context.close();

	}

}
