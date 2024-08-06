package com.example.qualifier.Methods;

import com.example.qualifier.Interface.Coach;
import org.springframework.stereotype.Component;

@Component
public class Football implements Coach {

    public String myCoach() {
        return "Football Coach";
    }
}
