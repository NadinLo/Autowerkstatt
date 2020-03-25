package com.company;

public class ServiceStation implements IService{
    Location location;
    String name;
    double toPay;

    public ServiceStation (Location location, String name){
        this.location = location;
        this.name = name;
    }

    @Override
    public double changeTyres(Tyre[] storage, TyreType tyreType, Car car) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = car.setOfTyres[i];
                car.setOfTyres[i] = new Tyre(tyreType);
                this.toPay = this.toPay + 100;
            }
            else if (storage[i].tyreType == tyreType){
                Tyre x = car.setOfTyres[i];
                car.setOfTyres[i] = storage[i];
                storage[i] = x;
                this.toPay = this.toPay + 25;
            }
        }
        return this.toPay;
    }

    @Override
    public double doService(Car car) {
        car.kilometerToService = 0;
        return 300;
    }
}
