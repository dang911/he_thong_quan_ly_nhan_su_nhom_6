//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this1 license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package hrdemo;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner2;
//
//public class Hrdemo {
//
//    static Scanner sc = new Scanner(System.in);
//    private static final HRService hrService = new HRService();
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//    public static void main(String[] args) {
//
//        int choice;
//        do {
//            showMenu();
//            choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1:
//                    addFullTimeEmployee();
//                    break;
//                case 2:
//                    addPartTimeEmployee();
//                    break;
//                case 3:
//                    addInternEmployee();
//                    break;
//                case 4:
//                    hrService.showAllEmployees();
//                    break;
//                case 5:
//                    System.out.println("Exit program!");
//                    break;
//                default:
//                    System.out.println("Invalid choice!");
//            }
//
//        } while (choice != 5);
//    }
//
//    private static void showMenu() {
//        System.out.println("\n===== HUMAN RESOURCE MANAGEMENT =====");
//        System.out.println("1. Add Full-time Employee");
//        System.out.println("2. Add Part-time Employee");
//        System.out.println("3. Add Intern");
//        System.out.println("4. Show all employees");
//        System.out.println("5. Exit");
//        System.out.print("Choose: ");
//    }
//
//    // ===== ADD FULL TIME =====
//    private static void addFullTimeEmployee() {
//        try {
//            System.out.print("ID: ");
//            String id = sc.nextLine();
//
//            System.out.print("Full name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Date of birth (dd/MM/yyyy): ");
//            Date dob = sdf.parse(sc.nextLine());
//
//            System.out.print("Phone: ");
//            String phone = sc.nextLine();
//
//            System.out.print("Email: ");
//            String email = sc.nextLine();
//
//            System.out.print("Department ID: ");
//            String deptId = sc.nextLine();
//
//            System.out.print("Monthly salary: ");
//            double salary = Double.parseDouble(sc.nextLine());
//
//            System.out.print("Bonus: ");
//            double bonus = Double.parseDouble(sc.nextLine());
//
//            Employee e = new FullTimeEmployee(
//                    id, name, dob, phone, email, deptId, salary, bonus
//            );
//
//            hrService.addEmployee(e);
//            System.out.println("Added Full-time Employee successfully!");
//
//        } catch (Exception e) {
//            System.out.println("Invalid input!");
//        }
//    }
//
//    // ===== ADD PART TIME =====
//    private static void addPartTimeEmployee() {
//        try {
//            System.out.print("ID: ");
//            String id = sc.nextLine();
//
//            System.out.print("Full name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Date of birth (dd/MM/yyyy): ");
//            Date dob = sdf.parse(sc.nextLine());
//
//            System.out.print("Phone: ");
//            String phone = sc.nextLine();
//
//            System.out.print("Email: ");
//            String email = sc.nextLine();
//
//            System.out.print("Department ID: ");
//            String deptId = sc.nextLine();
//
//            System.out.print("Hourly rate: ");
//            double rate = Double.parseDouble(sc.nextLine());
//
//            Employee e = new PartTimeEmployee(
//                    id, name, dob, phone, email, deptId, rate);
//
//            hrService.addEmployee(e);
//            System.out.println("Added Part-time Employee successfully!");
//
//        } catch (Exception e) {
//            System.out.println("Invalid input!");
//        }
//    }
//
//    // ===== ADD INTERN =====
//    private static void addInternEmployee() {
//        try {
//            System.out.print("ID: ");
//            String id = sc.nextLine();
//
//            System.out.print("Full name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Date of birth (dd/MM/yyyy): ");
//            Date dob = sdf.parse(sc.nextLine());
//
//            System.out.print("Phone: ");
//            String phone = sc.nextLine();
//
//            System.out.print("Email: ");
//            String email = sc.nextLine();
//
//            System.out.print("Department ID: ");
//            String deptId = sc.nextLine();
//
//            System.out.print("Allowance: ");
//            double allowance = Double.parseDouble(sc.nextLine());
//
//            Employee e = new InternEmployee(
//                    id, name, dob, phone, email, deptId, allowance
//            );
//
//            hrService.addEmployee(e);
//            System.out.println("Added Intern successfully!");
//
//        } catch (Exception e) {
//            System.out.println("Invalid input!");
//        }
//    }
//}

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
                    updateEmployees();
                    break;

                case 3:
                    searchMenu();
                    break;

                case 4:
                    delete();
                    break;
                
                case 5:
                    showSalaryById();
                    break;
                
                case 6:
                    hrService.showAllEmployees();
//                    System.out.println("Exit program!");                            
                    break;
                case 7:
                    showbydept();
                    break;
                case 8:
                    salarybydept();
                    break;
                case 9:
                    hrService.showAllWorkLogs();
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
        System.out.println("2. Update Employees");
        System.out.println("3. Search For Employee"); 
        System.out.println("4. Remove Employee");
        System.out.println("5. Show Salary By ID");
        System.out.println("6. Show All Employees");                
        System.out.println("7. Show Employees By Department");                
        System.out.println("8. Show Salary By Department");        
        System.out.println("9. Show All WorkLogs");
        System.out.print("Choose: ");
    }

    // ================= SEARCH EMPLOYEE MENU =================
    
    private static void searchMenu(){
        System.out.println("\n--- Search By ---");
        System.out.println("1. ID");
        System.out.println("2. Full Name");
        System.out.println("3. Phone ");
        System.out.println("4. Email ");
        System.out.println("5. Department");
        
        System.out.print("Choose type: ");
        int type = Integer.parseInt(sc.nextLine());
        System.out.println("Search For: ");
        String sf = sc.nextLine().trim();
        hrService.searchEmployees(type,sf);
    }
    
    // ================= UPDATE EMPLOYEES =================

    private static void updateEmployees(){
        
        System.out.println("ID: ");
        String id = sc.nextLine().toLowerCase().trim();
        System.out.println("New Phone: ");
        String newphone = sc.nextLine().trim();
        System.out.println("New Email: ");
        String newemail = sc.nextLine().trim();
        
        hrService.updateEmployeess(id,newphone,newemail);

    }
    
    private static void delete(){
        System.out.println("Remove ID: ");
        String id = sc.nextLine().toLowerCase().trim();
        
        hrService.DelEmployee(id);
    }
    
    private static void showbydept(){
        System.out.println("Employees in Department ID: ");
        String deptid = sc.nextLine().toLowerCase().trim();
        
        hrService.showByDept(deptid);
    }
    
    private static void salarybydept(){
        System.out.println("Salary Of Department ID: ");
        String deptid = sc.nextLine().toLowerCase().trim();
        
        hrService.showSalaryDepId(deptid);
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
        String id = sc.nextLine().trim();

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

            System.out.print("Base salary: ");
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