package com.pluralsight.dealership;

import java.io.*;

public class DealershipFileManager {
    // Load and read the inventory.csv file
    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader br = new BufferedReader(fr);
            String dealershipInfo = br.readLine();
            String[] fields = dealershipInfo.split("[|]");
            dealership = new Dealership(fields[0], fields[1], fields[2]);
            String vehicleInfo;
            while ((vehicleInfo = br.readLine()) != null) {
                fields = vehicleInfo.split("[|]");
                try {
                    int vin = Integer.parseInt(fields[0]);
                    int year = Integer.parseInt(fields[1]);
                    String make = fields[2];
                    String model = fields[3];
                    String vehicleType = fields[4];
                    String color = fields[5];
                    int odometer = Integer.parseInt(fields[6]);
                    double price = Double.parseDouble(fields[7]);
                    dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                } catch (Exception e) {
                    System.out.println("Field isn't valid for vehicle");
                }
            }
        } catch (Exception e) {
            System.out.println("File not able to be read.");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fw = new FileWriter("./src/main/resources/inventory-backup.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            // Write first line of csv
            bw.write(String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhone()));
            // Write all vehicles in csv format
            for (Vehicle v : dealership.getAllVehicles()) {
                bw.write(v.toCSVFormat() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Can't write to file");
        }
    }
}
