# SME Analytics Platform

A console-based Java application for managing employees, customers, databases, analyses, and consultants. The platform allows adding, listing, and managing data for small and medium-sized enterprises (SMEs), with optional file persistence.

---

## Features

- **Employees**  
  - Add new employees with details like name, hire date, email, role, salary, and department.  
  - List all employees.  
  - Delete employees (admin password required).  

- **Customers**  
  - Add customers with name, sector, tenure, and subscription plan.  
  - List all customers.  

- **Databases**  
  - Add databases with attributes such as size, name, type, and active status.  
  - List all databases.  

- **Analyses**  
  - Add and list analyses (currently with dummy implementation).  

- **Consultants**  
  - Add consultants with name, surname, email, and specialty.  
  - List all consultants.  

- **Data Persistence**  
  - Save employees and customers to a file.  
  - Load employees and customers from a file.  

---

## Technologies

- Java 17+  
- Console-based UI (Scanner input)  
- Object-oriented design with `Employee`, `Customer`, `Database`, `Analysis`, and `Consultant` classes  

---

## Installation

1. Clone the repository:  

   ```bash
   git clone https://github.com/yourusername/sme-analytics-platform.git

2. Open in your favorite IDE (Eclipse, IntelliJ, VS Code).

3. Compile and run `Main.java`:

   ```bash
   javac -d bin src/es/ulpgc/hpi/p3/projectimplementation/control/Main.java
   java -cp bin es.ulpgc.hpi.p3.projectimplementation.control.Main
   ```

---

## Usage

1. Run the program.
2. Use the **Main Menu** to navigate between Employees, Customers, Databases, Analysis, and Consultants.
3. Select actions like **Add**, **List**, or **Delete** as prompted.
4. Save or load data from a file to persist changes between sessions.
5. Enter `0` to exit the program.

Example of the Main Menu:

```
===== MAIN MENU =====
1. Employees
2. Customers
3. Databases
4. Analysis
5. Consultants
6. Save data
7. Load data
0. Exit
```

---

## Admin Features

* Deleting employees requires an **admin password**: `admin123`.

---

## File Format

* Employees and customers are saved in a semicolon-separated file (`;`).
* Example:

```
EMPLOYEE;John;Doe;2023-01-01;john.doe@email.com;Developer;50000;IT
CUSTOMER;Acme Corp;Technology;3;PREMIUM
```

---

## Future Improvements

* Implement full analysis functionality.
* Add validation and error handling for all inputs.
* Enhance UI with a graphical interface.
* Include database persistence (e.g., SQLite, MySQL).

---

## License

This project is licensed under the MIT License.
