package es.ulpgc.hpi.p3.projectimplementation.control;

import es.ulpgc.hpi.p3.projectimplementation.model.*;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Main {

    private static final List<Customer> customerList = new ArrayList<>();
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final List<Analysis> analysisList = new ArrayList<>();
    private static final List<Database> databaseList = new ArrayList<>();
    private static final List<Consultant> consultantList = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            int option = readInt("Choose an option: ");

            switch (option) {
                case 1 -> employeeMenu();
                case 2 -> customerMenu();
                case 3 -> databaseMenu();
                case 4 -> analysisMenu();
                case 5 -> consultantMenu();
                case 6 -> saveToFile();
                case 7 -> loadFromFile();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option");
            }
        }
        System.out.println("Bye 👋");
    }

    // ================= MENUS =================

    private static void printMainMenu() {
        System.out.println("""
                ===== MAIN MENU =====
                1. Employees
                2. Customers
                3. Databases
                4. Analysis
                5. Consultants
                6. Save data
                7. Load data
                0. Exit
                """);
    }

    private static void employeeMenu() {
        System.out.println("""
                --- EMPLOYEES ---
                1. Add employee
                2. List employees
                3. Delete employee (admin)
                0. Back
                """);

        int option = readInt("Option: ");
        switch (option) {
            case 1 -> addEmployee();
            case 2 -> listEmployees();
            case 3 -> deleteEmployee();
        }
    }

    private static void customerMenu() {
        System.out.println("""
                --- CUSTOMERS ---
                1. Add customer
                2. List customers
                0. Back
                """);

        int option = readInt("Option: ");
        if (option == 1) addCustomer();
        else if (option == 2) listCustomers();
    }

    private static void databaseMenu() {
        System.out.println("""
                --- DATABASES ---
                1. Add database
                2. List databases
                0. Back
                """);

        int option = readInt("Option: ");
        if (option == 1) addDatabase();
        else if (option == 2) listDatabases();
    }

    private static void analysisMenu() {
        System.out.println("""
                --- ANALYSIS ---
                1. Add analysis
                2. List analysis
                0. Back
                """);

        int option = readInt("Option: ");
        if (option == 1) addAnalysis();
        else if (option == 2) listAnalysis();
    }

    private static void consultantMenu() {
        System.out.println("""
                --- CONSULTANTS ---
                1. Add consultant
                2. List consultants
                0. Back
                """);

        int option = readInt("Option: ");
        if (option == 1) addConsultant();
        else if (option == 2) listConsultants();
    }

    // ================= ADD =================

    private static void addEmployee() {
        employeeList.add(new Employee(
                readString("Name: "),
                readString("Surname: "),
                LocalDate.parse(readString("Birth date (YYYY-MM-DD): ")),
                new Email(readString("Email: ")),
                readString("Role: "),
                readDouble("Salary: "),
                readString("Department: ")
        ));
    }

    private static void addCustomer() {
        customerList.add(new Customer(
                readString("Name: "),
                readString("Surname: "),
                readInt("Age: "),
                SubscriptionPlan.valueOf(readString("Plan: ").toUpperCase()),
                new ArrayList<>()
        ));
    }

    private static void addDatabase() {
        databaseList.add(new Database(
                Boolean.parseBoolean(readString("Active (true/false): ")),
                readInt("Size: "),
                readString("Name: "),
                LocalDate.parse(readString("Date (YYYY-MM-DD): ")),
                FileType.valueOf(readString("File type: ").toUpperCase())
        ));
    }

    private static void addConsultant() {
        consultantList.add(new Consultant(
                readString("Name: "),
                readString("Surname: "),
                new Email(readString("Email: ")),
                readString("Specialty: ")
        ));
    }

    private static void addAnalysis() {
        System.out.println("Analysis added (dummy example)");
    }

    // ================= LIST =================

    private static void listEmployees() {
        employeeList.forEach(System.out::println);
    }

    private static void listCustomers() {
        customerList.forEach(System.out::println);
    }

    private static void listDatabases() {
        databaseList.forEach(System.out::println);
    }

    private static void listAnalysis() {
        analysisList.forEach(System.out::println);
    }

    private static void listConsultants() {
        consultantList.forEach(System.out::println);
    }

    // ================= DELETE =================

    private static void deleteEmployee() {
        if (!checkPassword()) return;
        listEmployees();
        int index = readInt("Index to delete: ");
        if (index >= 0 && index < employeeList.size()) {
            employeeList.remove(index);
            System.out.println("Employee deleted ✔");
        }
    }

    private static boolean checkPassword() {
        return ADMIN_PASSWORD.equals(readString("Admin password: "));
    }

    // ================= SAVE / LOAD =================

    private static void saveToFile() {
        String path = readString("Enter file path to save: ");

        try (PrintWriter pw = new PrintWriter(path)) {

            for (Employee e : employeeList) {
                pw.println("EMPLOYEE;" +
                        e.getName() + ";" +
                        e.getSurname() + ";" +
                        e.getHireDate() + ";" +
                        e.getEmail() + ";" +
                        e.getRole() + ";" +
                        e.getSalary() + ";" +
                        e.getDepartment());
            }

            for (Customer c : customerList) {
                pw.println("CUSTOMER;" +
                        c.getName() + ";" +
                        c.getTenure() + ";" +
                        c.getSubscriptionPlan());
            }

            System.out.println("Saved ✔");

        } catch (Exception e) {
            System.out.println("Error saving file ❌");
        }
    }


    private static void loadFromFile() {
        String path = readString("Enter file path: ");
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File not found ❌");
            return;
        }

        try (Scanner sc = new Scanner(file)) {
            employeeList.clear();
            customerList.clear();

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(";");

                switch (p[0]) {
                    case "EMPLOYEE" ->
                            employeeList.add(new Employee(
                                    p[1], p[2], LocalDate.parse(p[3]),
                                    new Email(p[4]), p[5],
                                    Double.parseDouble(p[6]), p[7]
                            ));

                    case "CUSTOMER" ->
                            customerList.add(new Customer(
                                    p[1], p[2],
                                    Integer.parseInt(p[3]),
                                    SubscriptionPlan.valueOf(p[4]),
                                    new ArrayList<>()
                            ));
                }
            }

            System.out.println("Loaded ✔");

        } catch (Exception e) {
            System.out.println("Error loading file ❌");
        }
    }


    // ================= UTIL =================

    private static String readString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int readInt(String msg) {
        return Integer.parseInt(readString(msg));
    }

    private static double readDouble(String msg) {
        return Double.parseDouble(readString(msg));
    }
}
