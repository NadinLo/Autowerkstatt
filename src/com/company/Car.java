package com.company;

import java.text.DecimalFormat;

public class Car {
    String brand;
    double fuelConsumptionEvery100Km;       // in Liter
    double mileage;
    double kilometerToService;
    double fuelMax;                            // in Liter
    double tank;
    Fuel drivesWith;
    double consumptionLastDrive;
    Location location;
    DecimalFormat df = new DecimalFormat("###.##");

    public Car (String brand, Fuel drivesWith, double fuelConsumptionEvery100Km, int fuelMax){
        this.brand = brand;
        this.drivesWith = drivesWith;
        this.fuelConsumptionEvery100Km = fuelConsumptionEvery100Km;
        this.mileage = 0;
        this.kilometerToService = 6000;
        this.fuelMax = fuelMax;
        this.tank = this.fuelMax;

    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void drives (Location location, double distance) {
        boolean isDrivingAllowed = carCheck(distance);
        if (isDrivingAllowed) {
            this.mileage = this.mileage + distance;
            this.kilometerToService = this.kilometerToService - distance;
            this.consumptionLastDrive = (this.fuelConsumptionEvery100Km/100 * distance);
            this.tank = this.tank - this.consumptionLastDrive;
            this.location = location;
            this.printCarStatus();
        }
        else {
            System.out.println("Go to the next Fuel Station.");
        }
    }

    public boolean carCheck(double distance){
        if(this.kilometerToService - distance <= 50){
            System.out.println("Watch out! Your car needs a service");
            return true;
        }
        if(this.tank <= this.fuelConsumptionEvery100Km / 100 * distance){
            System.out.println("Watch out! You can't drive this distance with this tank.\n" +
                    "possible longest distance: " + 100 / fuelConsumptionEvery100Km*tank + " km");
            return false;
        }
        else {
            return true;
        }
    }


    public void printCarStatus (){
        System.out.println("current Status:\n" +
                "----------------------------------\n" +
                "fuel gauge in liter: " + df.format(this.tank) + "\n" +
                "consumption last drive: " + df.format(consumptionLastDrive) + "\n" +
                "mileage in km: " + df.format(this.mileage) + "\n" +
                "km to service: " + df.format(this.kilometerToService) + "\n" +
                "----------------------------------");

    }
}
