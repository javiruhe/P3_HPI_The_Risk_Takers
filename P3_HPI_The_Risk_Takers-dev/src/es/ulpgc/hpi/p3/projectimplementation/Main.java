package es.ulpgc.hpi.p3.projectimplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final List<Customer> customerList = new ArrayList<>();
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final List<Analysis> analysisList = new ArrayList<>();
    private static final List<Database> databaseList = new ArrayList<>();
    private static final List<Consultant> consultantList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = askCommand(scanner);
        while (!command.equals("exit")) {
            processCommand(command);
            command = askCommand(scanner);
        }
    }

    private static void processCommand(String command) {
        String[] parts = command.split(" ");
        if (parts[0].equals("add-customer")) addCustomer(parts);
        else if (parts[0].equals("add-employee")) addEmployee(parts);
        else if (parts[0].equals("add-analysis")) addAnalysis(parts);
        else if (parts[0].equals("add-database")) addDatabase(parts);
        else if (parts[0].equals("add-consultant")) addConsultant(parts);

    }

    private static void addCustomer(String[] parts) {
        customerList.add(new Customer(parts[1], parts[2], parts[3], parts[4], parts[5]));
    }

    private static void addEmployee(String[] parts) {
        employeeList.add(new Employee(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]));
    }

    private static void addAnalysis(String[] parts) {
        analysisList.add(new Analysis(findDatabase(parts[1], parts[2])));
    }

    private static void addDatabase(String[] parts) {
        databaseList.add(new Database(parts[1], parts[2], parts[3], parts[4], parts[5]));
    }

    private static void addConsultant(String[] parts) {
        consultantList.add(new Consultant(parts[1], parts[2], parts[3], parts[4]));
    }

    private static Database findDatabase(String databaseId) {
        return databaseList.stream()
                .filter(s -> s.getId() == Integer.parseInt(databaseId))
                .collect(Collectors.toList()).get(0);
    }

    private static String askCommand(Scanner scanner) {
        System.out.println("Write a command\n" + help());
        return scanner.nextLine().trim();
    }

    private static String help() {
        return "exit";
    }
}
