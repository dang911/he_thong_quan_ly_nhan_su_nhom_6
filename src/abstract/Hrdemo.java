package hrdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Hrdemo {

    static Scanner sc = new Scanner(System.in);
    private static final HRService hrService = new HRService();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addEmployeeMenu();
                    break;

                case 2:
                    hrService.showAllEmployees();
                    break;

                case 3:
                    showSalaryById();
                    break;

                case 4:
                    hrService.showAllWorkLogs();
                    break;

                case 5:
                    System.out.println("Exit program!");
                            
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
    // ================= MENU =================

    private static void showMenu() {
        System.out.println("\n===== HUMAN RESOURCE MANAGEMENT ====="
        );
        System.out.println("1. Add Employee");
        System.out.println("2. Show All Employees");
                
        System.out.println("3. Show Salary By ID");
        System.out.println("4. Show All WorkLogs");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    // ================= ADD EMPLOYEE MENU =================

    private static void addEmployeeMenu() {

        System.out.println("\n--- Add Employee ---");
        System.out.println("1. Full-time");
        System.out.println("2. Part-time");
        System.out.println("3. Intern");
        System.out.print("Choose type: ");

        int type = Integer.parseInt(sc.nextLine());

        switch (type) {
            case 1:
                addFullTimeEmployee();
                break;
            case 2:
                addPartTimeEmployee();
                break;
            case 3:
                addInternEmployee();
                break;
            default:
                System.out.println("Invalid type!");
        }
    }

    // ================= SHOW SALARY =================

    private static void showSalaryById() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        double salary = hrService.calculateSalaryById(id);

        System.out.println("Salary of employee " + id + " is: " + 
                String.format("%,.0f VND",salary));
    }

    // ================= ADD FULL TIME =================

    private static void addFullTimeEmployee() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Full name: ");
            String name = sc.nextLine();

            System.out.print("Date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(sc.nextLine());

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Department ID: ");
            String deptId = sc.nextLine();

            System.out.print("Monthly salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            System.out.print("Bonus: ");
            double bonus = Double.parseDouble(sc.nextLine());

            Employee e = new FullTimeEmployee(
                    id, name, dob, phone, email, deptId, salary, bonus
            );

            hrService.addEmployee(e);
            System.out.println("Added Full-time Employee successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    // ================= ADD PART TIME =================

    private static void addPartTimeEmployee() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Full name: ");
            String name = sc.nextLine();

            System.out.print("Date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(sc.nextLine());

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Department ID: ");
            String deptId = sc.nextLine();

            System.out.print("Hourly rate: ");
            double rate = Double.parseDouble(sc.nextLine());

            Employee e = new PartTimeEmployee(
                    id, name, dob, phone, email, deptId, rate
            );

            hrService.addEmployee(e);
            System.out.println("Added Part-time Employee successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    // ================= ADD INTERN =================

    private static void addInternEmployee() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Full name: ");
            String name = sc.nextLine();

            System.out.print("Date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(sc.nextLine());

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Department ID: ");
            String deptId = sc.nextLine();

            System.out.print("Allowance: ");
            double allowance = Double.parseDouble(sc.nextLine());

            Employee e = new InternEmployee(
                    id, name, dob, phone, email, deptId, allowance
            );

            hrService.addEmployee(e);
            System.out.println("Added Intern successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}
