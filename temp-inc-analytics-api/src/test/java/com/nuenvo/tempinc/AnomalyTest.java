package com.nuenvo.tempinc;

import com.nuenvo.tempinc.support.AbstractIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Sql(
  scripts = {"classpath:db/Migrate.sql", "classpath:db/ClearSeed.sql"},
  executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS
)
class AnomalyTest extends AbstractIntegrationTest {

  @Test
  @DisplayName("[Anomalies] Get by Thermometer -> Success")
  void thermometerIsGiven_whenGetByThermometer_thenReturnsAnomaliesList() {

    given(specification)
      .param("id", 2L)
    .when()
      .get("/api/anomalies/search/by-thermometer")
    .then()
      .statusCode(HttpStatus.OK.value())
      .and()
      .body(
        "size()", is(5),
        "id", is(List.of(6, 7, 8, 9, 10))
      );
  }

  @Test
  @DisplayName("[Anomalies] Get by Room -> Success")
  void roomIsGiven_whenGetByRoom_thenReturnsAnomaliesList() {

    given(specification)
      .param("id", 1L)
    .when()
      .get("/api/anomalies/search/by-room")
    .then()
      .statusCode(HttpStatus.OK.value())
      .and()
      .body(
        "size()", is(10),
        "id", is(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
      );
  }
}
