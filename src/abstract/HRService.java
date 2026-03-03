package hrdemo;


import java.util.*;

public class HRService {
    private List<Employee> employees = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<WorkLog> workLogs = new ArrayList<>();
    private List<Leave> leaves = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }

    public void addWorkLog(WorkLog w) {
        this.workLogs.add(w);
    }

    public void requestLeave(Leave l) {
        this.leaves.add(l);
    }
    
    public double calculateSalaryById(String id){
        FileHandler fileHandler = new FileHandler();

        List<Employee> employees = fileHandler.loadEmployees();
        List<WorkLog> workLogs = fileHandler.loadWorkLogs();
        
        Employee found = null;

        for (Employee e : employees) {
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
    
    public void showAllEmployees() {

        List<Employee> employees = fileHandler.loadEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }

        System.out.println("\n===== EMPLOYEE LIST =====");

        for (Employee e : employees) {
            System.out.println("----------------------");
            System.out.println("ID: " + e.getId());
            System.out.println("Name: " + e.getFullName());
            System.out.println("DOB: " + e.getDateOfBirth());
            System.out.println("Phone: " + e.getPhone());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Department: " + e.getDepartmentId());
            System.out.println("DaySalary: " + e.calculateSalary());
        }
}
    public void showAllWorkLogs() {
        List<WorkLog> workLogs = fileHandler.loadWorkLogs();

        if (workLogs.isEmpty()) {
            System.out.println("No workLog data found!");
            return;
        }

        System.out.println("\n===== WORKLOGS LIST =====");

        for (WorkLog w : workLogs) {
            System.out.println("----------------------");
            System.out.println("ID: " + w.getEmpId());
            System.out.println("Date: " + w.getDate());
            System.out.println("Hours Workeds: " + w.getHoursWorked());
        }
    }
}
