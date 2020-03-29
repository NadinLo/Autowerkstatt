package com.company;

public interface IFuel {
    boolean hasMyFuel(Fuel fuel);
    Location getLocation();
    void goFuel(Car car);
    double getPriceToPay ();
    void addLineToReceipt(String serviceProvided, double price);
    void printBill();
}
