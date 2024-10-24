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

    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.println(ColorCodes.GREEN + "\nVehicles\n~~~~~~~~" + ColorCodes.RESET);
        System.out.printf(ColorCodes.BLUE + "%-10s %-10s %-10s %-10s %-10s %-10s %-15s %5s\n",
                "VIN", "Make", "Model", "Year", "Type", "Color", "Mileage", "Price");
        System.out.println("---------------------------------------------------------------------------------------" + ColorCodes.RESET);
        for (Vehicle v: vehicles) {
            System.out.println(v);
        }
        System.out.println();
    }

    public void processGetByPriceRequest() {}
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
