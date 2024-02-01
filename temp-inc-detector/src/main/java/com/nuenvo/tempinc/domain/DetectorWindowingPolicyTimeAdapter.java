package com.nuenvo.tempinc.domain;

import com.nuenvo.sharedkernel.annotation.domain.DomainPolicy;
import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.application.event.ReadingEvent;
import com.nuenvo.tempinc.domain.port.primary.DetectorWindowingPolicy;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@DomainPolicy
@ConditionalOnProperty(
  name = "anomaly.detector.algorithm",
  havingValue = "time-window"
)
class DetectorWindowingPolicyTimeAdapter implements DetectorWindowingPolicy {

  @Value("${anomaly.detector.algorithm.window-size:10}")
  private Integer size;

  private final AnomalyDetectorService service;

  private final List<ReadingEvent> readings;

  public DetectorWindowingPolicyTimeAdapter(AnomalyDetectorService service) {

    this.readings = new LinkedList<>();
    this.service = service;
  }

  @Override
  public List<AnomalyEvent> detect(@NonNull ReadingEvent event) {

    var anomalies = Collections.<AnomalyEvent>emptyList();

    if (!readings.isEmpty()) {

      if (event.timestamp() - readings.get(0).timestamp() > size) {

        anomalies = service.detect(readings);
        readings.remove(0);
      }
    }
    readings.add(event);

    return anomalies;
  }
}
