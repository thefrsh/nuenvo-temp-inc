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
class ThermometerTest extends AbstractIntegrationTest {

  @Test
  @DisplayName("[Thermometers] Get by Threshold -> Success")
  void thresholdIsGiven_whenGetByThreshold_thenReturnsThermometersAndAnomaliesCount() {

    given(specification)
      .param("threshold", 8)
    .when()
      .get("/api/thermometers/search/by-threshold")
    .then()
      .statusCode(HttpStatus.OK.value())
      .and()
      .body(
        "size()", is(1),
        "id", is(List.of(2)),
        "anomaliesCount", is(List.of(1))
      );
  }
}
