package com.company;

import java.text.DecimalFormat;

public class FuelStation {
    double prizeBenzine;
    double prizeDiesel;
    double refillCapacity;
    double prizeToPay;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");



    public FuelStation() {
        this.prizeBenzine = 1.24;
        this.prizeDiesel = 1.15;

    }

    public void refuel(Car car) {
        refillCapacity = car.fuelMax - car.fuelGauge;
        if (car.drivesWith == Fuel.BENZINE) {
            prizeToPay = refillCapacity * prizeBenzine;

        } else {
            prizeToPay = refillCapacity * prizeDiesel;
        }
        car.fuelStation.receiveBill(refillCapacity, car);

    }

    public void receiveBill(double refillCapacity, Car car) {
        System.out.println("Bill----------------\n" +
                "Capacity of refilled fuel in liter: " + decimalFormat.format(refillCapacity) + "\n" +
                "refuelled with " + car.drivesWith + "\n" +
                "Bill to pay: " + decimalFormat.format(this.prizeToPay));

    }

}
