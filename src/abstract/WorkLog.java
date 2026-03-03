package hrdemo;

import java.util.Date;

public class WorkLog {
    private String employeeId;
    private Date date;
    private int hoursWorked;

    public WorkLog(String employeeId, Date date, int hoursWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }
}
