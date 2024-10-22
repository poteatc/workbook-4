package com.pluralsight.hotel;

import java.time.LocalDate;

public class DetailedReservation {
    private Room room;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double price;
    private RoomType roomType;
    enum RoomType {
        KING,
        DOUBLE
    }
    private boolean weekend;
    private double reservationTotal;

}
