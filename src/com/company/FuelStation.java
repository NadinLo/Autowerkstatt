package com.company;

import java.text.DecimalFormat;

public class FuelStation extends EnergySupply {

    public FuelStation(Company company, Location location, FuelPrice[] fuels) {
        super(company, location);
        this.fuels = fuels;
    }
}
