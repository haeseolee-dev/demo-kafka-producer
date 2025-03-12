package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KafkaProducerApplicationTest {

    /**
     * Ensures that the Spring Boot application context loads successfully.
     */
    @Test
    void contextLoads() {
        assertTrue(true);
    }
}
