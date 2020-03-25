package com.company;

import java.text.DecimalFormat;

public class FuelStation extends EnergySupply {

    public FuelStation(Company company, Location location, FuelPrice[] fuels) {
        super(company, location);
        this.fuels = fuels;
    }

    @Override
    public void printBill(double refillCapacity, double fuelPrice, Car car) {
        super.printBill(refillCapacity, fuelPrice, car);
        System.out.println("Bill----------------\n" +
                "Amount: " + decimalFormat.format(refillCapacity) + "\n" +
                "refueled with " + car.drivesWith + "\n" +
                "Price per liter: " + fuelPrice + "\n" +
                "Bill to pay: " + decimalFormat.format(this.priceToPay));
    }
}
