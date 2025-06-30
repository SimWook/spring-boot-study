package org.example.springbootstudy;

import org.example.springbootstudy.config.MySpringBootApplication;

import static org.springframework.boot.SpringApplication.run;


@MySpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {
        run(SpringApplication.class, args);
    }
}
