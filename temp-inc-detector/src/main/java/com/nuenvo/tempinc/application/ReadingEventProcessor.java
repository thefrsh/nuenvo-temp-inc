package com.nuenvo.tempinc.application;

import com.nuenvo.sharedkernel.annotation.application.ApplicationService;
import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.application.event.ReadingEvent;
import com.nuenvo.tempinc.domain.port.primary.DetectorWindowingPolicy;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@ApplicationService
@RequiredArgsConstructor
class ReadingEventProcessor {

  private final DetectorWindowingPolicy policy;

  @Bean
  Function<KStream<Long, ReadingEvent>, KStream<Long, AnomalyEvent>> processor() {

    return (readings) -> readings
      .flatMapValues(policy::detect);
  }
}
