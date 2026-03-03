package hrdemo;

import java.util.Date;

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
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartmentId() {
        return departmentId;
    }
    @Override
    public String toString() {
        return "| ID: " + this.id + " | Name: " + this.fullName + " | Date Of Birth: " + this.dateOfBirth + " | Phone: " + this.phone + " | Email: " + this.email + " | DepartmentID: " + this.departmentId;
    }
    public abstract double calculateSalary();
}

