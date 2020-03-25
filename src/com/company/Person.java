package com.company;

import java.text.DecimalFormat;

public class Person {
    String name;
    double wallet;
    double toPay;
    Car car;
    Tyre[] storage = new Tyre[4];
    DecimalFormat decimalFormat = new DecimalFormat("##.##");

    public Person(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public void buyCar(Car car) {
        this.car = car;
    }

    public void refuel (IFuel[] fuelStations){
        for (IFuel fuel: fuelStations) {
            if (fuel != null) {
                if (fuel.hasMyFuel(this.car.drivesWith) && fuel.getLocation() == this.car.location) {
                    fuel.goFuel(this.car);
                    this.toPay = fuel.getPriceToPay();
                    break;
                }
            }
        }
    }

    public void goToService (ServiceStation serviceStation){
        toPay = serviceStation.doService(this.car);
    }

    public void changeTyres (ServiceStation serviceStation, TyreType tyreType){
        toPay = serviceStation.changeTyres(this.storage, tyreType, this.car);
    }

    public void payBill() {
        this.wallet = this.wallet - this.toPay;
        this.toPay = 0;
        System.out.println("You have still " + decimalFormat.format(this.wallet) + " cash in your Wallet");
    }


}
