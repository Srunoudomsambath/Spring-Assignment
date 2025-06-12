package org.example.springassignment;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class StudentUI {
    private final StudentService studentService;
    private final Scanner scanner = new Scanner(System.in);

    public StudentUI(StudentService studentService) {
        this.studentService = studentService;
    }

    public void start() {
        while (true) {
            System.out.println("""
                    
                    =====================================
                           STUDENT MANAGEMENT SYSTEM
                    =====================================
                    1. Insert Student
                    2. View All Students
                    3. View Student by ID
                    4. Update Student by ID
                    5. Delete Student by ID
                    0. Exit
                    """);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> insertStudent();
                case 2 -> selectAllStudents();
                case 3 -> selectStudentById();
                case 4 -> updateStudentById();
                case 5 -> deleteStudentById();
                case 0 -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void insertStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Student Gender (M/F): ");
        String gender = scanner.nextLine();
        System.out.print("Enter Score: ");
        double score = scanner.nextDouble();
        scanner.nextLine();
        Student student = new Student(id, fullName, gender, score);
        studentService.InsertStudent(student);
        System.out.println("Student added successfully!");
    }

    public void selectAllStudents() {
        studentService.SelectAllStudentList().forEach(System.out::println);
    }

    public void selectStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student student = studentService.SelectStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void updateStudentById() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter new Gender (M/F): ");
        String gender = scanner.nextLine();
        System.out.print("Enter new Score: ");
        double score = scanner.nextDouble();
        scanner.nextLine();
        boolean updated = studentService.updateStudentById(id, fullName, gender, score);
        if (updated) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudentById() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean deleted = studentService.deleteStudentById(id);
        if (deleted) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}