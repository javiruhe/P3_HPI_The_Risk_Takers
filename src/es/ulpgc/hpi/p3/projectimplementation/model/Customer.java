package es.ulpgc.hpi.p3.projectimplementation.model;

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


    public Customer(String name, String industry, int tenure,
                    SubscriptionPlan plan,
                    List<Employee> initialEmployees) {
        this.customerID = ++NEXT_ID;
        this.name = name;
        this.industry = industry;
        this.tenure = tenure;
        this.subscriptionPlan = plan;
        this.economicBalance = 0.0;

    }

    public void updateRevenue(double amount) {
        this.economicBalance += amount;
    }

    public void upgradeSubscription(SubscriptionPlan newPlan) {
        this.subscriptionPlan = newPlan;
    }

    public int getCustomerID() { return customerID; }
    public String getName() { return name; }

    public void setAssignedConsultant(Consultant assignedConsultant) {
        this.assignedConsultant = assignedConsultant;
    }

    public Consultant getAssignedConsultant() {
        return assignedConsultant;
    }

}
