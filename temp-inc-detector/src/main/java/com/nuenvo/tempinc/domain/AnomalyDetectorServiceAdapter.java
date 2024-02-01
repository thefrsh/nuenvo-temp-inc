package com.nuenvo.tempinc.domain;

import com.nuenvo.sharedkernel.annotation.domain.DomainService;
import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.application.event.ReadingEvent;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
class AnomalyDetectorServiceAdapter implements AnomalyDetectorService {

  @Value("${anomaly.detector.max-deviation:5}")
  private Integer margin;

  @Override
  public List<AnomalyEvent> detect(@NonNull List<ReadingEvent> window) {

    var average = window.stream()
      .collect(Collectors.averagingDouble(ReadingEvent::temperature));

    return window.stream()
      .filter(reading -> reading.temperature() > average + margin)
      .map(reading -> new AnomalyEvent(
        reading.temperature(),
        reading.timestamp(),
        reading.roomId(),
        reading.thermometerId(),
        reading.temperature() - average
      ))
      .toList();
  }
}
