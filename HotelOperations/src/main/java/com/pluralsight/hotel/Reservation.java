package com.pluralsight.hotel;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;


    public Reservation(String roomType, int numberOfNights, boolean weekend) {
            this.roomType = roomType;
            this.numberOfNights = numberOfNights;
            this.weekend = weekend;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        double price = 0.0;
        if (roomType.equalsIgnoreCase("king")) {
            price = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            price = 124.00;
        }
        if (weekend) {
            price += price * .10;
        }
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }
    
    public void setIsWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
