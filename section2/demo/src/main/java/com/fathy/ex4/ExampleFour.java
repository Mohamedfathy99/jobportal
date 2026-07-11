package com.fathy.ex4;


import com.fathy.ex4.beans.Car;
import com.fathy.ex4.beans.Engine;
import com.fathy.ex4.beans.Person;
import com.fathy.ex4.beans.Vehicle;
import com.fathy.ex4.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleFour {

	static void main() {


		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var person  = context.getBean(Person.class);
		var vehicle  = context.getBean(Vehicle.class);
		System.out.println("Person name from Spring Context is: " + person.getName());
		System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());
		System.out.println("Vehicle that person own is: " + person.getVehicle());

		var car  = context.getBean(Car.class);
		var engine  = context.getBean(Engine.class);
		System.out.println("Car name from Spring Context is: " + car.getName());
		System.out.println("Engine name from Spring Context is: " + engine.getName());
		System.out.println("engine that car has is: " + car.getEngine());
	}

}
