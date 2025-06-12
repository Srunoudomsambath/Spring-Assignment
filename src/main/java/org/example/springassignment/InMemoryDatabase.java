package org.example.springassignment;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InMemoryDatabase {
    private final List<Student> studentList = new ArrayList<Student>();

    public InMemoryDatabase() {
        studentList.add(new Student(1, "Pheng", "M", 50.10));
        studentList.add(new Student(2, "Theara", "F", 80.10));
        studentList.add(new Student(3, "Menghuy", "M", 70.10));
        studentList.add(new Student(4, "Sambath", "M", 60.10));
        studentList.add(new Student(5, "Oudom", "M", 90.10));
        studentList.add(new Student(6, "Sanom", "M", 880.10));
        studentList.add(new Student(7, "Leaphea", "F", 78.10));
        studentList.add(new Student(8, "Liza", "F", 99.10));
        studentList.add(new Student(9, "Sreypic", "F", 67.10));
        studentList.add(new Student(10, "Tangan", "M", 30.10));

    }


    public List<Student> getStudentList() {
        return studentList;
    }
}

