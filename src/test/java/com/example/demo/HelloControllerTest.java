package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;



class HelloControllerTest {

    @Test
    void hello_shouldReturnHelloWorld() {
        HelloController controller = new HelloController();
        String result = controller.hello();
        assertThat(result).isEqualTo("Hello, World!");
    }
}