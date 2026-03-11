
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
    +getFullName()  String
    +getDateOfBirth() Date
    +getPhone() String
    +getEmail() String
    +getDepartmentId() String
    +setPhone(newphone: String) void
    +setEmail(newemail: String) void
    +calculateSalary() double
    +toString() String
}

class FullTimeEmployee{
    -baseSalary : double
    -bonus : double
    +FullTimeEmployee(id: String,fullName: String,dob: Date,phone: String,email: String,departmentId: String)
    +getBaseSalary() double
    +getBonus() double
    +calculateSalary() double
    +toString() String
}

class PartTimeEmployee{
    -hourlyRate : double
    +PartTimeEmployee(id: String,fullName: String,dob: Date,phone: String,email: String,departmentId: String)
    +getHourlyRate() double
    +calculateSalary() double
    +toString() String
}

class InternEmployee{
    -allowance : double
    +InternEmployee(id: String,fullName: String,dob: Date,phone: String,email: String,departmentId: String)
    +getAllowance()  double
    +calculateSalary() double
    +toString() String
}

class Department{
    -id : String
    -name : String
    +Department(id,name)
}

class HRService{
    -employees : List<Employee>
    -departments :List<Department>
    -workLogs: List<WorkLog>
    -leaves: List<Leave>
    -fileHandler: FileHandler
    +addEmployee(e: Employee)  void
    +addWorkLog(w WorkLog) void
    +DeleteEmployee(id: String)  void
    +updateEmployee( id: String)  void
    +searchEmployee( type: int,sf: String)  void
    +calculateSalaryById(id: String) double
    +showSalaryDepId(depId: String) void
    +showByDept(depID String) void
    +showAllEmployees() void
    +showAllWorkLogs()  void
}

class FileHandler{
    +saveEmployees(employees: List<Employee>,append: boolean): void
    +saveWorkLogs(workLogs: List<WorkLog>) void
    +loadEmployees() List<Employee>
    +loadWorkLogs() List<WorkLog> 
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

class Hrdemo{
    -sc: Scanner
    -hrService: HRService
    -sdf: SimpleDateFormat
    +main(String[] args) void
    +showMenu() void
    +searchMenu() void
    +updateEmployees() void
    +delete() void
    +showbydept() void
    +salarybydept() void
    +addEmployeeMenu() void
    +showSalaryById() void
    +addFullTimeEmployee() void
    +addPartTimeEmployee() void
    +addInternEmployee() void
}

Employee <|-- FullTimeEmployee
Employee <|-- PartTimeEmployee
Employee <|-- InternEmployee
