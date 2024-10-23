package com.pluralsight.hotel;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            int numberOfAvailableSuites = getAvailableSuites();
            if (numberOfAvailableSuites <= 0) {
                return false;
            } else if (numberOfRooms <= numberOfAvailableSuites) {
                this.numberOfSuites -= numberOfRooms;
                return true;
            } else {
                return false;
            }
        } else {
            int numberOfAvailableBasicRooms = getAvailableRooms();
            if (numberOfAvailableBasicRooms <= 0) {
                return false;
            } else if (numberOfRooms <= numberOfAvailableBasicRooms) {
                this.numberOfRooms -= numberOfRooms;
                return true;
            } else {
                return false;
            }
        }
    }

    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedBasicRooms;
    }


}
