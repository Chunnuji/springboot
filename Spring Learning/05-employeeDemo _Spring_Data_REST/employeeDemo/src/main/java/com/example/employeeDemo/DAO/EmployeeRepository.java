package com.example.employeeDemo.DAO;

import com.example.employeeDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //...................
}
