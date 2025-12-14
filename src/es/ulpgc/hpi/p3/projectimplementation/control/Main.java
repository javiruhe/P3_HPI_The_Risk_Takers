package es.ulpgc.hpi.p3.projectimplementation.control;

import es.ulpgc.hpi.p3.projectimplementation.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Employee> employees = new ArrayList<>();
        customerList.add(new Customer(parts[1], parts[2], Integer.valueOf(parts[3]), SubscriptionPlan.valueOf(parts[4]), employees));
    }

    private static void addEmployee(String[] parts) {
        Email email = new Email(parts[4]);
        employeeList.add(new Employee(parts[1], parts[2], LocalDate.parse(parts[3]), email, parts[5], Double.parseDouble(parts[6]), parts[7]));
    }

    private static void addAnalysis(String[] parts) {
        Database db = findDatabase(parts[1]);
        AnalysisTopic theme = AnalysisTopic.valueOf(parts[2]);

        Analysis analysis;

        switch (parts[2].toUpperCase()) {
            case "CLUSTER":
                int kValue = Integer.parseInt(parts[3]);
                String algorithm = parts[4];
                analysis = new ClusterAnalysis(db, theme, kValue, algorithm);
                break;

            case "LINEAR":
                String dependentVar = parts[3];
                String independentVar = parts[4];
                analysis = new LinearRegression(db, theme, dependentVar, independentVar);
                break;

            case "MULTIVARIANT":
                dependentVar = parts[3];
                List<String> independentVars = Arrays.asList(parts[4].split(","));
                analysis = new MultivariantRegression(db, theme, dependentVar, independentVars);
                break;

            case "AI":
                String modelType = parts[3];
                int epochs = Integer.parseInt(parts[4]);
                analysis = new AIModelAnalysis(db, theme, modelType, epochs);
                break;

            default:
                throw new IllegalArgumentException("Unknown analysis: " + parts[2]);
        }

        analysisList.add(analysis);
    }


    private static void addDatabase(String[] parts) {
        databaseList.add(new Database(Boolean.parseBoolean(parts[1]), Integer.valueOf(parts[2]), parts[3], LocalDate.parse(parts[4]), FileType.valueOf(parts[5])));
    }

    private static void addConsultant(String[] parts) {
        Email email = new Email(parts[3]);
        consultantList.add(new Consultant(parts[1], parts[2], email, parts[4]));
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
