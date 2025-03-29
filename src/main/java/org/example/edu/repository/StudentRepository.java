package org.example.edu.repository;

import org.example.edu.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public long save(Student student) {
        studentList.add(student);
        return student.getId();
    }

    public Student getById(long id) {
        Student findStudent = null;

        for (Student student: studentList){
            if (student.getId() == id) {
                findStudent = student;
            }
        }
        return findStudent;
    }

    public void deleteById(long id) {
        int indexDeleteStudent = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                indexDeleteStudent = i;
            }
        }
        studentList.remove(indexDeleteStudent);
    }

}
