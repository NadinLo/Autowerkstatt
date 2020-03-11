package com.company;

public class Car {
    String brand;
    int horsepower;
    int fuelConsumptionEvery100Km;
    int mileage;
    int kilometerToService;
    int fuelMax;
    int fuelGauge;

    public Car (String brand, int horsepower, int fuelConsumptionEvery100Km, int fuelMax){
        this.brand = brand;
        this.horsepower = horsepower;
        this.fuelConsumptionEvery100Km = fuelConsumptionEvery100Km;
        this.mileage = 0;
        this.kilometerToService = 6000;
        this.fuelMax = fuelMax;
        this.fuelGauge = this.fuelMax;
    }

    public void carDrives (int distance) {
        boolean isDrivingAlowed = carCheck(distance);
        if (isDrivingAlowed) {
            this.mileage = this.mileage + distance;
            this.kilometerToService = this.kilometerToService - distance;
            this.fuelGauge = this.fuelMax - (this.fuelConsumptionEvery100Km/100 * distance);
        }
        else {
            System.out.println("Got to the next Fuel Station. You're lucky. The next one is just 2 km away.");
            carDrives(2);
            //todo: goToFuelStation();

        }
    }
    public boolean carCheck(int distance){
        if(this.kilometerToService - distance <= 10){
            System.out.println("Watch out! You shouldn't drive so far without going to the car service station");
            return false;
        }
        if(this.fuelGauge <= this.fuelConsumptionEvery100Km/2){
            System.out.println("Watch out! You should go to the fuel station during the next 50km");
            return false;
        }
        else {
            return true;
        }
    }
}