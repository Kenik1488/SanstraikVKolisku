package org.example.edu.controller;

import org.example.edu.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> studentList = new ArrayList<>();
    private long countId = 0;

    @GetMapping("/student")
    public List<Student> getStudentList() {
        return studentList;
    }

    @PostMapping("/student")
    public long saveStudent(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        countId = countId + 1;
        Student savedStudent = new Student(countId, name, email, age);
        studentList.add(savedStudent);
        return savedStudent.getId();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable long id) {

        for (Student student : studentList) {
            if (student.getId() == id) return student;
        }

        return null;
    }

}
