package com.company;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Nadin", 200);
        person.buyCar(new Car("VW", 30, Fuel.BENZINE, 6, 30));
        person.car.carDrives(50);
        person.car.carDrives(100);
        person.car.goToFuelStation(new FuelStation());
        person.payBill();
    }
}
