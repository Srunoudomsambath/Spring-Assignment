package org.example.springassignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String full_name;
    private String gender;
    private double score;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                '}';
    }
}
