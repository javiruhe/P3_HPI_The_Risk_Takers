package es.ulpgc.hpi.p3.projectimplementation;

import java.util.List;

public class Customer {
    private static int ID = 0;
    private final int id;
    private final String name;
    private final String email;
    private int tenure;
    private double economicBalance;
    private List<Employee> employeeList;
    private final String industry;

    public Customer(String name, String email, List<Employee> employees, String industry, int tenure) {
        this.id = ++ID;
        this.name = name;
        this.email = email;
        employeeList = employees;
        this.industry = industry;
        this.tenure = tenure;
    }

    public void updateEconomicBalance(double economicBalance) {
        this.economicBalance = economicBalance;
    }

    public void setEmployees(List<Employee> employees) {
        employeeList = employees;
    }

    public static int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getEconomicBalance() {
        return economicBalance;
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public String getIndustry() {
        return industry;
    }

    public int getTenure() {
        return tenure;
    }
}
