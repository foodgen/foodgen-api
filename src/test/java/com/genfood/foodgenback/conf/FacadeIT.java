package com.genfood.foodgenback.conf;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@AllArgsConstructor
public class FacadeIT {
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

  @BeforeAll
  static void beforeAll() {
    postgres.start();
  }

  @AfterAll
  static void afterAll() {
    postgres.stop();
  }

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    String flywayTestdataPath = "classpath:/db/testdata";
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
    registry.add(
        "token.signing.key",
        () -> "azertyuiopmlkjhgfdswxcvbnnbvcxwmlkjhgfdsqpoiuytrekqjsdkqsjdkqszaaa");
    registry.add("spring.flyway.locations", () -> "classpath:/db/migration," + flywayTestdataPath);
  }
}
