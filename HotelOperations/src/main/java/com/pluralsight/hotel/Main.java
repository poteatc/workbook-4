package com.pluralsight.hotel;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(2, 99.99, false, false);
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
        System.out.printf("%s (employee #: %s) in the %s department earned $%.2f this week\n",
                e2.getName(), e2.getEmployeeId(), e2.getDepartment(), e2.getTotalPay());
    }
}
