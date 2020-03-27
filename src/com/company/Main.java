package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Nadin", 200);
        ServiceStation myServiceStation = new ServiceStation(Location.BLUDENZ, "Lieblingswerkstatt");

        person.buyCar(new Car("VW", Fuel.BENZINE,6, 40, TyreType.SUMMER_TYRE));
        person.car.setLocation(Location.BREGENZ);
        IFuel[] fuelStations = new IFuel[90];
        newFuelStation(fuelStations);

        person.car.drives(Location.DORNBIRN, 12);
        person.car.drives(Location.BLUDENZ, 44.5);
        person.refuel(fuelStations);
        person.askForReceipt(person.myEnergySupply);
        person.payBill();

        person.goToService(myServiceStation);
        person.changeTyres(myServiceStation, TyreType.WINTER_TYRE);
        person.askForReceipt(myServiceStation);
        person.payBill();


    }

    private static void newFuelStation(IFuel[] fuelStations) {
        fuelStations[0] = new FuelStation (Company.OMV, Location.BREGENZ,
                new FuelPrice[] {
                        new FuelPrice (Fuel.BENZINE, 1.25),
                        new FuelPrice (Fuel.DIESEL, 1.19)
                });
        fuelStations[1] = new FuelStation (Company.SHELL, Location.DORNBIRN,
                new FuelPrice[] {
                        new FuelPrice(Fuel.DIESEL, 1.08),
                        new FuelPrice(Fuel.BENZINE, 1.29),
                        new FuelPrice(Fuel.ELECTRICITY, 0.98)
                });
        fuelStations[2] = new FuelStation(Company.AGIP, Location.BLUDENZ,
                new FuelPrice[]{
                        new FuelPrice(Fuel.BENZINE, 1.31),
                        new FuelPrice(Fuel.DIESEL, 1.32),
                        new FuelPrice(Fuel.GAS, 0.78)
                });
        fuelStations[3] = new ChargingStation(Company.VKW, Location.LUSTENAU, 0.47);
    }
}
