package com.pluralsight.hotel;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;


    public Employee(String employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getOvertimeHours() {
        return hoursWorked - 40;
    }

    public int getRegularHours() {
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
