package com.company;

import java.text.DecimalFormat;

public class Person {
    String name;
    double wallet;
    double toPay;
    Car car;
    Tyre[] storage = new Tyre[4];
    IFuel myEnergySupply;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");

    public Person(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public void buyCar(Car car) {
        this.car = car;
    }

    public void refuel (IFuel[] fuelStations){
        int i;
        for (i = 0; i < fuelStations.length; i++){
            if (fuelStations[i] != null) {
                if (fuelStations[i].hasMyFuel(this.car.drivesWith) && fuelStations[i].getLocation() == this.car.location) {
                    fuelStations[i].goFuel(this.car);
                    this.toPay = fuelStations[i].getPriceToPay();
                    break;
                }
            }
        }
        this.myEnergySupply = fuelStations[i];
    }

    public void goToService (ServiceStation serviceStation){
        toPay = serviceStation.doService(this.car);
    }

    public void changeTyres (ServiceStation serviceStation, TyreType tyreType){
        toPay = toPay + serviceStation.changeTyres(this.storage, tyreType, this.car);
    }

    public void askForReceipt (ServiceStation serviceStation){
        serviceStation.printBill();
        payBill();
    }

    public void askForReceipt (IFuel myEnergySupply){
        myEnergySupply.printBill();
        payBill();
    }

    public void payBill() {
        this.wallet = this.wallet - this.toPay;
        this.toPay = 0;
        System.out.println("You have still " + decimalFormat.format(this.wallet) + " cash in your Wallet");
    }


}
