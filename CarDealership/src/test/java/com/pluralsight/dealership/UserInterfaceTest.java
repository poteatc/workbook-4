package com.pluralsight.dealership;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    private Dealership d;
    private ArrayList<Vehicle> vehicles;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Vehicle vehicle = new Vehicle(100, 100, "Kia", "Sorento", "SUV", "Grey", 130000, 5000);
        d =  new DealershipFileManager().getDealership();
    }

    @org.junit.jupiter.api.Test
    void display() {

    }

    @Test
    void processGetByPriceRequest() {
        d.addVehicle();
    }
}