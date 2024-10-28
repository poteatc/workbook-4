package com.pluralsight.dealership;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    private Dealership dealership;

    @BeforeEach
    void setUp() {
        // Initialize a new Dealership instance before each test
        dealership = new Dealership("Test Dealership", "123 Test St", "123-456-7890");
    }

    @Test
    void testAddVehicle() {
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        dealership.addVehicle(vehicle);
        assertEquals(1, dealership.getAllVehicles().size(), "Vehicle should be added to the inventory.");
    }

    @Test
    void testRemoveVehicle() {
        Vehicle vehicle = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        dealership.addVehicle(vehicle);
        dealership.removeVehicle(vehicle);
        assertEquals(0, dealership.getAllVehicles().size(), "Vehicle should be removed from the inventory.");
    }

    @Test
    void testGetVehiclesByPrice() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> result = dealership.getVehiclesByPrice(10000, 21000);
        assertEquals(1, result.size(), "Should return one vehicle in the price range.");
        assertEquals(vehicle1, result.get(0), "Returned vehicle should be the Toyota Camry.");
    }

    @Test
    void testGetVehiclesByMakeModel() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> result = dealership.getVehiclesByMakeModel("Toyota", "Camry");
        assertEquals(1, result.size(), "Should return one vehicle with make Toyota and model Camry.");
        assertEquals(vehicle1, result.get(0), "Returned vehicle should be the Toyota Camry.");
    }

    @Test
    void testGetVehiclesByYear() {
        Vehicle vehicle1 = new Vehicle(1, 2019, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> result = dealership.getVehiclesByYear(2018, 2020);
        assertEquals(1, result.size(), "Should return one vehicle within the year range.");
        assertEquals(vehicle1, result.get(0), "Returned vehicle should be the Toyota Camry.");
    }

    @Test
    void testGetVehiclesByColor() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> result = dealership.getVehiclesByColor("Blue");
        assertEquals(1, result.size(), "Should return one vehicle with the specified color.");
        assertEquals(vehicle1, result.get(0), "Returned vehicle should be the Toyota Camry.");
    }

    @Test
    void testGetVehiclesByMileage() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> result = dealership.getVehiclesByMileage(10000, 20000);
        assertEquals(1, result.size(), "Should return one vehicles within the mileage range.");
    }

    @Test
    void testGetVehiclesByType() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> result = dealership.getVehiclesByType("Sedan");
        assertEquals(2, result.size(), "Should return two vehicles of type Sedan.");
    }

    @Test
    void testGetAllVehicles() {
        Vehicle vehicle1 = new Vehicle(1, 2020, "Toyota", "Camry", "Sedan", "Blue", 15000, 20000);
        Vehicle vehicle2 = new Vehicle(2, 2021, "Honda", "Accord", "Sedan", "Black", 5000, 25000);
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);

        List<Vehicle> allVehicles = dealership.getAllVehicles();
        assertEquals(2, allVehicles.size(), "Should return the total number of vehicles in inventory.");
    }
}
