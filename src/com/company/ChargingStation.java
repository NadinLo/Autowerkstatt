package com.company;

public class ChargingStation extends EnergySupply {
    public ChargingStation(Company company, Location location, double price) {
        super(company, location);
        this.fuels = new FuelPrice[]{new FuelPrice(Fuel.ELECTRICITY, price)};

    }
}
