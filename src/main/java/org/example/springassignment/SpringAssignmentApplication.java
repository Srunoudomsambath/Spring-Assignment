package org.example.springassignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringAssignmentApplication implements CommandLineRunner {
    private final StudentUI studentUI;

    public SpringAssignmentApplication(StudentUI studentUI) {
        this.studentUI = studentUI;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringAssignmentApplication.class, args);
    }
    @Override
    public void run(String... arg) throws Exception {
        studentUI.start();
    }


}
