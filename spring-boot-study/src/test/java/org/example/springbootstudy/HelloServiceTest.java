package org.example.springbootstudy;

import org.assertj.core.api.Assertions;
import org.example.springbootstudy.helloboot.HelloDecorator;
import org.example.springbootstudy.helloboot.SimpleHelloService;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();
        String result = helloService.sayHello("World");
        assert "Hello World".equals(result) : "Expected 'Hello World' but got '" + result + "'";
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String result = decorator.sayHello("World");

        Assertions.assertThat(result).isEqualTo("*World*");
    }
}
