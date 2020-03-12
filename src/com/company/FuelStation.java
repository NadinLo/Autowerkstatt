package com.company;

public class FuelStation {
    double prizeBenzine;
    double prizeDiesel;
    Fuel type;
    double refillCapacity;
    double prizeToPay;


    public FuelStation() {
        this.prizeBenzine = 1.24;
        this.prizeDiesel = 1.15;

    }

    public void refuel (Car car){
        refillCapacity = car.fuelMax - car.fuelGauge;
        if(car.drivesWith == Fuel.BENZINE){
            prizeToPay = refillCapacity*prizeBenzine;
        } else {
            prizeToPay = refillCapacity*prizeDiesel;
        }
    }

}
