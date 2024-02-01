package com.nuenvo.tempinc.application;

import com.nuenvo.sharedkernel.annotation.application.ApplicationService;
import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.domain.port.primary.AnomalyFactory;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.kstream.KStream;

import java.util.function.Consumer;

@RequiredArgsConstructor
@ApplicationService(value = "sink")
class AnomalyEventSink implements Consumer<KStream<Long, AnomalyEvent>> {

  private final AnomalyFactory factory;

  @Override
  public void accept(KStream<Long, AnomalyEvent> anomalies) {

    anomalies.foreach((id, anomaly) -> factory.create(anomaly));
  }
}
