package com.company;

import java.text.DecimalFormat;

public class FuelStation implements IFuel {
    Company company;
    Location location;
    FuelPrice[] fuels;

    double refillCapacity;
    double priceToPay;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");

    public FuelStation(Company company, Location location, FuelPrice[] fuels) {
        this.company = company;
        this.location = location;
        this.fuels = fuels;
    }

    @Override
    public boolean hasMyFuel(Fuel fuel) {
        boolean hasMyFuel = false;
        for (FuelPrice fuel1 : fuels) {
            if (fuel1.fuel == fuel) {
                hasMyFuel = true;
                break;
            }
        }
        return hasMyFuel;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public void goFuel(Car car) {
        this.refillCapacity = car.fuelMax - car.tank;
        double fuelPrice = 0;
        for (FuelPrice fuel: fuels) {
            if(fuel.fuel == car.drivesWith){
                fuelPrice = fuel.price;
            }
        }
        this.priceToPay = this.refillCapacity * fuelPrice;
        car.tank = car.fuelMax;
        printBill(this.refillCapacity, fuelPrice, car);
    }

    @Override
    public double getPriceToPay() {
        return this.priceToPay;
    }

    public void printBill(double refillCapacity, double fuelPrice, Car car) {
        System.out.println("Bill----------------\n" +
                "Capacity of refilled fuel in liter: " + decimalFormat.format(refillCapacity) + "\n" +
                "refuelled with " + car.drivesWith + "\n" +
                "Price per liter fuel: " + fuelPrice + "\n" +
                "Bill to pay: " + decimalFormat.format(this.priceToPay));

    }
}
