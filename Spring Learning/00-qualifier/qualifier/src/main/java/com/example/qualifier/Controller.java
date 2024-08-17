package com.example.qualifier;

import com.example.qualifier.Interface.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public Coach coach;

    @Autowired
    public Controller(@Qualifier("swim1")Coach coach){
        this.coach=coach;
    }

    @GetMapping("/controller")
    public String myController(){
        return "My Controller";
    }

    @GetMapping("/coach")
    public String coach(){
        return coach.myCoach();
    }
}
