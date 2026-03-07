package hrdemo;

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
}
