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

    public double getAllowance() {
        return this.allowance;
    }
    @Override
    public double daySalary() {
        return this.allowance;
    }
    
    @Override
    public String toString() {
        return "IN," + super.toString() +  "," + this.allowance;
    }
    @Override
    public String getSalaryInfo(){
        return "| Allowance: " + this.allowance;
    }
}
