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
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
  name = "Anomaly",
  description = "Anomaly-related endpoints"
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "anomalies/search")
class AnomalyRestController {

  private final AnomalyRestRepository repository;

  @Operation(
    summary = "Get Anomalies by Thermometer ID",
    description = "Gets a list of Anomalies by their associated Thermometer",
    tags = "Anomaly",
    parameters = {
      @Parameter(
        name = "id",
        description = "ID of the desired Thermometer",
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
          array = @ArraySchema(schema = @Schema(implementation = AnomalyProjection.class))
        )
      ),
      @ApiResponse(
        responseCode = "400",
        description = "Incorrect format of the Thermometer ID parameter",
        content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = ErrorResponse.class)
        )
      )
    }
  )
  @GetMapping(path = "by-thermometer", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AnomalyProjection> findAllByThermometerId(@RequestParam Long id) {

    return repository.findAllByThermometerId(id);
  }

  /* -------------------------------------------------------------- */

  @Operation(
    summary = "Get Anomalies by Room ID",
    description = "Gets a list of Anomalies by their associated Room",
    tags = "Anomaly",
    parameters = {
      @Parameter(
        name = "id",
        description = "ID of the desired Room",
        required = true,
        in = ParameterIn.QUERY
      )
    }
  )
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Operation succcessul",
        content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          array = @ArraySchema(schema = @Schema(implementation = AnomalyProjection.class))
        )
      ),
      @ApiResponse(
        responseCode = "400",
        description = "Incorrect format of the Room ID parameter",
        content = @Content(
          mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = ErrorResponse.class)
        )
      )
    }
  )
  @GetMapping(path = "by-room", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AnomalyProjection> findAllByRoomId(@RequestParam Long id) {

    return repository.findAllByRoomId(id);
  }
}
