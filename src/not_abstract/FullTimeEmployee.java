package notabstract;

import java.util.Date;

public class FullTimeEmployee {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String departmentId;
    private double baseSalary;
    private double bonus;


    public FullTimeEmployee(String id, String fullName, Date dateOfBirth,
                    String phone, String email, String departmentId, double 
                    baseSalary, double bonus) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.departmentId = departmentId;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }
    
    @Override
    public String toString() {
        return this.id + " - " + this.fullName + " - " + this.departmentId;
    }
    public double calculateSalary(){
        return this.baseSalary + this.bonus;
    };
    
}

