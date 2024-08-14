//package com.example.cruddemo2.exception;
//
//import com.example.cruddemo2.entity.Student;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//public class SrudentExceptionHandler {
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorMessage> StudentIdException(StudentNotFoundException exp){
//        StudentErrorMessage sem = new StudentErrorMessage();
//        sem.setStatus(HttpStatus.NOT_FOUND.value());
//        sem.setMessage(exp.getMessage());
//        sem.setTimestamp(System.currentTimeMillis());
//        return new ResponseEntity<>(sem,HttpStatus.NOT_FOUND);
//    }
//
//}
