package notabstract;

import java.util.Date;

public class InternEmployee {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String departmentId;
    private double allowance;

    public InternEmployee(String id, String fullName, Date dateOfBirth,
                    String phone, String email, String departmentId, double 
                    allowance) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.departmentId = departmentId;
        this.allowance = allowance;
    }
    
    @Override
    public String toString() {
        return this.id + " - " + this.fullName + " - " + this.departmentId;
    }
    public double calculateSalary() {
        return this.allowance;
    }
}
    

