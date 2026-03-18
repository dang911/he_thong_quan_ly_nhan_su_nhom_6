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
        fileHandler.saveLeaves(leaves, true);
    }
    
    public void deleteEmployee(String id) {
        List<Employee> employeesF = fileHandler.loadEmployees();
        List<Employee> employeeAfter = new ArrayList<>();
        for (Employee e : employeesF) {
            if (!(e.getId().toLowerCase().equals(id.toLowerCase()))){
                employeeAfter.add(e);
            }
        }
        fileHandler.saveEmployees(employeeAfter,false);
    }
    
    public void updateEmployees(String id, String newphone,String newemail) {
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
                                + " | DepartmentID: " + e.getDepartmentId() + e.getSalaryInfo());
                    }
                }
                break;
            case (2):
                for (Employee e : employeesF) {
                    if (e.getFullName().toLowerCase().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + e.getSalaryInfo());
                    }
                }
                break;
            case (3):
                for (Employee e : employeesF) {
                    if (e.getPhone().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + e.getSalaryInfo());
                    }
                }
                break;
            case (4):
                for (Employee e : employeesF) {
                    if (e.getEmail().toLowerCase().equals(sf)) {
                        System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                                + " | Date Of Birth: " + e.getDateOfBirth()
                                + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                                + " | DepartmentID: " + e.getDepartmentId() + e.getSalaryInfo());
                    }
                }
                break;
            default:
                break;
        }
    }
    
    public void assignEmployees(String id, String deptId) {
        List<Employee> employeesF = fileHandler.loadEmployees();

        if (employeesF.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }
        
        for (Employee e : employeesF) {
            if (e.getId().toLowerCase().equals(id)) {
                e.setDepartment(deptId);
                System.out.println("Update Successfully!");
            }
        } 
        fileHandler.saveEmployees(employeesF,false);  
    }
    
    public double calculateSalaryById(String id){

        List<Employee> employeesF = fileHandler.loadEmployees();
        List<WorkLog> workLogs = fileHandler.loadWorkLogs();
        List<Leave> leaves = fileHandler.loadLeaves();
        Employee found = null;

        for (Employee e : employeesF) {
            if (e.getId().toLowerCase().equals(id)) {
                found = e;
                break;
            }
        }

        if (found == null) {
            return 0;
        } else {           
            return found.calculateSalary(workLogs,leaves);
        }
    }
    
    public void showSalaryDeptId(String deptId){
        List<Employee> employeesF = fileHandler.loadEmployees();
        List<WorkLog> workLogs = fileHandler.loadWorkLogs();
        List<Leave> leaves = fileHandler.loadLeaves();
        double sum = 0;
        for (Employee e : employeesF) {
            if (e.getDepartmentId().toLowerCase().equals(deptId)) {
                System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                    + " | Salary: " + String.format("%,.0f VND",e.calculateSalary(workLogs,leaves)));
                sum += e.calculateSalary(workLogs,leaves);
            }
        }
        System.out.println("| TOTAL SALARY OF " + deptId.toUpperCase() + " is " + String.format("%,.0f VND",sum));
    }
    
    public void showByDept(String deptId) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Employee> employeesF = fileHandler.loadEmployees();

        if (employeesF.isEmpty()) {
            System.out.println("No employee data found!");
            return;
        }

        System.out.println("\n===== DEPARTMENT "+deptId+" =====");

        for (Employee e : employeesF) {
            if (e.getDepartmentId().toLowerCase().equals(deptId)) {
                System.out.println("| ID: " + e.getId() + " | Name: " + e.getFullName()
                    + " | Date Of Birth: " + sdf.format(e.getDateOfBirth())
                    + " | Phone: " + e.getPhone() + " | Email: " + e.getEmail()
                    + " | DepartmentID: " + e.getDepartmentId() + e.getSalaryInfo());
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
                " | DepartmentID: " + e.getDepartmentId() + e.getSalaryInfo());
        }
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
            System.out.println(" | ID: " + w.getEmpId()+" | Date: " + 
                sdf.format(w.getDate())+" | Hours Workeds: " + 
                w.getHoursWorked());
        }
    }
    
    public void showAllLeaves() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Leave> leaves = fileHandler.loadLeaves();

        if (leaves.isEmpty()) {
            System.out.println("No leaves data found!");
            return;
        }

        System.out.println("\n===== LEAVES LIST =====");

        for (Leave l : leaves) {
            System.out.println(" | ID: " + l.getEmployeeId()+" | FromDate: " + 
                sdf.format(l.getFromDate())+" | ToDate: " + 
                sdf.format(l.getToDate())+" | Reason: " + l.getReason()+
                " | Status: " + l.convert());
        }
    }
    
    public void reviewLeave(String id, String result) {

        List<Leave> leavesF = fileHandler.loadLeaves();
        
        for (Leave l : leavesF) {
            if (l.getEmployeeId().toLowerCase().equals(id)) {
                l.setStatus(result);
            }
        }
        fileHandler.saveLeaves(leavesF,false);  
    }
}

