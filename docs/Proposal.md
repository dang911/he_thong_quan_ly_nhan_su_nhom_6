# ĐỀ XUẤT DỰ ÁN

## 1. Tên dự án

**Hệ thống Quản lý Nhân sự (Human Resource Management System – HRMS)**

## 2. Vấn đề cần giải quyết

Việc quản lý nhân viên thủ công tốn nhiều thời gian và dễ xảy ra sai sót.

Dự án này nhằm xây dựng một ứng dụng **Java chạy trên console**, giúp quản lý nhân viên và phòng ban, hỗ trợ **tính lương** và **tạo các báo cáo lương cơ bản**, dựa trên các nguyên lý **Lập trình Hướng Đối Tượng (OOP)**.

## 3. Đối tượng sử dụng

* Nhân viên nhân sự (HR)
* Trưởng phòng / Quản lý phòng ban
* Quản trị viên hệ thống

## 4. Phạm vi & Thiết kế tổng thể

### 4.1. Các thực thể chính (Entities)

* `Employee` (lớp trừu tượng)
* `FullTimeEmployee` (Nhân viên toàn thời gian)
* `PartTimeEmployee` (Nhân viên bán thời gian)
* `InternEmployee` (Thực tập sinh)
* `Department` (Phòng ban)
* `Attendance / WorkLog` (Chấm công / Nhật ký làm việc)

### 4.2. Các trường dữ liệu (Yêu cầu tối thiểu)

#### Employee (Nhân viên)

* `id` – mã nhân viên
* `fullName` – họ và tên
* `dateOfBirth` – ngày sinh
* `phone` – số điện thoại
* `email`
* `departmentId` – mã phòng ban

#### FullTimeEmployee (Toàn thời gian)

* `baseSalary` – lương cơ bản
* `bonus` – thưởng
* `allowance` – phụ cấp

#### PartTimeEmployee (Bán thời gian)

* `hourlyRate` – lương theo giờ
* `hoursWorked` – số giờ làm việc

#### InternEmployee (Thực tập sinh)

* `stipend / allowance` – trợ cấp

#### Department (Phòng ban)

* `id` – mã phòng ban
* `name` – tên phòng ban
* `available` - số lượng nhân viên 

#### WorkLog (Nhật ký làm việc)

* `employeeId` – mã nhân viên
* `workDate` – ngày làm việc
* `hoursWorked` – số giờ làm việc

### 4.3. Thiết kế lớp (Cấu trúc OOP)

Hệ thống được thiết kế với **11 lớp chính**, áp dụng các nguyên lý **kế thừa**, **trừu tượng** và **đóng gói**.

#### Nhóm lớp thực thể

* `Employee` (abstract)
* `FullTimeEmployee`
* `PartTimeEmployee`
* `InternEmployee`
* `Department`
* `WorkLog`

#### Nhóm lớp xử lý nghiệp vụ

**EmployeeManager**

* Thêm, sửa, xóa nhân viên
* Tìm kiếm và hiển thị nhân viên

**DepartmentManager**

* Thêm, sửa, xóa phòng ban
* Gán nhân viên vào phòng ban

**PayrollService**

* Tính lương cho từng nhân viên
* Tính tổng lương toàn công ty
* Báo cáo lương theo phòng ban

#### Nhóm lớp hệ thống

**FileHandler**

* Lưu và đọc dữ liệu từ file CSV/TXT

**MainApp**

* Menu console
* Điểm bắt đầu chạy chương trình

## 5. Các chức năng chính

### 5.1. Quản lý nhân viên

* Thêm nhân viên mới (chọn loại: toàn thời gian / bán thời gian / thực tập sinh)
* Cập nhật thông tin nhân viên
* Xóa nhân viên theo mã
* Hiển thị danh sách nhân viên
* Tìm kiếm nhân viên theo tên hoặc phòng ban

### 5.2. Quản lý phòng ban

* Thêm phòng ban
* Cập nhật phòng ban
* Xóa phòng ban
* Gán nhân viên vào phòng ban

### 5.3. Tính lương & Báo cáo

* Tính lương cho từng nhân viên
* Tính tổng quỹ lương của công ty
* Báo cáo lương theo từng phòng ban

### 5.4. Lưu trữ dữ liệu

* Lưu dữ liệu nhân viên và phòng ban vào file (CSV/TXT)
* Tải dữ liệu từ file khi chương trình khởi động
* Chức năng xử lý file sẽ được hoàn thiện ở các giai đoạn sau

## 6. Kết quả mong đợi

* File `.jar` chạy được
* Mã nguồn Java có cấu trúc rõ ràng
* Sơ đồ lớp (UML) và lưu đồ (flowchart)
* File **AI_LOG.md** ghi lại quá trình sử dụng AI
