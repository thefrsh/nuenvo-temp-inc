package com.nuenvo.tempinc.support;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractIntegrationTest {

  protected static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
    DockerImageName.parse("postgres:16-alpine")
  );

  protected RequestSpecification specification;

  @LocalServerPort
  protected Integer port;

  @DynamicPropertySource
  protected static void override(DynamicPropertyRegistry registry) {

    postgres.start();

    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
  }

  @BeforeEach
  protected void configure() {

    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    var headers = new HashMap<String, String>();

    headers.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

    specification = new RequestSpecBuilder()
      .setPort(port)
      .addHeaders(headers)
      .build();
  }
}
