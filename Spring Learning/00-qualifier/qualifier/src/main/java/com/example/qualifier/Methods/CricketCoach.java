package com.example.qualifier.Methods;

import com.example.qualifier.Interface.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CricketCoach implements Coach {
    public String myCoach() {
        return "Cricket Coach";
    }
}
