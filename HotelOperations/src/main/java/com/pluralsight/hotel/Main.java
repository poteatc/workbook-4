package com.pluralsight.hotel;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(2, 99.99, false, false);
        System.out.println("Is room 1 available? " + room1.isAvailable());

        System.out.println("New guest arrived to check in to room 1...");
        room1.checkIn();
        System.out.println("Is room 1 available? " + room1.isAvailable());
        room1.checkOut();
        System.out.println("Guest checked out of room 1...");
        System.out.println("Is room 1 available? " + room1.isAvailable());
        room1.cleanRoom();
        System.out.println("Housekeeping cleaned room 1!");
        System.out.println("Is room 1 available? " + room1.isAvailable());



        Reservation res1 = new Reservation("king", 3, true);
        Reservation res2 = new Reservation("double", 3, false);

        System.out.printf("The price for a %s room is $%.2f for %d nights is $%.2f\n",
                res1.getRoomType(), res1.getPrice(), res1.getNumberOfNights(), res1.getReservationTotal());
        System.out.printf("The price for a %s room is $%.2f for %d nights is $%.2f\n",
                res2.getRoomType(), res2.getPrice(), res2.getNumberOfNights(), res2.getReservationTotal());

        Employee e1 = new Employee("100ESDY", "Caleb", "Housekeeping", 15, 45);
        Employee e2 = new Employee("102TRWA", "Joe", "Customer Service", 15, 35);

        System.out.printf("%s (employee #: %s) in the %s department earned $%.2f this week\n",
                e1.getName(), e1.getEmployeeId(), e1.getDepartment(), e1.getTotalPay());
        System.out.printf("%s (employee #: %s) in the %s department earned $%.2f this week so far\n",
                e2.getName(), e2.getEmployeeId(), e2.getDepartment(), e2.getTotalPay());

        e2.punchTimeCard(10, 18.5);
        System.out.println(e2.getName() + " punched in and out for today");

        System.out.printf("%s (employee #: %s) in the %s department earned $%.2f this week so far\n",
                e2.getName(), e2.getEmployeeId(), e2.getDepartment(), e2.getTotalPay());

        Hotel hotel = new Hotel("Wyndham", 50, 100, 25, 50);
        System.out.println(hotel.bookRoom(25, true));
        System.out.println(hotel.bookRoom(5, true));
        System.out.println(hotel.bookRoom(50, false));
        System.out.println(hotel.bookRoom(1, false));

    }
}
