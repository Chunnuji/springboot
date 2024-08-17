package com.example.cruddemo1.dao;

import com.example.cruddemo1.domain.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    List<Student> findByEmailExt(String ext);

    void updateStudent(Student student);

    void deleteStudentById(Integer id);

    int deleteAllStudents();
}
