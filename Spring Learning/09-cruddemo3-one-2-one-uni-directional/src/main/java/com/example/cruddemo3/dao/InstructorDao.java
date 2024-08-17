package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Instructor;

public interface InstructorDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
