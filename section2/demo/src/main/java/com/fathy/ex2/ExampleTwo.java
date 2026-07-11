package com.fathy.ex2;


import com.fathy.ex2.beans.Vehicle;
import com.fathy.ex2.config.AnotherProjectConfig;
import com.fathy.ex2.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleTwo {

	static void main() {


//		var context = new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherProjectConfig.class);
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var veh  = context.getBean("teslaVehicle", Vehicle.class);
		System.out.println("Vehicle name from spring context is: "+veh.getName());

		var vehicle  = (Vehicle) context.getBean("hondaVehicle");
		System.out.println("Vehicle name from spring context is: "+vehicle.getName());

		var vhcle = context.getBean(Vehicle.class);
		System.out.println("Vehicle name from spring context is: "+vhcle.getName());

		var helloWorld = context.getBean(String.class);
		System.out.println("String value from spring context is: "+helloWorld);

	}

}
