package com.nuenvo.tempinc.domain;

import com.nuenvo.sharedkernel.annotation.domain.DomainFactory;
import com.nuenvo.tempinc.application.event.ReadingEvent;
import com.nuenvo.tempinc.domain.port.primary.ReadingFactory;

import java.time.Instant;
import java.util.Random;

@DomainFactory
class ReadingFactoryAdapter implements ReadingFactory {

  @Override
  public ReadingEvent create() {

    return new ReadingEvent(
      10 + 20 * new Random().nextDouble(),
      (int) Instant.now().getEpochSecond(),
      1L,
      1L
    );
  }
}
