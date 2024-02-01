package com.nuenvo.tempinc.application.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Schema(
  description = "Error Response object"
)
public class ErrorResponse {

  @Schema(
    description = "Timestamp of the occured error",
    example = "2023-02-20T13:36:19.490+00:00"
  )
  private final Date timestamp;

  @Schema(
    description = "Status code",
    example = "401"
  )
  private final Integer status;

  @Schema(
    description = "Reason phrase",
    example = "Unauthorized"
  )
  private final String error;

  @Schema(
    description = "Detailed message about the error",
    example = "The requested resource is not found"
  )
  private final String message;

  @Schema(
    description = "Path of the requested resource",
    example = "/api/anomalies/2"
  )
  private final String path;

  @Builder
  public ErrorResponse(HttpStatus status, String message, String path) {

    this.timestamp = new Date();
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = message;
    this.path = path;
  }
}
