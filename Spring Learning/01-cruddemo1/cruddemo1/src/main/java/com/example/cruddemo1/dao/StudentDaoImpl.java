package com.example.cruddemo1.dao;

import com.example.cruddemo1.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager em;

    @Autowired
    public StudentDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
//        TypedQuery<Student> query = em.createQuery("From Student order by lastName desc",Student.class);
        TypedQuery<Student> query = em.createQuery("From Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("From Student where lastName = :lastNameVal",Student.class);
        query.setParameter("lastNameVal",lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> findByEmailExt(String ext) {
//        TypedQuery<Student> query = em.createQuery("From Student where email like %:extVal")
        return null;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(Integer id) {
        Student s1 = em.find(Student.class,id);
        em.remove(s1);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {

        return em.createQuery("Delete from Student").executeUpdate();
    }
}
