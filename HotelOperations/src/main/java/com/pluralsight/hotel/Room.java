package com.pluralsight.hotel;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean available;
    private boolean dirty;

    public Room() {
        this.numberOfBeds = 1;
        this.price = 100.00;
        this.available = true;
        this.dirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isOccupied() {
        return !available;
    }

    public boolean isDirty() {
        return dirty;
    }
}
