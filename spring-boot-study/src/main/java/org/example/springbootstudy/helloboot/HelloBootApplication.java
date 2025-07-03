package org.example.springbootstudy.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class HelloBootApplication {

    private final JdbcTemplate jdbcTemplate;

    public HelloBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    public static void main(String[] args) {
        run(HelloBootApplication.class, args);
    }
}
