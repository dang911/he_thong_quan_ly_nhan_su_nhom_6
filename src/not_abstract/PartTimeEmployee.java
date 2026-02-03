package notabstract;

import java.util.Date;

public class PartTimeEmployee {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String departmentId;
    private double hourRate;

    public PartTimeEmployee(String id, String fullName, Date dateOfBirth,
                    String phone, String email, String departmentId, double
                    hourRate) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.departmentId = departmentId;
        this.hourRate = hourRate;
    }
    @Override
    public String toString() {
        return this.id + " - " + this.fullName + " - " + this.departmentId;
    }
    public double calculateSalary(){
        return this.hourRate;
    };
}

