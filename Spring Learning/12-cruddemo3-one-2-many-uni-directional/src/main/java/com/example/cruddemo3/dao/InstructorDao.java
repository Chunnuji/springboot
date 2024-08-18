package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Course;
import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;

import java.util.List;

public interface InstructorDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    void deleteCourse(int id);

    Course findCourseById(int id);

    Course getCourseWithReview(int id);

    void saveCourseWithReview(Course course);


}
