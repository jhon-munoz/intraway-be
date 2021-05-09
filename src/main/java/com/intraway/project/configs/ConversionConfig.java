package com.intraway.project.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversionConfig {

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }
}

