package org.example.springbootstudy.helloboot;

public interface HelloService {
    String sayHello(String name);

    default int countOf(String name) {
        return 0;
    };
}
