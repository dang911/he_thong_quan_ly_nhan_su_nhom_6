
```mermaid
classDiagram
class Employee{
    -id : String
    -fullName : String
    -dateOfBirth : Date
    -phone : String
    -email : String
    -departmentId : String
    +Employee(id: String,fullName: String,dateOfBirth: Date,phone: String,email: String,departmentId: String)
    +getId()  String
    +getFullName() String
    +getDateOfBirth() Date
    +getPhone() String
    +getEmail() String
    +getDepartmentId() String
    +setPhone(newphone: String) void
    +setEmail(newemail: String) void
    +daySalary() double
    +getSalaryInfo() double
    +calculateSalary(workLogs: List<WorkLog>) double
    +toString() String
}

class FullTimeEmployee{
    -baseSalary : double
    -bonus : double
    +FullTimeEmployee(id: String,fullName: String,dob: Date,phone: String,email: String,departmentId: String)
    +getBaseSalary() double
    +getBonus() double
    +daySalary() double
    +getSalaryInfo() double
    +toString() String
}

class PartTimeEmployee{
    -hourlyRate : double
    +PartTimeEmployee(id: String,fullName: String,dob: Date,phone: String,email: String,departmentId: String)
    +getHourlyRate() double
    +daySalary() double
    +getSalaryInfo() double
    +toString() String
}

class InternEmployee{
    -allowance : double
    +InternEmployee(id: String,fullName: String,dob: Date,phone: String,email: String,departmentId: String)
    +getAllowance()  double
    +daySalary() double
    +getSalaryInfo() double
    +toString() String
}

class Department{
    -id : String
    -name : String
    +Department(id,name)
    +getId() String
    +getName() String
}

class HRService{
    -employees : List<Employee>
    -departments :List<Department>
    -workLogs: List<WorkLog>
    -leaves: List<Leave>
    -fileHandler: FileHandler
    +addEmployee(e: Employee)  void
    +addWorkLog(w: WorkLog) void
    +deleteEmployee(id: String)  void
    +updateEmployee( id: String)  void
    +searchEmployee( type: int,sf: String)  void
    +assignEmployees(id: String, deptId: String) void
    +calculateSalaryById(id: String) double
    +showSalaryDeptId(deptId: String) void
    +showByDept(deptId: String) void
    +showAllEmployees() void
    +showAllWorkLogs()  void
    +showAllLeaves() void
    +reviewLeave(id:String, result: String) void
}

class FileHandler{
    +saveEmployees(employees: List<Employee>,append: boolean) void
    +loadEmployees() List<Employee>
    +loadWorkLogs() List<WorkLog>
    +saveLeaves(leaves: List<Leave>) void
    +loadLeaves() List<Leave>
}

class WorkLog{
    -employeeId: String
    -date: Date
    +WorkLog(employeeId: String, date: Date, hoursWorked: double)
    +dayWorked() long
    +getHoursWorked() double
    +getDate() Date
    +getEmpId() String
}

class Leave{
    -employeeId: String
    -fromDate: Date
    -toDate: Date
    -reason: String
    -status: String
    +Leave(employeeId: String, fromDate: Date, toDate: Date, reason: String, status: String)
    +getFromDate() Date
    +getToDate() Date
    +getEmployeeId() String
    +getReason() String
    +getStatus() String
    +setStatus(status: String) void
    +calLeaveDays() long
    +convert() String
    toString() String
}

class Validation{
    +isNotEmpty(value: String) boolean
    +isPositiveNumber(value: double) boolean
    +isValidEmail(email: String) boolean
    +isValidPhone(phone: String) boolean
    +isValidWorkingHours(hours: int) boolean
    +isValidDateRange(from: java.time.LocalDate ,to: java.time.LocalDate) boolean
}

class Hrdemo{
    -sc: Scanner
    -hrService: HRService
    -sdf: SimpleDateFormat
    +main(String[] args) void
    +showMenu() void
    +employeeMenu() void
    +salaryMenu() void
    +departmentMenu() void
    +searchMenu() void
    +addEmpToDept() void
    +updateEmployees() void
    +delete() void
    +showbydept() void
    +salarybydept() void
    +leaveMenu() void
    +reviewRQ() void
    +addRequests() void
    +addEmployeeMenu() void
    +showSalaryById() void
    +addFullTimeEmployee() void
    +addPartTimeEmployee() void
    +addInternEmployee() void
}

Employee <|-- FullTimeEmployee
Employee <|-- PartTimeEmployee
Employee <|-- InternEmployee
