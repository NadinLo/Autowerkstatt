package com.company;

public class Person {
    String name;
    double wallet;
    Car car;

    public Person (String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public void buyCar (Car car){
        this.car = car;
    }
}
