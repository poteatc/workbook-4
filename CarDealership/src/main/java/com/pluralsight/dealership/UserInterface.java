package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    DealershipFileManager dealershipFileManager;

    public UserInterface() {

    }

    private void init() {
        this.dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() {
        init();
        boolean done = false;
        do {
            printMenuPrompt();
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
        printVehicleListHeader();
        for (Vehicle v: vehicles) {
            System.out.println(v);
        }
    }

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the minimum price: ");
        String input = scanner.nextLine().trim();
        double min = getPositiveDoubleInput(input);
        if (min == -1) return;

        System.out.print("Please enter the maximum price: ");
        input = scanner.nextLine().trim();
        double max = getPositiveDoubleInput(input);
        if (max == -1) return;

        List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(min, max);
        if (vehiclesByPrice.isEmpty()) {
            System.out.println("There are no vehicles within that price range...");
        } else {
            displayVehicles(vehiclesByPrice);
        }
    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the make (brand) of the vehicle: ");
        String make = scanner.nextLine().trim().toLowerCase();

        System.out.print("Please enter the model: ");
        String model = scanner.nextLine().trim().toLowerCase();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        if (vehiclesByMakeModel.isEmpty()) {
            System.out.println("There are no vehicles with that make and model...");
        } else {
            displayVehicles(vehiclesByMakeModel);
        }
    }

    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the minimum year: ");
        String input = scanner.nextLine().trim();
        int min = getPositiveIntegerInput(input);
        if (min == -1) return;

        System.out.print("Please enter the maximum price: ");
        input = scanner.nextLine().trim();
        int max = getPositiveIntegerInput(input);
        if (max == -1) return;

        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(min, max);
        if (vehiclesByYear.isEmpty()) {
            System.out.println("There are no vehicles within those years...");
        } else {
            displayVehicles(vehiclesByYear);
        }
    }

    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the color of the vehicle: ");
        String color = scanner.nextLine().trim().toLowerCase();

        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        if (vehiclesByColor.isEmpty()) {
            System.out.println("There are no vehicles with that color...");
        } else {
            displayVehicles(vehiclesByColor);
        }
    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the minimum mileage: ");
        String input = scanner.nextLine().trim();
        int min = getPositiveIntegerInput(input);
        if (min == -1) return;

        System.out.print("Please enter the maximum mileage: ");
        input = scanner.nextLine().trim();
        int max = getPositiveIntegerInput(input);
        if (max == -1) return;

        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(min, max);
        if (vehiclesByMileage.isEmpty()) {
            System.out.println("There are no vehicles within that mileage range...");
        } else {
            displayVehicles(vehiclesByMileage);
        }
    }
    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the vehicle type: ");
        String type = scanner.nextLine().trim().toLowerCase();

        List<Vehicle> vehiclesByType = dealership.getVehiclesByType(type);
        if (vehiclesByType.isEmpty()) {
            System.out.println("There are no vehicles with that type...");
        } else {
            displayVehicles(vehiclesByType);
        }
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a vehicle VIN: ");
        String input = scanner.nextLine().toLowerCase().trim();
        int vin = getPositiveIntegerInput(input);

        System.out.println("Please enter a vehicle year: ");
        input = scanner.nextLine().toLowerCase().trim();
        int year = getPositiveIntegerInput(input);

        System.out.println("Please enter a vehicle brand: ");
        String make = scanner.nextLine();

        System.out.println("Please enter a vehicle model: ");
        String model = scanner.nextLine();

        System.out.println("Please enter a vehicle type: ");
        String type = scanner.nextLine();

        System.out.println("Please enter a vehicle color: ");
        String color = scanner.nextLine();

        System.out.println("Please enter the vehicle's mileage: ");
        input = scanner.nextLine().toLowerCase().trim();
        int mileage = getPositiveIntegerInput(input);

        System.out.println("Please enter the vehicle's price: ");
        input = scanner.nextLine().toLowerCase().trim();
        double price = getPositiveDoubleInput(input);

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        dealership.addVehicle(vehicle);

        dealershipFileManager.saveDealership(dealership);
    }
    public void processRemoveVehicleRequest() {}

    // Helper methods

    private void printMenuPrompt() {
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
    }

    private void printVehicleListHeader() {
        System.out.println(ColorCodes.GREEN + "\nVehicles\n~~~~~~~~" + ColorCodes.RESET);
        System.out.printf(ColorCodes.BLUE + "%-10s %-10s %-10s %-10s %-10s %-10s %-15s %5s\n",
                "VIN", "Make", "Model", "Year", "Type", "Color", "Mileage", "Price");
        System.out.println("---------------------------------------------------------------------------------------" + ColorCodes.RESET);
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

    private int getPositiveIntegerInput(String input) {
        int i = -1;
        try {
            i = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer number (Ex. 10, 987, 1234)");
        }
        if (i < 0) {
            System.out.println("Please enter a positive number...");
            i = -1;
        }
        return i;
    }
}
