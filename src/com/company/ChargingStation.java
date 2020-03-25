package com.company;

public class ChargingStation extends EnergySupply {
    public ChargingStation(Company company, Location location, double price) {
        super(company, location);
        this.fuels = new FuelPrice[]{new FuelPrice(Fuel.ELECTRICITY, price)};

    }

    @Override
    public void printBill(double refillCapacity, double fuelPrice, Car car) {
        super.printBill(refillCapacity, fuelPrice, car);
        System.out.println("Bill----------------\n" +
                "Amount: " + decimalFormat.format(refillCapacity) + "\n" +
                "charged with " + car.drivesWith + "\n" +
                "Price per kwh: " + fuelPrice + "\n" +
                "Bill to pay: " + decimalFormat.format(this.priceToPay));
    }
}
