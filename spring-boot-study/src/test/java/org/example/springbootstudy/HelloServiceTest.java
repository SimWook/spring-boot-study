package org.example.springbootstudy;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();
        String result = helloService.sayHello("World");
        assert "Hello World".equals(result) : "Expected 'Hello World' but got '" + result + "'";
    }
}
