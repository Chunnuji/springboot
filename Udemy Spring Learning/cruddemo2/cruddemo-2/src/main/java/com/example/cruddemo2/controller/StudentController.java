package com.example.cruddemo2.controller;

import com.example.cruddemo2.entity.Student;
import com.example.cruddemo2.exception.StudentErrorMessage;
import com.example.cruddemo2.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    ArrayList<Student> studentArrayList = new ArrayList<>();
    @PostConstruct
    public void loadData(){
        studentArrayList.add(new Student("Chunnu","Ji"));
        studentArrayList.add(new Student("Ramawati","Devi"));
        studentArrayList.add(new Student("Anil","Tiwari"));
    }

    @GetMapping("/studentRecord/{ind}")
    public Student getStudent(@PathVariable int ind){

        if(ind >= studentArrayList.size() || ind <0){
            throw new StudentNotFoundException("Student id not found "+ind);
        }
        return studentArrayList.get(ind);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorMessage> StudentIdException(StudentNotFoundException exp){
        StudentErrorMessage sem = new StudentErrorMessage();
        sem.setStatus(HttpStatus.NOT_FOUND.value());
        sem.setMessage(exp.getMessage());
        sem.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(sem,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorMessage> anyException(Exception exp){
        StudentErrorMessage sem = new StudentErrorMessage();
        sem.setStatus(HttpStatus.BAD_REQUEST.value());
        sem.setMessage(exp.getMessage());
        sem.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(sem,HttpStatus.BAD_REQUEST);
    }
}
