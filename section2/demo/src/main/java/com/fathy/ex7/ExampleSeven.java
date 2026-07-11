package com.fathy.ex7;

import com.fathy.ex7.beans.MyService;
import com.fathy.ex7.beans.UserSession;
import com.fathy.ex7.config.ProjectScopeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleSeven {

    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectScopeConfig.class);
        var myService1 = context.getBean(MyService.class);
        var myService2 = context.getBean(MyService.class);
        System.out.println("myService1:  " + myService1.hashCode());
        System.out.println("myService2: " + myService2.hashCode());
        System.out.println("myService1 == myService2: " + (myService1 == myService2));


        var userSession1 = context.getBean(UserSession.class);
        var userSession2 = context.getBean(UserSession.class);
        System.out.println("userSession1:  " + userSession1.hashCode());
        System.out.println("userSession2: " + userSession2.hashCode());
        System.out.println("userSession1:  " + userSession1.getSessionId());
        System.out.println("userSession2: " + userSession2.getSessionId());
        System.out.println("userSession1 == userSession2: " + (userSession1 == userSession2));
    }
}
