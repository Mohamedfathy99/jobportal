package com.fathy.ex5;


import com.fathy.ex5.beans.Coffee;
import com.fathy.ex5.beans.CoffeeShop;
import com.fathy.ex5.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleFive {

	static void main() {


		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var coffeeShop = context.getBean(CoffeeShop.class);
		Coffee coffee = coffeeShop.getCoffee();
		System.out.println(coffee.makeCoffee());

	}

}
