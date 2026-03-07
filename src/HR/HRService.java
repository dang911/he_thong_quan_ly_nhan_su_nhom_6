package hrdemo;


import java.util.*;
import java.text.SimpleDateFormat;

public class HRService {
    private List<Employee> employees = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<WorkLog> workLogs = new ArrayList<>();
    private List<Leave> leaves = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    public void addEmployee(Employee e) {
        this.employees.add(e);
        fileHandler.saveEmployees(this.employees,true);
    }

    public void addWorkLog(WorkLog w) {
        this.workLogs.add(w);
    }

    public void requestLeave(Leave l) {
        this.leaves.add(l);
    }
    
    public void DelEmployee(String id) {
        List<Employee> employeesF = fileHandler.loadEmployees();
        List<Employee> employeeAfter = new ArrayList<>();
        for (Employee e : employeesF) {
            if (!(e.getId().toLowerCase().equals(id.toLowerCase()))){
                employeeAfter.add(e);
            }
        }
        fileHandler.saveEmployees(employeeAfter,false);
    }
    
    public void updateEmployeess(String id, String newphone,String newemail) {
        List<Employee> employeesF = fileHandler.loadEmployees();

        if (employeesF.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }
        
        for (Employee e : employeesF) {
            if (e.getId().toLowerCase().equals(id)) {
                e.setPhone(newphone);
                e.setEmail(newemail);
                System.out.println("Update Successfully!");
            }
        } 
        fileHandler.saveEmployees(employeesF,false);
        
    }
    
    public void searchEmployees(int type, String sf) {
        List<Employee> employeesF = fileHandler.loadEmployees();

        if (employeesF.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }
        switch (type) {
            case (1):
                for (Employee e : employeesF) {
                    if (e.getId().toLowerCase().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
                    }
                }
                break;
            case (2):
                for (Employee e : employeesF) {
                    if (e.getFullName().toLowerCase().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
                    }
                }
                break;
            case (3):
                for (Employee e : employeesF) {
                    if (e.getPhone().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
                    }
                }
                break;
            case (4):
                for (Employee e : employeesF) {
                    if (e.getId().toLowerCase().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
                    }
                }
                break;
            case (5):
                for (Employee e : employeesF) {
                    if (e.getDepartmentId().toLowerCase().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
                    }
                }
                break;
            default:
                break;
        }
    }

    
    public double calculateSalaryById(String id){
        FileHandler fileHandler = new FileHandler();

        List<Employee> employeesF = fileHandler.loadEmployees();
        List<WorkLog> workLogs = fileHandler.loadWorkLogs();
        
        Employee found = null;

        for (Employee e : employeesF) {
            if (e.getId().equals(id)) {
                found = e;
                break;
            }
        }
       

        if (found == null) {
            return 0;
        }    
            long days = 0;
        for (WorkLog w : workLogs) {
            if (w.getEmpId().equals(id)) {
                days = w.daysWorked();
            }
        }
        return found.calculateSalary() * days;
    }
    
    public void showSalaryDepId(String depId){
        FileHandler fileHandler = new FileHandler();

        List<Employee> employeesF = fileHandler.loadEmployees();
        List<WorkLog> workLogs = fileHandler.loadWorkLogs();
        
        Employee found = null;

        for (Employee e : employeesF) {
            if (e.getDepartmentId().toLowerCase().equals(depId)) {

                for (WorkLog w : workLogs) {
                    if (w.getEmpId().equals(e.getId())) {
                        long days = w.daysWorked();
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Salary: " + e.calculateSalary() * days);
                    }
                }
            }
        }
    }
    
    public void showByDept(String depID) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Employee> employeesF = fileHandler.loadEmployees();

        if (employeesF.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }

        System.out.println("\n===== DEPARTMENT "+depID+" =====");

        for (Employee e : employeesF) {
            if (e.getDepartmentId().toLowerCase().equals(depID)) {
                System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                    + " | Date Of Birth: " + sdf.format(e.getDateOfBirth())
                    + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                    + " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
            }
        }
    }
    
    public void showAllEmployees() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Employee> employeesF = fileHandler.loadEmployees();

        if (employeesF.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }

        System.out.println("\n===== EMPLOYEE LIST =====");

        for (Employee e : employeesF) {
            System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName() + 
                " | Date Of Birth: " + sdf.format(e.getDateOfBirth()) + 
                " | Phone: " + e.getPhone() + " | Email: " + e.getEmail() + 
                " | DepartmentID: " + e.getDepartmentId() + " | DaySalary: " + e.calculateSalary());
        }
//        for (Employee e : this.employees) {
//            System.out.println(e + " | DaySalary: " + e.calculateSalary());
//        }
    }
    
    public void showAllWorkLogs() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<WorkLog> workLogs = fileHandler.loadWorkLogs();

        if (workLogs.isEmpty()) {
            System.out.println("No workLog data found!");
            return;
        }

        System.out.println("\n===== WORKLOGS LIST =====");

        for (WorkLog w : workLogs) {
            System.out.println("----------------------");
            System.out.println("ID: " + w.getEmpId());
            System.out.println("Date: " + sdf.format(w.getDate()));
            System.out.println("Hours Workeds: " + w.getHoursWorked());
        }
    }
}

