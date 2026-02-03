package hrdemo;

import java.util.Date;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;

    public PartTimeEmployee(String id, String fullName, Date dob,
                            String phone, String email, String deptId,
                            double hourlyRate) {
        super(id, fullName, dob, phone, email, deptId);
        this.hourlyRate = hourlyRate;

    }

    @Override
    public double calculateSalary() {
        return this.hourlyRate;
    }
}
