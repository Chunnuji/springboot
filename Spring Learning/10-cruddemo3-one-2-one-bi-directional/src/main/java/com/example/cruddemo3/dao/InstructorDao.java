package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;

public interface InstructorDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

}
