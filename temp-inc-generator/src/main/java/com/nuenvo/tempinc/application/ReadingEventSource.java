package com.nuenvo.tempinc.application;

import com.nuenvo.sharedkernel.annotation.application.ApplicationService;
import com.nuenvo.tempinc.application.event.ReadingEvent;
import com.nuenvo.tempinc.domain.port.primary.ReadingFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Supplier;

@ApplicationService
@RequiredArgsConstructor
class ReadingEventSource {

  private final ReadingFactory factory;

  @Bean
  Supplier<Message<ReadingEvent>> source() {

    return () -> {

      var reading = factory.create();

      return MessageBuilder.withPayload(reading)
        .setHeader("partition-id", reading.thermometerId())
        .build();
    };
  }
}
