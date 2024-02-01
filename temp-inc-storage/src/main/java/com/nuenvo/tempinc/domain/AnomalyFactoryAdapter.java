package com.nuenvo.tempinc.domain;

import com.nuenvo.sharedkernel.annotation.domain.DomainFactory;
import com.nuenvo.tempinc.application.event.AnomalyEvent;
import com.nuenvo.tempinc.domain.model.Anomaly;
import com.nuenvo.tempinc.domain.port.primary.AnomalyFactory;
import com.nuenvo.tempinc.infrastructure.RoomRepository;
import com.nuenvo.tempinc.infrastructure.ThermometerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@DomainFactory
@RequiredArgsConstructor
@Slf4j(topic = "com.nuenvo.tempinc.domain.AnomalyFactoryAdapter")
class AnomalyFactoryAdapter implements AnomalyFactory {

  private final RoomRepository rooms;

  private final ThermometerRepository thermometers;

  private final AnomalyRepository anomalies;

  private final ModelMapper mapper;

  @Override
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void create(AnomalyEvent event) {

    try {

      var anomaly = mapper.map(event, Anomaly.class);

      var thermometer = thermometers.findById(event.thermometerId())
        .orElseThrow();

      var room = rooms.findById(event.roomId())
        .orElseThrow();

      anomaly.setThermometer(thermometer);
      anomaly.setRoom(room);

      anomalies.save(anomaly);
    }
    catch (NoSuchElementException e) {

      log.error(e.getMessage());
    }
  }
}
