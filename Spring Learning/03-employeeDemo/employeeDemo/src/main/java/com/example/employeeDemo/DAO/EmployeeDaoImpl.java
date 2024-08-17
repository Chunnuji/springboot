package com.example.employeeDemo.DAO;

import com.example.employeeDemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("From Employee",Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return em.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee e = em.find(Employee.class,id);
        em.remove(e);
    }
}
