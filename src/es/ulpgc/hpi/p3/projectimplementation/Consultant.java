package es.ulpgc.hpi.p3.projectimplementation;

import java.util.ArrayList;
import java.util.List;
public class Consultant {
    private static int ID = 0;
    private final int id;
    private final String name, surname;
    private Email email;
    private String specialization;

    private final List<Customer> customerList;

    public Consultant(String name, String surname, Email email, String specialization) {
        this.id = ++ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.specialization = specialization;
        this.customerList = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Adds a new Customer to the list of assigned customers for this consultant.
     * * @param customer The Customer object to be assigned.
     */
    public void assignCustomer(Customer customer) {
        customerList.add(customer);
    }

    /**
     * Returns an unmodifiable copy of the list of customers assigned to this consultant.
     * This ensures the internal customer list remains secure and cannot be altered
     * directly from outside the class (Defensive Copy).
     * * @return An immutable List of Customer objects.
     */
    public List<Customer> getAssignedCustomers() {
        return List.copyOf(customerList);
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}



