package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Course;
import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;
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
}
