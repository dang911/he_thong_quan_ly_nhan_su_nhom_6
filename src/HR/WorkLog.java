package hrdemo;

import java.util.Date;

public class WorkLog {
    private String employeeId;
    private Date date;
    private double hoursWorked;

    public WorkLog(String employeeId, Date date, double hoursWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }
    
    public long daysWorked() {
        long diff = System.currentTimeMillis() - this.date.getTime();
        return diff / (24L * 60 * 60 * 1000);
    }
    public double getHoursWorked() {
        return this.hoursWorked;
    }
    public Date getDate() {
        return this.date;
    }
    public String getEmpId() {
        return this.employeeId;
    }
}
