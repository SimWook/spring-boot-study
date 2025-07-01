package org.example.springbootstudy.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
    @Test
    void helloController() {
        HelloController helloController = new HelloController(msg -> msg);
        String result = helloController.hello("World");
        Assertions.assertThat(result).isEqualTo("World");
    }

    @Test
    void failingHelloController() {
        HelloController helloController = new HelloController(msg -> msg);

        Assertions.assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
