package com.fathy.ex1;


import com.fathy.ex1.beans.Vehicle;
import com.fathy.ex1.ex1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleOne {

	static void main() {


		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var veh  = context.getBean("vehicle1",Vehicle.class);
		System.out.println("Vehicle name from spring context is: "+veh.getName());

		var vehicle  = (Vehicle) context.getBean("vehicle2");
		System.out.println("Vehicle name from spring context is: "+vehicle.getName());



	}

}
