package com.fathy.demo.config;

import com.fathy.demo.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Spring @Configuration annotation is part of the spring core framework
Spring configuration annotation indicates that the class has @Bean definition methods.
So Spring container can process the class and generate Spring Beans to be used in the application.
 */

@Configuration
public class ProjectConfig {

    /*
    @Bean annotation, which lets spring know that it needs to call this method
     when it initializes its context and adds the returned value to the context
     */

    @Bean
     Vehicle vehicle(){
         var veh = new Vehicle();
         veh.setName("Tesla");
         return veh;
     }

     @Bean
    String hello(){
        return "Hello World";
     }

     @Bean
    Integer number(){
        return 27;
     }

}
