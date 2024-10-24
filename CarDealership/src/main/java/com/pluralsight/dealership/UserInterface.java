package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }

    private void init() {
        this.dealership = new DealershipFileManager().getDealership();
    }

    public void display() {
        init();
        boolean done = false;
        do {
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~
                    |       Menu       |
                    ~~~~~~~~~~~~~~~~~~~~
                    Please enter an option:
                    A) Filter vehicles by price
                    B) Filter vehicles by make and model
                    C) Filter vehicles by year
                    D) Filter vehicles by color
                    E) Filter vehicles by mileage
                    F) Filter vehicles by type
                    G) Show all vehicles
                    H) Add new vehicle to dealership
                    I) Remove vehicle from dealership
                    X) Exit application
                    """);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "a":
                    processGetByPriceRequest();
                    break;
                case "b":
                    processGetByMakeModelRequest();
                    break;
                case "c":
                    processGetByYearRequest();
                    break;
                case "d":
                    processGetByColorRequest();
                    break;
                case "e":
                    processGetByMileageRequest();
                    break;
                case "f":
                    processGetByVehicleTypeRequest();
                    break;
                case "g":
                    processGetAllVehiclesRequest();
                    break;
                case "h":
                    processAddVehicleRequest();
                    break;
                case "i":
                    processRemoveVehicleRequest();
                    break;
                case "x":
                    System.out.println("Exiting application...");
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid choice (A, B, C, D, E, F, G, H, I, or X):");
                    break;
            }

        } while (!done);
    }

    private void printVehicleListHeader() {
        System.out.println(ColorCodes.GREEN + "\nVehicles\n~~~~~~~~" + ColorCodes.RESET);
        System.out.printf(ColorCodes.BLUE + "%-10s %-10s %-10s %-10s %-10s %-10s %-15s %5s\n",
                "VIN", "Make", "Model", "Year", "Type", "Color", "Mileage", "Price");
        System.out.println("---------------------------------------------------------------------------------------" + ColorCodes.RESET);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        printVehicleListHeader();
        for (Vehicle v: vehicles) {
            System.out.println(v);
        }
    }

    private double getPositiveDoubleInput(String input) {
        double d = -1;
        try {
            d = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a floating point number (Ex. 100, 54321.09, 123.50)");
        }
        if (d < 0) {
            System.out.println("Please enter a positive number...");
            d = -1;
        }
        return d;
    }

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the minimum price: ");
        String input = scanner.nextLine().trim();
        double min = getPositiveDoubleInput(input);
        if (min == -1) return;

        System.out.print("Please enter the minimum price: ");
        input = scanner.nextLine().trim();
        double max = getPositiveDoubleInput(input);
        if (max == -1) return;

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {}
    public void processGetByYearRequest() {}
    public void processGetByColorRequest() {}
    public void processGetByMileageRequest() {}
    public void processGetByVehicleTypeRequest() {}

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}
}
