package hrdemo;

import java.util.Date;

public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;

    public FullTimeEmployee(String id, String fullName, Date dob,
                            String phone, String email, String deptId,
                            double baseSalary, double bonus) {
        super(id, fullName, dob, phone, email, deptId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary + this.bonus;
    }
}
