package org.example.springbootstudy;

import java.util.Objects;

public class HelloController {
    public String hello(String msg) {
        SimpleHelloService helloService = new SimpleHelloService();

        return helloService.sayHello(Objects.requireNonNull(msg));
    }
}
