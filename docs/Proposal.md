# ĐỀ XUẤT DỰ ÁN  
## Hệ thống Quản lý Nhân sự (Human Resource Management System – HRMS)

---

## 1. Tên dự án
**Hệ thống Quản lý Nhân sự (HRMS)**  
Ứng dụng Java chạy trên **console**, áp dụng các nguyên lý **Lập trình Hướng Đối Tượng (OOP)**.

---

## 2. Vấn đề cần giải quyết
Việc quản lý nhân viên theo phương pháp thủ công:
- Tốn nhiều thời gian
- Dễ xảy ra sai sót
- Khó mở rộng và thống kê dữ liệu

Dự án này nhằm xây dựng một hệ thống HRMS đơn giản bằng Java, hỗ trợ:
- Quản lý nhân viên và phòng ban
- Chấm công, nghỉ phép
- Tính lương và báo cáo lương cơ bản

---

## 3. Đối tượng sử dụng
- **Nhân viên Nhân sự (HR)**
- **Trưởng phòng / Quản lý phòng ban**
- **Quản trị viên hệ thống**

---

## 4. Phạm vi & Thiết kế tổng thể

### 4.1 Các thực thể chính (Entities)

- `Employee` (lớp trừu tượng)
- `FullTimeEmployee` – Nhân viên toàn thời gian
- `PartTimeEmployee` – Nhân viên bán thời gian
- `InternEmployee` – Thực tập sinh
- `Department` – Phòng ban
- `WorkLog` / `Attendance` – Nhật ký làm việc
- `LeaveOfAbsence` – Nghỉ phép

---

### 4.2 Các trường dữ liệu (Yêu cầu tối thiểu)

#### Employee (Nhân viên – abstract)
- `id` – mã nhân viên  
- `fullName` – họ và tên  
- `dateOfBirth` – ngày sinh  
- `phone` – số điện thoại  
- `email`  
- `departmentId` – mã phòng ban  

#### FullTimeEmployee
- `baseSalary` – lương cơ bản  
- `bonus` – thưởng

#### PartTimeEmployee
- `hourlyRate` – lương theo giờ   

#### InternEmployee
- `allowance` – trợ cấp  

#### Department
- `id` – mã phòng ban  
- `name` – tên phòng ban  

#### WorkLog
- `employeeId` – mã nhân viên  
- `workDate` – ngày làm việc  
- `hoursWorked` – số giờ làm  

#### LeaveOfAbsence
- `employeeId`  
- `fromDate`  
- `toDate`  
- `reason`  
- `status` – trạng thái (Pending / Approved / Rejected)

---

### 4.3 Thiết kế lớp (Cấu trúc OOP)

Hệ thống gồm **11 lớp chính**, áp dụng:
- Kế thừa (Inheritance)
- Trừu tượng (Abstraction)
- Đóng gói (Encapsulation)
- Đa hình (Polymorphism)

#### Nhóm lớp thực thể
- `Employee` (abstract)
- `FullTimeEmployee`
- `PartTimeEmployee`
- `InternEmployee`
- `Department`
- `WorkLog`
- `Leave`

#### Nhóm lớp xử lý nghiệp vụ
- `HRService`
  - `List<Employee>`
  - `List<Department>`
  - `List<WorkLog>`
  - `List<Leave>`

**Chức năng xử lý:**
- `add / remove / search employee`
- `assign department`
- `calculate payroll`
- `approve leave`

#### Nhóm lớp hệ thống
- `FileHandler`
  - `employeeFile`
  - `departmentFile`
  - `workLogFile`

**Chức năng:**
- `saveEmployees()`
- `loadEmployees()`
- `saveWorkLogs()`
- `loadLeaves()`

#### Lớp quản trị
- `Administrator`
  - `username`
  - `password`

---

## 5. Các chức năng chính

### 5.1 Quản lý nhân viên
- Thêm nhân viên mới  
  - Toàn thời gian / Bán thời gian / Thực tập sinh
- Cập nhật thông tin nhân viên
- Xóa nhân viên theo mã
- Hiển thị danh sách nhân viên
- Tìm kiếm nhân viên theo:
  - Tên
  - Phòng ban

---

### 5.2 Quản lý phòng ban
- Thêm phòng ban
- Cập nhật phòng ban
- Xóa phòng ban
- Gán nhân viên vào phòng ban

---

### 5.3 Tính lương & Báo cáo
- Tính lương cho từng nhân viên
- Tính tổng quỹ lương công ty
- Báo cáo lương theo phòng ban

---

### 5.4 Lưu trữ dữ liệu
- Lưu dữ liệu vào file **CSV / TXT**
- Tải dữ liệu khi chương trình khởi động
- Chức năng xử lý file sẽ được mở rộng ở các giai đoạn sau

---

## 6. Kết quả mong đợi
- File **`.jar`** chạy được
- Mã nguồn Java có cấu trúc rõ ràng
- **Sơ đồ lớp (UML)**
- **Lưu đồ (Flowchart)**
- File **`AI_LOG.md`** ghi lại quá trình sử dụng AI

---
