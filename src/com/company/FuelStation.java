package com.company;

public class FuelStation {
    double prizeBenzine;
    double prizeDiesel;
    Fuel type;
    double refillCapacity;
    double prizeToPay;
    Car car;
    String bill;


    public FuelStation() {
        this.prizeBenzine = 1.24;
        this.prizeDiesel = 1.15;

    }

    public void refuel(Car car) {
        refillCapacity = car.fuelMax - car.fuelGauge;
        if (car.drivesWith == Fuel.BENZINE) {
            prizeToPay = refillCapacity * prizeBenzine;
            car.fuelStation.receiveBill(refillCapacity, car);

        } else {
            prizeToPay = refillCapacity * prizeDiesel;
            car.fuelStation.receiveBill(refillCapacity, car);
        }

    }

    public void receiveBill(double refillCapacity, Car car) {
        System.out.println("Bill----------------\n" +
                "Capacity of rifilled fuel in liter: " + refillCapacity + "\n" +
                "refuelled with " + car.drivesWith + "\n" +
                "Bill to pay: " + this.prizeToPay);

    }

}
