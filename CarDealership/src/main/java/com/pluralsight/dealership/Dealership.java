package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name; // Dealership name
    private String address; // Dealership address
    private String phone; // Dealership contact phone
    private ArrayList<Vehicle> inventory; // List of vehicles available in the dealership's inventory

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); // Initialize empty inventory list
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Filters inventory by price range and returns list of matching vehicles
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesInPriceRange = inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max)
                .toList();
        return vehiclesInPriceRange;
    }

    // Filters inventory by make and model and returns list of matching vehicles
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehiclesWithMakeAndModel = inventory.stream().filter(
                vehicle -> vehicle.getMake().trim().equalsIgnoreCase(make)
                        && vehicle.getModel().trim().equalsIgnoreCase(model)).toList();
        return vehiclesWithMakeAndModel;
    }

    // Filters inventory by year range and returns list of matching vehicles
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehiclesInYearRange = inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
                .toList();
        return vehiclesInYearRange;
    }

    // Filters inventory by color and returns list of matching vehicles
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesWithColor = inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .toList();
        return vehiclesWithColor;
    }

    // Filters inventory by mileage range and returns list of matching vehicles
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehiclesInMileageRange = inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
                .toList();
        return vehiclesInMileageRange;
    }

    // Filters inventory by vehicle type and returns list of matching vehicles
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesOfType = inventory.stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .toList();
        return vehiclesOfType;
    }

    // Returns entire vehicle inventory
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Adds a vehicle to the inventory list
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Removes a vehicle from the inventory list
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
