package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("VW", 30, Fuel.BENZINE, 6, 50);
        car.carDrives(50);
        car.goToFuelStation(new FuelStation());
    }
}
