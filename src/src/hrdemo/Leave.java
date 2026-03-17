package hrdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Leave {
    private String employeeId;
    private Date fromDate;
    private Date toDate;
    private String reason;
    private String status;

    public Leave(String employeeId, Date from, Date to,
                 String reason, String status) {
        this.employeeId = employeeId;
        this.fromDate = from;
        this.toDate = to;
        this.reason = reason;
        this.status = status;
    }
    
    public long CalLeaveDays(){
        long diff = this.toDate.getTime() - this.fromDate.getTime();
        return diff / (24L * 60 * 60 * 1000);
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public String getReason() {
        return this.reason;
    }
    
    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status) {    
        this.status = status;
    }
    
    public String convert(){
        String s;
        switch (this.status){
            case "0":
                s = "Rejected";
                break;
            case "1":
                s = "Approved";
                break;
            default:
                s = "Pending";       
        }
        return s;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return this.employeeId + "," + sdf.format(this.fromDate) + "," + sdf.format(this.toDate) + "," + 
               this.reason + "," + getStatus();
    }
}
