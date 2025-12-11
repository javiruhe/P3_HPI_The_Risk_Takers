package es.ulpgc.hpi.p3.projectimplementation;

import java.util.List;
public class Consultant {
    private static int ID = 0;
    private final int id;
    private final String name, surname;
    private final String email;
    private String especialisation;

    private List<Customer> customerList;

    public Consultant(String name, String surname, String email, String especialisation) {
        this.id = ++ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.especialisation = especialisation;
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

    public String getEspecialisation() {
        return especialisation;
    }

    public void assignCustomer(Customer customer){

    }

    public void getAssignedCustomers(){

    }
}
