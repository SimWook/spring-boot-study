package org.example.springbootstudy.helloboot;

import org.example.springbootstudy.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import static org.springframework.boot.SpringApplication.run;

@MySpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {
        run(SpringApplication.class, args);
    }
}
