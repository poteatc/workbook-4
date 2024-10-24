package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
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

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesInPriceRange = inventory.stream().filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max).toList();
        return vehiclesInPriceRange;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehiclesWithMakeAndModel = inventory.stream().filter(
                vehicle -> vehicle.getMake().trim().equalsIgnoreCase(make)
                        && vehicle.getModel().trim().equalsIgnoreCase(model)).toList();
        return vehiclesWithMakeAndModel;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehiclesInYearRange = inventory.stream().filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max).toList();
        return vehiclesInYearRange;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesWithColor = inventory.stream().filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color)).toList();
        return vehiclesWithColor;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehiclesInMileageRange = inventory.stream().filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max).toList();
        return vehiclesInMileageRange;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesOfType = inventory.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType)).toList();
        return vehiclesOfType;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {

    }
}
