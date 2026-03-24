package hrdemo;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public abstract class Employee {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String departmentId;

    public Employee(String id, String fullName, Date dateOfBirth,
                    String phone, String email, String departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.departmentId = departmentId;
    }
    public String getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setPhone(String newphone) {
        this.phone = newphone;
    }

    public void setEmail(String newemail) {
        this.email = newemail;
    }

    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartment(String deptId) {
        this.departmentId = deptId;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return this.id + "," + this.fullName + 
                "," + sdf.format(this.dateOfBirth) + 
                "," + this.phone + "," + 
                this.email + "," + this.departmentId;
    }
    public double calculateSalary(List<WorkLog> workLogs, List<Leave> leaves){
        long days = 0;
        for (WorkLog w : workLogs) {
            if (w.getEmpId().equals(this.id)) {
               days = w.daysWorked();
            } 
        }
        long daysoff = 0;
        for (Leave l : leaves) {
            if (l.getEmployeeId().equals(this.id)) {
                if (l.convert().equals("Approved")){
                    daysoff = l.calLeaveDays();
                }
            }
        }
        return daySalary()*(days-daysoff);
    }
    
    public abstract double daySalary();
    public abstract String getSalaryInfo();
}

