package es.ulpgc.hpi.p3.projectimplementation;

public class Employee {
    private static int ID = 0;
    private final int id;
    private final String name, surname;
    private final String email;
    private final Customer Company;
    private String department;
    private String role;
    private Double tenure;

    public Employee(String name, String surname, String email, Customer company, String department, String role, Double tenure) {
        this.id = ++ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        Company = company;
        this.department = department;
        this.role = role;
        this.tenure = tenure;
    }

    public void changeDepartment(String department) {
        this.department = department;
    }

    public void promote(String role) {
        this.role = role;
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

    public Customer getCompany() {
        return Company;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public Double getTenure() {
        return tenure;
    }
}
