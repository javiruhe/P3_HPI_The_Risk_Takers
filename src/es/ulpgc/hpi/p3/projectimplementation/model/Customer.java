package es.ulpgc.hpi.p3.projectimplementation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer or client entity within the system.
 * This class manages the customer's profile, including their subscription status,
 * financial balance, and industry details. It serves as the primary link between
 * the client organization and their assigned consultant.
 */

public class Customer {
    private static int NEXT_ID = 0;

    private final int customerID;
    private double economicBalance;
    private final String name;
    private int tenure;
    private final String industry;

    private SubscriptionPlan subscriptionPlan;
    private Consultant assignedConsultant;
    private List<Employee> employeeList;


    public Customer(String name, String industry, int tenure,
                    SubscriptionPlan plan) {
        this.customerID = ++NEXT_ID;
        this.name = name;
        this.industry = industry;
        this.tenure = tenure;
        this.subscriptionPlan = plan;
        this.economicBalance = 0.0;
        this.employeeList = new ArrayList<>();
    }

    public void updateRevenue(double amount) {
        this.economicBalance += amount;
    }

    public void upgradeSubscription(SubscriptionPlan newPlan) {
        this.subscriptionPlan = newPlan;
    }

    public int getCustomerID() { return customerID; }
    public String getName() { return name; }

    public double getEconomicBalance() {
        return economicBalance;
    }

    public int getTenure() {
        return tenure;
    }

    public String getIndustry() {
        return industry;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setAssignedConsultant(Consultant assignedConsultant) {
        this.assignedConsultant = assignedConsultant;
    }

    public Consultant getAssignedConsultant() {
        return assignedConsultant;
    }

    @Override
    public String toString() {
        return "Name:'" + name + '\'' +
                ", Sector:'" + industry + '\'' +
                ", Employees:" + employeeList.size();
    }


}
