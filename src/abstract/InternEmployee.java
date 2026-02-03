package hrdemo;

import java.util.Date;

public class InternEmployee extends Employee {
    private double allowance;

    public InternEmployee(String id, String fullName, Date dob,
                           String phone, String email, String deptId,
                           double allowance) {
        super(id, fullName, dob, phone, email, deptId);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return this.allowance;
    }
}
