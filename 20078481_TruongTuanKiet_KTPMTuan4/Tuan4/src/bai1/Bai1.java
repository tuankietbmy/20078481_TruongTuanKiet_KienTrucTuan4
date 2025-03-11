package bai1;

import java.util.ArrayList;
import java.util.List;

// Observer Interface (Sinh viên)
interface Observer {
    void update(String message);
}

// Concrete Observer (Sinh viên)
class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " nhận được thông báo: " + message);
    }
}

// Subject Interface (Lớp học)
class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Concrete Subject (Lớp học)
class Classroom extends Subject {
    private String className;

    public Classroom(String className) {
        this.className = className;
    }

    public void setAnnouncement(String message) {
        System.out.println("📢 Thông báo từ lớp " + className + ": " + message);
        notifyObservers(message);
    }
}

// Main Class
public class Bai1 {
    public static void main(String[] args) {
        // Tạo lớp học
        Classroom lopIT = new Classroom("CNTT-01");

        // Tạo sinh viên
        Student sv1 = new Student("Tuan");
        Student sv2 = new Student("Kiet");
        Student sv3 = new Student("Ngoc");

        // Đăng ký sinh viên vào lớp
        lopIT.attach(sv1);
        lopIT.attach(sv2);
        lopIT.attach(sv3);

        // Lớp trưởng gửi thông báo
        lopIT.setAnnouncement("Ngày mai kiểm tra giữa kỳ!");
    }
}
