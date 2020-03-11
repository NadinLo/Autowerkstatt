package com.company;

public class Car {
    String brand;
    int horsepower;
    int mileage;
    int kilometerToService;
    int fuelGauge;

    public Car (String brand, int horsepower){
        this.brand = brand;
        this.horsepower = horsepower;
        this.mileage = 0;
        this.kilometerToService = 6000;
        this.fuelGauge = 100;
    }

    public void carDrives (){

    }
}
