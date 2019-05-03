package com.ttn.springdemo;

import com.ttn.springdemo.config.audit.CustomAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing(auditorAwareRef = "auditorAware")
public class SpringDemoApplication {
    public static void main(String[] args) {
       SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    public AuditorAware auditorAware() {
        return new CustomAuditorAware();
    }
}