package com.fathy.ex6.beans;

public class Bike {

    private String name;

    public Bike() {
        System.out.println("Bike bean created by spring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                '}';
    }

}
