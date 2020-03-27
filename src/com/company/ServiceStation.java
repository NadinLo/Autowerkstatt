package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceStation implements IService{
    Location location;
    String name;
    double toPay;

    String lineOnReceipt = "---------------";                   //15 Chars
    ArrayList<String> linesOnReceipt = new ArrayList<>();

    public ServiceStation (Location location, String name) {
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
                addLineToReceipt("new Tyre. " + tyreType.toString(), 100.00);
            }
            else if (storage[i].tyreType == tyreType){
                Tyre x = car.setOfTyres[i];
                car.setOfTyres[i] = storage[i];
                storage[i] = x;
                this.toPay = this.toPay + 25;
                addLineToReceipt("change Tyre", 25.00);
            }
        }
        return this.toPay;
    }

    @Override
    public double doService(Car car) {
        car.kilometerToService = 0;
        this.toPay = this.toPay + 300;
        addLineToReceipt("Service", 300.00);
        return this.toPay;
    }

    public void addLineToReceipt(String serviceProvided, double price) {
        char[]lineOnReceiptChar = lineOnReceipt.toCharArray();
        int endIndex = Math.min(serviceProvided.length(), lineOnReceiptChar.length); //mind.Länge von serviceProvided, aber max.Länge von lineOnReceipt
        char[]serviceProvidedChar = serviceProvided.substring(0, endIndex).toCharArray(); //serviceProvided evtl.kürzen

        for (int i = 0; i < serviceProvidedChar.length && i < lineOnReceiptChar.length; i++) { //ersten Chars von lineOnReceipt werden durch serviceProvided ersetzt
            lineOnReceiptChar[i] = serviceProvidedChar[i];
        }
        this.lineOnReceipt = Arrays.toString(lineOnReceiptChar) + price + " €\n";     // durch Preis ergänzt
        this.linesOnReceipt.add(lineOnReceipt);
    }

    @Override
    public void printBill (){
        try {
            File receipt = new File ("C:\\Users\\DCV\\Documents\\Coding\\Java IO\\Texte\\Bill.txt");
            FileWriter myWriter = new FileWriter(receipt);
            myWriter.write("Your receipt\n\n");
            myWriter.write(linesOnReceipt.toString());
            myWriter.write("\n" + lineOnReceipt + toPay + " €");
            myWriter.write("" + name + "\n" + location);
            myWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
