package com.company;

public interface IService {
    double changeTyres(Tyre[] storage, TyreType tyreType, Car car);
    double doService(Car car);
    void printBill ();
    void addLineToReceipt(String serviceProvided, double price);


}
