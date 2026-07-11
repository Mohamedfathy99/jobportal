package com.fathy.ex2.config;

import com.fathy.ex2.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
Spring @Configuration annotation is part of the spring core framework
Spring configuration annotation indicates that the class has @Bean definition methods.
So Spring container can process the class and generate Spring Beans to be used in the application.
 */

@Configuration
@Import({AnotherProjectConfig.class})
public class ProjectConfig {

    /*
    @Bean annotation, which lets spring know that it needs to call this method
     when it initializes its context and adds the returned value to the context
     */

    @Bean(name = "teslaVehicle")
    Vehicle vehicle1(){
         var veh = new Vehicle();
         veh.setName("Tesla");
         return veh;
     }

    @Bean(value = "audiVehicle")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Primary
    @Bean({"hondaVehicle", "honda", "favouriteVehicle"})
    @Description("This is the Vehicle class bean")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }



}
