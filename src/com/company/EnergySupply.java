package com.company;

import java.text.DecimalFormat;

public  class EnergySupply implements IFuel{
    Company company;
    Location location;
    FuelPrice[] fuels;

    double refillCapacity;
    double priceToPay;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");

    public EnergySupply(Company company, Location location) {
        this.company = company;
        this.location = location;
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
                "Amount: " + decimalFormat.format(refillCapacity) + "\n" +
                "[...] with " + car.drivesWith + "\n" +                     // charged / refilled with
                "Price [...]: " + fuelPrice + "\n" +                        //per liter / kwh
                "Bill to pay: " + decimalFormat.format(this.priceToPay));

    }

}
