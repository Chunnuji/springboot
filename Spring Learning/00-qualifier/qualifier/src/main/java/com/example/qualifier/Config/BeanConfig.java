package com.example.qualifier.Config;

import com.example.qualifier.Interface.Coach;
import com.example.qualifier.Methods.CricketCoach;
import com.example.qualifier.Methods.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("swim1")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
