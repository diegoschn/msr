package com.diegoschneider.msr.commons;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
