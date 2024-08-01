package com.example.SpringLearning;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String myMethod(){
        return "Hello World";
    }

    @PreAuthorize(value = "hasRole('dev')")
    @GetMapping("/userA")
    public String userAMethod(){
        return "Hello userA";
    }

    @PreAuthorize(value = "hasRole('prod')")
    @GetMapping("/admin")
    public String myAdmin(){
        return "Hello admin";
    }
}
