package org.example.springassignment;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentList;
    public StudentService(InMemoryDatabase db){
        this.studentList = db.getStudentList();
    }
    public List<Student> SelectAllStudentList() {
        return studentList;
    }
    public void InsertStudent(Student student){
        studentList.add(student);
    }
    public Student SelectStudentById(int id){
        for(Student student : studentList){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }
    public boolean updateStudentById(int id,String newName,String newGender,double newScore){
        for(Student s:studentList){
            if(s.getId()==id){
                s.setFull_name(newName);
                s.setGender(newGender);
                s.setScore(newScore);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudentById(int id){
        return studentList.removeIf(s -> s.getId()==id);
    }
}
