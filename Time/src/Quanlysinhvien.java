import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class Quanlysinhvien {

    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so luong sv:");
        n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        for (int i = 1; i <= n; i++) {
            input();
        }
        System.out.println("IN DANH SACH SV:");
        output();

        // You can add more calls here to test other methods
    }

    // Nhap moi 1 sinh vien
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao thong tin sinh vien:");
        System.out.println("Nhap ma sv:");
        String code = scanner.nextLine();
        System.out.println("Nhap ten sv:");
        String name = scanner.nextLine();
        System.out.println("Nhap tuoi:");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.println("Nhap email:");
        String email = scanner.nextLine();
        System.out.println("Nhap sdt:");
        String phone = scanner.nextLine();
        System.out.println("Nhap gioi tinh (0 - Nu, 1 - Nam):");
        int gender = scanner.nextInt();
        System.out.println("Nhap diem:");
        float grade = scanner.nextFloat();
        scanner.nextLine(); // consume the newline

        Student student = new Student(name, age, email, phone, code, gender, grade);
        studentList.add(student);
    }

    // In danh sach sinh vien
    public static void output() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    // Xoa sinh vien theo ma code
    public static void removeByCode(String code) {
        studentList.removeIf(student -> student.getCode().equals(code));
    }

    // Sap xep sinh vien theo thu tu diem giam dan
    public static void sortByGradeDesc() {
        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
    }

    // Tim kiem sinh vien theo ma sinh vien hoac ten sinh vien
    public static Student findByCodeOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getCode().equalsIgnoreCase(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    // Tim kiem sinh vien co diem >= x
    public static List<Student> filterByGrade(float x) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                result.add(student);
            }
        }
        return result;
    }
}

class Student {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String code;
    private int gender; // 0 - Female, 1 - Male
    private float grade;

    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.code = code;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + (gender == 1 ? "Male" : "Female") +
                ", grade=" + grade +
                '}';
    }
}











