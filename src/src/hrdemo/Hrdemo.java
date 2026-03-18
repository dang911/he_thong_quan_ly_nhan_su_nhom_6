
package hrdemo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
                    employeeMenu();
                    break;

                case 2:
                    departmentMenu();
                    break;

                case 3:
                    salaryMenu();
                    break;

                case 4:
                    leaveMenu();
                    break;

                case 5:
                    hrService.showAllWorkLogs();
                    break;
                    
                case 6:
                    System.out.println("Exit program!");
                    break;                    
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
    // ================= MENU =================

    private static void showMenu() {
        System.out.println("\n===== HUMAN RESOURCE MANAGEMENT =====");
        System.out.println("1. Employee Management");
        System.out.println("2. Department Management");
        System.out.println("3. Salary Management");
        System.out.println("4. Leave Management");
        System.out.println("5. WorkLog Management");
        System.out.println("6. Exit");
        System.out.print("Choose: ");
    }
    
    private static void employeeMenu() {

        System.out.println("\n--- Employee Management ---");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Remove Employee");
        System.out.println("5. Show All Employee");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine());

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
                hrService.showAllEmployees();

            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void salaryMenu() {

        System.out.println("\n--- Salary Management ---");
        System.out.println("1. Show Salary By ID");
        System.out.println("2. Show Salary By Department");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:
                showSalaryById();
                break;

            case 2:
                salarybydept();
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void departmentMenu() {

        System.out.println("\n--- Department Management ---");
        System.out.println("1. Show Employees By Department");
        System.out.println("2. Add Employee To Department");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:
                showbydept();
                break;

            case 2:
                addEmpToDept();
                break;

            default:
                System.out.println("Invalid choice!");
        }
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

    private static void updateEmployees() {

        System.out.print("ID: ");
        String id = sc.nextLine().toLowerCase().trim();

        String newphone;
        do {
            System.out.print("New Phone: ");
            newphone = sc.nextLine().trim();

            if (!Validation.isValidPhone(newphone)) {
                System.out.println("Invalid phone! Phone must be 9-11 digits.");
            }

        } while (!Validation.isValidPhone(newphone));

        String newemail;
        do {
            System.out.print("New Email: ");
            newemail = sc.nextLine().trim();

            if (!Validation.isValidEmail(newemail)) {
                System.out.println("Invalid email format!");
            }

        } while (!Validation.isValidEmail(newemail));

        hrService.updateEmployees(id, newphone, newemail);
    }
    
//    =====================================================================
    
    private static void addEmpToDept() {
        System.out.print("ID: ");
        String id = sc.nextLine().toLowerCase().trim();

        String deptId;
            do {
                System.out.print("Department ID: ");
                deptId = sc.nextLine();
            } while (!Validation.isNotEmpty(deptId));

        hrService.assignEmployees(id, deptId);
    }
    
    private static void delete(){
        System.out.println("Remove ID: ");
        String id = sc.nextLine().toLowerCase().trim();
        
        hrService.deleteEmployee(id);
    }
    
    private static void showbydept(){
        System.out.println("Employees in Department ID: ");
        String deptId = sc.nextLine().toLowerCase().trim();
        
        hrService.showByDept(deptId);
    }
    
    private static void salarybydept(){
        System.out.println("Salary Of Department ID: ");
        String deptId = sc.nextLine().toLowerCase().trim();
        
        hrService.showSalaryDeptId(deptId);
    }
    
    // ================= LEAVE MENU =================

    
    private static void leaveMenu() {

        System.out.println("\n--- LEAVE MANAGEMENT ---");
        System.out.println("1. Add requests");
        System.out.println("2. Review request");
//        System.out.println("3.");
        System.out.print("Choose type: ");
        
        int type = Integer.parseInt(sc.nextLine());
        switch (type) {
            case 1:
                addRequests();
                break;
            case 2:
                reviewRQ();
                break;
            default:
                System.out.println("Invalid type!");
        }
    }
    
    private static void reviewRQ() {
        hrService.showAllLeaves();
        
        System.out.println("Review ID: ");
        String id = sc.nextLine().toLowerCase().trim();
        
        System.out.println("Approved/Rejected (1/0):");
        String result = sc.nextLine();

        System.out.println("Enter to Exit (Y to continue): ");
        String type = sc.nextLine().toLowerCase();
        
        hrService.reviewLeave(id, result);
        
        switch (type) {
            case "y":
                leaveMenu();
                break;
            default:
                showMenu();
        }
    }
    
    private static void addRequests() {
      try {
            String id;
            do {
                System.out.print("ID: ");
                id = sc.nextLine();
            } while (!Validation.isNotEmpty(id));
            
            Date fromDate;
            System.out.print("Leave Date (dd/MM/yyyy): ");
            fromDate = sdf.parse(sc.nextLine());
            Date toDate;
            System.out.print("Back Date (dd/MM/yyyy): ");
            toDate = sdf.parse(sc.nextLine());
            
            String reason;
            do {
                System.out.print("Reason: ");
                reason = sc.nextLine();
            } while (!Validation.isNotEmpty(reason));

            String status = "Pending";
            
            Leave l = new Leave(id, fromDate, toDate, reason, status);

            hrService.requestLeave(l);

            System.out.println("Added Request successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
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
        String id = sc.nextLine().toLowerCase().trim();

        double salary = hrService.calculateSalaryById(id);

        System.out.println("Salary of employee " + id + " is: " + 
                String.format("%,.0f VND",salary));
    }

    // ================= ADD FULL TIME =================

    private static void addFullTimeEmployee() {
        try {

            String id;
            do {
                System.out.print("ID: ");
                id = sc.nextLine();
            } while (!Validation.isNotEmpty(id));

            String name;
            do {
                System.out.print("Full name: ");
                name = sc.nextLine();
            } while (!Validation.isNotEmpty(name));

            System.out.print("Date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(sc.nextLine());

            String phone;
            do {
                System.out.print("Phone: ");
                phone = sc.nextLine();
            } while (!Validation.isValidPhone(phone));

            String email;
            do {
                System.out.print("Email: ");
                email = sc.nextLine();
            } while (!Validation.isValidEmail(email));

            String deptId;
            do {
                System.out.print("Department ID: ");
                deptId = sc.nextLine();
            } while (!Validation.isNotEmpty(deptId));

            double salary;
            do {
                System.out.print("Base salary: ");
                salary = Double.parseDouble(sc.nextLine());

                if (!Validation.isPositiveNumber(salary)) {
                    System.out.println("Salary must be positive!");
                }

            } while (!Validation.isPositiveNumber(salary));

            double bonus;
            do {
                System.out.print("Bonus: ");
                bonus = Double.parseDouble(sc.nextLine());

            } while (!Validation.isPositiveNumber(bonus));

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

            String id;
            do {
                System.out.print("ID: ");
                id = sc.nextLine();
            } while (!Validation.isNotEmpty(id));

            String name;
            do {
                System.out.print("Full name: ");
                name = sc.nextLine();
            } while (!Validation.isNotEmpty(name));

            System.out.print("Date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(sc.nextLine());

            String phone;
            do {
                System.out.print("Phone: ");
                phone = sc.nextLine();
            } while (!Validation.isValidPhone(phone));

            String email;
            do {
                System.out.print("Email: ");
                email = sc.nextLine();
            } while (!Validation.isValidEmail(email));
            
            String deptId;
            do {
                System.out.print("Department ID: ");
                deptId = sc.nextLine();
            } while (!Validation.isNotEmpty(deptId));

            double rate;
            do {
                System.out.print("Hourly rate: ");
                rate = Double.parseDouble(sc.nextLine());

                if (!Validation.isPositiveNumber(rate)) {
                    System.out.println("Rate must be positive!");
                }

            } while (!Validation.isPositiveNumber(rate));

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

            String id;
            do {
                System.out.print("ID: ");
                id = sc.nextLine();
            } while (!Validation.isNotEmpty(id));

            String name;
            do {
                System.out.print("Full name: ");
                name = sc.nextLine();
            } while (!Validation.isNotEmpty(name));

            System.out.print("Date of birth (dd/MM/yyyy): ");
            Date dob = sdf.parse(sc.nextLine());

            String phone;
            do {
                System.out.print("Phone: ");
                phone = sc.nextLine();
            } while (!Validation.isValidPhone(phone));

            String email;
            do {
                System.out.print("Email: ");
                email = sc.nextLine();
            } while (!Validation.isValidEmail(email));

            String deptId;
            do {
                System.out.print("Department ID: ");
                deptId = sc.nextLine();
            } while (!Validation.isNotEmpty(deptId));

            double allowance;
            do {
                System.out.print("Allowance: ");
                allowance = Double.parseDouble(sc.nextLine());

                if (!Validation.isPositiveNumber(allowance)) {
                    System.out.println("Allowance must be positive!");
                }

            } while (!Validation.isPositiveNumber(allowance));

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
