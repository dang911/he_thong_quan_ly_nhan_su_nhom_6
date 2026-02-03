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
    @Override
    public String toString() {
        return this.id + " - " + this.fullName + " - " + this.departmentId;
    }
    public abstract double calculateSalary();
}

