package org.example.springbootstudy.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String msg) {
        if (msg == null || msg.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello((msg));
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + ":" + helloService.countOf(name);
    }
}
