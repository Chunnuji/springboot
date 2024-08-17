package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Instructor;
import com.example.cruddemo3.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
