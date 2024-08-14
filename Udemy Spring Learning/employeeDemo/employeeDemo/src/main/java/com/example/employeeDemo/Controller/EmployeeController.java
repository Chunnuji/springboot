package com.example.employeeDemo.Controller;

import com.example.employeeDemo.Entity.Employee;
import com.example.employeeDemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

   @Autowired
   public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
       return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
       employee.setId(0);
       return employeeService.save(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void delEmployee(@PathVariable int id){
       employeeService.deleteById(id);
    }
}
