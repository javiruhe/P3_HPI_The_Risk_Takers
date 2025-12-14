package es.ulpgc.hpi.p3.projectimplementation.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents an employee within the organization.
 This class encapsulates the employee's personal information, professional role,
 * and compensation details. It serves as the central entity for managing
 * employment status, including promotions, department transfers, and tenure calculation.
 */
public class Employee {
    private static int NEXT_ID = 0;

    private final int employeeID;
    private final String name;
    private final String surname;
    private final LocalDate hireDate;
    private final Email email;
    private String role;
    private double salary;
    private String department;

    // Constructor
    public Employee(String name, String surname, LocalDate hireDate, Email email,
                    String role, double salary, String department) {
        this.employeeID = ++NEXT_ID;
        this.name = name;
        this.surname = surname;
        this.hireDate = hireDate;
        this.email = email;
        this.role = role;
        this.salary = salary;
        this.department = department;
    }

    public int getYearsOfService() {
        if (hireDate == null) return 0;
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    public void promote(String newRole, double newSalary) {
        this.role = newRole;
        this.salary = newSalary;
    }

    public void changeDepartment(String newDepartment) {
        this.department = newDepartment;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public int getEmployeeID() { return employeeID; }

    @Override
    public String toString() {
        return name + " " + surname + " (" + role + ")";
    }
}
