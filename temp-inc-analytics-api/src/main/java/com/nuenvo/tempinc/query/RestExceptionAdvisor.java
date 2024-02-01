package com.nuenvo.tempinc.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuenvo.tempinc.application.web.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j(topic = "com.nuenvo.tempinc.query.RestExceptionAdvisor")
class RestExceptionAdvisor {

  private final ObjectMapper mapper;

  @SneakyThrows
  @ExceptionHandler(value = NumberFormatException.class)
  public void handleNumberFormatException(NumberFormatException e,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {

    var errors = ErrorResponse.builder()
      .status(HttpStatus.BAD_REQUEST)
      .message(e.getMessage())
      .path(request.getRequestURI())
      .build();

    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(errors.getStatus());

    log.info("Outgoing Response with status [{}]", errors.getStatus());

    mapper.writeValue(response.getWriter(), errors);
  }
}
