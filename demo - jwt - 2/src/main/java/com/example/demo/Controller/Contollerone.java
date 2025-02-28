package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class Contollerone {

    @GetMapping(value = "/demo")
    public String fun1(){
        return "fun1";
    }

    @GetMapping(value = "/demo2")
    public String fun2(){
        return "fun2";
    }
}
