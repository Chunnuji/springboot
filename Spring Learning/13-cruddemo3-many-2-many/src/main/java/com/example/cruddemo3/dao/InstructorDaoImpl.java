package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Course;
import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;
import com.example.cruddemo3.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDaoImpl implements InstructorDao{

    private final EntityManager em;

    @Autowired
    public InstructorDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        em.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return em.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = em.find(Instructor.class,id);

        //removing foreign key dependency from Course before deleting Instructor object

        List<Course> courseList = instructor.getCourseList();

        for (Course c:courseList) {
            c.setInstructor(null);
        }

        em.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return em.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = em.find(InstructorDetail.class,id);

        //Binding --> deleting both Instructor and Instructor details
//        em.remove(instructorDetail);

        //Non-Binding delete --> Deleting only Instructor details

        instructorDetail.getInstructor().setInstructorDetail(null);
        em.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = em.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data",id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = em.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courseList "
                        + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        em.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        em.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course = findCourseById(id);
        em.remove(course);
    }

    @Override
    public Course findCourseById(int id) {
        return em.find(Course.class,id);
    }

    @Override
    public Course getCourseWithReview(int id) {
        TypedQuery<Course> query = em.createQuery(
                "select c from Course c "+
                        "JOIN FETCH c.reviewList "+
                        "where c.id = :data", Course.class);

        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void saveCourseWithReview(Course course) {
        em.persist(course);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = em.find(Student.class,id);

//        TypedQuery<Course> query = em.createQuery(
//                "select s.courseList from Student s "+
//                        "JOIN FETCH s.courseList "+
//                        "where s.id=:data", Course.class);
//
//        query.setParameter("data",id);
//        List<Course> courseList= query.getResultList();

        em.remove(student);
    }

    @Override
    public Course findCourseStudentById(int id) {
        TypedQuery<Course> courseTypedQuery = em.createQuery(
                "select c from Course c "+
                        "JOIN FETCH c.studentList "+
                        "where c.id=:data",Course.class);

        courseTypedQuery.setParameter("data",id);
        return courseTypedQuery.getSingleResult();
    }

    @Override
    public Student findStudentCourseById(int id) {
        TypedQuery<Student> studentTypedQuery = em.createQuery(
                "select s from Student s "+
                        "JOIN FETCH s.courseList "+
                        "where s.id=:data",Student.class);

        studentTypedQuery.setParameter("data",id);
        return studentTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void studentPickCourse(Student student) {
        em.merge(student);
    }

    @Override
    public Student findStudentOnlyById(int id) {
        return em.find(Student.class,id);
    }


}