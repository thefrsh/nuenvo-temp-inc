package com.nuenvo.tempinc.query;

import com.nuenvo.tempinc.application.web.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "thermometers/search")
class ThermometerRestController {

  private final ThermometerRestRepository repository;

  @Operation(
    summary = "Get Thermometers with Anomalies higher than Threshold",
    description = "Gets a list of Thermometers with their associated Anomalies higher than the provided Threshold",
    tags = "Thermometer",
    parameters = {
      @Parameter(
        name = "threshold",
        description = "Desired threshold",
        required = true,
        in = ParameterIn.QUERY
      )
    }
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Operation successful",
        content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          array = @ArraySchema(items = @Schema(implementation = AnomalyProjection.class))
        )
      ),
      @ApiResponse(
        responseCode = "400",
        description = "Incorrect format of the Threshold parameter",
        content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = ErrorResponse.class)
        )
      )
    }
  )
  @GetMapping(path = "by-threshold", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ThermometerProjection> findAllByThreshold(@RequestParam Integer threshold) {

    return repository.findAllByThreshold(threshold);
  }
}
