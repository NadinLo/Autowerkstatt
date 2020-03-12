package com.company;

import java.text.DecimalFormat;

public class Person {
    String name;
    double wallet;
    Car car;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");


    public Person (String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public void buyCar (Car car){
        this.car = car;
    }
    public void payBill (){
        this.wallet = this.wallet - car.fuelStation.prizeToPay;
        System.out.println("You have still " + decimalFormat.format(this.wallet) + " cash in your Wallet");
    }
}
