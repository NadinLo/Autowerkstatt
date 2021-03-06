package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public  class EnergySupply implements IFuel{
    Company company;
    Location location;
    FuelPrice[] fuels;

    double refillCapacity;
    double priceToPay;
    DecimalFormat decimalFormat = new DecimalFormat("##.##");

    final String stub = "---------------";                   //15 Chars
    String lineOnReceipt = "";
    ArrayList<String> linesOnReceipt = new ArrayList<>();

    public EnergySupply(Company company, Location location) {
        this.company = company;
        this.location = location;
    }

    @Override
    public boolean hasMyFuel(Fuel fuel) {
        boolean hasMyFuel = false;
        for (FuelPrice fuel1 : fuels) {
            if (fuel1.fuel == fuel) {
                hasMyFuel = true;
                break;
            }
        }
        return hasMyFuel;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public void goFuel(Car car) {
        this.refillCapacity = car.fuelMax - car.tank;
        double fuelPrice = 0;
        for (FuelPrice fuel: fuels) {
            if(fuel.fuel == car.drivesWith){
                fuelPrice = fuel.price;
            }
        }
        this.priceToPay = this.priceToPay + (this.refillCapacity * fuelPrice);
        car.tank = car.fuelMax;
        addLineToReceipt("refueld:", refillCapacity);
        addLineToReceipt("" + car.drivesWith, fuelPrice);
    }

    @Override
    public double getPriceToPay() {
        return this.priceToPay;
    }

    @Override
    public void addLineToReceipt(String serviceProvided, double price) {
        String lineOnReceipt = "---------------";                   //15 Chars

        char[]lineOnReceiptChar = lineOnReceipt.toCharArray();
        int endIndex = Math.min(serviceProvided.length(), lineOnReceiptChar.length-2); //mind.Länge von serviceProvided, aber max.Länge von lineOnReceipt -2
        char[]serviceProvidedChar = serviceProvided.substring(0, endIndex).toCharArray(); //serviceProvided evtl.kürzen

        for (int i = 0; i < serviceProvidedChar.length && i < lineOnReceiptChar.length; i++) { //ersten Chars von lineOnReceipt werden durch serviceProvided ersetzt
            lineOnReceiptChar[i] = serviceProvidedChar[i];
        }
        lineOnReceipt = Arrays.toString(lineOnReceiptChar).replace(",", "") + decimalFormat.format(price) + " €\n";     // durch Preis ergänzt
        this.linesOnReceipt.add(lineOnReceipt);
    }

    @Override
    public void printBill() {
        try {
            File receipt = new File ("C:\\Users\\DCV\\Documents\\Coding\\Java IO\\Texte\\Bill_EnergySupply.txt");
            FileWriter myWriter = new FileWriter(receipt);
            myWriter.write("Your receipt\n\n");
            myWriter.write(linesOnReceipt.toString().
                    replace("\n,","\n").
                    replace(" ", "").
                    replace("[", "").
                    replace("]",""));
            myWriter.write("\n" + stub + decimalFormat.format(this.priceToPay) + " €\n");
            myWriter.write(company.toString() + "\n" + location.toString());
            myWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
