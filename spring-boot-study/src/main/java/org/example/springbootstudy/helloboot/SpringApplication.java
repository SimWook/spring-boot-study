package org.example.springbootstudy.helloboot;

import org.example.springbootstudy.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import static org.springframework.boot.SpringApplication.run;


@MySpringBootApplication
public class SpringApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            String name = environment.getProperty("my.name");
            System.out.println("my.name = " + name);
        };
    }

    public static void main(String[] args) {
        run(SpringApplication.class, args);
    }
}
