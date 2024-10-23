package com.pluralsight.hotel;

import java.time.LocalDateTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;
    private double punchOutTime;


    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void punchTimeCard(double inTime, double outTime) {
        double hoursToday = outTime - inTime;
        hoursWorked += hoursToday;
    }

    public void punchIn(double time) {
        this.punchInTime = time;
    }

    public void punchIn() {
        LocalDateTime currentTime = LocalDateTime.now();
        double time = currentTime.getHour() + (currentTime.getMinute() / 60);
        this.punchInTime = time;
    }

    public void punchOut(double time) {
        this.punchOutTime = time;
        hoursWorked += punchOutTime - punchInTime;
    }

    public double getOvertimeHours() {
        return hoursWorked - 40;
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * (payRate * 1.5);
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
