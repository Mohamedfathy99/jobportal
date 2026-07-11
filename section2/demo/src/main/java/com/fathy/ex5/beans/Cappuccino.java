package com.fathy.ex5.beans;

import org.springframework.stereotype.Component;

@Component("cappuccino")
public class Cappuccino implements Coffee  {

    @Override
    public String makeCoffee() {
        return "Making a delicious cappuccino!";
    }
}
