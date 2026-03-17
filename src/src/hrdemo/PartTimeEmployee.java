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
    
    public double getHourlyRate() {
        return this.hourlyRate;
    }
    
    @Override
    public double daySalary() {
        return this.hourlyRate * 5;
    }
    @Override
    public String toString() {
        return "PT," + super.toString() +  "," + this.hourlyRate;
    }
    @Override
    public String getSalaryInfo(){
        return "| Hourly Rate: " + this.hourlyRate;
    }
}