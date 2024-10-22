package com.pluralsight.hotel;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room() {
        this.numberOfBeds = 1;
        this.price = 100.00;
        this.occupied = true;
        this.dirty = false;
    }

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public boolean isDirty() {
        return dirty;
    }
}
