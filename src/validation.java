public class Validation {

    // 1. Kiem tra chuoi nhap vao hop le
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // 2. Kiem tra so duong
    public static boolean isPositiveNumber(double value) {
        return value > 0;
    }

    // 3. Kiem tra dinh dang email
    public static boolean isValidEmail(String email) {
        if (!isNotEmpty(email)) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    // 4. Kiem tra sdt hop le
    public static boolean isValidPhone(String phone) {
        if (!isNotEmpty(phone)) {
            return false;
        }
        return phone.matches("\\d{9,11}");
    }

    // 5. Kiem tra so gio lam viec
    public static boolean isValidWorkingHours(int hours) {
        return hours > 0 && hours <= 12;
    }

    // 6. Kiem tra ngay nghi hop le
    public static boolean isValidDateRange(java.time.LocalDate from,
                                           java.time.LocalDate to) {
        if (from == null || to == null) {
            return false;
        }
        return !from.isAfter(to);
    }
}

