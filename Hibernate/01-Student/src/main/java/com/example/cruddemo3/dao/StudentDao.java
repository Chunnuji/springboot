package com.example.cruddemo3.dao;

import com.example.cruddemo3.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.jdbc.support.JdbcUtils.isNumeric;

@Repository
public class StudentDao {

    private final EntityManager em;

    private final Session session;

    @Autowired
    public StudentDao(EntityManager em,Session session) {
        this.em = em;
        this.session=session;
    }

    @Transactional
    public void saveStudent(Student student){
        em.merge(student);
    }

    public void findStudent(int id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        Predicate id1 = cb.equal(root.get("id"),id);
        cq.select(root).where(id1);
        TypedQuery<Student> query= em.createQuery(cq);
        Student student = query.getSingleResult();
        System.out.println(student);
    }

    public void findStudentByFirstName(String firstName){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        Predicate firstName1 = cb.equal(root.get("firstName"),firstName);
        cq.select(root).where(firstName1);
        TypedQuery<Student> query= em.createQuery(cq);
        List<Student> students = query.getResultList();
        System.out.println(students);
    }

    public void findStudentRecords(String searchString){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        Predicate predicates0 = cb.like(root.get("firstName"), "%"+searchString+"%");
        Predicate predicates1 = cb.like(root.get("email"), "%"+searchString+"%");
        Predicate predicates2 = cb.like(root.get("lastName"), "%"+searchString+"%");
        Predicate predicates3=null;
        if(isNumeric(Integer.parseInt(searchString))){
            predicates3 = cb.equal(root.get("id"),Integer.parseInt(searchString) );
        }
        if(predicates3!=null){
            cq.select(root).where(cb.or(predicates2,predicates1,predicates0,predicates3));
            TypedQuery<Student> query= em.createQuery(cq);
            List<Student> students = query.getResultList();
            System.out.println(students);
        }else{
            cq.select(root).where(cb.or(predicates2,predicates1,predicates0));
            TypedQuery<Student> query= em.createQuery(cq);
            List<Student> students = query.getResultList();
            System.out.println(students);
        }
    }

//    public void findStudentRecords(String firstName){
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> root = cq.from(Student.class);
//        cq.select(root).where(cb.like(root.get("firstName"),"%ac%"));
//        TypedQuery<Student> query= em.createQuery(cq);
//        List<Student> students = query.getResultList();
//        System.out.println(students);
//    }

}
